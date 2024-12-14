//utilizaçao de ArrayList e List para deixar codigo flexivel//
import java.util.ArrayList;
import java.util.List;

// criando class farmacia utilizando o List para nao precisar de implementaçao especifica //
public class Farmacia {
    private double lucro;
    private List<Medicamento> medicamentos;
    private List<Funcionario> funcionarios;

    // construtor
    public Farmacia(double lucro) {
        this.lucro = 0; // lucro inicial zero
        this.medicamentos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    // criaçao do get e set
    public double getLucro() {
        return lucro;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    //adiciona um medicamento
    public void addMedicamento(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    //adiciona um funcionario
    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    //lista os medicamento disponiveis

    public void listarMedicamentos() {
        System.out.println("Medicamentos disponiveis");
        for (Medicamento medicamento : medicamentos) {
            System.out.println(medicamento);
        }
    }
    //lista os funcionarios disponiveis
    public void listarNomesFuncionarios() {
        System.out.println("Funcionários disponíveis:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }
    }


    //funcionarios e seus respectivos bonus
    public void listarFuncionarios() {
        System.out.println("Funcionarios e seus bonus");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

    }

    //funcao para comprar um medicamento
    public void comprarMedicamento(String nomeMedicamento, String nomeFuncionario, int quantidade) {
        Medicamento medicamentoEncontrado = null;

        //encontra o medicamento pelo nome
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equals(nomeMedicamento)) {
                medicamentoEncontrado = medicamento;
                break;
            }
        }

        //verica se tem estoque do medicamento encontrado
        if (medicamentoEncontrado != null && medicamentoEncontrado.getQuantidadeEmEstoque() >= quantidade) {
          //diminui do estoque
            medicamentoEncontrado.setQuantidadeEmEstoque(medicamentoEncontrado.getQuantidadeEmEstoque() - quantidade);
        //atualiza o lucro
            lucro += medicamentoEncontrado.getPreco() * quantidade;

            //bonus do funcionario
            funcionarios.stream()
                    .filter(func -> func.getNome().equals(nomeFuncionario))
                    .findFirst()
                    .ifPresent(Funcionario::aumentarBonus);

            System.out.println("Medicamento " + nomeMedicamento + " vendido por " + nomeFuncionario + ".");
        } else {
            System.out.println("Estoque insuficiente ou medicamento não encontrado.");
        }
    }

    public void listarFuncionariosComBonus() {
        System.out.println("Funcionários e seus bônus:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - Bônus: " + funcionario.getBonus());
        }
    }

        //limpa os dados da farmacia

        public void limparTudo () {
            lucro = 0;
            for (Funcionario funcionario : funcionarios) {
                funcionario.resetarBonus();
            }

            for (Medicamento medicamento : medicamentos) {
                medicamento.resetarQuantidade();
            }

            System.out.println("Lucros, bonus e medicamentos limpados com sucesso");
        }

    // override para evitar erro de nao corresponder//
    @Override
    public String toString() {
        return "Farmacia{" +
                "lucro=" + lucro +
                ", medicamentos=" + medicamentos +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
