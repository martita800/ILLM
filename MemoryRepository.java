/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class MemoryRepository implements IRepository{
     ArrayList <Conversation> conversacion;
     
     public MemoryRepository(int numeroConversacionesaCrear) {

        conversacion = new ArrayList<>();
        // Fake repository
        for (int i = 0; i < numeroConversacionesaCrear; i++) {
            
            ArrayList <Message> mensajes=new ArrayList <>();
            conversacion.add(new Conversation("" , mensajes , "" , "" ));
        }
     }

    @Override
    public boolean exportarConversacion(ArrayList<Conversation> conversacion) {
        this.conversacion.clear();
        for (Conversation c : conversacion) {
            // Creando copias.
            this.conversacion.add(new Conversation(c));
        }
        
        // De otro modo se borraría aquí también ya que apuntan al mismo objeto.

        return true;
    }

    @Override
    public ArrayList<Conversation> importarConversacion() {
        return this.conversacion;
    }
    
}
