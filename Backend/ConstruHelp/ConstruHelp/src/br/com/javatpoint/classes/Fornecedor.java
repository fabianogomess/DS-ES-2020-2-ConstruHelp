package br.com.javatpoint.classes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Fornecedor")
@PrimaryKeyJoinColumn(name="cpf")
public class Fornecedor extends Pessoa {
   private String papel;
   
   public String getPapel(){
       return papel;
   }
   public void setPepel(String papel){
       this.papel = papel;
   }
}
