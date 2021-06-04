package br.com.javatpoint.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="materiais")
public class Material {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="material_sequence")
	@SequenceGenerator(name="material_sequence", sequenceName="mat_seq")
	private Long Id;
	@Column
    private String nomeMaterial;
	@Column
    private String quantidade;
	@Column
	private String descricao;
	@Column
	private String proposito;

    public String getNomeMaterial(){
        return nomeMaterial;
    }
    public String getQuantidade(){
        return quantidade;
    }
    public String getDescricao(){
        return descricao;
    }
    public String getProposito() {
    	return proposito;
    }

    public void setNomeMaterial(String nome){
        this.nomeMaterial = nome;
    }
    public void setQuantidade(String quantidade){
        this.quantidade = quantidade;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setProposito(String proposito){
        this.proposito = proposito;
    }
    
    public String toString() {
    	return "Material: "+this.nomeMaterial+", Quantidade: "+this.quantidade+", Descrição: "+this.descricao+", Propósito: "+this.proposito+".\n";
    }
}
