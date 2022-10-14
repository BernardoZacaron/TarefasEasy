/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.CategoriaDAO;
import vianna.edu.br.dao.implement.TarefaDAO;
import vianna.edu.br.util.VerificadorLogin;
import vianna.edu.br.model.Tarefa;

/**
 *
 * @author Windows 10
 */
public class CallSaveTarefaAlteradaAction implements ICommanderAction {

    public CallSaveTarefaAlteradaAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        
        TarefaDAO td = new TarefaDAO();
        CategoriaDAO cd = new CategoriaDAO();
        Tarefa t = null;
        try {
            t = td.findById(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException ex) {
            request.setAttribute("msg", "tarefa não encontrada");
            new CallListTarefaPageAction().executa(request, response);
        }
        
        try {
            t.setDescricao(request.getParameter("descricao"));
            t.setCategoria(cd.findById(Integer.parseInt(request.getParameter("categoria"))));
            td.alterar(t);
            
            request.setAttribute("msg", "tarefa alterada com sucesso!");
        } catch (SQLException ex) {
            request.setAttribute("msg", "não foi possível alterar a tarefa");
            new CallListTarefaPageAction().executa(request, response);
        }
        
        new CallListTarefaPageAction().executa(request, response);
    }
    
}
