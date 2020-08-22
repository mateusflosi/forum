package Model;

public class Usuario {
    int colocacao;
    String nome;
    String login;
    int pontos;
    
    public void setColocacao(int colocacao)
    {
        this.colocacao = colocacao;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setLogin(String login)
    {
        this.login = login;
    }
    
    public void setPontos(int pontos)
    {
        this.pontos = pontos;
    }
    
    public int getColocacao()
    {
        return this.colocacao;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getLogin()
    {
        return this.login;
    }
    
    public int getPontos()
    {
        return this.pontos;
    }
}
