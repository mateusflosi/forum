package Controller;

import Model.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarServlet", urlPatterns = {"/Cadastrar"})
public class CadastrarServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO u = new UsuarioDAO();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        
        try{
            u.inserir(login, email, nome, senha);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        catch(Exception e){
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("cadastro.jsp").forward(request,response);
        }
    }
}
