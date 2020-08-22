package Controller;

import Model.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inserirTopicoServlet", urlPatterns = {"/inserirTopico"})
public class inserirTopicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TopicosDAO t = new TopicosDAO();
        UsuarioDAO u = new UsuarioDAO();
        String login = (String) request.getParameter("login");
        String conteudo = (String) request.getParameter("conteudo");
        String titulo = (String) request.getParameter("titulo");
        
        try {
            t.inserir(login, conteudo, titulo);
            u.adicionaPontos(login, 10);
            request.setAttribute("login", login);
            request.getRequestDispatcher("topicos").forward(request,response);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("insereTopico.jsp").forward(request,response);
        }
    }
}
