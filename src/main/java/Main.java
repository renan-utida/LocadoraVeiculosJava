import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.print("Quantos veículos deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCadastro do veículo " + (i + 1) + ":");

            System.out.print("Digite o modelo do veículo: ");
            String modelo = scanner.nextLine();

            System.out.print("Digite o valor da diária: ");
            double valorDiaria = scanner.nextDouble();

            System.out.print("Quantos dias o veículo foi alugado? ");
            int diasAlugados = scanner.nextInt();

            System.out.print("Houve atraso na devolução? (Sim/Não): ");
            scanner.nextLine(); // Consumir quebra de linha
            String resposta = scanner.nextLine();

            int diasAtraso = 0;
            if (resposta.equalsIgnoreCase("Sim")) {
                System.out.print("Quantos dias de atraso? ");
                diasAtraso = scanner.nextInt();
            }

            Veiculo veiculo = new Veiculo(modelo, valorDiaria);
            double custoInicial = diasAlugados * valorDiaria;
            double desconto = veiculo.desconto(diasAlugados);
            double multa = veiculo.calcularMulta(diasAtraso);
            double valorFinal = custoInicial - desconto + multa;

            // Exibir os resultados
            System.out.println("\n" + veiculo);
            System.out.println("Custo inicial para " + diasAlugados + " dias: R$ " + df.format(custoInicial));
            System.out.println("Desconto aplicado: R$ " + df.format(desconto));
            System.out.println("Multa por " + diasAtraso + " dias de atraso: R$ " + df.format(multa));
            System.out.println("Valor Final a ser pago: R$ " + df.format(valorFinal) + "\n");
        }

        scanner.close();
    }
}

