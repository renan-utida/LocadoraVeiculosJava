import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    @Test
    @DisplayName("Cálculo de custo sem desconto")
    void testCalcularCustoSemDesconto() {
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        int dias = 3;

        double resultado = veiculo.calcularCusto(dias);

        assertEquals(300.0, resultado, 0.01);
    }

    @Test
    @DisplayName("Cálculo de custo com desconto")
    void testCalcularCustoComDesconto() {
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        int dias = 10;

        double resultado = veiculo.calcularCusto(dias);

        assertEquals(900.0, resultado, 0.01); // 1000 - 100 (desconto de 10%)
    }

    @Test
    @DisplayName("Cálculo do desconto aplicado")
    void testDescontoAplicado() {
        Veiculo veiculo = new Veiculo("SUV", 200.0);
        int dias = 7;

        double resultado = veiculo.desconto(dias);

        assertEquals(140.0, resultado, 0.01); // 1400 * 10%
    }

    @Test
    @DisplayName("Cálculo da multa por atraso")
    void testCalcularMulta() {
        Veiculo veiculo = new Veiculo("Hatch", 150.0);
        int diasAtraso = 3;

        double resultado = veiculo.calcularMulta(diasAtraso);

        assertEquals(540.0, resultado, 0.01); // 3 * 150 * 1.2
    }

    @Test
    @DisplayName("Custo para zero dias de aluguel")
    void testCustoZeroDias() {
        Veiculo veiculo = new Veiculo("Hatch", 120.0);
        int dias = 0;

        double resultado = veiculo.calcularCusto(dias);

        assertEquals(0.0, resultado, 0.01);
    }

    @Test
    @DisplayName("Exceção para valor de diária negativo")
    void testValorDiariaNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Veiculo("Sedan", -50.0));
    }

    @Test
    @DisplayName("Exceção para número de dias negativos no cálculo de custo")
    void testDiasNegativos() {
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        int dias = -5;

        assertThrows(IllegalArgumentException.class, () -> veiculo.calcularCusto(dias));
    }

    @Test
    @DisplayName("Exceção para número de dias negativos na multa")
    void testDiasAtrasoNegativo() {
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        int diasAtraso = -2;

        assertThrows(IllegalArgumentException.class, () -> veiculo.calcularMulta(diasAtraso));
    }
}
