package Controller;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "comentarServlet", urlPatterns = {"/comentar"})
public class comentarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ComentarioDAO c = new ComentarioDAO();
        TopicosDAO t = new TopicosDAO();
        UsuarioDAO u = new UsuarioDAO();
        String titulo = (String) request.getParameter("titulo");
        String login = (String) request.getParameter("login");
        String conteudo = (String) request.getParameter("conteudo");
        String id = (String) request.getParameter("id");
        String comentario = (String) request.getParameter("novoComentario");
        
        try{
            c.inserir(comentario, login, Integer.parseInt(id));
            u.adicionaPontos(login, 3);
        } catch(Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        request.setAttribute("titulo", titulo);
        request.setAttribute("login", login);
        request.setAttribute("conteudo", conteudo);
        request.setAttribute("id", id);
        request.getRequestDispatcher("exibeTopico").forward(request,response);
    }
}
