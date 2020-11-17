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
public class No {
    private String palavra;
    private int frequencia;
    private No esq;
    private No dir;

    public No(String palavra, int frequencia, No esq, No dir) {
        this.palavra = palavra;
        this.frequencia = frequencia;
        this.esq = esq;
        this.dir = dir;
    }

    
    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String elemento) {
        this.palavra = elemento;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "No{" + "palavra=" + palavra + ", frequencia=" + frequencia + ", esq=" + esq + ", dir=" + dir + '}';
    }

}
