/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObtenerRandom implements ILLM {

    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "input.csv");
    String delimitador = ";";

    List<FraseRandom> frasesLeidas = importarDelimitado(ruta, delimitador);

    private List<FraseRandom> importarDelimitado(Path ruta, String delimitador) {
        ArrayList<FraseRandom> fraseR = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                FraseRandom p = FraseRandom.getFraseFromDelimitedString(linea, delimitador);
                if (p != null) {
                    fraseR.add(p);
                }
            }
        } catch (IOException e) {
            // En otros ejemplos propagaremos una exception
            return null;
        }

        return fraseR;
    }

    @Override
    public String obtenerFrase(String mensajeUsuario) {

        if (mensajeUsuario.toLowerCase().contains("hola")) {
            ArrayList<String> lista = new ArrayList<>();
            for (int i = 0; i < frasesLeidas.size(); i++) {
                FraseRandom f = frasesLeidas.get(i);
                if (f.getTipo().toLowerCase().contains("saludo")) {
                    lista.add(f.getContenido());
                }
            }
            return obtenerFraseAleatoria(lista);
        } else {
            if (mensajeUsuario.toLowerCase().contains("adios")) {
                ArrayList<String> lista = new ArrayList<>();
                for (int i = 0; i < frasesLeidas.size(); i++) {
                    FraseRandom f = frasesLeidas.get(i);
                    if (f.getTipo().toLowerCase().contains("despedida")) {
                        lista.add(f.getContenido());
                    }
                }
                return obtenerFraseAleatoria(lista);
            } else {
                if (mensajeUsuario.toLowerCase().contains("algo")) {
                    ArrayList<String> lista = new ArrayList<>();
                    for (int i = 0; i < frasesLeidas.size(); i++) {
                        FraseRandom f = frasesLeidas.get(i);
                        if (f.getTipo().toLowerCase().contains("pregunta")) {
                            lista.add(f.getContenido());
                        }
                    }
                    return obtenerFraseAleatoria(lista);
                } else {
                    if (mensajeUsuario.toLowerCase().contains("?")) {
                        ArrayList<String> lista = new ArrayList<>();
                        for (int i = 0; i < frasesLeidas.size(); i++) {
                            FraseRandom f = frasesLeidas.get(i);
                            if (f.getTipo().toLowerCase().contains("respuesta")) {
                                lista.add(f.getContenido());
                            }
                        }
                        return obtenerFraseAleatoria(lista);
                    } else {
                        if (mensajeUsuario.toLowerCase().contains("creo")) {
                            ArrayList<String> lista = new ArrayList<>();
                            for (int i = 0; i < frasesLeidas.size(); i++) {
                                FraseRandom f = frasesLeidas.get(i);
                                if (f.getTipo().toLowerCase().contains("afirmacion")) {
                                    lista.add(f.getContenido());
                                }
                            }
                            return obtenerFraseAleatoria(lista);
                        } else {
                            if (mensajeUsuario.toLowerCase().contains("pienso")) {
                                ArrayList<String> lista = new ArrayList<>();
                                for (int i = 0; i < frasesLeidas.size(); i++) {
                                    FraseRandom f = frasesLeidas.get(i);
                                    if (f.getTipo().toLowerCase().contains("negacion")) {
                                        lista.add(f.getContenido());
                                    }
                                }
                                return obtenerFraseAleatoria(lista);
                            } else {
                                if (mensajeUsuario.toLowerCase().contains("sabes")) {
                                    ArrayList<String> lista = new ArrayList<>();
                                    for (int i = 0; i < frasesLeidas.size(); i++) {
                                        FraseRandom f = frasesLeidas.get(i);
                                        if (f.getTipo().toLowerCase().contains("sorpresa")) {
                                            lista.add(f.getContenido());
                                        }
                                    }
                                    return obtenerFraseAleatoria(lista);
                                } else {
                                    if (mensajeUsuario.toLowerCase().contains("refran")) {
                                        ArrayList<String> lista = new ArrayList<>();
                                        for (int i = 0; i < frasesLeidas.size(); i++) {
                                            FraseRandom f = frasesLeidas.get(i);
                                            if (f.getTipo().toLowerCase().contains("refran")) {
                                                lista.add(f.getContenido());
                                            }
                                        }
                                        return obtenerFraseAleatoria(lista);
                                    } else {
                                        return "no puedo responder a eso";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String obtenerFraseAleatoria(ArrayList<String> lista) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista.size());
        return lista.get(indiceAleatorio);
    }

    @Override
    public String getNOmbreILLM() {
        String nombre = "random";
        return nombre;
    }

}
