/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import model.dao.UsuarioDao;
import model.domain.Usuario;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Richard
 */
public final class UsuarioControl
{
    private final PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Usuario usuarioDigitado;
    
    private Usuario usuarioSelecionado;
    
    private List<Usuario> usuarioTabela;
    
    private UsuarioDao usuarioDao;
    
    public  UsuarioControl()
    {
        usuarioDao = new UsuarioDao();
        usuarioTabela = ObservableCollections.observableList(
                new ArrayList<Usuario>());
        novo();
        pesquisar();
    }

    public void novo()
    {
        setUsuarioDigitado(new Usuario() );
    }

    public void pesquisar()
    {
        usuarioTabela.clear();
        usuarioTabela.addAll(usuarioDao.pesquisar(usuarioDigitado));
    }
    
    public void salvar()
    {
        usuarioDao.atualizar(usuarioDigitado);
        novo();
        pesquisar();
    }
    
    public void excluir()
    {
        usuarioDao.excluir(usuarioDigitado);
        novo();
        pesquisar();
    }

    public Usuario getUsuarioDigitado() {
        return usuarioDigitado;
    }

    public void setUsuarioDigitado(Usuario usuarioDigitado) {
        Usuario oldUsuarioDigitado = this.usuarioDigitado;
        this.usuarioDigitado = usuarioDigitado;
        propertyChangeSupport.firePropertyChange("UsuarioDigitado",
                oldUsuarioDigitado,usuarioDigitado);
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
        if(this.usuarioSelecionado != null)
        {
            setUsuarioDigitado(usuarioSelecionado);
        }
    }

    public List<Usuario> getUsuarioTabela() {
        return usuarioTabela;
    }

    public void setUsuarioTabela(List<Usuario> usuarioTabela) {
        this.usuarioTabela = usuarioTabela;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    public void addPropertyChangeListener (PropertyChangeListener e)
    {
        propertyChangeSupport.addPropertyChangeListener(null);   
    }
    
    public void  removePropertyChangeListener(PropertyChangeListener e)
    {
        propertyChangeSupport.removePropertyChangeListener(null);   
    }
}
