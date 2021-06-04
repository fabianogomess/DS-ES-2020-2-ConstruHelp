package br.com.javatpoint.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="lista")
	public class Lista {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="lista_sequence")
		@SequenceGenerator(name="lista_sequence", sequenceName="list_seq")
		private Long id;
		
		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="projeto_id")
		private Projeto projeto;
		
	    @OneToMany(cascade= CascadeType.ALL,
	    orphanRemoval = true		
	    )
	    private List<Material> listaDeMateriais = new ArrayList<>();
	    
	    public Lista(Material a) {
	    	listaDeMateriais.add(a);
	    }
	    public String getListaMateriais() {
	    	return listaDeMateriais.toString();
	    }
	}
