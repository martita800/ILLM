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
public class ObtenerFake implements ILLM {

    @Override
    public String obtenerFrase(String mensajeUsuario) {
        FraseLLM respuesta = new FraseLLM();
        if (mensajeUsuario.toLowerCase().contains("hola")) {
            return respuesta.obtenerSaludoAleatorio();
        } else {
            if (mensajeUsuario.toLowerCase().contains("adios")) {
                return respuesta.obtenerDespedidaAleatoria();
            } else {
                if (mensajeUsuario.toLowerCase().contains("algo")) {
                    return respuesta.obtenerPreguntaAleatoria();
                } else {
                    if (mensajeUsuario.toLowerCase().contains("?")) {
                        return respuesta.obtenerRespuestaAleatoria();
                    } else {
                        if (mensajeUsuario.toLowerCase().contains("creo")) {
                            return respuesta.obtenerAfirmacionAleatoria();
                        } else {
                            if (mensajeUsuario.toLowerCase().contains("pienso")) {
                                return respuesta.obtenerNegacionAleatoria();
                            } else {
                                if (mensajeUsuario.toLowerCase().contains("sabes")) {
                                    return respuesta.obtenerSorpresaAleatoria();
                                } else {
                                    if (mensajeUsuario.toLowerCase().contains("refran")) {
                                        return respuesta.obtenerRefranAleatoria();
                                    } else {
                                        return "no se que responder a eso";
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

    }

    @Override
    public String getNOmbreILLM() {
        String nombre = "fake";
        return nombre;
    }
}
