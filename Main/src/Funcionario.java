// criando class funcionario //
public class Funcionario {
    private String nome;
    private int bonus; // bonus em pontos
    private double salarioBase;

    // construtor
    public Funcionario(String nome) {
        this.nome = nome;
        this.bonus = 0; // bonus iniciando com 0
        this.salarioBase = 1700; // salario base inicial
    }

    // criaçao do get e set
    public String getNome() {
        return nome;
    }

    public int getBonus() {
        return bonus;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void aumentarBonus() {
        bonus += 10;
        }

    public void resetarBonus() {
        bonus = 0;
    }
        //calculo do salario base com o bonus
        public double calcularSalarioTotal() {
            // A cada 30 pontos de bônus, o salário total aumenta em R$100
            double bonusIncremento = (bonus / 30) * 100;
            return salarioBase + bonusIncremento;
        }


    // override para evitar erro de nao corresponder//
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", bonus=" + bonus +
                ", salarioBase=" + salarioBase +
                ", salarioTotal=" + calcularSalarioTotal() +
                '}';
    }
}

