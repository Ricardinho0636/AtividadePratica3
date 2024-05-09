import java.util.List;

public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private List<String> tecnologias;

    public Desenvolvedor(String nome, String matricula, List<String> tecnologias) {
        super(nome, matricula);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario() {
        return 3000.0;
    }

    @Override
    public void trabalhar() {
        System.out.println("O desenvolvedor " + getNome() + " está codificando.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("O desenvolvedor " + getNome() + " está reportando o progresso do trabalho.");
    }
}

