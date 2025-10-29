package GRAFO;

import java.io.Serializable;
import java.util.ArrayList;

public class Grafo<T> implements Serializable {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
    private static final long UIID = 1L;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }

    public void adicionarVertice(T pessoa) {
        Vertice<T> novoVertice = new Vertice<T>(pessoa);
        this.vertices.add(novoVertice);
    }

    public ArrayList<Vertice<T>> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Aresta<T>> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta<T>> arestas) {
        this.arestas = arestas;
    }

    public void adicionarAresta(T p1, T p2) {
        Vertice<T> inicio = this.pegarPessoa(p1);
        Vertice<T> fim = this.pegarPessoa(p2);
        Aresta<T> aresta = new Aresta<T>(inicio, fim);
        inicio.fazerAmizade(aresta);
        fim.fazerAmizade(aresta);
        this.arestas.add(aresta);

    }

    public Vertice<T> pegarPessoa(T pessoa) {
        for (Vertice<T> vertice : vertices) {
            if (vertice.getPessoa().equals(pessoa)) {
                return vertice;
            }
        }
        return null;
    }

    public void buscaEmLargura() {
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        ArrayList<Vertice<T>> fila = new ArrayList<Vertice<T>>();
        Vertice<T> atual = this.vertices.getFirst();
        marcados.add(atual);
        System.out.println(atual.getPessoa());
        fila.add(atual);
        while (!fila.isEmpty()) {
            Vertice<T> visitado = fila.getFirst();
            for (int i = 0; i < visitado.getLigacacoes().size(); i++) {
                Vertice<T> proximo = visitado.getLigacacoes().get(i).getFim();
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    System.out.println(proximo.getPessoa().toString());
                    fila.add(proximo);
                }
            }
            fila.removeFirst();
        }
    }

    @Override
    public String toString() {
        return "Grafo{" +
                "vertices=" + vertices +
                ", arestas=" + arestas +
                '}';
    }
}
