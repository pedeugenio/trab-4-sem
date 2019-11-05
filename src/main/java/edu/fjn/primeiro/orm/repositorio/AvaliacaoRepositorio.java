/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.repositorio;

import edu.fjn.primeiro.orm.modelo.avaliacao.Avaliacao;
import edu.fjn.primeiro.orm.repositorio.util.FabricaConexao;
import javax.persistence.EntityManager;

/**
 *
 * @author franc
 */
public class AvaliacaoRepositorio {

    public void salvar(Avaliacao avaliacao) {
        EntityManager gerenciador = FabricaConexao.obterGerenciador();
        try {
            gerenciador.getTransaction().begin();
            gerenciador.persist(avaliacao);
            gerenciador.getTransaction().commit();
        } catch (Exception e) {
            // Verifica se a transação está ativa ainda.
            // Um erro pode encerrar a transação sem permitir
            // um rollback pelo programador.
            if (gerenciador.getTransaction().isActive()) {
                gerenciador.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            gerenciador.close();
        }
    }

}
