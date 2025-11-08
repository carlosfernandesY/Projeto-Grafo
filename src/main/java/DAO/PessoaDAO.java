package DAO;

import Config.Config;
import MODEL.Vertice;

import java.io.*;

public class PessoaDAO {
    private static final String LOCAL_PATH = Config.PATH + "users/";

    public Vertice acharPorNome(String nome) {
        Vertice pessoa;
        try {
            File arquivoPessoa = new File(LOCAL_PATH + nome);
            if (arquivoPessoa.exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(arquivoPessoa));
                pessoa = (Vertice) objectInputStream.readObject();
                objectInputStream.close();
                return pessoa;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());

        }
        return null;
    }

    public void serializarPessoa(Vertice vertice) {
        try {
            File pathPessoa = new File(LOCAL_PATH + vertice.getPessoa().getName());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathPessoa));
            objectOutputStream.writeObject(vertice);
            objectOutputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarPessoa(Vertice vertice) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(LOCAL_PATH + vertice.getPessoa().getName());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vertice);
            fileOutputStream.close();
            objectOutputStream.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void adiconarNalista(Vertice vertice, Vertice verticeAdicionar) {
        vertice.adiconarPessoa(verticeAdicionar);
        salvarPessoa(vertice);
    }

    public void resetarListaAmizade(Vertice vertice) {
        vertice.getAmizades().clear();
        salvarPessoa(vertice);
    }

    public boolean contemNoGrafo(String nome) {
        return acharPorNome(nome) != null;
    }
}
