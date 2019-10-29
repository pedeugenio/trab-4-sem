/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.teste;

import edu.fjn.primeiro.orm.modelo.Aluno;
import edu.fjn.primeiro.orm.modelo.Curso;
import edu.fjn.primeiro.orm.modelo.Responsavel;
import edu.fjn.primeiro.orm.modelo.TipoResponsavel;
import edu.fjn.primeiro.orm.repositorio.AlunoRepositorio;
import edu.fjn.primeiro.orm.repositorio.util.FabricaConexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Executavel {

    public static void main(String[] arg) {

        AlunoRepositorio alunoRepositorio
                = new AlunoRepositorio();
        
        Aluno aluno = alunoRepositorio.buscarPorId(2);
        
        System.out.println("nome: "+aluno.getNome());
        System.out.println("responsavel: "+aluno.
                    getResponsavel().getNome());
        
        aluno.getCursos().forEach((a) -> {
            System.out.println("Curso: " + a.getNome());
            System.out.println("Carga Horaria: " + a.getCargaHoraria());
        });
        
        
//        
//        Aluno aluno = new Aluno();
//        aluno.setCodigo(2);
//        aluno.setNome("Antonio");
//        
//        Responsavel responsavel = new Responsavel();
//        responsavel.setNome("Pedro José");
//        responsavel.setCpf("22233311109");
//        responsavel.setTipo(TipoResponsavel.PAI);
//        
//        aluno.setResponsavel(responsavel);
//        
//        List<Curso> cursos = new ArrayList<>();
//        
//        Curso curso = new Curso();
//        curso.setNome("Java Basico");
//        curso.setCargaHoraria(40);
//        curso.setAno(2017);           
//        cursos.add(curso);
//        
//        curso = new Curso();
//        curso.setNome("Java Intermediario");
//        curso.setCargaHoraria(60);
//        curso.setAno(2018);        
//        cursos.add(curso);
//        
//        curso = new Curso();
//        curso.setNome("Java Avançado");
//        curso.setCargaHoraria(100);
//        curso.setAno(2019);        
//        cursos.add(curso);
//        
//        aluno.setCursos(cursos);
        
 //       alunoRepositorio.salvar(aluno);
        FabricaConexao.fechar();
    }

}
