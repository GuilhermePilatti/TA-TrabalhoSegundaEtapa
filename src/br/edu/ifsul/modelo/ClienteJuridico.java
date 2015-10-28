/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "cliente_juridico")
public class ClienteJuridico extends Cliente implements Serializable{
    @CNPJ
    @NotBlank(message = "O CNPJ deve ser informado")
    @Length(max = 18, message = "O CNPJ não deve possui mais de {max} caracteres")
    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;
    
    @NotBlank(message = "A inscrição estadual deve ser informada")
    @Length(max = 15, message = "A inscrição estadual não deve possui mais de {max} caracteres")
    @Column(name = "ie", length = 15, nullable = false)
    private String ie;

    public ClienteJuridico() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
}
