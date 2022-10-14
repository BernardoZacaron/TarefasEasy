/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.CategoriaDAO;
import vianna.edu.br.model.Categoria;

/**
 *
 * @author Aluno
 */
public class CallHomePageAction implements ICommanderAction{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> categorias = new ArrayList<>();
        
        try{
            categorias = new CategoriaDAO().findAll();
            
        }catch (SQLException ex){
            request.setAttribute("msg", "erro ao buscar categorias no banco");
            new CallHomePageAction().executa(request, response);
        }
        
        request.setAttribute("categorias", categorias);
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
        rd.forward(request,response);
    }
}
