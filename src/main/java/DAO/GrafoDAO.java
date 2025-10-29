package DAO;
import Config.Config;
import GRAFO.Grafo;
import MODEL.Pessoa;

import java.io.*;


public class GrafoDAO implements Serializable {
    private final static String PATH_LOCAL= Config.PATH+"grafo/grafo.class";
    private final Grafo<Pessoa> grafo ;

    public GrafoDAO() throws IOException, ClassNotFoundException {
        this.grafo = carregarGrafo();

    }
    public Grafo<Pessoa> carregarGrafo()   {
        try {
            FileInputStream grafoCaminho = new FileInputStream(PATH_LOCAL);
            ObjectInputStream objectInputStream = new ObjectInputStream(grafoCaminho);

            return (Grafo<Pessoa>) objectInputStream.readObject();
        }catch (IOException e){
            return new Grafo<>();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


   public  void serializarGrafo(Pessoa pessoa) throws IOException {
        grafo.adicionarVertice(pessoa);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH_LOCAL));
        objectOutputStream.writeObject(grafo);
    }
    public  void serializarGrafo() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH_LOCAL));
        objectOutputStream.writeObject(grafo);
    }

    void fazerAmizade(Pessoa pessoaLogada, Pessoa pessoaParaFazerAmizade){
       grafo.adicionarAresta(pessoaLogada,pessoaParaFazerAmizade);
    }
    void mostra(){
        System.out.println(grafo.toString());
    }

}
