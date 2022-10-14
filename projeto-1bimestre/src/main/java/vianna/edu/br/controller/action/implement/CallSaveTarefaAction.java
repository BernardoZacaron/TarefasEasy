/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.CategoriaDAO;
import vianna.edu.br.dao.implement.TarefaDAO;
import vianna.edu.br.dao.implement.UsuarioDAO;
import vianna.edu.br.model.Tarefa;
import vianna.edu.br.model.Usuario;
import vianna.edu.br.util.VerificadorLogin;

/**
 *
 * @author Windows 10
 */
public class CallSaveTarefaAction implements ICommanderAction {

    public CallSaveTarefaAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        
        Tarefa t = null;
        try {
            t = new Tarefa(0, request.getParameter("descricao"), false, sdf.parse(request.getParameter("dataPlanejada")), null, 0);
        } catch (ParseException ex) {
            request.setAttribute("msg", "data inserida é inválida");
            new CallCreateTarefaPageAction().executa(request, response);
        }
        
        t.setUsuario((Usuario)request.getSession().getAttribute("user"));
        
        try {
            t.setCategoria(new CategoriaDAO().findById(Integer.parseInt(request.getParameter("categoria"))));
        } catch (SQLException ex) {
            request.setAttribute("msg", "categoria não encontrada");
            new CallCreateTarefaPageAction().executa(request, response);
        }
    
        try {
            new TarefaDAO().inserir(t);
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao gravar tarefa no banco");
            new CallCreateTarefaPageAction().executa(request, response);
        }
        
        new CallListTarefaPageAction().executa(request, response);
    }
}
