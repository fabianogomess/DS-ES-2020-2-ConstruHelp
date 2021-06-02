package br.com.javatpoint.classes;

public class Material {
    private String nomeMaterial;
    private String quantidade;
    private String unidade;

    public String getNomeMaterial(){
        return nomeMaterial;
    }
    public String getQuantidade(){
        return quantidade;
    }
    public String getUnidade(){
        return unidade;
    }

    public void setNomeMaterial(String nome){
        this.nomeMaterial = nome;
    }
    public void setQuantidade(String quantidade){
        this.quantidade = quantidade;
    }
    public void setUnidade(String unidade){
        this.unidade = unidade;
    }
}
