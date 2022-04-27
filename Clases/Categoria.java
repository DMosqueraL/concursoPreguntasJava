/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Categoria {

    BufferedReader bufferLectura = null;
    Pregunta datosPreg = null;
    ArrayList<Pregunta> lista = new ArrayList<>();
    Categoria categoria;

    /**
     * Método para cargar cada una de las categorías a partir de archivos .txt
     * para jugar las 5 rondas
     * @author Doris
     */
    public ArrayList<Pregunta> extraerCategoria(Integer ronda) throws IOException {

        try {
            switch (ronda) {
                case 1:
                    // Abrir el .txt correspondiente a la categoria 1 en buffer de lectura
                    bufferLectura = new BufferedReader(new FileReader("preguntasCat1.txt"));
                    break;
                case 2:
                    // Abrir el .txt correspondiente a la categoria 2 en buffer de lectura
                    bufferLectura = new BufferedReader(new FileReader("preguntasCat2.txt"));
                    break;
                case 3:
                    // Abrir el .txt correspondiente a la categoria 3 en buffer de lectura
                    bufferLectura = new BufferedReader(new FileReader("preguntasCat3.txt"));
                    break;
                case 4:
                    // Abrir el .txt correspondiente a la categoria 4 en buffer de lectura
                    bufferLectura = new BufferedReader(new FileReader("preguntasCat4.txt"));
                    break;
                case 5:
                    // Abrir el .txt correspondiente a la categoria 5 en buffer de lectura
                    bufferLectura = new BufferedReader(new FileReader("preguntasCat5.txt"));
                    break;
            }
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();

            while (linea != null) {
                // Sepapar la linea leída con el separador definido previamente
                String[] preguntas = linea.split(",");

                datosPreg = new Pregunta(preguntas[0], preguntas[1], preguntas[2], preguntas[3], preguntas[4], preguntas[5]);
                lista.add(datosPreg);

                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                }
            }
        }
        return lista;
    }
    
    public ArrayList<Pregunta> cargarCategoria(Integer numeroRonda) throws IOException {
        
        Pregunta pregunta = new Pregunta();
        ArrayList<Pregunta> lista = new ArrayList<>();
        lista = categoria.extraerCategoria(numeroRonda);
        System.out.println(lista);
        return lista;
    }

    

}
