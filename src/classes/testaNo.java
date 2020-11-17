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

public class testaNo {
    public static void main(String[] args) {
        ABB arvre = new ABB();
        arvre.insere("gabriel");
        arvre.insere("marcelo");
        arvre.insere("bia");
        arvre.insere("debora");
        arvre.insere(("Marcelo"));
        
        System.out.println(arvre);
        arvre.inOrdem();
        
        arvre.remove("debora");
        
        System.out.println("");
        arvre.inOrdem();
        
        System.out.println("");
        System.out.println(arvre.buscaRecursiva("Marcelo"));
    }
}
