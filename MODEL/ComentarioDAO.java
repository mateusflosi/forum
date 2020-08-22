package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ComentarioDAO {
    
    public Map<String,String> comentariosDoTopico(int id)
    {
        Map<String,String> comentarios = new HashMap<>();
        
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            String sql = "SELECT LOGIN,COMENTARIO FROM comentario WHERE id_topico=?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                comentarios.put(rs.getString("login"),rs.getString("comentario"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar a conexão", e);
        }
        return comentarios;
    }
    
    public void inserir(String comentario, String login, int id_topico) throws Exception {
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            if(isVazio(comentario, login)) throw new Exception("Campo não preenchido");
            String sql = "INSERT INTO comentario( comentario, login, id_topico) VALUES (?, ?, ?);";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, comentario);
            stm.setString(2, login);
            stm.setInt(3, id_topico);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro na conexão com o banco de dados", e);
        }
    }

    private boolean isVazio(String comentario, String login) {
        if(comentario.equals("")) return true;
        return login.equals("");
    }
}
