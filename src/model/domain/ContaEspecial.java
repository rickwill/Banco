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
@Table(name = "TB_CONTAESP")
public class ContaEspecial extends Conta
{
    //Atributos
    @Column(name ="CE_LIM",length = 20,nullable = false )
    private float limite;
    //Construtor
    public ContaEspecial(){}
    public ContaEspecial(int numCont, int digCont, float lim)
    {
        super(digCont, numCont);
        this.limite = lim;
    }
    
    //Getters e Setters
      public float getLimite()
      {
        return limite;
    }

    public void setLimite(float limite)
    {
        this.limite = limite;
    }
    
    //Outros Métodos
    public boolean Debita (float valor)
    {
        if(getLimite() >= valor)
        {
            this.setLimite(getLimite() - valor);
            System.out.println("Você Está Bonado, Aah Mlk!!");
            return true;
        }
        else
        {
            System.out.println("Você Está Duro, Lazarento!!");
            return false;
        }
    }
}
