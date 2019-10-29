/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.teste;

import edu.fjn.primeiro.orm.modelo.Aluno;
import edu.fjn.primeiro.orm.modelo.Responsavel;
import edu.fjn.primeiro.orm.modelo.TipoResponsavel;
import edu.fjn.primeiro.orm.repositorio.AlunoRepositorio;
import edu.fjn.primeiro.orm.repositorio.util.FabricaConexao;

/**
 *
 * @author franc
 */
public class Executavel {

    public static void main(String[] arg) {

        AlunoRepositorio alunoRepositorio
                = new AlunoRepositorio();
        
        Aluno aluno = new Aluno();
        aluno.setCodigo(1);
        aluno.setNome("Paulo");
        
        Responsavel responsavel = new Responsavel();
        responsavel.setNome("Mariana");
        responsavel.setCpf("11122233310");
        responsavel.setTipo(TipoResponsavel.MAE);
        
        aluno.setResponsavel(responsavel);
        
        alunoRepositorio.salvar(aluno);
        FabricaConexao.fechar();
    }

}
