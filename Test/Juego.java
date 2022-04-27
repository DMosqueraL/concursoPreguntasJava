/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Clases.Jugador;
import Clases.Ronda;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Doris
 */
public class Juego {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        String nombreJugador = mostrarBienvenida();
        Jugador jugador = new Jugador(nombreJugador);
        Ronda ronda = new Ronda(1);
        Integer numeroRonda = ronda.numeroRonda();
        ronda.jugarRonda(numeroRonda, nombreJugador);
        jugador.PuntajeJugador(ronda.acumPuntaje());
        jugador.guardarDatos(jugador.nombre(), jugador.PuntajeJugador());
    }

    public static String mostrarBienvenida() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("");
        System.out.print("\t¡¡¡BIENVENIDO AL CHALLENGE SOFKA!!! \n\t\tEl desafío es contigo\n\nIngrese nombre del jugador: ");
        Scanner lector = new Scanner(System.in);
        String nombreJugador = lector.next();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        return nombreJugador;
    }
}
