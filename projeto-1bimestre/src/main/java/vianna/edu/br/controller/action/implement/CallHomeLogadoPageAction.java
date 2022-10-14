/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.CategoriaDAO;
import vianna.edu.br.model.Categoria;
import vianna.edu.br.util.VerificadorLogin;

/**
 *
 * @author Aluno
 */
public class CallHomeLogadoPageAction implements ICommanderAction{
    
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        try {
            List<Categoria> categorias = new CategoriaDAO().findAll();
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao buscar categorias no banco");
            new CallHomePageAction().executa(request, response);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pg=home_logado");
        rd.forward(request,response);
    }

}
