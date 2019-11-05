/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.modelo.disciplina;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author franc
 */
@Entity
public class Disciplina {

    @Id
    private String codigo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeCriacao;

    public Disciplina() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    @PrePersist
    private void antesDeSalvar(){
        this.codigo = UUID.randomUUID().toString();
        this.dataDeCriacao = new Date();
    }
    
}
