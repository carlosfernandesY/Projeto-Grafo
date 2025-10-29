package GRAFO;

import java.io.Serializable;
import java.util.ArrayList;

public class  Vertice<Type> implements Serializable {
    private Type pessoa;
    private ArrayList<Aresta<Type>> ligacacoes;

    public Vertice(Type pessoa) {
        this.pessoa = pessoa;
        this.ligacacoes = new ArrayList<Aresta<Type>>();
    }

    public Type getPessoa() {
        return pessoa;
    }

    public void setPessoa(Type pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<Aresta<Type>> getLigacacoes() {
        return ligacacoes;
    }

    public void setLigacacoes(ArrayList<Aresta<Type>> ligacacoes) {
        this.ligacacoes = ligacacoes;
    }

    public void fazerAmizade(Aresta<Type> aresta) {
        this.ligacacoes.add(aresta);
    }
}
