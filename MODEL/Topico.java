package Model;

public class Topico {
    private int id;
    private String titulo;
    private String login;
    private String conteudo;
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }
    
    public int getId(){
        return id;
    }
    
    public String getTitulo(){
        return titulo;
    } 
    
    public String getLogin(){
        return login;
    }
    
    public String getConteudo(){
        return conteudo;
    }
}
