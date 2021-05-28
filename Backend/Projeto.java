//import java.util.ArrayList;

import javax.xml.crypto.Data;

public class Projeto {
    private String nomeProjeto;
    private String descricao;
    private Data data;
    private String status;

    private Endereco enderecoDoPrijeto;
    

    public String getNomeProjeto(){
        return nomeProjeto;
    }
    public String getDescricao(){
        return descricao;
    }
    public Data getData(){
        return data;
    }
    public String getStatus(){
        return status;
    }
    public Endereco getEndereco(){
        return enderecoDoPrijeto;
    }


    public void setNomeProjeto(String nome){
        this.nomeProjeto = nome;
    }
    public void setDescrição(String descricao){
        this.descricao = descricao;
    }
    public void setData(Data data){
        this.data = data;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setEndereco(Endereco endereco){
        this.enderecoDoPrijeto = endereco;
    }

}
