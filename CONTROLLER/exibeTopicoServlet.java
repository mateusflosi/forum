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
    
    protected void processamento(HttpServletRequest request, HttpServletResponse response,
            String titulo, String login, String conteudo, int id) throws ServletException, IOException {
        TopicosDAO t = new TopicosDAO();
        UsuarioDAO u = new UsuarioDAO();
        ComentarioDAO c = new ComentarioDAO();
        request.setAttribute("titulo", titulo);
        request.setAttribute("login", login);
        request.setAttribute("conteudo", conteudo);
        request.setAttribute("id", id);
        request.setAttribute("autor", u.getNome(t.getLogin(id)));
        request.setAttribute("comentarios", c.comentariosDoTopico(id));
        request.getRequestDispatcher("exibeTopico.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = (String) request.getParameter("titulo");
        String login = (String) request.getParameter("login");
        String conteudo = (String) request.getParameter("conteudo");
        int id = Integer.parseInt((String) request.getParameter("id"));
        processamento(request, response, titulo, login, conteudo, id);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String erro = (String) request.getAttribute("erro");
        String titulo = (String) request.getAttribute("titulo");
        String login = (String) request.getAttribute("login");
        String conteudo = (String) request.getAttribute("conteudo");
        int id = Integer.parseInt((String) request.getAttribute("id"));
        processamento(request, response, titulo, login, conteudo, id);
    }
}
