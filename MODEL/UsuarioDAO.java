package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public String autenticar(String login, String senhaDigitada) throws Exception{
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            String senhaBanco, sql = "SELECT NOME, SENHA from usuario WHERE login = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            rs.next(); 
            senhaBanco = rs.getString("senha");
            if(senhaBanco.equals(senhaDigitada)) return rs.getString("nome");
            throw new Exception("Senha incorreta");
        } catch (SQLException e) {
            throw new SQLException("Usuario não existe", e);
        }
    }
    
    public void inserir(String login, String email, String nome, String senha) throws Exception {
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            if(isVazio(login, email, nome, senha)) throw new Exception("Dados incompletos");
            
            String sql = "INSERT INTO usuario( login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            stm.setString(2, email);
            stm.setString(3, nome);
            stm.setString(4, senha);
            stm.setInt(5, 0);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Login ja existe", e);
        }
    }
    
    public List<Usuario> ranking() {
        List<Usuario> ranking = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            int i = 0;
            String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                ranking.add(preencheUsuario(rs,i));
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar a conexão", e);
        }

        return ranking;
    }

    private boolean isVazio(String login, String email, String nome, String senha) {
        if(login.equals("")) return true;
        if(email.equals("")) return true;
        if(nome.equals("")) return true;
        return senha.equals("");
    }
    
    private Usuario preencheUsuario(ResultSet rs, int i)
    {
        Usuario u = new Usuario();
        try {
            u.setColocacao(i+1);
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setPontos(rs.getInt("pontos"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public String getNome(String login) {
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            String sql = "SELECT NOME FROM usuario WHERE login=?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getString("nome");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar a conexão", e);
        }
    }
    
    public void adicionaPontos(String login, int pontos) {
        try(Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/coursera","postgres","senha")){
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, pontos);
            stm.setString(2, login);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar a conexão", e);
        }
    }
}
