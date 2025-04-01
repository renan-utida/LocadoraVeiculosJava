import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Veiculo> veiculos = new ArrayList<>();
        List<Integer> diasAlugados = new ArrayList<>();
        List<Integer> diasAtraso = new ArrayList<>();

        // Perguntar quantos carros deseja cadastrar
        System.out.print("Quantos veículos deseja cadastrar? ");
        int quantidadeVeiculos = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        // Capturar dados dos veículos
        for (int i = 0; i < quantidadeVeiculos; i++) {
            System.out.println("\nCadastro do veículo " + (i + 1) + ":");

            System.out.print("Digite o modelo do veículo: ");
            String modelo = scanner.nextLine();

            System.out.print("Digite o valor da diária: ");
            double valorDiaria = scanner.nextDouble();

            System.out.print("Digite a quantidade de dias alugados: ");
            int dias = scanner.nextInt();

            System.out.print("Houve atraso na devolução? (Sim/Não): ");
            scanner.nextLine(); // Consumir quebra de linha
            String resposta = scanner.nextLine().trim().toLowerCase();
            int atraso = 0;
            if (resposta.equals("sim")) {
                System.out.print("Digite a quantidade de dias de atraso: ");
                atraso = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha
            }

            // Criar e armazenar o veículo
            Veiculo veiculo = new Veiculo(modelo, valorDiaria);
            veiculos.add(veiculo);
            diasAlugados.add(dias);
            diasAtraso.add(atraso);
        }

        // Exibir os dados de todos os veículos cadastrados
        System.out.println("\n---------------- RELATÓRIO DE VEÍCULOS ----------------");

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo v = veiculos.get(i);
            int dias = diasAlugados.get(i);
            int atraso = diasAtraso.get(i);

            double custoInicial = v.calcularCusto(dias) + v.desconto(dias);
            double desconto = v.desconto(dias);
            double multa = v.calcularMulta(atraso);
            double valorFinal = custoInicial - desconto + multa;

            System.out.println("\n" + v);
            System.out.printf("Custo inicial para %d dias: R$ %.2f%n", dias, custoInicial);
            System.out.printf("Desconto aplicado: R$ %.2f%n", desconto);
            System.out.printf("Multa por %d dias de atraso: R$ %.2f%n", atraso, multa);
            System.out.printf("Valor Final a ser pago: R$ %.2f%n", valorFinal);
        }

        scanner.close();
    }
}
