package Controller;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exibeTopicoServlet", urlPatterns = {"/exibeTopico"})
public class exibeTopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TopicosDAO t = new TopicosDAO();
        UsuarioDAO u = new UsuarioDAO();
        ComentarioDAO c = new ComentarioDAO();
        String titulo = (String) request.getParameter("titulo");
        String login = (String) request.getParameter("login");
        request.setAttribute("titulo", titulo);
        request.setAttribute("login", login);
        request.setAttribute("conteudo", t.getConteudo(titulo));
        request.setAttribute("autor", u.getNome(t.getLogin(titulo)));
        request.setAttribute("comentarios", c.comentariosDoTopico(t.getId(titulo)));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TopicosDAO t = new TopicosDAO();
        UsuarioDAO u = new UsuarioDAO();
        ComentarioDAO c = new ComentarioDAO();
        String erro = (String) request.getAttribute("erro");
        String titulo = (String) request.getAttribute("titulo");
        String login = (String) request.getAttribute("login");
        request.setAttribute("titulo", titulo);
        request.setAttribute("login", login);
        request.setAttribute("erro", erro);
        request.setAttribute("conteudo", t.getConteudo(titulo));
        request.setAttribute("autor", u.getNome(t.getLogin(titulo)));
        request.setAttribute("comentarios", c.comentariosDoTopico(t.getId(titulo)));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request,response);
    }
}
