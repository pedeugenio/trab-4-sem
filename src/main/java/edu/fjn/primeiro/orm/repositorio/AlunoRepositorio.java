/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.repositorio;

import edu.fjn.primeiro.orm.modelo.aluno.Aluno;
import edu.fjn.primeiro.orm.repositorio.util.FabricaConexao;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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

    public List<Aluno> listar() {
        EntityManager em = FabricaConexao.obterGerenciador();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Aluno.class);
        List<Aluno> alunos = criteria.list();
        em.close();
        return alunos;
    }

    public Aluno buscarPorId(Integer id) {
        EntityManager gerenciador = FabricaConexao.obterGerenciador();
        Aluno a = gerenciador.find(Aluno.class, id);
        gerenciador.close();
        return a;
    }

    public List<Aluno> buscarPorNomeJPQL(String nomeBuscado) {
        EntityManager gerenciador = FabricaConexao
                .obterGerenciador();

        List<Aluno> alunos = gerenciador.
                createQuery("select a from Aluno "
                        + "a WHERE a.nome = :nom")
                .setParameter("nom", nomeBuscado)
                .getResultList();

        gerenciador.close();
        return alunos;

    }

    /**
     * busca por igualdade de valor. diferenciando miusculo e minusculo.
     *
     * @param nomeBuscado
     * @return
     */
    public List<Aluno> buscarPorNome(String nomeBuscado) {
        EntityManager gerenciador = FabricaConexao
                .obterGerenciador();
        Session session = (Session) gerenciador.
                getDelegate();
        Criteria c = session.createCriteria(Aluno.class);
        c.add(Restrictions.eq("nome", nomeBuscado));
        List<Aluno> alunos = c.list();
        gerenciador.close();
        return alunos;
    }

    public List<Aluno> buscarPorParteNome(String nomeBuscado) {
        EntityManager gerenciador = FabricaConexao
                .obterGerenciador();
        Session session = (Session) gerenciador.
                getDelegate();
        Criteria c = session.createCriteria(Aluno.class);

        c.add(Restrictions.
                ilike("nome", nomeBuscado,
                        MatchMode.ANYWHERE));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Aluno> alunos = c.list();
        gerenciador.close();
        return alunos;
    }

}
