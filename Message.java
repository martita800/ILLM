/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.temporal.Temporal;

/**
 *
 * @author marti
 */
public class Message implements java.io.Serializable  {
    private String emisor;
    private String contenido;

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setUnixTimeSegs(long unixTimeSegs) {
    }

    public String getEmisor() {
        return emisor;
    }

    public String getContenido() {
        return contenido;
    }

    public long getUnixTimeSegs() {
        return System.currentTimeMillis()/1000L;
    }

    public Message(String emisor, String contenido, long unixTimeSegs) {
        this.emisor = emisor;
        this.contenido = contenido;
    }
}
