public class Estagiario extends Funcionario implements Trabalhavel {
    private int horasTrabalhadas;

    public Estagiario(String nome, String matricula, int horasTrabalhadas) {
        super(nome, matricula);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * 10.0;
    }

    @Override
    public void trabalhar() {
        System.out.println("O estagiário " + getNome() + " está aprendendo e contribuindo.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("O estagiário " + getNome() + " está relatando seu progresso.");
    }
}
