import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        try {
            // Entrada do usuário para o modelo do veículo (não pode ser vazio)
            String modelo;
            while (true) {
                System.out.print("Digite o modelo do veículo: ");
                modelo = scanner.nextLine().trim();
                if (!modelo.isEmpty()) {
                    break;
                }
                System.out.println("Erro: O modelo do veículo não pode estar em branco.\n");
            }

            // Entrada para o valor da diária (deve ser um número positivo)
            double valorDiaria;
            while (true) {
                try {
                    System.out.print("Digite o valor da diária: ");
                    valorDiaria = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
                    if (valorDiaria <= 0) throw new IllegalArgumentException();
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: O valor da diária deve ser um número positivo.\n");
                }
            }

            // Criar objeto Veiculo
            Veiculo veiculo = new Veiculo(modelo, valorDiaria);

            // Entrada para a quantidade de dias alugados (deve ser um número positivo)
            int dias;
            while (true) {
                try {
                    System.out.print("Digite a quantidade de dias alugados: ");
                    dias = Integer.parseInt(scanner.nextLine().trim());
                    if (dias <= 0) throw new IllegalArgumentException();
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: O número de dias deve ser um número inteiro positivo.\n");
                }
            }

            // Cálculo de custo e desconto
            double custoInicial = dias * valorDiaria;
            double desconto = veiculo.desconto(dias);
            double custoComDesconto = veiculo.calcularCusto(dias);

            // Perguntar sobre multa por atraso (só aceita "sim" ou "não")
            int diasAtraso = 0;
            double multa = 0;
            while (true) {
                System.out.print("Houve atraso na devolução? (Sim/Não): ");
                String resposta = scanner.nextLine().trim().toLowerCase();
                if (resposta.equals("sim") || resposta.equals("não") || resposta.equals("nao")) {
                    if (resposta.equals("sim")) {
                        while (true) {
                            try {
                                System.out.print("Digite a quantidade de dias de atraso: ");
                                diasAtraso = Integer.parseInt(scanner.nextLine().trim());
                                if (diasAtraso < 0) throw new IllegalArgumentException();
                                multa = veiculo.calcularMulta(diasAtraso);
                                break;
                            } catch (Exception e) {
                                System.out.println("Erro: O número de dias de atraso deve ser um numero inteiro positivo.\n");
                            }
                        }
                    }
                    break;
                }
                System.out.println("Erro: Responda apenas com 'Sim' ou 'Não'.\n");
            }

            // Cálculo do valor final
            double valorFinal = custoComDesconto + multa;

            // Exibir resumo final
            System.out.println("\n---------- RESUMO DO ALUGUEL ----------");
            System.out.println(veiculo);
            System.out.println("Custo inicial para " + dias + " dias: R$ " + df.format(custoInicial));
            System.out.println("Desconto aplicado: R$ " + df.format(desconto));
            System.out.println("Multa por " + diasAtraso + " dias de atraso na devolução: R$ " + df.format(multa));
            System.out.println("Valor Final a ser pago: R$ " + df.format(valorFinal));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado. Tente novamente.\n");
        } finally {
            scanner.close();
        }
    }
}