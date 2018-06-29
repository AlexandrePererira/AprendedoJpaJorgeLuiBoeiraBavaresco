/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Alexandre
 */
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "O Nickname  não pode ser nulo")
    @NotBlank(message = "O Nickname não pode ser em branco")
    @Length(max = 30, message = "O Nickname não pode ter mais que {max} caracteres")
    @Column(name = "nickname", length = 30, nullable = false)
    private String nickname;
    @NotNull(message = "O endereço  não pode ser nulo")
    @NotBlank(message = "O endereço não pode ser em branco")
    @Length(max = 30, message = "O emdereço não pode ter mais que {max} caracteres")
    @Column(name = "endereco", length = 30, nullable = false)
    private String endereco;
    @NotNull(message = "O numero  não pode ser nulo")
    @NotBlank(message = "O numero não pode ser em branco")
    @Length(max = 10, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    @NotNull(message = "O complemento  não pode ser nulo")
    @NotBlank(message = "O compelemento não pode ser em branco")
    @Length(max = 30, message = "O complemento não pode ter mais que {max} caracteres")
    @Column(name = "complemento", length = 30, nullable = false)
    private String complemento;
    @NotNull(message = "O cep  não pode ser nulo")
    @NotBlank(message = "O cep não pode ser em branco")
    @Length(max = 9, message = "O emdereço não pode ter mais que {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @NotNull(message = "O bairro  não pode ser nulo")
    @NotBlank(message = "O bairro não pode ser em branco")
    @Length(max = 30, message = "O bairro não pode ter mais que {max} caracteres")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    @Length(max = 30, message = "O emdereço não pode ter mais que {max} caracteres")
    @Column(name = "referencia", length = 30)
    private String referencia;
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pessoa_id")
    private Pessoa pessoa;
    @NotNull(message = "O tipo de endereco deve ser informada")
    @ManyToOne
    @JoinColumn(name = "tipo_endereco_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_tipo_endereco_id")
    private TipoEndereco tipoendereco;

    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public TipoEndereco getTipoendereco() {
        return tipoendereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
     
    public void setTipoendereco(TipoEndereco tipoendereco) {
        this.tipoendereco = tipoendereco;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
