public class Clientes {

    private int matricula;
    private String nome;
    private boolean devedor;
    private double quantDevida;
    private String atividade;

    public Clientes() {
        this.matricula = matricula;
        this.nome = nome;
        this.devedor = devedor;
        this.quantDevida = quantDevida;
        this.atividade = atividade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getDevedor() {
        if (!devedor) {
            setQuantDevida(0.0);
        }
        return devedor;
    }

    public void setDevedor(boolean devedor) {
        this.devedor = devedor;
    }

    public double getQuantDevida() {
        return quantDevida;
    }

    public void setQuantDevida(double quantDevida) {
        this.quantDevida = quantDevida;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }
}
