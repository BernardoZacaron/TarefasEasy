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
import vianna.edu.br.dao.implement.TarefaDAO;
import vianna.edu.br.model.Categoria;
import vianna.edu.br.model.Tarefa;
import vianna.edu.br.model.Usuario;
import vianna.edu.br.util.VerificadorLogin;

/**
 *
 * @author Windows 10
 */
public class CallCreateTarefaPageAction implements ICommanderAction {

    public CallCreateTarefaPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            VerificadorLogin.verificaLogado(request, response);
            
            List<Categoria> categorias = new CategoriaDAO().findAll();
            
            request.setAttribute("categorias", categorias);
            
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pg=cadTarefa");
            rd.forward(request, response);
        } catch (SQLException ex) {
        }
    }
    
}
