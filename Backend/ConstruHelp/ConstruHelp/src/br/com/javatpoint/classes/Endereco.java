package br.com.javatpoint.classes;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	@Column
    private String rua;
	@Column
    private String bairro;
	@Column
    private String complemento;
	@Column
    private String cidade;
	@Column
    private String estado;
	
	public Endereco() {}
	
    public String getRua(){
        return rua;
    }
    public String getBairro(){
        return bairro;
    }
    public String getComplemento(){
        return complemento;
    }
    public String getCidade(){
        return cidade;
    }
    public String getEstado(){
        return estado;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public void setRua(String rua){
        this.rua = rua;
    }
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
}

