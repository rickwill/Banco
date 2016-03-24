/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Scanner;




/**
 *
 * @author Richard
 */
public class Ferramentas extends Banco
{
    //Atributos
    int op;
    Scanner sc = new Scanner(System.in);
    
    //Outros Metodos
    public void acaoMenu()
    {
        System.out.println(" ----------------Banco JavaX----------------");
        System.out.println("| MENU                                       |");
        System.out.println("|--------------------------------------------|");
        System.out.println("| Selecione o Tipo de Acesso:                |");
        System.out.println("| 1- Cliente.                                |");
        System.out.println("| 2- Gerente.                                |");
        System.out.println("| 3- Caixa.                                  |");
        System.out.println("| 4- Sair.                                   |");
        System.out.println(" --------------------------------------------");
        op = sc.nextInt();
   
        while(op>= 1 || op <= 4)
        {
            switch(op)
            {
                case 1:
                    acaoCliente();
                    break;
                    
                case 2:
                  
                    acaoGerente();
                    break;
                    
                case 3:
                    acaoCaixa();
                    break;
                    
                case 4:
                    System.exit(0);
                    break;
                
            } 
        }
    }
    public void acaoCliente()
    {
        System.out.println(" ----------------Banco JavaX----------------");
        System.out.println("| MENU > CLIENTE                             |");
        System.out.println("|--------------------------------------------|");
        System.out.println("|Selecione uma opção abaixo:                 |");
        System.out.println("|1- Consultar Saldo.                         |");
        System.out.println("|2- Imprimir Extrato.                        |");
        System.out.println("|3- Sacar.                                   |");
        System.out.println("|4- Depositar.                               |");
        System.out.println("|5- Transferir.                              |");
        System.out.println("|6- Voltar                                   |");
        System.out.println(" --------------------------------------------");
        op = sc.nextInt();
        while(op>= 1 || op <= 6)
        {
            switch(op)
            {
                case 1:
                    c1.imprimirSaldo();
                    System.out.println("Deseja Imprimir Extrato?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    op = sc.nextInt();
                    if(op==1)
                    {
                        
                    }
                    
                    acaoCliente();
                    break;
                    
                case 2:
                    acaoGerente();
                    break;
                case 3:
                    acaoCaixa();
                    break;
                    
                case 4:
                    acaoCaixa();
                    break;
                        
                case 5:
                    acaoCaixa();
                    break;
                case 6:
                    acaoMenu();
                    break;
            } 
        }
    }
    public void acaoGerente()
    {
        System.out.println(" ----------------Banco JavaX----------------");
        System.out.println("| MENU > GERENTE                             |");
        System.out.println("|--------------------------------------------|");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1- Cliente.");
        System.out.println("2- Conta Corrente.");
        System.out.println("3- Dependentes.");
        System.out.println("4- Conta Especial.");
        System.out.println("5- Conta Poupança.");
        System.out.println("6- Voltar.");
        
        op = sc.nextInt();
        while(op>= 1 || op <= 6)
        {
            switch(op)
            {
                case 1:
                    opcaoCliente();
                    break;
                    
                case 2:
                    opcaoContaCorrente();
                    break;
                    
                case 3:
                    opcaoContaEspecial();
                    break;
                
                case 4:
                    opcaoContaPoupanca();
                    break;
                    
                case 5:
                    opcaoDependente();
                    break;
                
                case 6:
                    acaoMenu();
                    break;
            } 
        } 
        
    }
    public void acaoCaixa()
    {
        System.out.println(" ----------------Banco JavaX----------------");
        System.out.println("| MENU > CAIXA                               |");
        System.out.println("|--------------------------------------------|");
        op = sc.nextInt();
        while(op>0 || op <5)
        {
        }
        
    }
    public void opcaoCliente()
    {
        System.out.println(" ----------------Banco JavaX----------------");
        System.out.println("| MENU > GERENTE                             |");
        System.out.println("|--------------------------------------------|");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1- Cadastrar Cliente.");
        System.out.println("2- Editar Cliente.");
        System.out.println("3- Excluir  Cliente.");
        System.out.println("4- Buscar Cliente.");
        System.out.println("5- Voltar.");
        op = sc.nextInt();
        while(op>= 1 || op <= 5)
        {
            switch(op)
            {
                case 1:
                    Cliente c1 = new Cliente();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    acaoGerente();
                    break;
            }
        }
    }
    public void opcaoContaCorrente()
    {
        System.out.println("----------------Conta Corrente-----------------------");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1- Abrir Conta Corrente.");
        System.out.println("2- Destruir Conta Corrente.");
        System.out.println("3- Buscar Conta Corrente.");
        System.out.println("4- Voltar.");
    }
    public void opcaoDependente()
    {
        System.out.println("----------------Dependente-----------------------");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1- Cadastrar Dependente.");
        System.out.println("2- Alterar Dependente.");
        System.out.println("3- Destruir Dependente.");
        System.out.println("4- Buscar Dependente.");
        System.out.println("5- Voltar.");
    }
    public void opcaoContaEspecial()
    {
        System.out.println("----------------Conta Especial-----------------------");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1- Abrir Conta Especial.");
        System.out.println("2- Destruir Conta Especial.");
        System.out.println("3- Buscar Conta Especial.");
        System.out.println("4- Voltar.");
    }
    public void opcaoContaPoupanca()
    {
        System.out.println("----------------Conta Poupança-----------------------");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1- Abrir Conta Poupança.");
        System.out.println("2- Destruir Conta Poupança.");
        System.out.println("3- Buscar Conta Poupança.");
        System.out.println("4- Voltar.");
    }
}
