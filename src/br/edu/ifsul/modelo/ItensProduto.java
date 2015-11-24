/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "itens_produto")
public class ItensProduto implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_itens_produto", sequenceName = "seq_itens_produto_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_itens_produto", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "codigo")
    private Produto produto;
    
    @NotNull(message = "A matéria prima deve ser informada")
    @ManyToOne
    @JoinColumn(name = "materiaprima", referencedColumnName = "codigo")
    private MateriaPrima materiaPrima;
    
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", columnDefinition = "DECIMAL(10,3) DEFAULT 0.00")
    private Double quantidade;
    
    @NotBlank(message = "a unidade deve ser informada")
    @Length(max = 20, message = "A unidade não deve possui mais de {max} caracteres")
    @Column(name = "unidade", length = 20, nullable = false)
    private String unidade;

    public ItensProduto() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.codigo);
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
        final ItensProduto other = (ItensProduto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return materiaPrima.getNome();
    }
}
