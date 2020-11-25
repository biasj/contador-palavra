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
 */

public class testaFreqPalavra {
    public static void main(String[] args) throws IOException {
        
        FreqPalavra contadorPalavra = new FreqPalavra();
        
        contadorPalavra.carregarTexto("arquivo.txt");
        
        
    }
}
