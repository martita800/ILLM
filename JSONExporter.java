/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marti
 */
public class JSONExporter implements IRepository {

    @Override
    public boolean exportarConversacion(ArrayList<Conversation> conversacion) {
        String RUTA = System.clearProperty("user.home") + File.separator + "Desktop" + File.separator + "datos.json";
        File FILE_REF = new File(RUTA);
        Gson gson = new Gson();
        String json = gson.toJson(conversacion);

        try {
            Files.write(FILE_REF.toPath(), json.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Conversation> importarConversacion() {
        String RUTA = System.clearProperty("user.home") + File.separator + "Desktop" + File.separator + "datos.json";
        File FILE_REF = new File(RUTA);
        Gson gson = new Gson();
        
        try {
            String json = new String(Files.readAllBytes(FILE_REF.toPath()), StandardCharsets.UTF_8);
            Type conversationListType = new TypeToken<ArrayList<Conversation>>(){}.getType();
            return gson.fromJson(json, conversationListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
