package com.stcm.FilesEdit;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.stcm.Entity.TorniqueteCount;

public class CsvEdit {
    public List<TorniqueteCount> cargarDatos(String rutaCsv) throws Exception {
        try (FileReader reader = new FileReader(rutaCsv)) {
            CsvToBean<TorniqueteCount> csvToBean = new CsvToBeanBuilder<TorniqueteCount>(reader)
                    .withType(TorniqueteCount.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        }
    }
    
    public void guardarDatos(String rutaDestino, List<TorniqueteCount> registros) throws Exception {
        try (FileWriter writer = new FileWriter(rutaDestino)) {
            StatefulBeanToCsv<TorniqueteCount> beanToCsv = new StatefulBeanToCsvBuilder<TorniqueteCount>(writer)
                    .withApplyQuotesToAll(false)
                    .build();

            beanToCsv.write(registros);
        }
    }

    
    /*public void mostrarDatos(List<TorniqueteCount> registros) {
    	for (TorniqueteCount i : registros) {
			System.out.println(registros);
		}
    }*/
}
