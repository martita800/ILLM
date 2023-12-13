/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author marti
 */
public class FraseRandom   {
    String tipo;
    int longitud;
    String contenido;

    public FraseRandom(String tipo, int longitud, String contenido) {
        this.tipo = tipo;
        this.longitud = longitud;
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
   
    public static FraseRandom getFraseFromDelimitedString(String delimitedString, String delimiter){
        
        // Con split es posible separar por el delimitador
        String[] chunks = delimitedString.split(delimiter);
        
        if(chunks.length != 3){
            // Esto proximamente será una excepción
            // Tomamos linea como inválida
            return null;
        }
        
        try{
            String tipo = chunks[0];
            int longitud = Integer.parseInt(chunks[1]);
            String contenido = chunks[2];
            FraseRandom p = new FraseRandom(tipo, longitud, contenido) ;
            return  p;
        }
        catch(Exception e){
            // Tomamos linea como inválida
            return null;
        }
    }
  public String getInstanceAsDelimitedString(String delimiter){
        return String.format(Locale.ENGLISH,"%s"+delimiter+"%d"+delimiter+"%.2f", tipo,longitud,contenido);
    }
}
