package com.stcm.transmetro;

import java.util.ArrayList;
import java.util.List;
import com.stcm.Entity.*;
import com.stcm.FilesEdit.CsvEdit;

public class App {
    
	public static void main( String[] args ){
		
    	String rutaArchivo = "./testingCsv/torniquete_48.csv";

        List<TorniqueteCount> datos = CsvEdit.leerCsvComoTorniquetes(rutaArchivo);
        int size_csv = datos.size();
        
        for (int i = 0; i < size_csv  - 1; i++) {
        	//Variable para la posicion actual...
        	TorniqueteCount value_act = datos.get(i);
        	//Variable para la posicion siguiente...
        	TorniqueteCount value_sig = datos.get(i+1);
        	
        	
        	long entradas_act = value_act.getEntradas();
        	long entradas_sig = value_sig.getEntradas();
        	
        	if(entradas_sig >= entradas_act && (entradas_sig - entradas_act) <= 50) {
        		long diferencia = entradas_act + (entradas_sig - entradas_act);
        		long contador_aux = value_sig.getContadorAuxiliar() + diferencia;
        		value_act.setContadorAuxiliar(contador_aux);
        	}
        	else if(entradas_sig < entradas_act) {
        		value_sig.setEntradas(entradas_act);
        	}
        	else if((entradas_sig - entradas_act) > 50) {
        		value_sig.setEntradas(entradas_act);
        	}
        	
		}
        
        for (TorniqueteCount torniqueteCount : datos) {
			System.out.println(torniqueteCount);
		}
        
	}
	
}