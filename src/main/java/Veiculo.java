import java.text.DecimalFormat;

public class Veiculo {
    private String modelo;
    private double valorDiaria;

    // Construtor
    public Veiculo(String modelo, double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException("O valor da diária deve ser positivo.");
        }
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    // Getters
    public String getModelo() {
        return modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    // Metodo para calcular o custo total do aluguel
    public double calcularCusto(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("O número de dias deve ser positivo.");
        }
        double custoTotal = dias * valorDiaria;
        return custoTotal - desconto(dias);
    }

    // Metodo para aplicar desconto
    public double desconto(int dias) {
        if (dias >= 7) {
            return (dias * valorDiaria) * 0.1; // Desconto de 10% do valor total
        }
        return 0;
    }

    // Metodo para calcular multa por devolução atrasada
    public double calcularMulta(int diasAtraso) {
        if (diasAtraso < 0) {
            throw new IllegalArgumentException("O número de dias de atraso não pode ser negativo.");
        }
        return diasAtraso * valorDiaria * 1.20; // Valor da diária + 20% de multa
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "Modelo: " + modelo + " | Valor da Diária: R$ " + df.format(valorDiaria).replace(".", ",");
    }
}

