package com.stcm.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.CsvBindByName;

public class TorniqueteCount {
	
    @CsvBindByName(column = "entradas")
    private long entradas;  

    @CsvBindByName(column = "fechaContador")
    private String fechaContador; // Temporalmente como String (ver nota abajo)

    @CsvBindByName(column = "RealValue")
    private long realValue;

    @CsvBindByName(column = "Evaluar")
    private int evaluar;

    @CsvBindByName(column = "fechaRegistro")
    private String fechaRegistro; // Temporalmente como String (ver nota abajo)o;
    
    @CsvBindByName(column = "ContadorAuxiliar")
    private long contadorAuxiliar;

	public TorniqueteCount() {
    	
    }
	
    // Getters y Setters

    public long getEntradas() { 
    	return entradas; 
    }
    
    public void setEntradas(long entradas) { 
    	this.entradas = entradas; 
    }

    public String getFechaContador() { 
    	return fechaContador; 
    }
    public void setFechaContador(String fechaContador) { 
    	this.fechaContador = fechaContador; 
    }

    public long getRealValue() { 
    	return realValue; 
    }
    public void setRealValue(long realValue) { 
    	this.realValue = realValue; 
    }

    public int getEvaluar() { return evaluar; }
    public void setEvaluar(int evaluar) { 
    	this.evaluar = evaluar; 
	}

    public String getFechaRegistro() { 
    	return fechaRegistro; 
    }
    
    public void setFechaRegistro(String fechaRegistro) { 
    	this.fechaRegistro = fechaRegistro; 
	}
    
    public long getContadorAuxiliar() {
		return contadorAuxiliar;
	}

	public void setContadorAuxiliar(long contadorAuxiliar) {
		this.contadorAuxiliar = contadorAuxiliar;
	}

    @Override
    public String toString() {
        return "\t  | "+entradas + " | " + fechaContador + " | " + realValue + " | " + evaluar + " | " + fechaRegistro + " | "+ contadorAuxiliar+ " \t     | ";
    }

    // Métodos para convertir fechas 
    public LocalDateTime getFechaContadorAsDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(fechaContador, formatter);
    }

    public LocalDateTime getFechaRegistroAsDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(fechaRegistro, formatter);
    }
	
	

}
