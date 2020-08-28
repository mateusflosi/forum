package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TopicosDAO {
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void inserir(String login, String conteudo, String titulo) throws Exception {
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            if(isVazio(login, conteudo, titulo)) throw new Exception("Campo não preenchido");
            //adicionar erro que não permite topicos com o mesmo titulo
            String sql = "INSERT INTO topico( id_topico, titulo, conteudo, login) VALUES (? ,?, ?, ?);";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, getId());
            stm.setString(2, titulo);
            stm.setString(3, conteudo);
            stm.setString(4, login);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro na conexão com o banco de dados", e);
        }
    }
    
    public List<Topico> topicosDoUsuario(String login)
    {
        List<Topico> topicos = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            String sql = "SELECT * FROM topico WHERE login=?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                topicos.add(preencheTopico(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar a conexão", e);
        }
        return topicos;
    }

    public List<Topico> outrosTopicos(String login)
    {
        List<Topico> outrosTopicos = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            String sql = "SELECT * FROM topico WHERE login!=?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                outrosTopicos.add(preencheTopico(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar a conexão", e);
        }
        
        return outrosTopicos;   
    }
    
    public String getLogin(int id)
    {
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            String sql = "SELECT LOGIN FROM topico WHERE id_topico=?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getString("login");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar a conexão", e);
        }
    }

    private boolean isVazio(String login, String conteudo, String titulo) {
        if(login.equals("")) return true;
        if(conteudo.equals("")) return true;
        return titulo.equals("");
    }

    private int getId() {
        Random rm = new Random();
        return rm.nextInt(2099999998) + 1;
    }

    private Topico preencheTopico(ResultSet rs) {
        Topico t = new Topico();
        try{
            t.setConteudo(rs.getString("conteudo"));
            t.setId(rs.getInt("id_topico"));
            t.setLogin(rs.getString("login"));
            t.setTitulo(rs.getString("titulo"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }
}
