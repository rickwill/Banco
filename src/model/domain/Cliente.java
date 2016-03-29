/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author RickWill, Nandão & UlysS
 */

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente extends Pessoa
{
    //Atributos
    
    @Column(name = "CLIENTE_DTASSOC",length = 10,nullable = false)
    private String dataAssociacao;
    
    
    //Construtor
    public Cliente(){}
    public Cliente(String nome, String endereco, String bairro, String cidade, 
            String estado, String cpf, String rg)
    {
        super(nome, endereco, bairro, cidade, estado, cpf, rg);
    }
    //Getters e Setters
    
    public Cliente getCliente()
    {
     Cliente temp = new Cliente();
     return temp;
    }
    
    public void setCliente(String nome, String endereco, String bairro, String cidade,
            String estado, String cpf, String rg)
    {
        
    }
    
    public String getDataAssociacao()
    {
        return dataAssociacao;
    }

    public void setDataAssociacao(String dataAssociacao)
    {
        this.dataAssociacao = dataAssociacao;
    }
    
    //Outros Métodos
  
    public void AbrirContaCorrente(){}
    public void RemoverContaCorrente(){}
    public void AdicionarDependente(){}
    public void ExcluirDependente(){}
    public void AbrirPoupanca(){}
    public void FecharPoupanca(){}
}
