/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.repositorio.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * SINGLETON
 *
 * @author franc
 */
public class FabricaConexao {

    private static final EntityManagerFactory fabrica
            = Persistence.createEntityManagerFactory("unidade-1");

    public static EntityManager obterGerenciador() {
        return fabrica.createEntityManager();
    }
    
    /**
     * Fechar conexão
     */
    public static void fechar(){
        fabrica.close();
    }

}
