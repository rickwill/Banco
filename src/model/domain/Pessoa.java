/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author RickWill, Nandão & UlysS.
 */

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa extends Usuario
{
    //Atributos
    @Column(name = "PESSOA_NM",length = 30,nullable = true)
    private String nome;
    @Column(name = "PESSOA_RUA",length = 30,nullable = true)
    private String rua;
    @Column(name = "PESSOA_BAIRRO",length = 20,nullable = true)
    private String bairro;
    @Column(name = "PESSOA_CD",length = 20,nullable = true)
    private String cidade;
    @Column(name = "PESSOA_UF",length = 2,nullable = true)
    private String estado;
    @Column(name = "PESSOA_EMAIL",length = 50,nullable = true)
    private String email;
    @Column(name = "PESSOA_CPF",length = 11,nullable = false)
    private String cpf;
    @Column(name = "PESSOA_RG",length = 9,nullable = true)
    private String rg;
    @Column(name = "PESSOA_TEL",length = 10,nullable = true)
    private int telefone;
    @Column(name = "PESSOA_CEL",length = 11,nullable = true)
    private int celular;
    
    // Método Construtor
    public Pessoa(){}
    public Pessoa(String nome, String endereco, String bairro, String cidade, 
            String estado, String cpf, String rg)
    {
        this.nome = nome;
        this.rua = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cpf = cpf;
        this.rg = rg;
    } 
    
    //Getters e Setters
    public Pessoa getPessoa()
    {
        Pessoa temp = new Pessoa(nome, rua, bairro, cidade, estado, cpf, rg);
        return(temp);
    }
    
    public void setPessoa(String nome, String endereco, String bairro, String cidade, 
            String estado, String cpf, String rg)
    {
        this.nome = nome;
        this.rua = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cpf = cpf;
        this.rg = rg;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRua()
    {
        return rua;
    }
    
    public void setRua(String rua)
    {
        this.rua = rua;
    }

    public String getBairro()
    {
        return bairro;
    }
    
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public String getCidade()
    {
        return cidade;
    }
    
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }
  
    public String getEstado() 
    {
        return estado;
    }
   
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
  
    public String getEmail()
    {
        return email;
    }
  
    public void setEmail(String email)
    {
        this.email = email;
    }
 
    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public int getTelefone()
    {
        return telefone;
    }

    public void setTelefone(int telefone)
    {
        this.telefone = telefone;
    }

    public int getCelular()
    {
        return celular;
    }
  
    public void setCelular(int celular)
    {
        this.celular = celular;
    }
    //Outros Métodos
    public void imprimirPessoaBasico()
    {
        System.out.println("Usuario: " + super.getUser());
        System.out.println("Nome: " + getNome() );
        System.out.println("CPF: " + getCpf());
        System.out.println("RG: " + getRg());
        
    }
    public void imprimirPessoa()
    {
        System.out.println("Usuario: " + super.getUser());
        System.out.println("Nome: " + getNome() );
        System.out.println("CPF: " + getCpf());
        System.out.println("RG: " + getRg());
        System.out.println("Rua: " + getRua());
        System.out.println("Bairro: " + getBairro());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Estado: " + getEstado());
        System.out.println("E-Mail: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Celular: " + getCelular());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }
}