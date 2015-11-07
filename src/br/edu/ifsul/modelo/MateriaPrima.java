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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "materia_prima")
public class MateriaPrima implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_materia_prima", sequenceName = "seq_materia_prima_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_materia_prima", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve possui mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O fabricante deve ser informado")
    @Length(max = 50, message = "O fabricante não deve possui mais de {max} caracteres")
    @Column(name = "fabricante", length = 50, nullable = false)
    private String fabricante;
    
    @NotNull(message = "O peso da saca deve ser informada")
    @Column(name = "pesoSaca", columnDefinition = "int")
    private Integer pesoSaca;
    
    @NotNull(message = "O fornecedor deve ser informado")
    @ManyToOne
    @JoinColumn(name = "fornecedor", referencedColumnName = "id")
    private Fornecedor forcenedor;

    public MateriaPrima() {
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getPesoSaca() {
        return pesoSaca;
    }

    public void setPesoSaca(Integer pesoSaca) {
        this.pesoSaca = pesoSaca;
    }

    public Fornecedor getForcenedor() {
        return forcenedor;
    }

    public void setForcenedor(Fornecedor forcenedor) {
        this.forcenedor = forcenedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MateriaPrima other = (MateriaPrima) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
