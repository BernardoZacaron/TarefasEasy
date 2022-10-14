/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
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
 * @author Aluno
 */
public class VerifyLoginAction implements ICommanderAction {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            Usuario user = new UsuarioDAO().verificarLogin(login, senha);
            
            if(user == null){
                request.setAttribute("msg", "Login ou senha incorreta");
                new CallLoginPageAction().executa(request, response);
            }else{
                request.getSession().setAttribute("user", user);
                new CallHomeLogadoPageAction().executa(request, response);
            }
        } catch (SQLException ex) {
            new CallErroPageAction("Não foi possível conectar ou consultar o banco de dados").executa(request, response);
        }
    }
    
}
