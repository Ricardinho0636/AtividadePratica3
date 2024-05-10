import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar Funcionário");
            System.out.println("2 - Remover Funcionário");
            System.out.println("3 - Listar Funcionários");
            System.out.println("4 - Buscar Funcionário por Nome ou Matrícula");
            System.out.println("5 - Sair");

            int opcao = Console.lerInt();
            Console.limparBuffer();

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

        Console.fecharScanner();
    }

    private static void adicionarFuncionario() {
        System.out.println("Digite o nome do funcionário:");
        String nome = Console.lerString();
        System.out.println("Digite a matrícula do funcionário:");
        String matricula = Console.lerString();

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Desenvolvedor");
        System.out.println("3 - Estagiário");

        int tipo = Console.lerInt();

        switch (tipo) {
            case 1:
                System.out.println("Digite o bônus anual do gerente:");
                double bonusAnual = Console.lerFloat();
                funcionarios.add(new Gerente(nome, matricula, bonusAnual));
                break;
            case 2:
                System.out.println("Digite as tecnologias dominadas pelo desenvolvedor (separadas por vírgula):");
                String tecnologiasInput = Console.lerString();
                List<String> tecnologias = List.of(tecnologiasInput.split(","));
                funcionarios.add(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                System.out.println("Digite o número de horas trabalhadas pelo estagiário:");
                int horasTrabalhadas = Console.lerInt();
                funcionarios.add(new Estagiario(nome, matricula, horasTrabalhadas));
                break;
            default:
                System.out.println("Tipo de funcionário inválido.");
        }

        System.out.println("Funcionário adicionado com sucesso.");
    }

    private static void removerFuncionario() {
        System.out.println("Digite a matrícula do funcionário a ser removido:");
        String matricula = Console.lerString();

        boolean removido = funcionarios.removeIf(func -> func.getMatricula().equalsIgnoreCase(matricula));
        if (removido) {
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario func : funcionarios) {
                System.out.println(func.getNome() + " - " + func.getMatricula());
            }
        }
    }

    private static void buscarFuncionario() {
        System.out.println("Digite o nome ou matrícula do funcionário a ser buscado:");
        String termoBusca = Console.lerString();

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
