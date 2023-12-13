package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marti
 */
public class Model {

    private ArrayList<Conversation> conversacion;
    private ArrayList<Message> listaMensajes;

     IRepository repository;
    ILLM illm;
    File ficheroEstadoSerializado;

    public Model(IRepository repository, ILLM illm) {
        this.illm = illm;
            
        this.repository = repository;

        ficheroEstadoSerializado = Paths.get(System.getProperty("user.home"), "Desktop", "model.bin").toFile();
        conversacion = new ArrayList<>();
    }

    
    public boolean guardarEstadoAplicación() {
        ObjectOutputStream oos = null;
        
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ficheroEstadoSerializado));
            oos.writeObject(conversacion);
            return true;
        } catch (IOException ex) {
            // Dejamos el error para la depuración, por el canal err.
            System.err.println("Error durante la serialización: " + ex.getMessage());
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    // Dejamos el error para la depuración, por el canal err.
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                    return false;
                }
            }
        }
    }

    public boolean cargarEstadoAplicación() {
        if (ficheroEstadoSerializado.exists() && ficheroEstadoSerializado.isFile()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroEstadoSerializado));
                this.conversacion = (ArrayList<Conversation>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                // Dejamos el error para la depuración, por el canal err.
                System.err.println("Error durante la deserialización: " + ex.getMessage());
                return false;
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        // Dejamos el error para la depuración, por el canal err.
                        System.err.println("Error durante la deserialización: " + ex.getMessage());
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    
    public void agregarMensaje(String mensaje, String emisor) {
        String nombreLL = illm.getNOmbreILLM();
        String tiempoIni ;
        String tiempoFin;
        Message nuevoMensaje;
       
        Instant instant = Instant.now(); // Obtener tiempo actual en formato Unix Epoch para el nuevo mensaje
        long tiempoActual = instant.getEpochSecond();
                if (listaMensajes == null) {
            listaMensajes = new ArrayList<>(); // Inicializa la lista si es null
            //tiempoIni=String.valueOf(tiempoActual);
            //System.out.println(mensaje);
        }

        nuevoMensaje = new Message(emisor, mensaje, tiempoActual);
        listaMensajes.add(nuevoMensaje);

        if (mensaje.equalsIgnoreCase("/salir")) {

            instant = Instant.now(); // Obtener tiempo actual al salir en formato Unix Epoch
            tiempoFin = String.valueOf(instant.getEpochSecond());
            tiempoFin=toDate(tiempoFin);
            List<Message> mensajesParaConversacion = new ArrayList<>(listaMensajes);

            if (!listaMensajes.isEmpty()) {
                Message primerMensaje = listaMensajes.get(0);
                tiempoIni = String.valueOf(primerMensaje.getUnixTimeSegs());
                Conversation nuevaConversacion = new Conversation(nombreLL, mensajesParaConversacion, tiempoIni, tiempoFin);
                conversacion.add(nuevaConversacion);
            }
            listaMensajes.clear();
        }
    }

    /*public String enviarMensaje() {

    }*/
    public boolean eliminarConversacion(int numero) {

        if (numero >= 0 && numero < conversacion.size()) {
            conversacion.remove(numero);
            return true; // La conversación fue eliminada
        } else {
            return false; // El número de conversación proporcionado no es válido
        }
    }

    public boolean importarConversacion() {
        ArrayList<Conversation> conversacionImportada = repository.importarConversacion();
        if (conversacionImportada != null) {
            for (Conversation conver : conversacionImportada) {
                if (!conversacion.contains(conver)) {
                    conversacion.add(conver);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean exportarConversacion() {
        return repository.exportarConversacion(conversacion);

    }

    public List<Conversation> obtenerConversacionInmutable() {

        List<Conversation> listaCopia = new ArrayList<>(conversacion.size());

        for (Conversation conver : conversacion) {
            listaCopia.add(conver);
        }

        return listaCopia;

    }

    public String enviarMensaje(String mensajeUsuario) {

        return illm.obtenerFrase(mensajeUsuario);
    }
    
    public String toDate(String tiempo){
         long timestampSeconds = Long.parseLong(tiempo);

        // Convertir el timestamp en segundos a un LocalDateTime
        Instant instant = Instant.ofEpochSecond(timestampSeconds);
        LocalDateTime fecha = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        // Formatear la fecha según tu preferencia
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Puedes ajustar el patrón de formato según tu necesidad
        String fechaFormateada = fecha.format(formatter);

        return fechaFormateada;
    }
}
