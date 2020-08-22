package Controller;

import Model.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO u = new UsuarioDAO();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        try{
            u.autenticar(login, senha);
            request.setAttribute("login", login);
            request.getRequestDispatcher("topicos").forward(request,response);
        } catch(Exception ex){
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        
        
    }
}
