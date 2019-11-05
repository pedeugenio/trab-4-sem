/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.modelo.avaliacao;

import edu.fjn.primeiro.orm.modelo.aluno.Aluno;
import edu.fjn.primeiro.orm.modelo.disciplina.Disciplina;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

/**
 *
 * @author franc
 */
@Entity
public class Avaliacao {

    @Id
    private String codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Disciplina disciplina;

    private Double nota;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @PrePersist
    private void gerarCodigo() {
        this.codigo = UUID.randomUUID().toString();
    }

}
