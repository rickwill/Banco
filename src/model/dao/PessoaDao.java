/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import model.domain.Pessoa;

/**
 *
 * @author Richard
 */
public class PessoaDao
{
    public void atualizar(Pessoa pessoa)
    {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        
        em.getTransaction().commit();
        em.close();
    }
    
}
