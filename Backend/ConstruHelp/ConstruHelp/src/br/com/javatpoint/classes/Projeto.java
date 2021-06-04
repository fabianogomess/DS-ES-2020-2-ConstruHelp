package br.com.javatpoint.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.xml.crypto.Data;

@Entity
@Table(name="projeto")
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="projeto_sequence")
	@SequenceGenerator(name="projeto_sequence", sequenceName="proj_seq")
	private long id;
	@Column
    private String nomeProjeto;
	@Column
    private String descricao;
	@Column
    private String status;
	
	@OneToOne(mappedBy = "projeto", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, optional=false)
	private Lista lista;
	
	@JoinTable(
	name = "proj_gest",
	joinColumns = @JoinColumn(name="id"),
	inverseJoinColumns = @JoinColumn(name="gestor", referencedColumnName="cpf"))
	@ManyToMany
	private List<Gestor> gestores;
	
	@JoinTable(
	name = "proj_fornecd",
	joinColumns = @JoinColumn(name="id"),
	inverseJoinColumns = @JoinColumn(name="fornecedor", referencedColumnName="cpf"))
	@ManyToMany
	private List<Fornecedor> fornecedores;
	
	@Embedded
    public Endereco endereco;
	
	public Projeto() {
	}
    
    public String getNomeProjeto(){
        return nomeProjeto;
    }
    public String getDescricao(){
        return descricao;
    }

    public String getStatus(){
        return status;
    }

    public void setNomeProjeto(String nome){
        this.nomeProjeto = nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public Gestor getGestorPrincipal(Gestor A) {
    	return gestores.get(0);
    }
    
    public void setFornecedores(Fornecedor fornA) {
    	fornecedores.add(fornA);
    }
    
    public void setGestores(Gestor A) {
    	gestores.add(A);
    }
    
   
    
    public long getID() {
    	return this.id;
    }

}
