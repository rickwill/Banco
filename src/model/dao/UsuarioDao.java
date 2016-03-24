/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.domain.Usuario;

/**
 *
 * @author Richard
 */
public class UsuarioDao
{
    public void atualizar(Usuario usuario)
    {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(usuario.getId() != null)
        {
            usuario = em.merge(usuario);
        }
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }
    public void excluir(Usuario usuario)
    {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> pesquisar(Usuario usuario)
    {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Usuario where 1 = 1");
        if (usuario.getId() != null)
        {
            sql.append("and u.id = :id");
        }
        if(usuario.getUser() != null && !usuario.getUser().equals(""))
        {
            sql.append("and u.user like :user ");
        }
        Query query = em.createQuery(sql.toString());
        if(usuario.getUser() != null)
        {
            query.setParameter("id", usuario.getId());
        }
        if(usuario.getUser() != null && !usuario.getUser().equals(""))
        {
           query.setParameter("user","%"+ usuario.getUser());//Linha Imcompleta
        }
        return query.getResultList();
    }
}
        

    
