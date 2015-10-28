/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "cliente_fisico")
public class ClienteFisico extends Cliente implements Serializable{
    @CPF
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O CPF não deve possui mais de {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
    @NotBlank(message = "O RG deve ser informado")
    @Length(max = 10, message = "O RG não deve possui mais de {max} caracteres")
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;

    public ClienteFisico() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
