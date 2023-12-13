/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marti
 */
public class XMLExporter implements IRepository {

    private static final String RUTA = System.clearProperty("user.home") + File.separator + "Desktop" + File.separator + "datos.json";
    private static final File FILE_REF = new File(RUTA);

    @Override
    public boolean exportarConversacion(ArrayList<Conversation> conversacion) {
        ObjectMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(conversacion);
            Files.write(FILE_REF.toPath(), xml.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList <Conversation> importarConversacion() {
        ObjectMapper xmlMapper = new XmlMapper();
        try (Scanner scannerRef = new Scanner(FILE_REF)) {
            StringBuilder xml = new StringBuilder();
            while (scannerRef.hasNext()) {
                xml.append(scannerRef.nextLine());
            }
            TypeReference <ArrayList<Conversation>> typeReference=new TypeReference<>(){};
            return xmlMapper.readValue(xml.toString(), typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
