import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar Funcionário");
            System.out.println("2 - Remover Funcionário");
            System.out.println("3 - Listar Funcionários");
            System.out.println("4 - Buscar Funcionário por Nome ou Matrícula");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    buscarFuncionario();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void adicionarFuncionario() {
        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();
        System.out.println("Digite a matrícula do funcionário:");
        String matricula = scanner.nextLine();

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Desenvolvedor");
        System.out.println("3 - Estagiário");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (tipo) {
            case 1:
                System.out.println("Digite o bônus anual do gerente:");
                double bonusAnual = scanner.nextDouble();
                funcionarios.add(new Gerente(nome, matricula, bonusAnual));
                break;
            case 2:
                System.out.println("Digite as tecnologias dominadas pelo desenvolvedor (separadas por vírgula):");
                String tecnologiasInput = scanner.nextLine();
                List<String> tecnologias = List(tecnologiasInput.split(","));
                funcionarios.add(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                System.out.println("Digite o número de horas trabalhadas pelo estagiário:");
                int horasTrabalhadas = scanner.nextInt();
                funcionarios.add(new Estagiario(nome, matricula, horasTrabalhadas));
                break;
            default:
                System.out.println("Tipo de funcionário inválido.");
        }

        System.out.println("Funcionário adicionado com sucesso.");
    }

    private static List<String> List(String[] split) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'List'");
    }

    private static void removerFuncionario() {
        System.out.println("Digite a matrícula do funcionário a ser removido:");
        String matricula = scanner.nextLine();

        boolean removido = funcionarios.removeIf(func -> func.getMatricula().equalsIgnoreCase(matricula));
        if (removido) {
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        funcionarios.forEach(func -> System.out.println(func.getNome() + " - " + func.getMatricula()));
    }

    private static void buscarFuncionario() {
        System.out.println("Digite o nome ou matrícula do funcionário a ser buscado:");
        String termoBusca = scanner.nextLine();

        boolean encontrado = false;
        for (Funcionario func : funcionarios) {
            if (func.getNome().equalsIgnoreCase(termoBusca) || func.getMatricula().equalsIgnoreCase(termoBusca)) {
                System.out.println("Funcionário encontrado: " + func.getNome() + " - " + func.getMatricula());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }
}
