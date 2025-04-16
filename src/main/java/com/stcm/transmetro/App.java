package com.stcm.transmetro;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import com.stcm.Entity.*;
import com.stcm.FilesEdit.CsvEdit;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	CsvEdit csv = new CsvEdit();
    	String ruta = "torniquete48.csv";
    	String destino = "torniquete48_procesado.csv";
    	
    	List<Integer> entradas = new ArrayList();
    	
    	entradas.add(1);
    	entradas.add(2);
    	entradas.add(3);
    	entradas.add(4);
    	entradas.add(5);
    	entradas.add(6);
    	entradas.add(7);
    	entradas.add(7);
    	entradas.add(7);
    	entradas.add(8);
    	entradas.add(8);
    	entradas.add(8);
    	entradas.add(10);
    	entradas.add(20);
    	entradas.add(0);
    	entradas.add(11);
    	entradas.add(11);
    	entradas.add(11);
    	entradas.add(12);
    	entradas.add(13);
    	entradas.add(25);
    	entradas.add(33);
    	entradas.add(40);
    	entradas.add(67);
    	entradas.add(120);
    	entradas.add(124);
    	entradas.add(126);
    	entradas.add(200);
    	entradas.add(207);
    	
    	int size_entradas = entradas.size();
    	
    	
    	
    	
    	
    	/*for (int i = 0; i < size_entradas - 1; i++) {
    		
			int actual = entradas.get(i);
			int siguiente = entradas.get(i + 1);
			
			int incremento = entradas.get(i + 1) - entradas.get(i) ;
	
				if(incremento < 50) {
					System.out.println("["+(i + 1)+"]. Tu condicion es verdadera, la diferencia es de: "+incremento+" no"
							+ " sobrepasa.");
				}else {
					//System.out.println("["+(i + 1)+"].Sobre pasa el limite por "+incremento);
			        entradas.set(i + 1, actual); // Se reemplaza el valor de la siguiente posición
				}				
				
			incremento = 0;
			
		}
    	
    	System.out.println(entradas);+/
    	
    	/*int actual = 560985;
    	int siguiente = 561034;
    	
    	int incremento = siguiente - actual;
    	
    		if(incremento < 50 ) {
    	    	System.out.println("Tu condicion es verdadera, tu diferencia es de "+incremento);
    		}else {
    			System.out.println("Tu condicion es falsa, tu diferencia es de "+ incremento);
    		}*/
    	
    	
    	/*try {
    		List<TorniqueteCount> lista_torniquetes = new ArrayList<>();
    		
    		lista_torniquetes =  csv.cargarDatos(ruta);
    		csv.guardarDatos(destino, lista_torniquetes);
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
    
    /*private static List<TorniqueteCount> leerCsv(String archivo) throws Exception {
        FileReader reader = new FileReader(archivo);
        CsvToBean<TorniqueteCount> csvToBean = new CsvToBeanBuilder<TorniqueteCount>(reader)
                .withType(TorniqueteCount.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }
    
    private static void mostrarLista(List<TorniqueteCount> lista) {
        for (TorniqueteCount i : lista) {
			System.out.println(lista);
		}
    }*/
}

