package Controller;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "topicosServlet", urlPatterns = {"/topicos"})
public class topicosServlet extends HttpServlet {

    protected void process(HttpServletRequest request, HttpServletResponse response, String login)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TopicosDAO t = new TopicosDAO(); 
        UsuarioDAO u = new UsuarioDAO();
        request.setAttribute("nome", u.getNome(login));
        request.setAttribute("login", login);
        request.setAttribute("topicosUsuario", t.topicosDoUsuario(login));
        request.setAttribute("outrosTopicos", t.outrosTopicos(login));
        request.getRequestDispatcher("topicos.jsp").forward(request,response);
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = (String) request.getAttribute("login");
        process(request, response, login);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = (String) request.getParameter("login");
        process(request, response, login);
    }
}
