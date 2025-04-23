package com.stcm.Services;

import java.util.List;

import com.stcm.Entity.TorniqueteCount;

public class TorniqueteCountServices {
	
	
	public void iterationRows(List<TorniqueteCount> data, int size_csv) {
		TorniqueteCountServices torniqueteServices = new TorniqueteCountServices();
		
        for (int i = 0; i < size_csv -1; i++) {
        	//Variable para la posicion actual y la posicion siguiente...
        	TorniqueteCount value_act = data.get(i);
        	TorniqueteCount value_sig = data.get(i+1);
        	
        	//Obtiene el valor de las entradas actuales y entradas siguientes, a exceopcion de contador auxiliar...
        	long entradas_act = value_act.getEntradas();
        	long entradas_sig = value_sig.getEntradas();
        	long contador_act = value_act.getContadorAuxiliar();
        	
            torniqueteServices.processValidation( entradas_act,  
            		entradas_sig,  contador_act, value_act,  value_sig);
        	
		}
	}
	
	public void processValidation(long entradas_act, long entradas_sig, long contador_act, TorniqueteCount value_act, TorniqueteCount value_sig) {
		long var_aux;
		
    	if(entradas_sig >= entradas_act && (entradas_sig - entradas_act) <= 50) {
    		addAuxCount(entradas_act, entradas_sig, contador_act, value_sig);
    		
    	}else if(entradas_sig <= entradas_act) {
    		value_sig.setContadorAuxiliar(contador_act);
    	}
    	//System.out.println("Actual: "+entradas_act+", Siguiente: "+entradas_sig);
	}
	
	public static void addAuxCount(long entradas_act, long entradas_sig, long contador_act, TorniqueteCount value_sig) {
			
			//Almacena la diferencia que hay entre el siguiente registro y el registro actual, para posteriormente 
			// ser sumado a la variable  actual.
			long diferencia = contador_act + (entradas_sig - entradas_act);
			
			//Se suma el valor de la posicion actual de la columna "ContadorAuxiliar"
			long contador_aux = value_sig.getContadorAuxiliar() + diferencia;
			
			//Almacena el valor en la posicion correspondiente.
			value_sig.setContadorAuxiliar(contador_aux);
		
	}
	
    public void mostrarTorniquetes(List<TorniqueteCount> list) {
        for (TorniqueteCount item : list) {
            System.out.println(item);
        }
    }
}
