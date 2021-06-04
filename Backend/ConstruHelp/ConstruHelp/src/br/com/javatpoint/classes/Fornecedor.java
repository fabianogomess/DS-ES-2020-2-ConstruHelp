package br.com.javatpoint.classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@PrimaryKeyJoinColumn(name="cpf")
@OnDelete(action= OnDeleteAction.CASCADE)
public class Fornecedor extends Pessoa {
  
	@Column
	private String papel;
	
	@ManyToMany(mappedBy = "fornecedores", cascade = CascadeType.ALL)
	private List<Projeto> projetoFornecedor; 
	
	
	public String getPapel(){
       return papel;
	}
	
	public void setPepel(String papel){
       this.papel = papel;
   }
}
