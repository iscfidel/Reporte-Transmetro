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
	            long contador_ant = 0;
	            
		            // Solo obtenemos el valor anterior si no estamos en la primera posición
		            if (i > 0) {
		                value_ant = data.get(i-1);
		                contador_ant = value_ant.getContadorAuxiliar();
		            }
	        	
	        	//Obtiene el valor de las entradas actuales y entradas siguientes, a exceopcion de contador auxiliar...
	        	long entradas_act = value_act.getEntradas();
	        	long entradas_sig = value_sig.getEntradas();
	        	long contador_act = value_act.getContadorAuxiliar();
	        	long real_value_act = value_act.getRealValue();
	        	
	            torniqueteServices.processValidation( entradas_act,  
	            		entradas_sig,  contador_act, contador_ant,  value_sig, value_act,  real_value_act);
	        	
			}
	}
	
	private void processValidation(long entradas_act, long entradas_sig, long contador_act, long contador_ant, 
		TorniqueteCount value_sig, TorniqueteCount value_act, long real_value_act) {
		
	    	if(entradas_sig >= entradas_act && (entradas_sig - entradas_act) < 51) {
	    		addAuxCountMin(entradas_act, entradas_sig, contador_act, value_sig, value_act, contador_ant, real_value_act);
	    		
	    	}else if(entradas_sig <= entradas_act) {
	    		addAuxCountMin(entradas_act, entradas_sig, contador_act, value_sig, value_act, contador_ant, real_value_act);
	    		value_sig.setContadorAuxiliar(contador_act);
	    		
	    	}else if((entradas_sig-entradas_act) > 50) {
	    		value_sig.setEntradas(entradas_act);
	    		value_sig.setContadorAuxiliar(entradas_act);
				value_act.setEvaluar(9999);
	    	}
	}
	
	private  void addAuxCountMin(long entradas_act, long entradas_sig, long contador_act, TorniqueteCount value_sig,
			TorniqueteCount value_act , long contador_ant, long real_value_act) {
		
			if(contador_act == 0) {
				contador_act = contador_ant;
				value_act.setContadorAuxiliar(contador_ant);
			}  
			
			//Almacena la diferencia que hay entre el siguiente registro y el registro actual, para posteriormente
			// ser sumado a la variable  actual.
			long diferencia_cont = contador_act + (entradas_sig - entradas_act);
			long contador_aux;
			
			//Se suma el valor de la posicion actual de la columna "ContadorAuxiliar"
			//contador_aux = value_sig.getContadorAuxiliar() + diferencia_cont;					
			contador_aux = diferencia_cont;
			//Almacena el valor en la posicion correspondiente.
			value_sig.setContadorAuxiliar(contador_aux);
			
			if(entradas_sig == 0) {
				value_sig.setEntradas(entradas_act);
				
			}
			
			value_act.setEvaluar(9999);
			diferencia_cont = 0;    
			
	}
	
    public void mostrarTorniquetes(List<TorniqueteCount> list) {
    	int i = 0;
	        for (TorniqueteCount item : list) {
	            System.out.println("["+(i+1)+"]. "+item);
	            i++;
	        }
    }
    
}