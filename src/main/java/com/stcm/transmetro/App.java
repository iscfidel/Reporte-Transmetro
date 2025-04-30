package com.stcm.transmetro;

import java.util.List;
import com.stcm.Entity.TorniqueteCount;
import com.stcm.FilesEdit.CsvEdit;
import com.stcm.Services.TorniqueteCountServices;

public class App {
    
	public static void main( String[] args ){ 
		
        CsvEdit csvEdit = new CsvEdit();
        
        //Ruta del archivo "*.csv"...
        String path_file = "./testingCsv/DontTouchMe.csv";
        
        //Ruta destino del archivo "*.csv"...
		//String new_path_file = "./testingCsv/Reportes-Procesados/Procesado_Torniquete_42.csv";
        
    	//Lista en donde se almacenaran los registros de mi archivo csv...
        List<TorniqueteCount> data = CsvEdit.leerCsvComoTorniquetes(path_file);
        
        //Instacianmos el objeto de la clase "TorniqueteCountServices".
        TorniqueteCountServices torniqueteServices = new TorniqueteCountServices(); 
        
        //Estas variables son utilizadas  para inicializar el valor del primer registro del campo "Contador_Auxiliar"
        TorniqueteCount tor = data.get(0);
        long ini_aux_count = tor.getEntradas();
        long ini_real_value = 7878;
        
        tor.setRealValue(ini_real_value);
        tor.setContadorAuxiliar(ini_aux_count);
        
        //Tamaño de la lista para utilizarlo en el for...
        int size_csv = data.size();
        
        torniqueteServices.iterationRows(data, size_csv);
        
        System.out.println("\t  ==========================================================");
        System.out.println("\t  | entradas | fechaContador | realValue | contadorAuxiliar|");
        System.out.println("\t  ==========================================================");
        torniqueteServices.mostrarTorniquetes(data);
        System.out.println("\t  ==========================================================");
        
        /*System.out.println("\n\nAlmacenando informacion...");
        csvEdit.guardarInfo(data, new_path_file);*/
        
        //----------------------------------------------------------------------------------------------------
	}
	
}








/*
 */