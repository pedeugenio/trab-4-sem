/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.repositorio;

import edu.fjn.primeiro.orm.modelo.disciplina.Disciplina;
import edu.fjn.primeiro.orm.repositorio.util.FabricaConexao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author franc
 */
public class DisciplinaRepositorio {

    public void salvar(Disciplina disciplina) {

        EntityManager gerenciador = FabricaConexao.obterGerenciador();
        try {
            gerenciador.getTransaction().begin();
            gerenciador.persist(disciplina);
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

    public void atualizar(Disciplina disciplina) {

        EntityManager gerenciador = FabricaConexao.obterGerenciador();
        try {
            gerenciador.getTransaction().begin();
            gerenciador.merge(disciplina);
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

    public Disciplina buscarPorId(String codigo) {
        return FabricaConexao.obterGerenciador()
                .find(Disciplina.class, codigo);
    }

    public List<Disciplina> listar() {
        return FabricaConexao.obterGerenciador()
                .createQuery("from Disciplina d",
                        Disciplina.class)
                .getResultList();
    }

}
