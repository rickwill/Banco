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
import model.dao.ClienteDao;
import model.domain.Cliente;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * @author RickWill, Nandão & UlysS
 */

public final class ClienteControl
{
    private final PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Cliente clienteDigitado;
    
    private Cliente clienteSelecionado;
    
    private List<Cliente> clienteTabela;
    
    private ClienteDao clienteDao;
    
    public ClienteControl()
    {
        clienteDao = new ClienteDao();
        clienteTabela = ObservableCollections.observableList(
                new ArrayList<Cliente>());
        novo();
        pesquisar();
    }

    public void novo()
    {
        setClienteDigitado(new Cliente());
    }

    public void pesquisar()
    {
        clienteTabela.clear();
        clienteTabela.addAll(clienteDao.pesquisar(clienteDigitado));
    }
    
    public void salvar()
    {
        clienteDao.atualizar(clienteDigitado);
        novo();
        pesquisar();
    }
    
    public void excluir()
    {
        clienteDao.excluir(clienteDigitado);
        novo();
        pesquisar();
    }

    public Cliente getClienteDigitado() {
        return clienteDigitado;
    }

    public void setClienteDigitado(Cliente clienteDigitado) {
        Cliente oldClienteDigitado = this.clienteDigitado;
        this.clienteDigitado = clienteDigitado;
        propertyChangeSupport.firePropertyChange("Cliente",
                oldClienteDigitado,clienteDigitado);
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
        if(this.clienteSelecionado != null)
        {
            setClienteDigitado(clienteSelecionado);
        }
    }

    public List<Cliente> getClienteTabela() {
        return clienteTabela;
    }

    public void setClienteTabela(List<Cliente> clienteTabela) {
        this.clienteTabela = clienteTabela;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
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
