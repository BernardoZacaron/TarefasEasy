/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.TarefaDAO;
import vianna.edu.br.model.Tarefa;
import vianna.edu.br.util.VerificadorLogin;
import vianna.edu.br.model.Usuario;

/**
 *
 * @author Windows 10
 */
public class CallListTarefaPageAction implements ICommanderAction {

    public CallListTarefaPageAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        
        List<Tarefa> tarefas = new TarefaDAO().findMinhasTarefas(user.getId());
        
        request.setAttribute("tarefas", tarefas);
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pg=listTask");
        rd.forward(request, response);
    }
    
}
