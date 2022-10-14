/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.dao.implement.CategoriaDAO;
import vianna.edu.br.model.Categoria;
import vianna.edu.br.util.VerificadorLogin;

/**
 *
 * @author Windows 10
 */
public class CallSaveCategoriaAction implements ICommanderAction {

    public CallSaveCategoriaAction() {
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificadorLogin.verificaLogado(request, response);
                
        Categoria cat = new Categoria(0, request.getParameter("nome"), request.getParameter("descricao"));
                
        try {
            new CategoriaDAO().inserir(cat);
        } catch (SQLException ex) {
            request.setAttribute("msg", "erro ao gravar categoria no banco");
            new CallCreateCategoriaPageAction().executa(request, response);
        }
        
        new CallHomePageAction().executa(request, response);
    }
    
}
