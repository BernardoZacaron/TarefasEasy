/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.UsuarioDAO;
import vianna.edu.br.model.Usuario;

/**
 *
 * @author Windows 10
 */
public class SaveUserAction implements ICommanderAction {

    public SaveUserAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario user = new Usuario(0, request.getParameter("cadNome"), request.getParameter("cadEmail"), request.getParameter("cadLogin"), request.getParameter("cadSenha"), new Date());
    
        if(user.getNome().isEmpty() || user.getNome().trim().isEmpty()){
            request.setAttribute("msg", "nome não pode ser vazio");
            request.setAttribute("user", user);
            new CallCreateUserPageAction().executa(request, response);
        }
        
        try {
            new UsuarioDAO().inserir(user);
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao salvar usuário no banco");
            request.setAttribute("user", user);
            new CallCreateUserPageAction().executa(request, response);
        }
        new CallLoginPageAction().executa(request, response);
    }
    
}
