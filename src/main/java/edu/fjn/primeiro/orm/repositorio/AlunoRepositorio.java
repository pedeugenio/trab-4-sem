/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.repositorio;

import edu.fjn.primeiro.orm.modelo.Aluno;
import edu.fjn.primeiro.orm.repositorio.util.FabricaConexao;
import javax.persistence.EntityManager;

/**
 *
 * @author franc
 */
public class AlunoRepositorio {

    public void salvar(Aluno aluno) {

        EntityManager gerenciador = FabricaConexao.obterGerenciador();
        try {
            gerenciador.getTransaction().begin();
            gerenciador.persist(aluno);
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

    public void atualizar(Aluno aluno) {
        EntityManager gerenciador = FabricaConexao.obterGerenciador();
        try {
            gerenciador.getTransaction().begin();
            gerenciador.merge(aluno);
            gerenciador.getTransaction().commit();
        } catch (Exception e) {
            // Verifica se a transação está ativa ainda.
            // Um erro pode encerrar a transação sem permitir
            // um rollback pelo programador.
            if (gerenciador.getTransaction().isActive()) {
                gerenciador.getTransaction().rollback();
            }
        } finally {
            gerenciador.close();
        }
    }

    public void remover(Aluno aluno) {
    }

    public Aluno buscarPorId(Integer id) {
        return null;
    }

}
