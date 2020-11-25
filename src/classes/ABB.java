package classes;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author beatrizsato
 */
public class ABB {
    private No raiz;
    
    // cria a árvore binária de busca
    public ABB() {
        this.raiz = null;
    }
    
    // verificar se arvore está vazia
    public boolean vazia() {
        return raiz == null;
    }
    
    // versão iterativa
    public void insere(String palavra) {
        No pai = null; // anterior
        No p = raiz;
        No novo = new No(palavra, 1, null, null);
                
        while(p != null) {
            pai = p;
            
            // compara elemento para ver se vai p esq ou dir
            if(palavra.compareToIgnoreCase(p.getPalavra()) < 0) {
//            if( palavra < p.getPalavra()) {
                // caminha pra esquerda
                p = p.getEsq();
            } else {
                p = p.getDir();
            }
        }
        
        // tem que checar se a árvore está vazia
        if(vazia()) {
            raiz = novo;
            return;
        }
        
        // sai desse laço quando p == null
        // precisa saber se vai pra dir ou esq
        if(palavra.compareToIgnoreCase(pai.getPalavra()) < 0)
//        if( palavra < pai.getPalavra())
            pai.setEsq(novo);
        else
            pai.setDir(novo);
    }

    public void insereRecursivo(String palavra) {
        
        if(vazia()) {
            raiz = new No(palavra, 1, null, null);
            return;
        }
        
        No novo = new No(palavra, 1, null, null);
        
        insereRecursivo(raiz, novo);
    }
    
    public void insereRecursivo(No p, No novo) {
        // qual é o caso base: já chegou
        // precisa saber se vai pra dir ou esq
        if(novo.getPalavra().compareToIgnoreCase(p.getPalavra()) < 0) {
//        if( novo.getPalavra() < p.getPalavra()) {
            if(p.getEsq() == null) {
                p.setEsq(novo);
            } else {
                // continua descendo pra esquerda
                insereRecursivo(p.getEsq(), novo);
            }
        } else {
            if(p.getDir() == null) {
                p.setDir(novo);
            } else {
                // continua descendo pra dir
                insereRecursivo(p.getDir(), novo);
            } 
        }
    }
    
    // PERCURSOS NA ÁRVORE
    public void preOrdem() {
        preOrdem(raiz);
    }
    
    public void preOrdem(No p) {
        if(p != null) {
            System.out.print(p.getPalavra() + " ");
            preOrdem(p.getEsq());
            preOrdem(p.getDir());
        }
    }
    
    public void inOrdem() {
        inOrdem(raiz);
    }
    
    public void inOrdem(No p) {
        if(p != null) {
            inOrdem(p.getEsq());
            System.out.print(p.getPalavra() + " ");
            inOrdem(p.getDir());   
        }
        
    }
    
    public void posOrdem() {
        posOrdem(raiz);
    }
    
    public void posOrdem(No p) {
        if(p!= null) {
            posOrdem(p.getEsq());
            posOrdem(p.getDir());
            System.out.print(p.getPalavra() + " ");  
        }
    }
    
    // BUSCAS
    // iterativa
    public No buscaIterativa(String palavra) {
        No p = raiz;
        while (p!=null) {
            if(p.getPalavra().equals(palavra)) {
                return p;
            } else {
                // compara elemento para ver se vai p esq ou dir
                if(palavra.compareToIgnoreCase(p.getPalavra()) < 0) {
//                if( palavra < p.getPalavra()) {
                    // caminha pra esquerda
                    p = p.getEsq();
                } else {
                    p = p.getDir();
                }
            }
                
        }
        
        return null;
    }
    
    public No buscaRecursiva(String palavra) {
        return buscaRecursiva(palavra, raiz);
    }
    
    public No buscaRecursiva(String palavra, No p) {
        if(p == null)
            return null;
        
        if (p.getPalavra().equals(palavra))
            return p;
      
        if(palavra.compareToIgnoreCase(p.getPalavra()) < 0)
//        if(palavra < p.getPalavra()) 
            return buscaRecursiva(palavra, p.getEsq());
            
            else 
                return buscaRecursiva(palavra, p.getDir());
        
    }
    
    // achar maior nó -> na direita??
    public No maiorElemento() {
        No p = raiz;
        
        while (p.getDir() != null) {
            p = p.getDir();
        }
        
        return p;
    }

    public No maiorRecursivo() {
        return maiorRecursivo(raiz);
    }
    
    public No maiorRecursivo(No p) {
        if(p == null) 
            return null;
        
        if(p.getDir() == null) 
            return p;
        
        return maiorRecursivo(p.getDir());
    }
    
    public No menorElemento() {
        No p = raiz;
        
        while(p.getEsq() != null) {
            p = p.getEsq();
        }
        return p;
    }
    
    public No menorRecursivo() {
        return menorRecursivo(raiz);
    }
    
    public No menorRecursivo(No p){
        if(p == null)
            return null;
        
        if(p.getEsq() == null)
            return p;
        
        return menorRecursivo(p.getEsq());
    }
    
    //Método que remove um nó na ABB
    public No remove(String palavra){
        return remove(raiz,palavra);
    }
    public No remove(No p, String palavra){
        if (p==null)
            return null; //Não achei
        
        if(palavra.compareToIgnoreCase(p.getPalavra()) < 0)
//        if (palavra<p.getPalavra())
            p.setEsq(remove(p.getEsq(),palavra));
//        else if (palavra>p.getPalavra())
        else if(palavra.compareToIgnoreCase(p.getPalavra()) > 0)
            p.setDir(remove(p.getDir(),palavra));
        else {
             //elemento==p.getElemento()
             //Verifica se o elemento será removido tem subárvore esquerda
             if (p.getEsq()!=null){
                //busca o maior na subárvore esquerda
                No aux = maiorRecursivo(p.getEsq());
                //Copia o elemento maior da subarv esq para p
                p.setPalavra(aux.getPalavra());
                //Remove elemento copiado recursivamente
                p.setEsq(remove(p.getEsq(),aux.getPalavra()));
              }
             //Verifica se o elemento será removido tem subárvore direita
               else if (p.getDir()!=null){
                //busca o menor na subárvore direita
                No aux = menorRecursivo(p.getDir());
                //Copia o elemento menor da subarv dir para p
                p.setPalavra(aux.getPalavra());
                //Remove elemento copiado recursivamente
                p.setDir(remove(p.getDir(),aux.getPalavra()));
                }
               else 
                   //Verifica se é folha
                   return null;
            }
            return p;
    };
    
    
    
    @Override
    public String toString() {
        return "ABB{" + "raiz=" + raiz + '}';
    }
    
    
}
