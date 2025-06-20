package com.stcm.Services;

import java.util.List;

import com.stcm.Entity.TorniqueteCount;

public class TorniqueteCountServices {
	
	//Metodo para recorrer toda la lista con los datos extraidos de nuestro archivo ".csv"...
	public void iterationRows(List<TorniqueteCount> data, int size_csv) {
		TorniqueteCountServices torniqueteServices = new TorniqueteCountServices();
		
	        for (int i = 0; i < size_csv -1; i++) {
	        	//Variable para la posicion actual y la posicion siguiente...
	        	TorniqueteCount value_act = data.get(i);
	        	TorniqueteCount value_sig = data.get(i+1);
	            TorniqueteCount value_ant = null;
	            //Variable para tomar el valor de una posicion anterior...
	            long contador_ant = 0;
	            
		            // Solo obtenemos el valor anterior si no estamos en la primera posición...
		            if (i > 0) {
		                value_ant = data.get(i-1);
		                contador_ant = value_ant.getContadorAuxiliar();
		            }
	        	
	        	//Obtiene el valor de las entradas actuales y entradas siguientes, a exceopcion de contador auxiliar...
	        	long entradas_act = value_act.getEntradas();
	        	long entradas_sig = value_sig.getEntradas();
	        	long contador_act = value_act.getContadorAuxiliar();
	        	long real_value_act = value_act.getRealValue();
	        	long real_value_sig = value_sig.getRealValue();
	        	
	            torniqueteServices.processValidationAccess( entradas_act,  
	            		entradas_sig,  contador_act, contador_ant,  value_sig, value_act,  real_value_act,  real_value_sig );			}
	}
	
	//Verifica las entradas y en base a sus resultados toma decisiones...
	private void processValidationAccess(long entradas_act, long entradas_sig, long contador_act, long contador_ant, 
				TorniqueteCount value_sig, TorniqueteCount value_act, long real_value_act, long real_value_sig ) {
		
		//Si nuestros valores cumplen nuestras reglas establecidas realizan sus calculos correspondientes...
	    	if(entradas_sig > entradas_act && (entradas_sig - entradas_act) < 51) {
	    		if((entradas_sig - contador_act) < 51) {
	    			addAuxCount(entradas_act, entradas_sig, contador_act, value_sig, value_act, contador_ant, real_value_act);
	    		}else {
					value_sig.setContadorAuxiliar(contador_act);
					value_sig.setRealValue(real_value_act);
	    		}
	    	
	    	}else if(entradas_sig <= entradas_act) { //Si entra a esta decision sustituye los valores de las variables por...
				value_sig.setContadorAuxiliar(contador_act);
				value_sig.setRealValue(real_value_act);
				
	    	}else if((entradas_sig-entradas_act) > 50) {
	    		value_sig.setContadorAuxiliar(contador_act);
	    		value_sig.setRealValue(real_value_act);
	    	}
	}
	
	//Metodo para realizar el calculo del real value y contador auxiliar
	private  void addAuxCount(long entradas_act, long entradas_sig, long contador_act, TorniqueteCount value_sig,
				  TorniqueteCount value_act , long contador_ant, long real_value_act) {
			
			if(contador_act == 0) {
				contador_act = contador_ant;
				value_act.setContadorAuxiliar(contador_ant);
			}
			
			//Almacena la diferencia que hay entre el siguiente registro y el registro actual, para posteriormente
			// ser sumado a la variable  actual.
			long diferencia_cont = contador_act + (entradas_sig - entradas_act);
			long diferencia_real_value = real_value_act + (entradas_sig - entradas_act);
			
			long contador_aux;
			long real_value_aux;
			
			//Se suma el valor de la posicion actual de la columna "ContadorAuxiliar"
			contador_aux = diferencia_cont;
			
			real_value_aux = diferencia_real_value;
			
			//Almacena el valor en la posicion correspondiente.
			value_sig.setContadorAuxiliar(contador_aux);
			
			value_sig.setRealValue(diferencia_real_value);
			
			if(entradas_sig == 0) {
				value_sig.setEntradas(entradas_act);
			}
			
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