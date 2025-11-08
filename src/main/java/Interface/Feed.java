package Interface;

import DAO.GrafoDAO;
import DAO.PessoaDAO;
import MODEL.Grafo;
import MODEL.Vertice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feed {
    GrafoDAO grafoDAO = new GrafoDAO();
    PessoaDAO pessoaDAO = new PessoaDAO();
    Vertice vertice;
    public Feed(Vertice vertice) {
        this.vertice = vertice;
       amizadesSugeridas();
    }
    public void menuFeed() {
        Scanner scanner = new Scanner(System.in);
        if (vertice.getPessoa() != null) {
            System.out.println("Escolha alguma opção\n1-Listar possiveis amizades\n2-Mandar mensagem para algum amigo\n3-Listar suas amizades\n4-Sair");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    listarPossiveisAmizades();
                    System.out.println("Deseja adicionar alguém S/n");
                    String esc = scanner1.nextLine();
                    if (esc.equalsIgnoreCase("s")) {
                        System.out.println("Digite o nome da pessoa");
                        String nomePessoa = scanner1.nextLine();
                        if (adicionarPorNome(nomePessoa)) {
                            System.out.println("Adicionado com sucesso");
                        } else {
                            System.out.println("Algo deu errado");
                        }
                    }
                    menuFeed();
                    break;
                case 2:
                    mandarMensagem();
                    menuFeed();
                    break;
                case 3:
                    listarSuasAmizades();
                    menuFeed();
                case 4:
                    return;
            }
        }
    }
    public void mandarMensagem() {
    }
    public void listarPossiveisAmizades() {
        if (this.vertice == null) {
            System.out.println("Nenhum usuário logado");
        }

        Grafo grafo = grafoDAO.carrregarGrafo();
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            if (!this.vertice.getPessoa().getName().equals(grafo.getVertices().get(i).getPessoa().getName())) {
                if (this.vertice.getPessoa().getInteresse().equals(grafo.getVertices().get(i).getPessoa().getInteresse())) {
                    System.out.println(grafo.getVertices().get(i).getPessoa().getName());
                }
            }
        }
    }
    public void atualizarVertice(Vertice v) {
        for (int i = 0; i < v.getAmizades().size(); i++) {
            if (v.getAmizades().get(i).equals(v)) {
                v.getAmizades().set(i, v);
                return;
            }
        }
    }
    public boolean adicionarPorNome(String nome) {
        try {
            Grafo grafo = grafoDAO.carrregarGrafo();
            Vertice pessoa = grafoDAO.acharPorNome(nome, grafo);
            if (pessoa != null && !this.vertice.getAmizades().contains(pessoa)) {
                this.vertice.adiconarPessoa(pessoa);
            }
            else{
                System.out.println("Essa pessoa já estar adicionada");
            }
            for (int i = 0; i < grafo.getVertices().size(); i++) {
                if (grafo.getVertices().get(i).equals(this.vertice)) {
                    grafo.getVertices().set(i, this.vertice);
                    break;
                }
            }
            grafoDAO.salvarGrafo(grafo);
            pessoaDAO.salvarPessoa(this.vertice);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    public void listarSuasAmizades() {
        System.out.println("Você já é amigo de: ");
        for (Vertice verticePercorrer : this.vertice.getAmizades()) {
            System.out.println(verticePercorrer.getPessoa().getName());
        }
    }
    public List<Vertice> amizadesSugeridas(){
        List<Vertice> pessoaRecomendadas = new ArrayList<>();
        for (int i = 0; i < vertice.getAmizades().size(); i++) {
            System.out.println(vertice.getPessoa().getName());

        }
        return null;
    }

}
