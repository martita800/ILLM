/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author marti
 */
public class FraseLLM {
    ArrayList <String> saludo;       
    ArrayList <String> despedida;
    ArrayList <String> pregunta;
    ArrayList <String> respuesta;
    ArrayList <String> afirmacion;
    ArrayList <String> negacion;
    ArrayList <String> sorpresa;
    ArrayList <String> refran;

    public FraseLLM() {
        this.saludo = new ArrayList<>();
        this.saludo.add("¡Hola! ¿Cómo estás?");
        this.saludo.add("Buenos días, ¡espero que tengas un gran día!");
        this.saludo.add("¡Qué alegría verte!");
        this.saludo.add("Hola, mucho gusto en conocerte");
        this.saludo.add("Saludos cordiales a todos aquí");
        
        this.despedida=new ArrayList<>();
        this.despedida.add("Hasta luego, cuídate mucho");
        this.despedida.add("Adiós, nos vemos pronto");
        this.despedida.add("Que tengas un buen día, nos vemos");
        this.despedida.add("Hasta la próxima, ha sido un placer");
        this.despedida.add("Me voy, pero nos vemos pronto");
        
        this.pregunta=new ArrayList<>();
        this.pregunta.add("¿Cómo te llamas?");
        this.pregunta.add("¿Qué hora es?");
        this.pregunta.add("¿Donde esta el baño?");
        this.pregunta.add("¿Podrías ayudarme, por favor?");
        this.pregunta.add("¿Cuál es tu color favorito?");
        
        this.respuesta=new ArrayList<>();
        this.respuesta.add("Me llamo Juan");
        this.respuesta.add("Son las tres de la tarde");
        this.respuesta.add("El baño está a la derecha");
        this.respuesta.add("Claro, dime en qué puedo ayudarte");
        this.respuesta.add("Mi color favorito es el azul");
        
        this.afirmacion=new ArrayList<>();
        this.afirmacion.add("Estoy completamente de acuerdo");
        this.afirmacion.add("Eso es absolutamente cierto");
        this.afirmacion.add("Sin duda, es la mejor opción");
        this.afirmacion.add("Definitivamente, eso es correcto");
        this.afirmacion.add("Claro que sí, es evidente");
        
        this.negacion=new ArrayList<>();
        this.negacion.add("No estoy de acuerdo con eso");
        this.negacion.add("Eso no es cierto");
        this.negacion.add("De ninguna manera, eso es incorrecto");
        this.negacion.add("No, eso no es lo que quiero");
        this.negacion.add("No, eso no es posible");
        
        this.sorpresa=new ArrayList<>();
        this.sorpresa.add("¡No puedo creerlo!");
        this.sorpresa.add("¡Eso es asombroso!");
        this.sorpresa.add("¡Vaya sorpresa!");
        this.sorpresa.add("¡Increíble, no me lo esperaba!");
        this.sorpresa.add("¡Wow, eso es impresionante!");
        
        this.refran=new ArrayList<>();
        this.refran.add("En abril aguas mil.");
        this.refran.add("A quien madruga dios le ayuda.");
    }

    public String obtenerSaludoAleatorio() {
        return obtenerFraseAleatoria(saludo);
    }

    // Método para obtener una despedida aleatoria
    public String obtenerDespedidaAleatoria() {
        return obtenerFraseAleatoria(despedida);
    }

    // Método para obtener una pregunta aleatoria
    public String obtenerPreguntaAleatoria() {
        return obtenerFraseAleatoria(pregunta);
    }
    
    public String obtenerSorpresaAleatoria() {
        return obtenerFraseAleatoria(sorpresa);
    }
    
    public String obtenerAfirmacionAleatoria() {
        return obtenerFraseAleatoria(afirmacion);
    }
    
    public String obtenerNegacionAleatoria() {
        return obtenerFraseAleatoria(negacion);
    }
    
    public String obtenerRespuestaAleatoria() {
        return obtenerFraseAleatoria(respuesta);
    }
    
    public String obtenerRefranAleatoria() {
        return obtenerFraseAleatoria(refran);
    }

    // Método para obtener una frase aleatoria de una lista dada

    public String obtenerFraseAleatoria(ArrayList<String> lista) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista.size());
        return lista.get(indiceAleatorio);
    }

    
    
    
    
    
    


    
    
}
