package com.stcm.transmetro;

import java.util.List;
import com.stcm.Entity.TorniqueteCount;
import com.stcm.FilesEdit.CsvEdit;
import com.stcm.Services.TorniqueteCountServices;

public class App {
    
	public static void main( String[] args ){ 
		
		//Ruta del archivo "*.csv"...
    	//String path_file = "./testingCsv/torniquete_48.csv";
        CsvEdit csvEdit = new CsvEdit();
		String path_file = "./testingCsv/contadores_torniquetes 48.csv";
		String new_path_file = "./testingCsv/V1__request_torniquete_48.csv";
    	//Lista en donde se almacenaran los registros de mi archivo csv...
        List<TorniqueteCount> data = CsvEdit.leerCsvComoTorniquetes(path_file);
        
        //Instacianmos el objeto de la clase "TorniqueteCountServices".
        TorniqueteCountServices torniqueteServices = new TorniqueteCountServices(); 
        
        //Estas variables son utilizadas  para inicializar el valor del primer registro del campo "Contador_Auxiliar"
        TorniqueteCount tor = data.get(0);
        long ini_auxCount = tor.getEntradas();
        tor.setContadorAuxiliar(ini_auxCount);
        
        //Tamaño de la lista para utilizarlo en el for...
        int size_csv = data.size();
        
        torniqueteServices.iterationRows(data, size_csv);
        /*System.out.println("\t  ====================================================================================");
        System.out.println("\t  | entradas | fechaContador | realValue | evaluar | fechaRegistro | contadorAuxiliar|");
        System.out.println("\t  ====================================================================================");
        torniqueteServices.mostrarTorniquetes(data);
        System.out.println("\t  ====================================================================================");*/
        System.out.println("\n\nAlmacenando informacion...");
        csvEdit.guardarInfo(data, new_path_file);
        
	}
	
}