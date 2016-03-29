/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Cliente;

/**
 * @author RickWill, Nandão & UlysS
 */

public class ClienteDao
{
    public void atualizar(Cliente cliente)
    {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(cliente.getId() != null)
        {
            cliente = em.merge(cliente);
        }
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }
    public void excluir(Cliente cliente)
    {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        cliente = em.merge(cliente);
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }
    public List<Cliente> pesquisar(Cliente cliente)
    {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Cliente where 1 = 1");
        if (cliente.getId() != null)
        {
            sql.append("and c.id = :id");
        }
        if(cliente.getUser()!= null && !cliente.getUser().equals(""))
        {
            sql.append("and u.user like :user ");
        }
        Query query = em.createQuery(sql.toString());
        if(cliente.getUser() != null)
        {
            query.setParameter("id", cliente.getId());
        }
        if(cliente.getUser() != null && !cliente.getUser().equals(""))
        {
           query.setParameter("user","%"+ cliente.getUser());//Linha Imcompleta
        }
        return query.getResultList();
    }
    
}
