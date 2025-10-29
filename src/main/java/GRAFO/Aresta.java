package GRAFO;

import java.io.Serializable;

public class Aresta<Pessoa> implements Serializable {
    private Vertice<Pessoa> comeco;
    private Vertice<Pessoa> fim;
    public Aresta(Vertice<Pessoa> comeco, Vertice<Pessoa> fim) {
        this.comeco = comeco;
        this.fim = fim;
    }
    public Vertice<Pessoa> getComeco() {
        return comeco;
    }

    public void setComeco(Vertice<Pessoa> comeco) {
        this.comeco = comeco;
    }

    public Vertice<Pessoa> getFim() {
        return fim;
    }

    public void setFim(Vertice<Pessoa> fim) {
        this.fim = fim;
    }
}
