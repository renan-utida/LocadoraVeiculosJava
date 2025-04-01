import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        List<Veiculo> veiculos = new ArrayList<>();
        List<Integer> diasAlugados = new ArrayList<>();
        List<Integer> diasAtraso = new ArrayList<>();

        int quantidadeVeiculos = 0;

        // Garantir que o usuário digite um número válido para a quantidade de veículos
        while (true) {
            try {
                System.out.print("Quantos veículos deseja cadastrar? ");
                quantidadeVeiculos = Integer.parseInt(scanner.nextLine());
                if (quantidadeVeiculos <= 0) {
                    System.out.println("Erro: O número deve ser maior que zero.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido.");
            }
        }

        // Capturar dados dos veículos
        for (int i = 0; i < quantidadeVeiculos; i++) {
            System.out.println("\nCadastro do veículo " + (i + 1) + ":");

            String modelo;
            while (true) {
                System.out.print("Digite o modelo do veículo: ");
                modelo = scanner.nextLine().trim();
                if (!modelo.isEmpty()) break;
                System.out.println("Erro: O modelo do veículo não pode estar vazio.");
            }

            double valorDiaria;
            while (true) {
                try {
                    System.out.print("Digite o valor da diária: ");
                    valorDiaria = Double.parseDouble(scanner.nextLine());
                    if (valorDiaria < 0) {
                        System.out.println("Erro: O valor da diária não pode ser negativo.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um valor numérico válido para a diária.");
                }
            }

            int dias;
            while (true) {
                try {
                    System.out.print("Digite a quantidade de dias alugados: ");
                    dias = Integer.parseInt(scanner.nextLine());
                    if (dias < 0) {
                        System.out.println("Erro: O número de dias não pode ser negativo.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um número inteiro válido.");
                }
            }

            int atraso = 0;
            while (true) {
                System.out.print("Houve atraso na devolução? (Sim/Não): ");
                String resposta = scanner.nextLine().trim().toLowerCase();
                if (resposta.equals("sim")) {
                    while (true) {
                        try {
                            System.out.print("Digite a quantidade de dias de atraso: ");
                            atraso = Integer.parseInt(scanner.nextLine());
                            if (atraso < 0) {
                                System.out.println("Erro: O número de dias de atraso não pode ser negativo.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: Digite um número inteiro válido para os dias de atraso.");
                        }
                    }
                    break;
                } else if (resposta.equals("não") || resposta.equals("nao")) {
                    atraso = 0;
                    break;
                } else {
                    System.out.println("Erro: Digite 'Sim' ou 'Não'.");
                }
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
            System.out.printf("\nCusto inicial para %d dias: R$ %s%n", dias, df.format(custoInicial));
            System.out.printf("Desconto aplicado: R$ %s%n", df.format(desconto));
            System.out.printf("Multa por %d dias de atraso: R$ %s%n", atraso, df.format(multa));
            System.out.printf("\nValor Final a ser pago: R$ %s%n", df.format(valorFinal) + "\n");
            System.out.println("------------------------------------------");
        }

        scanner.close();
    }
}
