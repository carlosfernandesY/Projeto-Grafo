package MODEL;



import java.io.Serializable;
import java.util.ArrayList;

public class Grafo implements Serializable {
    private ArrayList<Vertice> vertices;
    private static final long UUID = 3950071269853297411L;
    public  Grafo(){
        this.vertices = new ArrayList<>();
    }
    public void adiconarNaRede(Vertice pessoa){
        vertices.add(pessoa);
    }
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    @Override
    public String toString() {
        return "Grafo{" +
                "vertices=" + vertices +
                '}';
    }
}
