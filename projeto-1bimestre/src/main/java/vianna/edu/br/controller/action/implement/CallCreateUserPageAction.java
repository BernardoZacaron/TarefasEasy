/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller.action.implement;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.ICommanderAction;

/**
 *
 * @author Windows 10
 */
public class CallCreateUserPageAction implements ICommanderAction {

    public CallCreateUserPageAction() {
        
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?pg=cadUser");
        rd.forward(request,response);
    }
    
}
