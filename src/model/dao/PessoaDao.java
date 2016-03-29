/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Pessoa;

/**
 * @author RickWill, Nandão & UlysS
 */

public class PessoaDao
{
    public void atualizar(Pessoa pessoa)
    {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(pessoa.getId() != null)
        {
            pessoa = em.merge(pessoa);
        }
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }
    public void excluir(Pessoa pessoa)
    {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        pessoa = em.merge(pessoa);
        em.remove(pessoa);
        em.getTransaction().commit();
        em.close();
    }
    public List<Pessoa> pesquisar(Pessoa pessoa)
    {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Pessoa where 1 = 1");
        if (pessoa.getId() != null)
        {
            sql.append("and p.id = :id");
        }
        if(pessoa.getUser()!= null && !pessoa.getUser().equals(""))
        {
            sql.append("and u.user like :user ");
        }
        Query query = em.createQuery(sql.toString());
        if(pessoa.getUser() != null)
        {
            query.setParameter("id", pessoa.getId());
        }
        if(pessoa.getUser() != null && !pessoa.getUser().equals(""))
        {
           query.setParameter("user","%"+ pessoa.getUser());//Linha Imcompleta
        }
        return query.getResultList();
    }
}
