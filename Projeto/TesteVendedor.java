import java.util.Scanner;

public class TesteVendedor {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n====== Menu de Opções: ======");
            System.out.println("1. Criar Vendedor");
            System.out.println("2. Ler Vendedor");
            System.out.println("3. Atualizar Dados do Vendedor");
            System.out.println("4. Excluir Vendedor");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = entrada.nextInt();
            entrada.nextLine(); // Limpar a quebra de linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do vendedor: ");
                    String nomeCompleto = entrada.nextLine();
                    System.out.print("Digite o CPF do vendedor: ");
                    String cpf = entrada.nextLine();
                    System.out.println("Digite a idade do vendedor: ");
                    int idade = entrada.nextInt();
                    System.out.print("Digite o endereço do vendedor: ");
                    String endereco = entrada.nextLine();
                    System.out.print("Digite o e-mail do vendedor: ");
                    String email = entrada.nextLine();
                    System.out.println("Digite o salario do vendedor: ");
                    double salario = entrada.nextDouble();
                    System.out.println("Digite a comissão do vendedor: ");
                    double comissao = entrada.nextDouble();
                    Vendedor.criarVendedor(nomeCompleto, cpf, idade, endereco,  email, salario, comissao);
                    break;
                case 2:
                    System.out.print("Digite o CPF do vendedor a ser lido: ");
                    cpf = entrada.nextLine();
                    Vendedor.lerVendedor(cpf);
                    break;
                case 3:
                    System.out.print("Digite o CPF do vendedor a ser atualizado: ");
                    cpf = entrada.nextLine();
                    System.out.println("Digite o novo endereço do vendedor: ");
                    endereco = entrada.nextLine();
                    System.out.print("Digite o novo e-mail do vendedor: ");
                    email = entrada.nextLine();
                    Vendedor.atualizarVendedor(cpf, endereco, email);
                    break;
                case 4:
                    System.out.print("Digite o CPF do vendedor a ser excluído: ");
                    cpf = entrada.nextLine();
                    Vendedor.excluirVendedor(cpf);
                    break;
                case 5:
                    System.out.println("Saindo do programa!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente...");
                    break;
            }

        } while (escolha != 5);

        entrada.close();    
    }
}