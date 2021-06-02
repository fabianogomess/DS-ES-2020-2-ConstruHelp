package br.com.javatpoint.classes;

public class Lista {
    private String nomeLista;
    private String descricaoLista;
    private Material listaDeMateriais[];

    public String getNomeLista(){
        return nomeLista;
    }
    public String getDescricaoLista(){
        return descricaoLista;
    }

    public void setNomeLista(String nome){
        this.nomeLista = nome;
    }
    public void setDescricaoLista(String descricao){
        this.descricaoLista = descricao;
    }
}
