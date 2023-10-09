import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    ///// MENU DO CLIENTE

    public static void menuCliente(){
        Scanner ent2 = new Scanner(System.in);
        int op;

        Cliente.lerDados("clientes.txt");
        
        do {
         System.out.println("\n-------- MENU DO CLIENTE --------");
         System.out.println("1. Criar Cliente");
         System.out.println("2. Listar Cliente");
         System.out.println("3. Consultar Cliente");
         System.out.println("4. Ler Cliente");
         System.out.println("5. Atualizar Cliente");
         System.out.println("6. Excluir Cliente");
         System.out.println("7. Realizar um Pagamento");
         System.out.println("8. Realizar a Solicitacao de um Veiculo");
         System.out.println("9. Sair ");

         op = ent2.nextInt();
         ent2.nextLine();
    
            switch (op) {
                case 1:
                    Cliente.criarCliente();
                    break;
    
                case 2:
                    Cliente.listarCliente();
                    break;
    
                case 3:
                    Cliente.consultarCliente();
                    break;
    
                case 4:
                    Cliente.lerCliente();
                    break;
    
                case 5:
                    Cliente.atualizarCliente();
                    break;
    
                case 6:
                    Cliente.excluirCliente();
                    break;
    
                case 7:
                    Cliente cliente = null;
    
                    System.out.println(" Digite o valor do Pagamento");
                    double valorDoPagamento = ent2.nextDouble();
                    Cliente.realizarPagamento(cliente, valorDoPagamento);
                    break;
    
                case 8:
                    Cliente client = null;
                    Veiculo veiculo = null;
                    Cliente.SolicitarVeiculo(client, veiculo);
                    break;
                case 9:
                    System.out.println("Saindo...");               
                    break;    
                default:
                    System.out.println("Operacao invalida!");
                    break;
            }
            Cliente.salvarDados("clientes.txt");
         
        }while (op != 9);
    }
 
 
    public static void menuVenda(){
         List<Venda> vendas = new ArrayList<>();
         List<Vendedor> vendedores = new ArrayList<>();
         List<Veiculo> veiculos = new ArrayList<>();
         List<Cliente> clientes = new ArrayList<>();
         Venda venda = null;
         Vendedor vendedor = null;
         Cliente cliente = null;

         Scanner ent3 = new Scanner(System.in);
         int op2;

        Venda.lerDados("vendas.txt");
 
        do {
            System.out.println("\n-------- MENU DE VENDAS --------");
             System.out.println("1. Criar Venda ");
             System.out.println("2. Ler Venda ");
             System.out.println("3. Atualizar Venda ");
             System.out.println("4. Exluir Venda ");
             System.out.println("5. Criar Solicitação De uma Venda ");
             System.out.println("6. Listar Solicitações Pendentes ");
             System.out.println("7. Listar Registro de Vendas ");
             System.out.println("8. Excluir Solicitação ");
             System.out.println(" 9. Sair ");

            op2 = ent3.nextInt();
            ent3.nextLine();

            switch (op2) {
                 case 1 :
                     Venda.criarVenda();
                     break;
                 case 2 :
                     Venda.lerVenda();
                     break;
 
                 case 3 :
                     Venda.atualizarVenda(vendas, null, venda);
                     break;    
             
                 case 4 :
                     Venda.deletarVenda(vendas, null);
                     break;
 
                 case 5 :
                     Venda.criarSolicitacao(clientes, veiculos, cliente, vendedor);
                     break;
 
                 case 6 :
                     Venda.listarSolicitacoesPententes(vendas);
                     break;
 
                 case 7 :
                     Venda.listarRegistroDeVendas(vendas);
                     break;    
             
                 case 8 :
                     Venda.excluirSolicitacao(vendas);
                     break;
 
                 case 9 :
                     System.out.println(" Saindo... ");
                     break;
                 default:
                     System.out.println("Entrada Invalida");
                     break;
            }
            Venda.salvarDados("vendas.txt");
             
        }while (op2 != 9);
    }


    //////MENU DE VENDEDOR

    public static void menuVendedor(){
        Scanner entrada = new Scanner(System.in);
        int escolha;
        Vendedor.lerDados("vendedores.txt");

        do {
            System.out.println("\n====== Menu de Opções: ======");
            System.out.println("1. Criar Vendedor");
            System.out.println("2. Ler Vendedor");
            System.out.println("3. Atualizar Dados do Vendedor");
            System.out.println("4. Excluir Vendedor");
            System.out.println("5. Calcular Salario");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = entrada.nextInt();
            entrada.nextLine(); // Limpar a quebra de linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do vendedor: ");
                    String nomeCompleto = entrada.nextLine();

                    System.out.print("Digite o CPF do vendedor: ");
                    String cpf = entrada.nextLine();

                    System.out.print("Digite a idade do vendedor: ");
                    int idade = entrada.nextInt();
                    entrada.nextLine(); 

                    System.out.println("Digite o endereço do vendedor: ");
                    String endereco = entrada.nextLine();

                    System.out.print("Digite o e-mail do vendedor: ");
                    String email = entrada.nextLine();

                    System.out.print("Digite o salario do vendedor: ");
                    double salario = entrada.nextDouble();

                    Vendedor.criarVendedor(nomeCompleto, cpf, idade, endereco, email, salario);

                    break;
                case 2:
                    System.out.println("Digite o CPF do vendedor a ser lido: ");
                    cpf = entrada.nextLine();
                    Vendedor.lerVendedor(cpf);
                    break;
                case 3:
                    System.out.println("Digite o CPF do vendedor a ser atualizado: ");
                    cpf = entrada.nextLine();
                    System.out.println("Digite o novo endereço do vendedor: ");
                    endereco = entrada.nextLine();
                    System.out.println("Digite o novo e-mail do vendedor: ");
                    email = entrada.nextLine();
                    Vendedor.atualizarVendedor(cpf, endereco, email);
                    break;
                case 4:
                    System.out.println("Digite o CPF do vendedor a ser excluído: ");
                    cpf = entrada.nextLine();
                    Vendedor.excluirVendedor(cpf);
                    break;
                case 5:
                    System.out.println("Digite o CPF do vendedor: ");
                    cpf = entrada.nextLine();
                    System.out.println("Digite a comissão: ");
                    double comissao = entrada.nextDouble();
                    Vendedor.calcularSalario(cpf, comissao);
                    break;
                case 6:
                    System.out.println("Saindo do programa!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente...");
                    break;
            }
            Vendedor.salvarDados("vendedores.txt");

        } while (escolha != 6);
         
    }



    /////// MENU DO VEICULO
        /**
         * 
         */
        public static void menuVeiculo() {
	        String nomeArquivo = "C:\\Users\\Adm\\OneDrive\\Área de Trabalho\\veiculo.txt"; // Nome do arquivo onde os veículos serão armazenados

            int opcao;
	        Scanner scanner = new Scanner(System.in);

	        do {
	            System.out.println(" ========= MENU DE VEÍCULOS ========");
	            System.out.println(" Selecione uma das opções abaixo: ");
	            System.out.println(" 1. Criar um veículo ");
	            System.out.println(" 2. Ler veículo em arquivo ");
	            System.out.println(" 3. Atualizar veículo em arquivo ");
	            System.out.println(" 4. Excluir um veículo ");
	            System.out.println(" 5. Listar veículos ");
	            System.out.println(" 6. Atualizar estoque de um veículo");
	            System.out.println(" 7. Buscar veículo em arquivo ");
	            System.out.println(" 8. Sair ");
	            System.out.println(" Escolha uma opção: ");

	            opcao = scanner.nextInt();
	            scanner.nextLine(); // Consumir a nova linha

	            switch (opcao) {
	                case 1:
	                    System.out.println("Criando um veículo:");
	                    System.out.print("Marca: ");
	                    String marca = scanner.nextLine();
	                    System.out.print("Modelo: ");
	                    String modelo = scanner.nextLine();
	                    System.out.print("Ano de Fabricação: ");
	                    int anoDeFabricacao = scanner.nextInt();
	                    scanner.nextLine(); // Consumir a nova linha
	                    System.out.print("Cor: ");
	                    String cor = scanner.nextLine();
	                    System.out.print("Estado do Veículo: ");
	                    String estadoDoVeiculo = scanner.nextLine();
	                    System.out.print("Quantidade em Estoque: ");
	                    int quantidade = scanner.nextInt();
	                    scanner.nextLine(); // Consumir a nova linha

	                    Veiculo.criarVeiculoEmArquivo(marca, modelo, anoDeFabricacao, cor, estadoDoVeiculo, quantidade, nomeArquivo);
	                    break;
	                case 2:
	                    System.out.println("Lendo veículo em arquivo:");
	                    System.out.print("Marca do veículo: ");
	                    marca = scanner.nextLine();
	                    System.out.print("Modelo do veículo: ");
	                    modelo = scanner.nextLine();

	                    // Buscar e exibir o veículo em arquivo
	                    Veiculo veiculoLido = Veiculo.buscarVeiculoEmArquivo(marca, modelo, nomeArquivo);
	                    if (veiculoLido != null) {
	                        veiculoLido.lerVeiculo();
	                    } else {
	                        System.out.println("Veículo não encontrado.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("Atualizando veículo em arquivo:");
	                    System.out.print("Marca do veículo a ser atualizado: ");
	                    marca = scanner.nextLine();
	                    System.out.print("Modelo do veículo a ser atualizado: ");
	                    modelo = scanner.nextLine();

	                    Veiculo veiculoAtualizar = Veiculo.buscarVeiculoEmArquivo(marca, modelo, nomeArquivo);
	                    if (veiculoAtualizar != null) {
	                        // Solicitar as atualizações dos campos
	                        System.out.print("Nova Marca: ");
	                        marca = scanner.nextLine();
	                        System.out.print("Novo Modelo: ");
	                        modelo = scanner.nextLine();
	                        System.out.print("Novo Ano de Fabricação: ");
	                        anoDeFabricacao = scanner.nextInt();
	                        scanner.nextLine(); // Consumir a nova linha
	                        System.out.print("Nova Cor: ");
	                        cor = scanner.nextLine();
	                        System.out.print("Novo Estado do Veículo: ");
	                        estadoDoVeiculo = scanner.nextLine();
	                        System.out.print("Nova Quantidade em Estoque: ");
	                        quantidade = scanner.nextInt();
	                        scanner.nextLine(); // Consumir a nova linha

	                        // Atualizar o veículo
	                        veiculoAtualizar.setMarca(marca);
	                        veiculoAtualizar.setModelo(modelo);
	                        veiculoAtualizar.setAnoDeFabricacao(anoDeFabricacao);
	                        veiculoAtualizar.setCor(cor);
	                        veiculoAtualizar.setEstadoDoVeiculo(estadoDoVeiculo);
	                        veiculoAtualizar.setQuantidade(quantidade);

	                        // Perguntar se deseja excluir o veículo
	                        System.out.print("Deseja excluir o veículo? (S/N): ");
	                        String resposta = scanner.nextLine();
	                        if (resposta.equalsIgnoreCase("S")) {
	                            Veiculo.excluirVeiculoEmArquivo(marca, modelo, nomeArquivo);
	                            System.out.println("Veículo excluído.");
	                        } else {
	                            // Atualizar no arquivo
	                            veiculoAtualizar.atualizarVeiculoEmArquivo(nomeArquivo);
	                            System.out.println("Veículo atualizado.");
	                        }
	                    } else {
	                        System.out.println("Veículo não encontrado.");
	                    }
	                    break;	
	                case 4:
	                    System.out.println("Excluindo um veículo:");
	                    System.out.print("Marca do veículo a ser excluído: ");
	                    marca = scanner.nextLine();
	                    System.out.print("Modelo do veículo a ser excluído: ");
	                    modelo = scanner.nextLine();

	                    Veiculo.excluirVeiculoEmArquivo(marca, modelo, nomeArquivo);
	                    break;
	                case 5:
	                    System.out.println("Listando veículos:");
	                    Veiculo.listarVeiculosEmArquivo(nomeArquivo);
	                    break;
	                case 6:
	              
	                    System.out.println("Atualizando estoque de um veículo:");
	                    System.out.print("Marca do veículo a ser atualizado: ");
	                    marca = scanner.nextLine();
	                    System.out.print("Modelo do veículo a ser atualizado: ");
	                    modelo = scanner.nextLine();
	                    System.out.print("Quantidade a ser adicionada ou subtraída: ");
	                    int quantidadeAtualizacao = scanner.nextInt();
	                    scanner.nextLine(); // Consumir a nova linha

	                    Veiculo veiculoEstoque = Veiculo.buscarVeiculoEmArquivo(marca, modelo, nomeArquivo);
	                    if (veiculoEstoque != null) {
	                        System.out.println("1. Adicionar ao estoque");
	                        System.out.println("2. Subtrair do estoque");
	                        System.out.print("Escolha uma opção (1 ou 2): ");
	                        int opcaoEstoque = scanner.nextInt();
	                        scanner.nextLine(); // Consumir a nova linha

	                        if (opcaoEstoque == 1) {
	                            veiculoEstoque.atualizarEstoqueEmArquivo(quantidadeAtualizacao, nomeArquivo);
	                            System.out.println("Estoque atualizado: " + veiculoEstoque.getQuantidade());
	                        } else if (opcaoEstoque == 2) {
	                            // Certifique-se de que o estoque não se torne negativo
	                            if (quantidadeAtualizacao <= veiculoEstoque.getQuantidade()) {
	                                veiculoEstoque.atualizarEstoqueEmArquivo(-quantidadeAtualizacao, nomeArquivo);
	                                System.out.println("Estoque atualizado: " + veiculoEstoque.getQuantidade());
	                            } else {
	                                System.out.println("Quantidade a ser subtraída é maior que o estoque atual.");
	                            }
	                        } else {
	                            System.out.println("Opção inválida.");
	                        }
	                    } else {
	                        System.out.println("Veículo não encontrado.");
	                    }
	                    break;  	
	                	
	                case 7:
	                    System.out.println("Buscando veículo em arquivo:");
	                    System.out.print("Marca do veículo: ");
	                    String marca1 = scanner.nextLine();
	                    System.out.print("Modelo do veículo: ");
	                    String modelo1 = scanner.nextLine();
	                    // Buscar e exibir o veículo em arquivo
	                    Veiculo veiculoLido1 = Veiculo.buscarVeiculoEmArquivo(marca1, modelo1, nomeArquivo);
	                    if (veiculoLido1 != null) {
	                        veiculoLido1.lerVeiculo();
	                    } else {
	                        System.out.println("Veículo não encontrado.");
	                    }
	                    break;
	                case 8:
	                    System.out.println("Saindo do programa.");
	                    // scanner.close();
	                    System.exit(0);
                        break;
	                default:
	                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
	            }

	        }while (opcao != 8); 
 
	    }

    /////////////////////////////////////// main /////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n------ MENU PRINCIPAL ------ ");
            System.out.println("1. MENU DO CLIENTE ");
            System.out.println("2. MENU DO VENDEDOR");
            System.out.println("3. MENU DOS VEICULOS");
            System.out.println("4. MENU DAS VENDAS ");
            System.out.println("5. Sair");
            
            opcao = ent.nextInt();
            ent.nextLine();

            switch (opcao) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuVendedor();
                    break;
                case 3:
                    menuVeiculo();
                    break;
                case 4:
                    menuVenda();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println(" Opção inválida!");
                    break;
            }

        } while (opcao != 5);    
    }

}


        

    
    
    
