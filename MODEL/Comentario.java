package Model;

public class Comentario {
    private String login;
    private String comentario;
    private int id;
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getLogin(){
        return login;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    public int getId(){
        return id;
    }
}
