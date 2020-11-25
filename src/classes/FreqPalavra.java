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
 * Grupo:
 * 
 * Beatriz Sato
 * Gabriel Paiva Friedmann
 * Marcelo Frost Marchesan
 */
public class FreqPalavra {
    
	public void carregarTexto(String arquivo) throws FileNotFoundException, IOException {
        
    	 BufferedReader reader = new BufferedReader(new FileReader(arquivo));

         String linha, palavra, naoPalavra;
         String linhaEntrada[];
         ABB arvore = new ABB();
         int PosicaoLinha;
         
         naoPalavra = "";
         
         try {
             
             if (reader == null) {
                    return;
             }
                 
             linha = reader.readLine();
             PosicaoLinha = 0;

             while (linha != null && !linha.equals("0")) {
                 
                 Pattern lpPalavra = Pattern.compile("[a-zA-ZÀ-ú]+");

                 Matcher lmPalavra = lpPalavra.matcher(linha);

                 Boolean lbExistePalavra;

                 lbExistePalavra = lmPalavra.find();

                 while (lbExistePalavra) {
                                         
                     // retirar a palavra da linha desde a posição start até end -1 e armazenar em uma variável
                     palavra = linha.substring(lmPalavra.start(), lmPalavra.end());
  
                     // LÓGICA DE MANIPULAÇÃO DA LISTA E DO ARQUIVO
                     
                     this.buscaInsere(palavra, arvore);
//                     // busca a palavra na lista
//                     No temp = arvore.buscaRecursiva(palavra);
//
//                     // se palavra não estiver na lista
//                     if (temp == null) {
//                         // insere no início da lista
//                    	 arvore.insereRecursivo(palavra);
//
//                     } else {
//                         // pega a posição na lista e escreve no arquivo 
//                         buscaInsere(palavra, arvore);
//
//                     }
                     
                     // atualizar a nova posição de leitura na linha
                     PosicaoLinha = lmPalavra.end();
                     
                     lbExistePalavra = lmPalavra.find();

                 }
                 
                 // lê a próxima linha
                 linha = reader.readLine();
                 PosicaoLinha = 0;
             }

             // encerra comunicação entre arquivo lógico e físico, não encerra arquivo físico
             reader.close();

             System.out.println(arvore);

         } catch (FileNotFoundException e) {
             System.out.println(e);
         } catch (IOException e) {
             System.out.println(e);
         }
    	

    }
    
    public void buscaInsere(String palavra, ABB arvore) {
        No achado = null;
        achado = arvore.buscaRecursiva(palavra);
        
        // se palavra existir na arvore, aumenta o contador
        if(achado != null) {
            int cont = achado.getFrequencia();
            cont++;
            achado.setFrequencia(cont);
        } else {            
            arvore.insereRecursivo(palavra);
        }
    }
}
