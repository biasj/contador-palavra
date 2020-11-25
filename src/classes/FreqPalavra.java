/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class FreqPalavra {
    private String arquivo;
    private ABB arvore;

    public FreqPalavra(String arquivo) throws IOException {
        this.arquivo = arquivo;
        arvore = new ABB();
        carregarTexto();
    }

    public ABB getArvore() {
        return arvore;
    }
    
    public void carregarTexto() throws FileNotFoundException, IOException {
        
    	 BufferedReader reader = new BufferedReader(new FileReader(arquivo));

         String linha, palavra;
         int posicaoLinha = 0;
                  
         try {
             
             if (reader == null) {
                    return;
             }
                 
             linha = reader.readLine();

             while (linha != null && !linha.equals("0")) {
                 
                 Pattern lpPalavra = Pattern.compile("[a-zA-ZÀ-ú]+");
                 Matcher lmPalavra = lpPalavra.matcher(linha);
                 Boolean lbExistePalavra;
                 lbExistePalavra = lmPalavra.find();

                 while (lbExistePalavra) {
                                         
                     // retirar a palavra da linha desde a posição start até end -1 e armazenar em uma variável
                     palavra = linha.substring(lmPalavra.start(), lmPalavra.end());
  
                     // LÓGICA DE MANIPULAÇÃO DA LISTA E DO ARQUIVO
                     this.buscaInsere(palavra);
             
                     posicaoLinha = lmPalavra.end();
                     lbExistePalavra = lmPalavra.find();
                 }
                 
                 // lê a próxima linha
                 linha = reader.readLine();
                 posicaoLinha = 0;
             }

             // encerra comunicação entre arquivo lógico e físico, não encerra arquivo físico
             reader.close();

         } catch (FileNotFoundException e) {
             System.out.println(e);
         } catch (IOException e) {
             System.out.println(e);
         }
    }
    
    // verifica se palavra está na arvore e insere ou adiciona contador
    public void buscaInsere(String palavra) {
        No achado = arvore.buscaRecursiva(palavra);
        
        // se palavra existir na arvore, aumenta o contador
        if(achado != null) {
            int cont = achado.getFrequencia();
            achado.setFrequencia(++cont);
        } else {            
            arvore.insereRecursivo(palavra);
        }
    }
}
