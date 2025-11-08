package MODEL;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Vertice implements Serializable {
    private Pessoa pessoa;
    private ArrayList<Vertice> amizades;
    @Serial
    private static final long serialVersionUID = -8721785082523355329L;

    public Vertice(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.amizades = new ArrayList<Vertice>();
        // this.amizades.add(this);
    }

    public Vertice() {
        this.amizades = new ArrayList<Vertice>();
    }

    public void adiconarPessoa(Vertice pessoa) {
        this.amizades.add(pessoa);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<Vertice> getAmizades() {
        return amizades;
    }

    public void setAmizades(ArrayList<Vertice> amizades) {
        this.amizades = amizades;
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "pessoa=" + pessoa + "Nome\n" + pessoa.getName() + "\n" +
                ", amizades=" + amizades +
                '}';
    }
}
