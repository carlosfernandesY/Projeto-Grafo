package Interface;

import Config.Config;
import DAO.GrafoDAO;
import GRAFO.Grafo;
import MODEL.Pessoa;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Interface {
    Scanner scanner;
    private final static String PATH_LOCAL= Config.PATH+"users";
    public Interface(Scanner scanner){
        this.scanner = scanner;
    }

    public Pessoa login(String nome, String senha) {
        try {
            File dir = new File(PATH_LOCAL);
            if (dir.isDirectory()) {
                for (String nomes : Objects.requireNonNull(dir.list())) {
                    if (nomes.equals(nome)) {
                        FileInputStream fis = new FileInputStream(PATH_LOCAL + "/" + nome);
                        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
                        Pessoa pessoa = (Pessoa) objectInputStream.readObject();
                        if (pessoa.getSenha().equals(senha)) {
                            return pessoa;
                        }
                        else {
                            System.out.println("Senha incorreta");
                            break;
                        }

                    }
                }
            }
        }catch (IOException | ClassNotFoundException e ){
            throw new RuntimeException(e);
        }
        return null;
    }
    public void fazerAmizade(Pessoa logada, Pessoa amizade) throws IOException, ClassNotFoundException {
        GrafoDAO grafoDAO = new GrafoDAO();
        Grafo<Pessoa> pessoaGrafo = grafoDAO.carregarGrafo();
        pessoaGrafo.adicionarAresta(logada,amizade);
        grafoDAO.serializarGrafo();
    }
}
