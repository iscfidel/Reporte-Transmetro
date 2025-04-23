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
            TorniqueteCount value_ant = null;
            long contador_ant=0; 
            
            // Solo obtenemos el valor anterior si no estamos en la primera posición
            if (i > 0) {
                value_ant = data.get(i-1);
                contador_ant = value_ant.getContadorAuxiliar();
            }
        	
        	//Obtiene el valor de las entradas actuales y entradas siguientes, a exceopcion de contador auxiliar...
        	long entradas_act = value_act.getEntradas();
        	long entradas_sig = value_sig.getEntradas();
        	long contador_act = value_act.getContadorAuxiliar();
        	
            torniqueteServices.processValidation( entradas_act,  
            		entradas_sig,  contador_act, contador_ant,  value_sig, value_act);
        	
		}
	}
	
	public void processValidation(long entradas_act, long entradas_sig, long contador_act, long contador_ant, TorniqueteCount value_sig, TorniqueteCount value_act) {
		long var_aux;
		
		//System.out.println("Actual: "+entradas_act+", Siguiente: "+entradas_sig+ ", Anterior: "+ contador_ant);
		
    	if(entradas_sig >= entradas_act && (entradas_sig - entradas_act) <= 50) {
    		addAuxCount(entradas_act, entradas_sig, contador_act, value_sig, value_act, contador_ant);
    		
    	}else if(entradas_sig <= entradas_act) { 
    		addAuxCount(entradas_act, entradas_sig, contador_act, value_sig, value_act, contador_ant);
    		value_sig.setContadorAuxiliar(contador_act);
    		
    	}
    	
    	//var_aux = entradas_act;
	}
	
	public static void addAuxCount(long entradas_act, long entradas_sig, long contador_act, TorniqueteCount value_sig,TorniqueteCount value_act , long contador_ant) {
		
			if(contador_act == 0) {
				contador_act = contador_ant;
				value_act.setContadorAuxiliar(contador_ant);
			}
			//Almacena la diferencia que hay entre el siguiente registro y el registro actual, para posteriormente
			// ser sumado a la variable  actual.
			long diferencia = contador_act + (entradas_sig - entradas_act);
			
			//Se suma el valor de la posicion actual de la columna "ContadorAuxiliar"
			long contador_aux = value_sig.getContadorAuxiliar() + diferencia;
			
			//Almacena el valor en la posicion correspondiente.
			value_sig.setContadorAuxiliar(contador_aux);
			value_act.setEvaluar(9999);
			
			diferencia = 0;
		
	}
	
    public void mostrarTorniquetes(List<TorniqueteCount> list) {
        for (TorniqueteCount item : list) {
            System.out.println(item);
        }
    }
}
