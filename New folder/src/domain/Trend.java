/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author macmini
 */
public class Trend implements Serializable {

    int id;
    String ubicacion;//Ciudad 
    int inicio;
    int finalizacion;
    int intervalo;
    String busqueda;//Palabra o frase que busca el usuario
    String[] categoria;
    String[] tipoBusqueda;
    
    
    //Result
    int incXdia;
    int incXSemana;
    int incXintervalo;
    

    public Trend() {
    }

    public void init() {
        
        //Inicialliza las categorias
        tipoBusqueda = new String[10];
        tipoBusqueda[0] = "Busqueda de imagen";
        tipoBusqueda[1] = "Busqueda de noticias";
        tipoBusqueda[2] = "Google shopping";
        tipoBusqueda[3] = "Busqueda de youtube";
        
        
        categoria[0] = "Todas las categorias";
        categoria[1] = "Aficiones y tiempo libre";
        categoria[2] = "Alimentacion y bebidas";
        categoria[3] = "Animales y mascotas";
        
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public int getIncXSemana() {
        return incXSemana;
    }

    public void setIncXSemana(int incXSemana) {
        this.incXSemana = incXSemana;
    }

    public int getIncXdia() {
        return incXdia;
    }

    public void setIncXdia(int incXdia) {
        this.incXdia = incXdia;
    }

    public int getIncXintervalo() {
        return incXintervalo;
    }

    public void setIncXintervalo(int incXintervalo) {
        this.incXintervalo = incXintervalo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getIntervako() {
        return intervalo;
    }

    public void setIntervalo(int intervako) {
        this.intervalo = intervako;
    }

    public int getTermino() {
        return finalizacion;
    }

    public void setTermino(int termino) {
        this.finalizacion = termino;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String[] getCategoria() {
        return categoria;
    }

    public String[] getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String[] tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }
    
    
    
}
