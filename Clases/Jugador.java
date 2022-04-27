/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Doris
 */
public class Jugador extends Persona{
    //private String nombre;
    private Integer puntajeJugador = 0;

    public Jugador(String nombreJugador) {
        super(nombreJugador);
        //this.nombre = nombre;
    }

//    public String Nombre() {
//        return super(nombre);
//    }
//
//    public void Nombre(String nombre) {
//        this.nombre = nombre;
//    }

    public Integer PuntajeJugador() {
        return puntajeJugador;
    }

    public void PuntajeJugador(Integer puntajeJug) {
        this.puntajeJugador = puntajeJug;
    }

    @Override
    public String toString() {
        return "Jugador:" + super.nombre() + " - Puntaje: " + puntajeJugador;
    }
    /*
    Método que permite guardar en un archivo txt el nombre del jugador con su respectivo puntaje
    obtenido en el juego.
    No sobreescribe el archivo, continúa en la siguiente línea. Mostrando los datos 
    almacenados previamente (si lo hay)
    */
    public void guardarDatos(String nombre, Integer puntaje) throws FileNotFoundException, IOException{
        File f = new File("historicoJuego.txt");
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(f, true));
            escritor.append(nombre+": "+puntaje);
            escritor.newLine();
            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
