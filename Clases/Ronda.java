/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Interfaces.IPuntajeRonda;
import Clases.Interfaces.ICategoria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Doris
 */
public class Ronda implements IPuntajeRonda, ICategoria {

    private Integer numeroRonda;
    private Integer puntajeRonda;
    private Integer acumPuntaje;

    Pregunta pregunta = new Pregunta();
    Categoria categoria = new Categoria();

    public Ronda() {
    }

    public Ronda(Integer numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Integer numeroRonda() {
        return numeroRonda;
    }

    public void numeroRonda(Integer numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Integer acumPuntaje() {
        return acumPuntaje;
    }

    public void acumPuntaje(Integer acumPuntaje) {
        this.acumPuntaje = acumPuntaje;
    }

    /**
     * Métodos para traer los puntajes de cada ronda
     *
     *
     * @param numeroRonda
     */
    public void puntajeRonda1(Integer numeroRonda) {
        if (numeroRonda == 1) {
            this.puntajeRonda = PUNTAJE_RONDA_1;
        }
    }

    public void puntajeRonda2(Integer numeroRonda) {
        if (numeroRonda == 2) {
            this.puntajeRonda = PUNTAJE_RONDA_2;
        }
    }

    public void puntajeRonda3(Integer numeroRonda) {
        if (numeroRonda == 3) {
            this.puntajeRonda = PUNTAJE_RONDA_3;
        }
    }

    public void puntajeRonda4(Integer numeroRonda) {
        if (numeroRonda == 4) {
            this.puntajeRonda = PUNTAJE_RONDA_4;
        }
    }

    public void puntajeRonda5(Integer numeroRonda) {
        if (numeroRonda == 5) {
            System.out.println("¡¡¡ÚLTIMA RONDA!!!");
            this.puntajeRonda = PUNTAJE_RONDA_5;
        }
    }

    /**
     * Métodos para traer los nombres de las categorías, es decir, especificar
     * el nivel de dificultad de la ronda que se está jugando
     * @param numeroRonda
     * @return 
     */
    public String nombreCategoria(Integer numeroRonda) {
        String nombreCategoria = "";

        switch (numeroRonda) {
            case 1:
                nombreCategoria = NOMBRE_CATEGORIA_1;
                break;
            case 2:
                nombreCategoria = NOMBRE_CATEGORIA_2;
                break;
            case 3:
                nombreCategoria = NOMBRE_CATEGORIA_3;
                break;
            case 4:
                nombreCategoria = NOMBRE_CATEGORIA_4;
                break;
            case 5:
                nombreCategoria = NOMBRE_CATEGORIA_5;
                break;
        }
        return nombreCategoria;
    }

    /**
     * Método para la ronda final
     * @param numeroRonda
     * @param nombreJugador
     */
    public void ganarJuego(Integer numeroRonda, String nombreJugador) {
        if (numeroRonda == 6) {
            System.out.println("\t¡¡¡FELICITACIONES!!! " + nombreJugador + "\n\t\tHAZ GANADO EL JUEGO \n\n\t\t¡¡¡2000 PUNTOS!!! \n\n\t\tGRACIAS POR JUGAR ^_^");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }

    /**
     * Método para cargar la categoría de acuerdo al número de ronda.     *
     * @param numeroRonda
     * @return
     * @throws IOException
     */
    public ArrayList<Pregunta> cargarCategoria(Integer numeroRonda) throws IOException {
        
        Pregunta pregunta = new Pregunta();
        ArrayList<Pregunta> listaCategoria = new ArrayList<>();
        listaCategoria = categoria.extraerCategoria(numeroRonda);
        return listaCategoria;
    }

    /**
     * Método para capturar la respuesta dada por el jugador a la pregunta al
     * azar mostrada en consola     *
     * @param lector
     * @return
     */
    public String capturaRespuesta(Scanner lector) {
        System.out.println("");
        System.out.print("Dígite su respuesta: ");
        String respJug = lector.next().toUpperCase();
        System.out.println("");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        return respJug;
    }

    /**
     * Este método muestra los datos básicos de cada ronda: Ronda en la que se
     * está jugando Premio de la ronda Nivel de dificultad de la ronda
     * @param numeroRonda
     */
    public void mostrarDatosRonda(Integer numeroRonda) {
        System.out.println("");
        System.out.println("Ronda N° " + numeroRonda);
        puntajeRonda1(numeroRonda);
        puntajeRonda2(numeroRonda);
        puntajeRonda3(numeroRonda);
        puntajeRonda4(numeroRonda);
        puntajeRonda5(numeroRonda);
        System.out.println("Premio: " + puntajeRonda + " puntos.");
        System.out.println("Categoría: " + nombreCategoria(numeroRonda));
        nombreCategoria(numeroRonda);
        System.out.println("");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    /**
     * Método para iniciar el juego y jugarlo
     * @param numeroRonda
     * @param nombreJugador
     * @throws IOException
     */
    public void jugarRonda(Integer numeroRonda, String nombreJugador) throws IOException {
        boolean salir = false;
        Scanner lector = new Scanner(System.in);
        while (numeroRonda < 6 && !salir) {
            mostrarDatosRonda(numeroRonda);

            ArrayList<Pregunta> categoria = cargarCategoria(numeroRonda);
            Pregunta pregAleatoria = pregunta.cargarPreguntaAleatoria(categoria);

            if (numeroRonda > 1) {
                System.out.print("¿Desea seguir jugando? S/N: ");
                String seguir = lector.next().toUpperCase();
                if (seguir.equals("N")) {
                    System.out.println("");
                    System.out.println(nombreJugador + " obtuviste " + acumPuntaje + " puntos.");
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    break;
                }
            }

            String respJug = capturaRespuesta(lector);

            while (respJug != null) {
                this.acumPuntaje = 0;
                if (respJug.equalsIgnoreCase(pregAleatoria.RespCorrecta())) {
                    System.out.println("\n\t¡¡¡Respuesta Correcta!!! \n");
                    this.acumPuntaje += this.puntajeRonda;
                    numeroRonda++;
                    categoria.clear();
                    break;
                } else {
                    System.out.println("\n\t¡¡¡Nooooooo!!! Respuesta Incorrecta \n\n\tGracias por jugar ^_^\n");
                    this.acumPuntaje = 0;
                    salir = true;
                    break;
                }
            }
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
        ganarJuego(numeroRonda, nombreJugador);
    }

}
