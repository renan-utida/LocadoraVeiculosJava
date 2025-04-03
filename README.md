# Sistema de Locadora de Veículos - Aplicando conceitos do CP1

Este projeto implementa um sistema básico para uma locadora de veículos, implementando em Java. O objetivo é aplicar conceitos fundamentais de Programação Orientada a Objetos (POO), como classes, métodos e tratamento de exceções, além de realizar práticas de testes unitários com JUnit.

---

## 📋 Descrição do Projeto
O sistema permite gerenciar o aluguel de veículos, calculando custos baseados no período de aluguel, aplicando descontos para aluguéis de longa duração e calculando multas por atrasos na devolução. A implementação segue os requisitos estabelecidos na criação de testes unitários em Java (Checkpoint 1).

## 🚗 Funcionalidades
- **Cadastro de Veículos:** Possibilidade de cadastrar um veículo informando o modelo e o valor da diária.
- **Cálculo do Custo Total do Aluguel:** Com base na quantidade de dias de locação, o sistema calcula o valor total do aluguel.
- **Descontos:** Se o período de aluguel for igual ou superior a 7 dias, aplica-se automaticamente um desconto de 10%.
- **Cálculo de Multa por Atraso:** Se houver atraso na devolução do veículo, é cobrada uma multa de 20% sobre o valor da diária para cada dia de atraso (valor da diária + 20%).
- **Validações:** Para garantir entradas corretas, o sistema impede que valores inválidos sejam inseridos, como modelo vazio, diária negativa ou dias de aluguel negativos.
- **Testes Unitários:** Implementação de testes utilizando JUnit para garantir o funcionamento correto do sistema.
- Interface de linha de comando para interação com o usuário.

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 18
- **Ferramenta de Teste:** JUnit 5 (JUnit 5.9.2 - testes unitários)
- **Gerenciamento de Dependências:** Maven
- **Ambiente de Desenvolvimento:** IntelliJ IDEA / Eclipse / VS Code (qualquer IDE compatível com Java)

---

## 📦 Estrutura do Projeto
O projeto é composto por duas classes principais e uma de teste:

**Veiculo.java**: Classe principal que representa um veículo da locadora
**Main.java**: Classe com o método principal que implementa a interface de linha de comando
**VeiculoTest.java**: Classe de testes unitários para validar o funcionamento da classe Veiculo

```
/locadora-veiculos-558540
│── src
│   ├── main 
│       └── java
│           ├── Main.java # Classe principal do sistema
│           └── Veiculo.java # Classe que representa um veículo
│   └── test 
│       └── java
│           └── VeiculoTest.java  # Testes unitários para a classe Veiculo
│── README.md  # Documentação do projeto
│── .gitignore  # Arquivos ignorados pelo Git
```

