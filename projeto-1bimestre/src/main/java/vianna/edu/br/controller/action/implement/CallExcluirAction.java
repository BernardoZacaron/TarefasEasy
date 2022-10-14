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

/**
 *
 * @author Windows 10
 */
public class CallExcluirAction implements ICommanderAction {

    public CallExcluirAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        TarefaDAO td = new TarefaDAO();
        
        try {
            td.apagar(td.findById(Integer.parseInt(request.getParameter("id"))));
            
            request.setAttribute("msg", "tarefa apagada com sucesso!");
            new CallListTarefaPageAction().executa(request, response);
        } catch (SQLException ex) {
            request.setAttribute("msg", "não foi possível apagar a tarefa");
            new CallListTarefaPageAction().executa(request, response);
        }
                
    }
    
}
