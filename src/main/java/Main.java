import DAO.GrafoDAO;
import DAO.PessoaDAO;
import GRAFO.Grafo;
import GRAFO.Vertice;
import MODEL.Pessoa;

void  run() throws IOException, ClassNotFoundException {
   PessoaDAO dao = new PessoaDAO();
   GrafoDAO grafoDAO = new GrafoDAO();
   Pessoa pessoa = dao.buscarNaLista("Carlos");
   Pessoa p2 = dao.buscarNaLista("Renan");
   Grafo<Pessoa> graph  = grafoDAO.carregarGrafo();
    //Vertice<Pessoa>
   graph.adicionarAresta(pessoa,p2);

}

void main() throws IOException, ClassNotFoundException {
    run();
}



