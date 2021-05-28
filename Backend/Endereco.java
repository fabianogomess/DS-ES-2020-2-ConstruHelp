public class Endereco{
    private String rua;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

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