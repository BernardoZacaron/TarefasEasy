/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.TarefaDAO;
import vianna.edu.br.util.VerificadorLogin;
import vianna.edu.br.model.Tarefa;

/**
 *
 * @author Windows 10
 */
public class CallEditarPageAction implements ICommanderAction {

    public CallEditarPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        try {
            Tarefa tarefa = new TarefaDAO().findById(Integer.parseInt(request.getParameter("id")));
            
            request.setAttribute("tarefa", tarefa);
            
            new CallCreateTarefaPageAction().executa(request, response);
        } catch (SQLException ex) {
            request.setAttribute("msg", "tarefa não encontrada");
            new CallListTarefaPageAction().executa(request, response);
        }
    }
    
}
