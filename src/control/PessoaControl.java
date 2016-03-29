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
import model.dao.PessoaDao;
import model.domain.Pessoa;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * @author RickWill, Nandão & UlysS
 */

public final class PessoaControl
{
    private final PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Pessoa pessoaDigitada;
    
    private Pessoa pessoaSelecionada;
    
    private List<Pessoa> pessoaTabela;
    
    private PessoaDao pessoaDao;
    
    public PessoaControl ()
    {
        pessoaDao = new PessoaDao();
        pessoaTabela = ObservableCollections.observableList(
                new ArrayList<Pessoa>());
        novo();
        pesquisar();
    }
    public void novo()
    {
        setPessoaDigitada(new Pessoa());
    }

    public void pesquisar()
    {
        pessoaTabela.clear();
        pessoaTabela.addAll(pessoaDao.pesquisar(pessoaDigitada));
    }
    
    public void salvar()
    {
        pessoaDao.atualizar(pessoaDigitada);
        novo();
        pesquisar();
    }
    
    public void excluir()
    {
        pessoaDao.excluir(pessoaDigitada);
        novo();
        pesquisar();
    }
    
    public Pessoa getPessoaDigitada() {
        return pessoaDigitada;
    }

    public void setPessoaDigitada(Pessoa pessoaDigitada) {
        Pessoa oldPessoaDigitada = this.pessoaDigitada;
        this.pessoaDigitada = pessoaDigitada;
        propertyChangeSupport.firePropertyChange("PessoaDigitada",
                oldPessoaDigitada,pessoaDigitada);
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
        if(this.pessoaSelecionada != null)
        {
            setPessoaDigitada(pessoaSelecionada);
        }
    }

    public List<Pessoa> getPessoaTabela() {
        return pessoaTabela;
    }

    public void setPessoaTabela(List<Pessoa> pessoaTabela) {
        this.pessoaTabela = pessoaTabela;
    }

    public PessoaDao getPessoaDao() {
        return pessoaDao;
    }

    public void setUsuarioDao(PessoaDao usuarioDao) {
        this.pessoaDao = usuarioDao;
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
