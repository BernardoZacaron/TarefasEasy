/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.dao.implement;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import vianna.edu.br.dao.GenericDAO;
import vianna.edu.br.model.Categoria;

/**
 *
 * @author Aluno
 */
public class CategoriaDAO extends GenericDAO<Categoria, Integer>{

    @Override
    public void inserir(Categoria obj) throws SQLException {
        con.getTransaction().begin();
        con.persist(obj);
        con.getTransaction().commit();
    }

    @Override
    public void alterar(Categoria obj) throws SQLException {
        con.getTransaction().begin();
        con.merge(obj);
        con.getTransaction().commit();
    }

    @Override
    public void apagar(Categoria obj) throws SQLException {
        con.getTransaction().begin();
        con.remove(obj);
        con.getTransaction().commit();
    }

    @Override
    public Categoria findById(Integer key) throws SQLException {
        String consulta = "select c from Categoria c where c.id = :k ";
        Query q = con.createQuery(consulta); 
        q.setParameter("k", key);
        
        try{
            return (Categoria)q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Categoria> findAll() throws SQLException {
        String consulta = "select c from Categoria c ";
        Query q = con.createQuery(consulta);
        
        return q.getResultList();
    }
}
