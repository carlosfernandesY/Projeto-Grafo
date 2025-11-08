package Interface;

import DAO.GrafoDAO;
import DAO.PessoaDAO;
import MODEL.Vertice;
import MODEL.Pessoa;

import java.util.Scanner;

public class Login {
    GrafoDAO grafoDAO = new GrafoDAO();
    PessoaDAO pessoaDAO = new PessoaDAO();

    boolean testSenha(String senha, String novaSenha) {
        Scanner scanner = new Scanner(System.in);
        if (!senha.equals(novaSenha)) {
            System.out.println("Tennte novamente ");
            testSenha(senha, scanner.nextLine());
        }
        return true;
    }
    public Vertice cadastrarConta() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner sc = new Scanner(System.in);
        String[] arrayInteresse = {"FUTEBOL", "COMPUTAÇÃO", "MODA"};
        System.out.println("Qual seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite uma senha:");
        String senha = sc.nextLine();
        System.out.println("Confirme sua senha");
        String confirmeSenha = sc.nextLine();
        testSenha(senha,confirmeSenha);
        System.out.println("Digite Algum interesse seu:");
        System.out.println("-Digite um interesse seu dentre\n1-FUTEBOL\n2-COMPUTAÇÃO\n3-MODA");
        int escolha = sc.nextInt();
        if (escolha >= 1 && escolha <= arrayInteresse.length) {
            Pessoa pessoa = new Pessoa(nome, senha, arrayInteresse[escolha - 1]);
            Vertice vertice = new Vertice(pessoa);
            pessoaDAO.serializarPessoa(vertice);
            grafoDAO.adicionarNografo(vertice);
            return vertice;
        }
        return null;
    }
    public Vertice construirPesssoa(String nome) {
        Scanner sc = new Scanner(System.in);
        Vertice pessoa = pessoaDAO.acharPorNome(nome);
        System.out.println("Digite sua senha");
        String senha = sc.nextLine();
        if (testSenha(pessoa.getPessoa().getSenha(), senha)) {
            System.out.println("Login feito com sucesso");
            return pessoa;
        }
        return null;
    }
    public Vertice logarEmContaExistente() {
        System.out.println("Digite seu nome");
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        if (!pessoaDAO.contemNoGrafo(nome)) {
            do {
                System.out.println("Pessoa não encontrada");
                nome = sc.nextLine();
            } while (!pessoaDAO.contemNoGrafo(nome));
        }
        return construirPesssoa(nome);
    }
    public Vertice telaLogin() {
        Scanner sc = new Scanner(System.in);
        PessoaDAO pessoaDAO = new PessoaDAO();
        System.out.println("Já possui conta? Respoda S/N");
        String possuiConta = sc.nextLine();
        if (possuiConta.equalsIgnoreCase("S")) {
            return logarEmContaExistente();
        } else if (possuiConta.equalsIgnoreCase("N")) {
            return cadastrarConta();
        } else {
            System.out.println("Caracter inválido, tente novamente");
            return telaLogin();
        }
    }
}

