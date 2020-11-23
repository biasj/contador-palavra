/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author beatrizsato
 */
public class FreqPalavra {
    public void carregarTexto() {
        
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
