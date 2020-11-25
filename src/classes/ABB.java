package classes;


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
    
    // PERCURSO NA ÁRVORE
    public void inOrdem() {
        inOrdem(raiz);
    }
    
    public void inOrdem(No p) {
        if(p != null) {
            inOrdem(p.getEsq());
            System.out.print(p.getPalavra() + " ");
            System.out.println(p.getFrequencia() + " ");
            inOrdem(p.getDir());   
        }
        
    }
    
    // BUSCA
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
    
    @Override
    public String toString() {
        return "ABB{" + "raiz=" + raiz + '}';
    }
    
    
}
