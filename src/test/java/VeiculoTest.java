import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    @Test
    @DisplayName("Teste do construtor com valores válidos")
    public void testConstrutorValoresValidos() {
        // Arrange
        String modelo = "Sedan";
        double valorDiaria = 100.0;

        // Act
        Veiculo veiculo = new Veiculo(modelo, valorDiaria);

        // Assert
        assertEquals(modelo, veiculo.getModelo());
        assertEquals(valorDiaria, veiculo.getValorDiaria(), 0.001);
    }

    @Test
    @DisplayName("Exceção para Teste do construtor com valor de diária negativo")
    public void testConstrutorValorDiariaNegativo() {
        // Arrange
        String modelo = "Sedan";
        double valorDiaria = -100.0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Veiculo(modelo, valorDiaria);
        });
    }

    @Test
    @DisplayName("Exceção para valor de diária negativo")
    void testValorDiariaNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Veiculo("Sedan", -50.0));
    }

    @Test
    @DisplayName("Cálculo de custo sem desconto (5 dias) - Teste calcularCusto")
    public void testCalcularCustoSemDesconto() {
        // Arrange
        Veiculo veiculo = new Veiculo("Hatch", 50.0);
        int dias = 5;
        double expected = 250.0; // 5 * 50

        // Act
        double resultado = veiculo.calcularCusto(dias);

        // Assert
        assertEquals(expected, resultado, 0.001);
    }

    @Test
    @DisplayName("Cálculo de custo com desconto (7 dias) - Teste calcularCusto")
    public void testCalcularCustoComDesconto() {
        // Arrange
        Veiculo veiculo = new Veiculo("SUV", 100.0);
        int dias = 7;
        double expected = 630.0; // (7 * 100) - (7 * 100 * 0.1)

        // Act
        double resultado = veiculo.calcularCusto(dias);

        // Assert
        assertEquals(expected, resultado, 0.001);
    }

    @Test
    @DisplayName("Exceção para cálculo de custo para 0 dias - Teste calcularCusto")
    public void testCalcularCustoZeroDias() {
        // Arrange
        Veiculo veiculo = new Veiculo("Pickup", 80.0);
        int dias = 0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularCusto(dias);
        });
    }

    @Test
    @DisplayName("Exceção para número de dias negativos no cálculo de custo - Teste calcularCusto")
    void testDiasNegativos() {
        // Arrange
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        int dias = -5;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularCusto(dias);
        });
    }

    @Test
    @DisplayName("Cálculo do desconto aplicado 3 dias (sem desconto) - Teste desconto")
    public void testDescontoMenosDe7Dias() {
        // Arrange
        Veiculo veiculo = new Veiculo("Esportivo", 150.0);
        int dias = 3;
        double expected = 0.0;

        // Act
        double resultado = veiculo.desconto(dias);

        // Assert
        assertEquals(expected, resultado, 0.001);
    }

    @Test
    @DisplayName("Cálculo do desconto aplicado 7 dias (com desconto) - Teste desconto")
    public void testDesconto7Dias() {
        // Arrange
        Veiculo veiculo = new Veiculo("Minivan", 120.0);
        int dias = 7;
        double expected = 84.0; // (7 * 120) * 0.1

        // Act
        double resultado = veiculo.desconto(dias);

        // Assert
        assertEquals(expected, resultado, 0.001);
    }

    @Test
    @DisplayName("Cálculo do desconto aplicado 10 dias (com desconto) - Teste desconto")
    public void testDesconto10Dias() {
        // Arrange
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        int dias = 10;
        double expected = 100.0; // (10 * 100) * 0.1

        // Act
        double resultado = veiculo.desconto(dias);

        // Assert
        assertEquals(expected, resultado, 0.001);
    }

    @Test
    @DisplayName("Cálculo da multa por atraso (3 dias) - Teste calcularMulta")
    public void testCalcularMulta() {
        // Arrange
        Veiculo veiculo = new Veiculo("SUV", 100.0);
        int diasAtraso = 3;
        double expected = 360.0; // 3 * 100 * 1.2

        // Act
        double resultado = veiculo.calcularMulta(diasAtraso);

        // Assert
        assertEquals(expected, resultado, 0.001);
    }

    @Test
    @DisplayName("Teste calcularMulta para 0 dias de atraso")
    public void testCalcularMultaZeroDias() {
        // Arrange
        Veiculo veiculo = new Veiculo("Hatch", 50.0);
        int diasAtraso = 0;
        double expected = 0.0;

        // Act
        double resultado = veiculo.calcularMulta(diasAtraso);

        // Assert
        assertEquals(expected, resultado, 0.001);
    }

    @Test
    @DisplayName("Teste calcularMulta para dias negativos - deve lançar exceção")
    public void testDiasAtrasoNegativo() {
        // Arrange
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        int diasAtraso = -2;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            veiculo.calcularMulta(diasAtraso);
        });
    }

    @Test
    @DisplayName("Teste do método toString")
    public void testToString() {
        // Arrange
        Veiculo veiculo = new Veiculo("Sedan", 100.0);
        String expected = "Modelo: Sedan | Valor da Diária: R$ 100,00";

        // Act
        String resultado = veiculo.toString();

        // Assert
        assertEquals(expected, resultado);
    }
}
