/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public abstract class GenericDAO<C,K> {
    
    private EntityManagerFactory emf;
    protected EntityManager con;
    
    public GenericDAO(){
        emf = Persistence.createEntityManagerFactory("tarefas-pu");
        con = emf.createEntityManager();
    }
    
    public EntityManager getEm(){
        return con;
    }
    
    public abstract void inserir(C obj) throws SQLException;
    public abstract void alterar(C obj) throws SQLException;
    public abstract void apagar(C obj) throws SQLException;
    public abstract C findById(K key) throws SQLException;
    public abstract List<C> findAll() throws SQLException;
}
