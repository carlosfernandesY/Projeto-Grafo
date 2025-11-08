package DAO;

import Config.Config;
import MODEL.Grafo;
import MODEL.Vertice;

import java.io.*;

public class GrafoDAO {
    private static final String PATH_LOCAL = Config.PATH + "grafo/grafo";
    public void serializarGrafo(Grafo grafo) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH_LOCAL));
            objectOutputStream.writeObject(grafo);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public Grafo criarGrafo() {
        Grafo grafo = new Grafo();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH_LOCAL));
            objectOutputStream.writeObject(grafo);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return grafo;
    }
    public void salvarGrafo(Grafo grafo){
        try {
            FileOutputStream fileInputStream = new FileOutputStream(new File(PATH_LOCAL));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
            objectOutputStream.writeObject(grafo);
            objectOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

   }
    public Grafo carrregarGrafo() {
        try {
            File grafoArquivo = new File(PATH_LOCAL);
            if (grafoArquivo.exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(grafoArquivo));
                Grafo grafo = (Grafo) objectInputStream.readObject();
                objectInputStream.close();
                return grafo;

            } else {
                return criarGrafo();
            }
        } catch (IOException | ClassNotFoundException e) {
            return criarGrafo();
        }

    }
    public void adicionarNografo(Vertice vertice) {
        Grafo grafo = carrregarGrafo();
        grafo.adiconarNaRede(vertice);
        serializarGrafo(grafo);
    }
    public void listarPessoasNografo(Grafo grafo) {
        for (Vertice pessoa : grafo.getVertices()) {
            System.out.println(pessoa.toString());

        }
    }

    public Vertice acharPorNome(String nome,Grafo grafo){
        for(Vertice vertice:grafo.getVertices()){
            if(vertice.getPessoa().getName().equals(nome)){
                return vertice;
            }
        }
     return null;
    }

}
