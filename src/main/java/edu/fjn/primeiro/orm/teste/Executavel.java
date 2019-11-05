/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.teste;

import edu.fjn.primeiro.orm.modelo.aluno.Curso;
import edu.fjn.primeiro.orm.repositorio.AlunoRepositorio;
import edu.fjn.primeiro.orm.repositorio.AvaliacaoRepositorio;
import edu.fjn.primeiro.orm.repositorio.DisciplinaRepositorio;
import edu.fjn.primeiro.orm.repositorio.util.FabricaConexao;

/**
 *
 */
public class Executavel {

    public static void main(String[] arg) {
        AlunoRepositorio alunoRepositorio
                = new AlunoRepositorio();
        DisciplinaRepositorio disciplinaRepositorio
                = new DisciplinaRepositorio();
        AvaliacaoRepositorio avaliacaoRepositorio
                = new AvaliacaoRepositorio();

        disciplinaRepositorio.listar().forEach((d) -> {
            System.out.println(d.getNome());
        });

        alunoRepositorio.listar().
                forEach((a)
                        -> System.out.println("Aluno:" + a.getNome()));

        alunoRepositorio.buscarPorNome("ANTONIO")
                .forEach((a)
                        -> System.out.println("Aluno Buscado: " + a.getNome()));

        alunoRepositorio.buscarPorParteNome("a")
                .forEach((a) -> {
                    System.out.println("Aluno c/ ilike: " + a.getNome());
                    for (Curso curso : a.getCursos()) {
                        System.out.println("- " + curso.getNome());
                    }
                });

        alunoRepositorio.buscarPorNomeJPQL("ANTONIO")
                .forEach((a)
                        -> System.out.println("Aluno c/ JPQL: " + a.getNome()));

        /*
        Aluno aluno = alunoRepositorio.buscarPorId(2);
        Disciplina disciplina = disciplinaRepositorio
                .buscarPorId("a99ea4ca-95fa-4070-ab79-3b4ec85e84c1");

        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Disciplina: " + disciplina.getNome());

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAluno(aluno);
        avaliacao.setDisciplina(disciplina);
        avaliacao.setNota(9.0);

        avaliacaoRepositorio.salvar(avaliacao);
         */
        FabricaConexao.fechar();
    }

}
