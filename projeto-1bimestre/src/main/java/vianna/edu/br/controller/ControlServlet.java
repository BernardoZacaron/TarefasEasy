/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vianna.edu.br.controller;

import vianna.edu.br.controller.action.implement.CallSaveTarefaAlteradaAction;
import vianna.edu.br.controller.action.implement.CallExcluirAction;
import vianna.edu.br.controller.action.implement.CallConcluirAction;
import vianna.edu.br.controller.action.implement.CallSaveCategoriaAction;
import vianna.edu.br.controller.action.implement.CallSaveTarefaAction;
import vianna.edu.br.controller.action.implement.LogoutAction;
import vianna.edu.br.controller.action.implement.SaveUserAction;
import vianna.edu.br.controller.action.implement.CallCreateUserPageAction;
import vianna.edu.br.controller.action.implement.VerifyLoginAction;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vianna.edu.br.controller.action.implement.CallListTarefaPageAction;
import vianna.edu.br.controller.action.ICommanderAction;
import vianna.edu.br.controller.action.implement.CallCreateCategoriaPageAction;
import vianna.edu.br.controller.action.implement.CallCreateTarefaPageAction;
import vianna.edu.br.controller.action.implement.CallCreateTarefaPageAction;
import vianna.edu.br.controller.action.implement.CallCreateUserPageAction;
import vianna.edu.br.controller.action.implement.CallEditarPageAction;
import vianna.edu.br.controller.action.implement.CallErroPageAction;
import vianna.edu.br.controller.action.implement.CallErroPageAction;
import vianna.edu.br.controller.action.implement.CallHomeLogadoPageAction;
import vianna.edu.br.controller.action.implement.CallHomeLogadoPageAction;
import vianna.edu.br.controller.action.implement.CallHomePageAction;
import vianna.edu.br.controller.action.implement.CallHomePageAction;
import vianna.edu.br.controller.action.implement.CallLoginPageAction;
import vianna.edu.br.controller.action.implement.CallLoginPageAction;
import vianna.edu.br.controller.action.implement.LogoutAction;
import vianna.edu.br.controller.action.implement.SaveUserAction;
import vianna.edu.br.controller.action.implement.VerifyLoginAction;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "Control", urlPatterns = {"/control"})
public class ControlServlet extends HttpServlet {
    
    static final HashMap<String, ICommanderAction> comandos = new HashMap<>();

    public ControlServlet() {
        if(comandos.isEmpty()){
            comandos.put(null, new CallLoginPageAction());
            comandos.put("home", new CallHomePageAction());//listagem de categorias
            comandos.put("login", new CallLoginPageAction());
            comandos.put("verifyLogin", new VerifyLoginAction());
            comandos.put("homeLogado", new CallHomeLogadoPageAction()); 
            comandos.put("cadUsuario", new CallCreateUserPageAction());
            comandos.put("saveUser", new SaveUserAction());
            comandos.put("logout", new LogoutAction());
            comandos.put("addTarefa", new CallCreateTarefaPageAction());
            comandos.put("addCategoria", new CallCreateCategoriaPageAction());
            comandos.put("listarTarefas", new CallListTarefaPageAction());//listagem de tarefas
            comandos.put("saveTarefa", new CallSaveTarefaAction());
            comandos.put("saveCategoria", new CallSaveCategoriaAction());
            comandos.put("concluirTarefa", new CallConcluirAction());
            comandos.put("editarTarefa", new CallEditarPageAction());
            comandos.put("saveTarefaAlterada", new CallSaveTarefaAlteradaAction());
            comandos.put("excluirTarefa", new CallExcluirAction());
        }
    }
    
    static{
        comandos.put(null, new CallHomePageAction());
        comandos.put("home", new CallHomePageAction());
        comandos.put("login", new CallLoginPageAction());
        comandos.put("verifyLogin", new VerifyLoginAction());
        comandos.put("homeLogado", new CallHomeLogadoPageAction());
        comandos.put("cadUsuario", new CallCreateUserPageAction());
        comandos.put("saveUser", new SaveUserAction());
        comandos.put("logout", new LogoutAction());
        comandos.put("addTarefa", new CallCreateTarefaPageAction());
        comandos.put("addCategoria", new CallCreateCategoriaPageAction());
        comandos.put("listarTarefas", new CallListTarefaPageAction());
        comandos.put("saveTarefa", new CallSaveTarefaAction());
        comandos.put("saveCategoria", new CallSaveCategoriaAction());
        comandos.put("concluirTarefa", new CallConcluirAction());
        comandos.put("editarTarefa", new CallEditarPageAction());
        comandos.put("saveTarefaAlterada", new CallSaveTarefaAlteradaAction());
        comandos.put("excluirTarefa", new CallExcluirAction());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ac = request.getParameter("ac");
        
        try{
        comandos.get(ac).executa(request, response);
        }catch(Exception e){
            new CallErroPageAction("Ocorreu um erro interno no sistema"+e.getMessage()).executa(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
