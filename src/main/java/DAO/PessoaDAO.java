package DAO;
import Config.Config;
import GRAFO.Grafo;
import MODEL.Pessoa;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class PessoaDAO implements Serializable{
    private final static String PATH_LOCAL= Config.PATH+"users/";
    private GrafoDAO grafo;
    public  PessoaDAO() throws IOException, ClassNotFoundException {
        this.grafo = new GrafoDAO();

    }
    public void cadastrarEmArquivo(Pessoa pessoa) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH_LOCAL + pessoa.getName()));
            objectOutputStream.writeObject(pessoa);
            objectOutputStream.close();
            grafo.serializarGrafo(pessoa);



    }
    private boolean confirmarSenha(String senha,String confimarSenha) {
        if (confimarSenha.equals(senha)) {
            return true;
        }
        System.out.println("Senhas não combativeis, tente novamente: ");
        confirmarSenha(senha,new Scanner(System.in).nextLine());
        return false;
    }
    public void listarPessoaParaPossiveisAmizades(){
        File dir = new File(Config.PATH);
        if(dir.isDirectory()){
            System.out.println("Pessoa disponíveis para uma amizade:");
            for(String pessoas : Objects.requireNonNull(dir.list())){
                System.out.println(pessoas);
            }
        }
    }
    public Pessoa formularioCadastro() {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        System.out.println("Qual seu nome? ");
        pessoa.setName(scanner.nextLine());
        System.out.println("Qual a sua senha? ");
        String senha = scanner.nextLine();
        System.out.println("Confirme sua senha: ");
        if(confirmarSenha(senha,new Scanner(System.in).nextLine())){
            pessoa.setSenha(senha);
        }
        System.out.println("Escolha algum interesse do seu agrado: ");
        System.out.println("1-FUTEBOL\n2-COMPUTAÇÃO\n3-MODA");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                pessoa.setInteresse("Futebol");
                break;
            case 2:
                pessoa.setInteresse("Computação");
                break;
            case 3:
                pessoa.setInteresse("Moda");
                break;
        }
        return pessoa;
    }
    public Pessoa buscarNaLista(String nome) throws IOException, ClassNotFoundException {
        File dir = new File(PATH_LOCAL);
        if(dir.isDirectory()){
            for(String pessoa: Objects.requireNonNull(dir.list())){
                if(nome.equals(pessoa)){
                    FileInputStream fileInputStream = new FileInputStream(PATH_LOCAL+nome);
                    ObjectInputStream  objectInputStream = new ObjectInputStream(fileInputStream);
                    return (Pessoa) objectInputStream.readObject();

                }
            }
        }
        return null;
    }
    public void  fazerAmizade(){
    }
}



