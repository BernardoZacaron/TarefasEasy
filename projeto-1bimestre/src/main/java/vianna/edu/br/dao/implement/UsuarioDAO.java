/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.dao.implement;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import vianna.edu.br.controller.action.implement.CallErroPageAction;
import vianna.edu.br.dao.GenericDAO;
import vianna.edu.br.model.Usuario;
import vianna.edu.br.util.Criptografia;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO extends GenericDAO<Usuario, Integer>{
    
    @Override
    public void inserir(Usuario obj) throws SQLException {
        con.getTransaction().begin();
        obj.setSenha(Criptografia.getHash(obj.getSenha()));
        con.persist(obj);
        con.getTransaction().commit();
    }

    @Override
    public void alterar(Usuario obj) throws SQLException {
        con.getTransaction().begin();
        con.merge(obj);
        con.getTransaction().commit();
    }

    @Override
    public void apagar(Usuario obj) throws SQLException {
        con.getTransaction().begin();
        con.remove(obj);
        con.getTransaction().commit();
    }

    @Override
    public Usuario findById(Integer key) throws SQLException {
        //String sql = "select * from usuario where id=10";
        String consulta = "select u from Usuario u where u.id = :k ";
        Query q = con.createQuery(consulta); 
        q.setParameter("k", key);
        
        try{
            return (Usuario)q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
        String consulta = "select u from Usuario u ";
        Query q = con.createQuery(consulta);
        
        return q.getResultList();
    }
    
    public Usuario verificarLogin(String login, String senha) throws SQLException/*, NoSuchAlgorithmException*/{
        String consulta = "select u from Usuario u where upper(u.login) = upper(:login) and u.senha = :senha";
        Query q = con.createQuery(consulta);
        
        q.setParameter("login",login);
        q.setParameter("senha", Criptografia.getHash(senha));
        
        try{
            return (Usuario) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }catch(NonUniqueResultException e ){
            return (Usuario)q.getResultList().get(0);
        }
    }
}
