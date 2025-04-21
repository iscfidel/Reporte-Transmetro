package com.stcm.FilesEdit;

import java.io.FileReader;
import java.util.List;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.stcm.Entity.TorniqueteCount;

public class CsvEdit {
	
    /**
     * Lee un archivo CSV y devuelve una lista de filas, donde cada fila es un array de Strings.
     *
     * @param rutaArchivo Ruta al archivo .csv
     * @return Lista de filas (cada una como array de Strings)
     */
    public static List<TorniqueteCount> leerCsvComoTorniquetes(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            CsvToBean<TorniqueteCount> csvToBean = new CsvToBeanBuilder<TorniqueteCount>(reader)
                    .withType(TorniqueteCount.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            return csvToBean.parse();

        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo CSV: " + e.getMessage(), e);
        }
    }

    
    /**
     * Imprime el contenido de una lista de filas CSV.
     *
     * @param filas Lista de arrays de Strings (una por fila del archivo CSV)
     */
    public static void mostrarTorniquetes(List<TorniqueteCount> lista) {
        for (TorniqueteCount item : lista) {
            System.out.println(item.getEntradas());
        }
    }
}
