/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *//*
package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marti
 *//*
public class TSVRepository implements IRepository {

    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos.tsv");
    String delimitador = "\t";

    public TSVRepository() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean exportarConversacion(ArrayList<Conversation> conversacion) {
        ArrayList<String> lineas = new ArrayList<>();
        for (Conversation conver : conversacion) {
            lineas.add(conver.getInstanceAsDelimitedString(delimitador));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            System.err.println("Ocurrió un error al intentar exportar las personas: " + e.getMessage());
            return false;
        }

    }

    @Override
    public ArrayList<Conversation> importarConversacion() {
        ArrayList<Conversation> conversacion = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Conversation p = Conversation.getPersonFromDelimitedString(linea, delimitador);
                if (p != null) {
                    conversacion.add(p);
                }
            }
            return conversacion;
        } catch (IOException e) {
            // En otros ejemplos propagaremos una exception
            return null;
        }
    }

    

}*/
