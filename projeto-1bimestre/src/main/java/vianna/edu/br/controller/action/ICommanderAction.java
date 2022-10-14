package vianna.edu.br.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommanderAction {
    //public boolean podeAcessar(HttpServletRequest request, HttpServletResponse response);
    
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
