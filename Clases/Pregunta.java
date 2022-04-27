/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Doris
 */
public class Pregunta {
    private String textoPreg;
    private String opcA;
    private String opcB;
    private String opcC;
    private String opcD;
    private String respCorrecta;

    public Pregunta() {
    }

    public Pregunta(String textoPreg, String opcA, String opcB, String opcC, String opcD, String respCorrecta) {
        this.textoPreg = textoPreg;
        this.opcA = opcA;
        this.opcB = opcB;
        this.opcC = opcC;
        this.opcD = opcD;
        this.respCorrecta = respCorrecta;
    }

    public String TextoPreg() {
        return textoPreg;
    }

    public void TextoPreg(String textoPreg) {
        this.textoPreg = textoPreg;
    }

    public String OpcA() {
        return opcA;
    }

    public void OpcA(String opcA) {
        this.opcA = opcA;
    }

    public String OpcB() {
        return opcB;
    }

    public void OpcB(String opcB) {
        this.opcB = opcB;
    }

    public String OpcC() {
        return opcC;
    }

    public void OpcC(String opcC) {
        this.opcC = opcC;
    }

    public String OpcD() {
        return opcD;
    }

    public void OpcD(String opcD) {
        this.opcD = opcD;
    }

    public String RespCorrecta() {
        return respCorrecta;
    }

    public void RespCorrecta(String respCorrecta) {
        this.respCorrecta = respCorrecta;
    }
    
    @Override
    public String toString() {
        return "Pregunta:\n\t "+ textoPreg + "\n\nA. " + opcA + "\tB. " + opcB + "\nC. " + opcC + "\tD. " + opcD;
    }
    
    /**
     * Método para cargar una pregunta elegida al azar de una categoría/ronda de juego
     * @param categoria
     * @return 
     */
    public Pregunta cargarPreguntaAleatoria(ArrayList<Pregunta> categoria) {
        //Método para cargar pregunta aleatoria
        Pregunta pregAleatoria = new Pregunta();
        Integer num = (int)(Math.random() * categoria.size());
        pregAleatoria = categoria.get(num);
        System.out.println(pregAleatoria.toString());
        System.out.println("");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        return pregAleatoria;
    }
}
