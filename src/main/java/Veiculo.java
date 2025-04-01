public class Veiculo {
    private String modelo;
    private double valorDiaria;

    public double calcularCusto(int dias){
        return dias * valorDiaria;
    }

    public double aplicarDesconto(int dias){
        return valorDiaria * 0.9; // Desconto de 10% do valor total
    }
}
