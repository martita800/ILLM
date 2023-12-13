/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.ArrayList;


public interface IRepository {

    public boolean exportarConversacion(ArrayList<Conversation> conversacion);

    public ArrayList <Conversation> importarConversacion();
    
}
