package model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author marti
 */
public class Conversation implements java.io.Serializable {
    private static final long serialVersionUID=1L;
    
    private String nombreLLM;
    private List<Message> mensajes;
    private String tiempoIni;

    private String tiempoFin;

    public Conversation(String nombreLLM, List<Message> mensajes, String tiempoIni, String tiempoFin) {
        this.nombreLLM = nombreLLM;
        this.mensajes = mensajes;
        this.tiempoIni = tiempoIni;
        this.tiempoFin = tiempoFin;
    }
    public Conversation(Conversation otraC) {
        this.nombreLLM = nombreLLM;
        this.mensajes = mensajes;
        this.tiempoIni = tiempoIni;
        this.tiempoFin = tiempoFin;
    }

    public String getNombreLLM() {
        return nombreLLM;
    }

    public void setNombreLLM(String nombreLLM) {
        this.nombreLLM = nombreLLM;
    }

    public List<Message> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Message> mensajes) {
        this.mensajes = mensajes;
    }

    public String getTiempoIni() {
        return tiempoIni;
    }

    public void setTiempoIni(String tiempoIni) {
        this.tiempoIni = tiempoIni;
    }

    public String getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(String tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public Object getMensaje() {
        if (mensajes != null && !mensajes.isEmpty()) {
            return mensajes.get(0); // Devuelve el primer mensaje de la lista
        } else {
            return "No hay mensajes disponibles"; // Manejo de casos donde no hay mensajes
        }
    }

    public void agregarMensaje(String mensaje, String emisor) {
        if (mensajes == null) {
            mensajes = new ArrayList<>(); // Inicializa la lista si es null
        }
        String contenido = mensaje;
        long unixTimeSegs = System.currentTimeMillis() / 1000; // Obtiene el tiempo actual en segundos desde la época Unix
        Message nuevoMensaje = new Message(emisor, contenido, unixTimeSegs); // Suponiendo que Message es tu clase de mensaje
        mensajes.add(nuevoMensaje);
    }

   /* String getInstanceAsDelimitedString(String delimitador) {
        return String.format(Locale.ENGLISH, "%s" + delimitador + "%s" + delimitador + "%s" + delimitador + "%s", nombreLLM, obtenerComoString(mensajes), tiempoIni, tiempoFin);
    }*/

    /*private String obtenerComoString(List<Message> mensajes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Message mensaje : mensajes) {
            String contenido = mensaje.getContenido();
            if (contenido != null && !contenido.isEmpty()) {
                stringBuilder.append(contenido.substring(0, Math.min(20, contenido.length()))).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
/*
    static Conversation getPersonFromDelimitedString(String linea, String delimitador) {
        // Con split es posible separar por el delimitador
        String[] chunks = delimitedString.split(delimitador);

        if (chunks.length != 4) {
            // Esto proximamente será una excepción
            // Tomamos linea como inválida
            return null;
        }

        try {
            String nombreLLM = chunks[0];
            String nombre = chunks[1];
            String tiempoIni = chunks[2];
            String tiempoFin = chunks[3];
            Conversation p = new Conversation(nombreLLM, mensajes, tiempoIni, tiempoFin);
            return p;
        } catch (Exception e) {
            // Tomamos linea como inválida
            return null;
        }
    */
    
    
    


   @Override
    public String toString() {
        return "Conversation{" + "nombreLLM=" + nombreLLM + ", mensajes=" + mensajes + ", tiempoIni=" + tiempoIni + ", tiempoFin=" + tiempoFin + '}';
    }
}
