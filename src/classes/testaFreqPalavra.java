package classes;

import java.io.IOException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author beatrizsato
 * 
 * Grupo:
 * 
 * Beatriz Sato
 * Gabriel Paiva Friedmann
 * Marcelo Frost Marchesan
 */
public class testaFreqPalavra {
    public static void main(String[] args) throws IOException {
        
        FreqPalavra contadorPalavra = new FreqPalavra("arquivo.txt");
        System.out.println("Palavras aleatórias: ");
        contadorPalavra.getArvore().inOrdem();
        
        System.out.println("\nLetra de música PT BR: ");
        FreqPalavra contadorMusica = new FreqPalavra("musica.txt");
        contadorMusica.getArvore().inOrdem();
        
        System.out.println("\nLetra de música Ingles: ");
        FreqPalavra contadorMusicaIngles = new FreqPalavra("musica2.txt");
        contadorMusicaIngles.getArvore().inOrdem();
    }
}
