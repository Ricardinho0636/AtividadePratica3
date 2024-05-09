public class Gerente extends Funcionario {
    private double bonusAnual;

    public Gerente(String nome, String matricula, double bonusAnual) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
    }

    @Override
    public double calcularSalario() {
        return 5000.0 + bonusAnual;
    }
}
