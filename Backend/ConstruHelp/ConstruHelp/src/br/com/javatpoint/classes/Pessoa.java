package br.com.javatpoint.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Pessoa")
public class Pessoa {
	
	@Column(name = "Nome") 
	private String nome;
	
	@Column(name = "Senha")
	private String senha;
	
	@Id
	private String cpf;
	
	@Column(name = "Email")
	private String email;
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setNome(String nomeAtualizado) {
		this.nome = nomeAtualizado;
	}
	
	public void setCPF(String cpfAtualizado) {
		this.cpf = cpfAtualizado;
	}
	
	public void setEmail(String emailAtualizado) {
		this.email = emailAtualizado;
	}
	
	public void setSenha(String senhaAtualizado) {
		this.senha = senhaAtualizado;
	}
}