## 🔧 Como Executar o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/locadora-veiculo-558540.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd locadora-veiculo-558540
   ```
3. Compile o projeto:
   ```sh
   javac src/*.java
   ```
4. Execute a aplicação:
   ```sh
   java src.Main
   ```

## 🔧 Como Executar os Testes
Certifique-se de que o JUnit 5 está configurado em seu ambiente de desenvolvimento. E em seguida, dentro da classe de teste (VeiculoTest.java), basta clicarmos no ícone de play ao lado do método ou da classe de teste.

---

## 📊 Testes Implementados
Foram implementados vários cenários de teste para garantir o correto funcionamento do sistema:

1. Teste do construtor:
   - Verificação de valores válidos
   - Tratamento de exceção para valores de diária negativos
2. Teste do cálculo de custo:
   - Cenário sem desconto (menos de 7 dias)
   - Cenário com desconto (7 dias ou mais)
   - Tratamento de exceção para 0 dias ou dias negativos
3. Teste do cálculo de desconto:
   - Verificação de não aplicação de desconto (menos de 7 dias)
   - Verificação de aplicação de desconto (10 dias)
4. Teste do cálculo de multa:
   - Verificação de multa para 3 dias de atraso
   - Verificação para 0 dias de atraso
   - Tratamento de exceção para dias de atraso negativos
5. Teste do método toString

---

## 🚀 Exemplo de Uso
Exemplo de uso do sistema via linha de comando:
1. Execute o programa
2. Informe o modelo do veículo (ex: "Sedan")
3. Informe o valor da diária (ex: 100.00)
4. Informe a quantidade de dias alugados (ex: 7)
5. Informe se houve atraso na devolução
6. Se sim, informe a quantidade de dias de atraso

O sistema calculará automaticamente:
- O custo total do aluguel
- Desconto aplicado (se houver)
- Multa por atraso (se houver)
- Valor final a ser pago

Segue abaixo um exemplo demonstrativo de como ficaria: 

```sh
Digite o modelo do veículo: Sedan
Digite o valor da diária: 100
Digite a quantidade de dias alugados: 7
Houve atraso na devolução? (Sim/Não): Não

---------- RESUMO DO ALUGUEL ----------
Modelo: Sedan | Valor da Diária: R$ 100,00
Custo inicial para 7 dias: R$ 700,00
Desconto aplicado: R$ 70,00
Multa por 0 dias de atraso: R$ 0,00
Valor Final a ser pago: R$ 630,00
```

Exemplo de uso da classe Veiculo em código (Main.java):

```java
// Criar um novo veículo
Veiculo carro = new Veiculo("Sedan", 100.0);

// Calcular custo para 10 dias (com desconto de 10%)
double custo = carro.calcularCusto(10);  // Retorna 900.0 (1000 - 100)

// Calcular multa para 2 dias de atraso
double multa = carro.calcularMulta(2);   // Retorna 240.0 (2 * 100 * 1.2)

// Valor final
double valorFinal = custo + multa;       // 1140.0
```
---

## ✅ Requisitos Atendidos
- Implementação da classe Veiculo com atributos modelo e valorDiaria
- Método calcularCusto para cálculo do aluguel baseado nos dias
- Método desconto para aplicação de desconto em aluguéis longos (Maiores ou iguais a 7 dias)
- Método calcularMulta para cálculo de multa por atraso na devolução
- Interface de linha de comando para testes manuais
- Testes unitários completos com JUnit
- Validações e tratamento de exceções para entradas inválidas

---

## 👨‍💻 Desenvolvedor

[<img loading="lazy" src="https://github.com/user-attachments/assets/b4f96f4b-542e-4988-9bc1-b1acf22a41a1" width=115><br><sub>Renan Dias Utida</sub>](https://github.com/renan-utida)

### Linkedin: https://www.linkedin.com/in/renan-dias-utida-1b1228225/

---

## ❓ Curiosidades:

### 🔗 Passo a Passo em como foi criado o Teste Unitário no IntelliJ usando o JUnit
1. Criar um novo projeto Java no IntelliJ usando o Maven como Build System.
2. Adicionar a Dependecy (Biblioteca) do JUnit no projeto. Dentro do arquivo pom.xml, devemos:
   - Usar o Atalho:
       1. Alt + Insert
       2. Dependency
       3. Digitar: org.junit.jupiter:junit-jupiter-api:5.9.2
       4. Adicionar Dependency
       5. Adicionar mais uma linha no código.
            ```sh
            <scope>test</scope>
            ```
    - Ou Manualmente:
       ```sh
       <dependencies>
            <dependency>
                <groupId>org.junit.jupiter</groupId>
                <artifactId>junit-jupiter-api</artifactId>
                <version>5.9.2</version>
                <scope>test</scope>
            </dependency>
        </dependencies>
       ```
3. Criar uma nova classe em seu projeto.
4. Criar uma classe de teste para testar métodos dentro de uma classe. Para criarmos, devemos:
   - Abra a classe que deseja testar.
   - Clique com o botão direito dentro do código.
   - Selecione Generate >> Test.
   - Selecione JUnit 5, marque os métodos que quer testar.
   - Clique em OK, e o IntelliJ criará a classe de teste automaticamente.
5. Escrever o código de teste. Seguindo alguns requisitos:
   - Criar métodos de teste anotados com @Test.
   - Chamar os métodos da classe e armazenar os resultados.
   - Usar assertivas (assertEquals, assertTrue, etc.) para verificar se os resultados são os esperados.
6. Executando os testes no IntelliJ.
   - Para isso, basta clicarmos no ícone de play ao lado do método ou da classe de teste.
   - O IntelliJ executará os testes e mostrará se passaram ou falharam.
  
## 💭 Considerações Finais
Este projeto foi desenvolvido como parte da avaliação do CP2, com o objetivo de aplicar conceitos fundamentais de programação orientada a objetos e testes unitários em Java. Durante o desenvolvimento, foram aplicados diversos princípios importantes:
- **Validação de dados:** Implementação de verificações robustas para garantir que o sistema não aceite valores inválidos.
- **Tratamento de exceções:** Uso adequado de exceções para lidar com situações de erro de forma elegante.
- **Testes abrangentes:** Desenvolvimento de testes que cobrem tanto os casos de uso normais quanto os casos limítrofes.
- **Interface de usuário:** Criação de uma interface de linha de comando intuitiva com feedbacks claros para o usuário.

O sistema, embora simples, demonstra como uma aplicação bem estruturada pode ser construída aplicando boas práticas de programação. Possíveis melhorias futuras incluiriam:
- Persistência de dados em banco de dados
- Interface gráfica de usuário
- Implementação de um sistema de reservas
- Categorização de veículos com diferentes políticas de preços

Este projeto serviu como uma excelente oportunidade para fortalecer conceitos fundamentais da programação orientada a objetos e demonstrar a importância dos testes unitários no desenvolvimento de software confiável.
