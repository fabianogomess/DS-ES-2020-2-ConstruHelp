package br.com.javatpoint.classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@PrimaryKeyJoinColumn(name="cpf")
@OnDelete(action= OnDeleteAction.CASCADE)
public class Gestor extends Pessoa{

	@ManyToMany(mappedBy = "gestores", cascade = CascadeType.ALL)
	private List<Projeto> projetosGestor; 

	public void adicionarProjeto(Projeto projeto) {
		projetosGestor.add(projeto);
	}
}
