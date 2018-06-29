/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Alexandre
 */
@Entity
@Table(name = "pessoaFisica")
public class PessoaFisica extends Pessoa implements Serializable{
   
    @NotNull(message = "O RG não pode ser nulo")
    @NotBlank(message = "O RG não pode ser em branco")
    @Length(max = 10, message = "O RG não pode ter mais que {max} caracteres")
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;
    @NotNull(message = "O CPF não pode ser nulo")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @CPF(message = "O CPF deve ser válido")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    @NotNull(message = "A data de nasciemtno não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento")
    private Calendar nascimento;
    @NotNull(message = "O Nome Usuário não pode ser nulo")
    @NotBlank(message = "O Nome Usuário não pode ser em branco")
    @Length(max = 20, message = "O Nome Usuário não pode ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false,  unique = true)
    private String nomeUsuario;
    @NotNull(message = "O Senha não pode ser nulo")
    @NotBlank(message = "O Senha não pode ser em branco")
    @Length(max = 10, message = "O Senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 10, nullable = false)
    private String senha;
    

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
