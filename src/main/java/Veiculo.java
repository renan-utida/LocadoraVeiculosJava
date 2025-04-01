public class Veiculo {
    private String modelo;
    private double valorDiaria;

    // Construtor
    public Veiculo(String modelo, double valorDiaria){
        if (valorDiaria < 0){
            throw new IllegalArgumentException("O valor da diária não pode ser negativo.");
        }
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    // Metodo para calcular o custo total do aluguel
    public double calcularCusto(int dias){
        if (dias < 0) {
            throw new IllegalArgumentException("O número de dias não pode ser negativo")
        }
        double custoTotal = dias * valorDiaria
        return custoTotal - desconto(dias);
    }

    public double desconto(int dias){
        if (dias >= 7){
            return (dias * valorDiaria) * 0.1; // Desconto de 10% do valor total
        }
        return 0;
    }
}
