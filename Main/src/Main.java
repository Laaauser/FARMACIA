import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // cria os medicamentos da farmacia
        Medicamento medicamento1 = new Medicamento("Puran", 50, 19.99);
        Medicamento medicamento2 = new Medicamento("Dipirona", 40, 9.99);
        Medicamento medicamento3 = new Medicamento("Paracetamol", 100, 7.99);

        // cria os funcionarios da farmacia
        Funcionario funcionario1 = new Funcionario("A");
        Funcionario funcionario2 = new Funcionario("B");
        Funcionario funcionario3 = new Funcionario("C");
        Funcionario funcionario4 = new Funcionario("D");

        // cria a farmacia
        Farmacia farmacia = new Farmacia(0); // Lucro começa no zero


        // adiciona os medicamentos e os funcinarios
        farmacia.addMedicamento(medicamento1);
        farmacia.addMedicamento(medicamento2);
        farmacia.addMedicamento(medicamento3);
        farmacia.addFuncionario(funcionario1);
        farmacia.addFuncionario(funcionario2);
        farmacia.addFuncionario(funcionario3);
        farmacia.addFuncionario(funcionario4);


        // lista os nomes dos funcionarios
        farmacia.listarNomesFuncionarios();

        //pergunta com qual funcionario deseja comprar
        String nomeFuncionario;
        while (true) {
            System.out.print("Digite o nome do funcionário que fará a venda: ");
            nomeFuncionario = scanner.nextLine();

            // verifica se existe o funcionario
            if (nomeFuncionario.equals("A") || nomeFuncionario.equals("B") ||
                    nomeFuncionario.equals("C") || nomeFuncionario.equals("D")) {
                break;
            } else {
                System.out.println("Funcionário inválido, digite novamente.");
            }
        }

        // loop para realizar as compras
        while (true) {
            // mostra os medicamentos disponiveis e as quantidade disponiveis
            System.out.println("\nMedicamentos disponíveis:");
            for (Medicamento medicamento : farmacia.getMedicamentos()) {
                System.out.println(medicamento.getNome() + " - Estoque: " + medicamento.getQuantidadeEmEstoque() + " - Preco: R$ " + medicamento.getPreco());
            }

            // pergunta qual medicamento e quantidade deseja
            System.out.print("Digite o nome do medicamento: ");
            String nomeMedicamento = scanner.nextLine();

            // verifica se existe o medicamento
            Medicamento medicamentoEncontrado = null;
            for (Medicamento medicamento : farmacia.getMedicamentos()) {
                if (medicamento.getNome().equalsIgnoreCase(nomeMedicamento)) {
                    medicamentoEncontrado = medicamento;
                    break;
                }
            }
            //se nao existir o medicamento
            if (medicamentoEncontrado == null) {
                System.out.println("Medicamento inválido, digite novamente.");
                continue; // Retorna para o início do loop
            }

            // pergunta a quantidade que deseja
            int quantidade;
            while (true) {
                System.out.print("Digite a quantidade: ");
                quantidade = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                // verifica a quantidade em estoque
                if (quantidade <= medicamentoEncontrado.getQuantidadeEmEstoque()) {
                    break; // Quantidade válida
                } else {
                    System.out.println("Quantidade insuficiente, digite novamente.");
                }
            }

            // finaliza a compra
            farmacia.comprarMedicamento(nomeMedicamento, nomeFuncionario, quantidade);
            System.out.println("Compra realizada");

            // pergunta se deseja comprar mais
            System.out.print("Deseja comprar mais medicamentos? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break; // Sai do loop
            }
        }
        //vizualizcao dos dados da farmacia
        System.out.print("Você deseja vizualizar os dados? (s/n): ");
        String verDados = scanner.nextLine();
        if (verDados.equalsIgnoreCase("s")) {
            System.out.printf("Lucro total da farmácia: R$ %.2f%n", farmacia.getLucro());

            //mostrar medicamentos
            System.out.println("Medicamentos disponíveis:");
            System.out.printf("%-20s %-15s %-10s%n", "Nome", "Quantidade", "Preço");
            System.out.println("----------------------------------------------------");
            for (Medicamento medicamento : farmacia.getMedicamentos()) {
                System.out.printf("%-20s %-15d %-10.2f%n",
                        medicamento.getNome(),
                        medicamento.getQuantidadeEmEstoque(),
                        medicamento.getPreco());
            }


        //mostrar funcionarios e bonus
            System.out.println("\nFuncionários e seus bônus:");
            System.out.printf("%-10s %-10s %-15s %-15s%n", "Nome", "Bônus", "Salário Base", "Salário Total");
            System.out.println("----------------------------------------------------");
            for (Funcionario funcionario : farmacia.getFuncionarios()) {
                System.out.printf("%-10s %-10d %-15.2f %-15.2f%n",
                        funcionario.getNome(),
                        funcionario.getBonus(),
                        funcionario.getSalarioBase(),
                        funcionario.calcularSalarioTotal());
            }
        }


        //status final

        System.out.print("Você deseja limpar os dados? (s/n): ");
        String limpar = scanner.nextLine();
        if (limpar.equalsIgnoreCase("s")) {
            farmacia.limparTudo();
            System.out.println("Dados limpos.");
            System.out.println("Medicamentos disponíveis após limpeza:");
            System.out.printf("%-20s %-15s %-10s%n", "Nome", "Quantidade", "Preço");
            System.out.println("----------------------------------------------------");
            for (Medicamento medicamento : farmacia.getMedicamentos()) {
                System.out.printf("%-20s %-15d %-10.2f%n",
                        medicamento.getNome(),
                        medicamento.getQuantidadeEmEstoque(),
                        medicamento.getPreco());
            }


            //mostrar funcionarios e bonus
            System.out.println("\nFuncionários e seus bônus após limpeza:");
            System.out.printf("%-10s %-10s %-15s %-15s%n", "Nome", "Bônus", "Salário Base", "Salário Total");
            System.out.println("----------------------------------------------------");
            for (Funcionario funcionario : farmacia.getFuncionarios()) {
                System.out.printf("%-10s %-10d %-15.2f %-15.2f%n",
                        funcionario.getNome(),
                        funcionario.getBonus(),
                        funcionario.getSalarioBase(),
                        funcionario.calcularSalarioTotal());
            }
        }

        //acaba o scanner
        scanner.close();
    }
}

