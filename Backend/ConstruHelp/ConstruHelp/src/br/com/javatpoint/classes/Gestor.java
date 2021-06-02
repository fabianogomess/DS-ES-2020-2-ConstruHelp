package br.com.javatpoint.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Gestor")
@PrimaryKeyJoinColumn(name="cpf")
public class Gestor extends Pessoa{

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="gestor_projeto", 
	joinColumns= {@JoinColumn(name="gestor_id", referencedColumnName="cpf")}, 
	inverseJoinColumns= {@JoinColumn(name="projeto_id", referencedColumnName="id")}) 
	Projeto[] projetos = new Projeto[2];
	
}
