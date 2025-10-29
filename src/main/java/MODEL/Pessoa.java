package MODEL;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String name;
    private String interesse;
    private String senha;
    private static final long UUID =1L;

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                ", interesse='" + interesse + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }public Pessoa() {
    }

    public Pessoa(String name, String senha,String interesse) {
        this.name = name;
        this.interesse=interesse;
        this.senha = senha;

    }
}
