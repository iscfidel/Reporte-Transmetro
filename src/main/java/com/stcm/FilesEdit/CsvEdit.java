package com.stcm.FilesEdit;


import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import com.stcm.Entity.TorniqueteCount;

public class CsvEdit {

	/**
	 * Lee un archivo CSV y devuelve una lista de filas, donde cada fila es un array
	 * de Strings.
	 *
	 * @param rutaArchivo Ruta al archivo .csv
	 * @return Lista de filas (cada una como array de Strings)
	 */
	public static List<TorniqueteCount> leerCsvComoTorniquetes(String rutaArchivo) {
		try (FileReader reader = new FileReader(rutaArchivo)) {
			CsvToBean<TorniqueteCount> csvToBean = new CsvToBeanBuilder<TorniqueteCount>(reader)
					.withType(TorniqueteCount.class).withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true)
					.build();

			return csvToBean.parse();

		} catch (Exception e) {
			throw new RuntimeException("Error al leer el archivo CSV: " + e.getMessage(), e);
		}

	}
	
	public void guardarInfo(List<TorniqueteCount> torni, String rutaArchivo) {
	    try (Writer writer = new FileWriter(rutaArchivo)) {

	        ColumnPositionMappingStrategy<TorniqueteCount> strategy = new ColumnPositionMappingStrategy<>();
	        strategy.setType(TorniqueteCount.class);
	        strategy.setColumnMapping(
	            "entradas",
	            "fechaContador",
	            "realValue",
	            //"evaluar",
	            //"fechaRegistro",
	            "contadorAuxiliar"
	        );

	        StatefulBeanToCsv<TorniqueteCount> beanToCsv = new StatefulBeanToCsvBuilder<TorniqueteCount>(writer)
	                .withMappingStrategy(strategy)
	                .build();

	        beanToCsv.write(torni);
	        System.out.println("CSV creado exitosamente en " + rutaArchivo);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}