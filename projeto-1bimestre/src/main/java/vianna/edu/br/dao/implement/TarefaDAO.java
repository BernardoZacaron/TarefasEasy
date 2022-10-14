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
import vianna.edu.br.model.Tarefa;

/**
 *
 * @author Windows 10
 */
public class TarefaDAO extends GenericDAO<Tarefa, Integer>{ 

    @Override
    public void inserir(Tarefa obj) throws SQLException {
        con.getTransaction().begin();
        con.persist(obj);
        con.getTransaction().commit();
    }

    @Override
    public void alterar(Tarefa obj) throws SQLException {
        con.getTransaction().begin();
        con.merge(obj);
        con.getTransaction().commit();
    }

    @Override
    public void apagar(Tarefa obj) throws SQLException {
        con.getTransaction().begin();
        con.remove(obj);
        con.getTransaction().commit();
    }

    @Override
    public Tarefa findById(Integer key) throws SQLException {
        String consulta = "select t from Tarefa t where t.id = :k ";
        Query q = con.createQuery(consulta); 
        q.setParameter("k", key);
        
        try{
            return (Tarefa)q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Tarefa> findAll() throws SQLException {
        String consulta = "select t from Tarefa t ";
        Query q = con.createQuery(consulta);
        
        return q.getResultList();
    }

    public List<Tarefa> findTarefasByUsuarioAndCategoria(Integer usuario, String categoria) throws SQLException{
        String consulta = "select t from Tarefa t where t.usuario.id = :usuario and t.categoria.nome like :categoria ";
        Query q = con.createQuery(consulta);
        
        q.setParameter("usuario", usuario);
        q.setParameter("categoria", "%"+categoria+"%");
        
        return q.getResultList();
    }

    public List<Tarefa> findMinhasTarefas(int id) {
        String consulta = "select t from Tarefa t where t.usuario.id = :id ";
        Query q = con.createQuery(consulta);
        
        q.setParameter("id", id);
        
        return q.getResultList();
    }
}
