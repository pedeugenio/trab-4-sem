/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fjn.primeiro.orm.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author franc
 */
@Entity
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "responsavel_gen")
    @SequenceGenerator(initialValue = 1, 
            allocationSize = 1, 
            sequenceName = "responsavel_seq",
            name="responsavel_gen")
    private Integer codigo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoResponsavel tipo;

    public Responsavel() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoResponsavel getTipo() {
        return tipo;
    }

    public void setTipo(TipoResponsavel tipo) {
        this.tipo = tipo;
    }

}
