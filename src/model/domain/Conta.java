/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

/**
 * @author RickWill, Nandão & UlysS
 */

@Entity
@Table(name = "TB_CONTA")
public class Conta 
{
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcc;
    @Column(name = "CC_TITULAR",length = 30,nullable = false)
    private Cliente titular;
    @Column(name = "CC_NUM",length = 10,nullable = false)
    private int numeroConta;
    @Column(name = "CC_DG",length = 1,nullable = false)
    private int digitoConta;
    @Column(name = "CC_SALDO",length = 30,nullable = false)
    private double saldo;
    
    //Construtor
    public Conta(){}
    public Conta(int numCont,int digCont)
    {
        this.digitoConta = digCont;
        this.numeroConta = numCont;
    }
    public Conta(Cliente t, int numCont, int digCont, float Sin)
    {
        this.titular = t;
        this.digitoConta = digCont;
        this.numeroConta = numCont;
        this.saldo = Sin;
    }
    
    
    //Getters e Setters
    public Cliente getTitular()
    {
        return titular;
    }

    public void setTitular(Cliente titular)
    {
        this.titular = titular;
    }

    public int getNumeroConta()
    {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta)
    {
        this.numeroConta = numeroConta;
    }

    public int getDigitoConta()
    {
        return digitoConta;
    }

    public void setDigitoConta(int digitoConta)
    {
        this.digitoConta = digitoConta;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }
   
    //Outros Métodos
    /*public boolean Debita (float valor)
    {
        if (saldo >= valor)
        {
            setSaldo(getSaldo() - valor);
            return true;   
        }else
        {
            System.out.println("Saldo Insuficiente");
            return false;
        }
    }
    
    public boolean Credita (float valor)
    {
        setSaldo(getSaldo() + valor);
        return true;
    }
    
    public void imprimirSaldo()
    {
        System.out.println("Saldo: R$ " + getSaldo());
    }
    
    public boolean transferencia(Conta orig, Conta dest, float valor)
    {
        if(orig.getSaldo() >= valor)
        {
            orig.Debita(valor);
            dest.Credita(valor);
            return true;
        }
        else
        {
            System.out.println("Valor Transferido com Sucesso");
            return false;
        }
    }*/
    public void depositar(double valor){
		saldo = saldo+valor;
		
	}
	
	public void sacar(double valor){
		if(valor<saldo){
		saldo = saldo-valor;
		}
		else{
			JOptionPane.showMessageDialog(null, "Saldo insuficiente :"+ getSaldo());
		}
		
		}
	
	public void transferencia(Conta c,double valor){
		if(valor<saldo){
			double x = c.getSaldo();
			c.setSaldo(x+valor);
			saldo = saldo - valor;
			JOptionPane.showMessageDialog(null, "Operação realizada com sucesso! ;3");
		}
		
		else{
			JOptionPane.showMessageDialog(null, "Saldo insuficiente :"+ getSaldo());
		}
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.numeroConta;
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
        final Conta other = (Conta) obj;
        if (this.numeroConta != other.numeroConta) {
            return false;
        }
        return true;
    }
    
}
