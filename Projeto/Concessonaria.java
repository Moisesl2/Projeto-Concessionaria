import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Concessonaria {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int opcao;
        do{
            System.out.println(" \n------ MENU PRINCIPAL ------ ");
            System.out.println("1. MENU DO CLIENTE ");
            System.out.println("2. MENU DAS VENDAS ");
            System.out.println(" Sair");
            opcao = ent.nextInt();

            switch (opcao) {
                case 1:
                    menuCliente();
                    break;
            
                case 2:
                    menuVenda();
                    break;
                case 3:
                    menuVeiculo();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println(" Opção invalida!");
                    ent.close();
                    break;
            }

        }while (opcao != 4);

            
        

    }

    public static void menuCliente(){
       Scanner ent2 = new Scanner(System.in);
       int op;
       
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
                ent2.close();                
                break;    

            default:
                System.out.println("Operacao invalida!");
                break;
        }

        
       } while (op != 9);
    }

    // --------NOVO METODO PARA SUBSTITUIR METODO MENU CLIENTE
    public static void menuCliente2(){
        Scanner ent2 = new Scanner(System.in);
        int op;

        while (true) {
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
                ent2.close();                
                break;    

            default:
                System.out.println("Operacao invalida!");
                break;
            }
            
        }
    }

    ///--------ACABA AQUI---------


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
                    ent3.close();
                    break;
            }
            
        } while (op2 != 9);
    }

    //Menu Veiculo
    public static void menuVeiculo() {
	List<Veiculo> veiculos = new ArrayList<>();
        Scanner ent4 = new Scanner(System.in);
	int op3;

	do {
		System.out.println("\n-------- MENU DE VEÍCULOS --------");
		System.out.println("1. Criar Veículo ");
		System.out.println("2. Listar Veículos ");
		System.out.println("3. Ler Veículo ");
		System.out.println("4. Atualizar Veículo ");
		System.out.println("5. Excluir Veículo ");
		System.out.println("6. Atualizar Estoque ");
		System.out.println("7. Sair ");
		op3 = ent4.nextInt();

		switch (op3) {
			case 1:
		            criarVeiculo(veiculos);
		                break;

		            case 2:
		                listarVeiculo(veiculos);
		                break;

		            case 3:
		                lerVeiculo(veiculos);
		                break;

		            case 4:
		                atualizarVeiculo(veiculos);
		                break;

		            case 5:
		                excluirVeiculo(veiculos);
		                break;

		            case 6:
		                atualizarEstoque(veiculos);
		                break;

		            case 7:
		                System.out.println("Saindo...");
		                break;

		            default:
		                System.out.println("Opção inválida!");
		                break;
		        }
		    } while (op3 != 7);
		}

		public static void criarVeiculo(List<Veiculo> veiculos) {
		    Scanner ent = new Scanner(System.in);
		    System.out.println("Digite a marca do veículo: ");
		    String marca = ent.nextLine();
		    System.out.println("Digite o modelo do veículo: ");
		    String modelo = ent.nextLine();
		    System.out.println("Digite o ano de fabricação do veículo: ");
		    int anoFabricacao = ent.nextInt();
		    ent.nextLine(); // Consumir a quebra de linha
		    System.out.println("Digite a cor do veículo: ");
		    String cor = ent.nextLine();
		    System.out.println("Digite o estado do veículo: ");
		    String estadoDoVeiculo = ent.nextLine();
		    System.out.println("Digite a quantidade em estoque: ");
		    int quantidade = ent.nextInt();

		    Veiculo veiculo = Veiculo.criarVeiculo(marca, modelo, anoFabricacao, cor, estadoDoVeiculo, quantidade);
		    veiculos.add(veiculo);
		    System.out.println("Veículo criado com sucesso!");
		    ent.close();
		}

		public static void listarVeiculo(List<Veiculo> veiculos) {
		    Veiculo.listarVeiculo(veiculos);
		}

		public static void lerVeiculo(List<Veiculo> veiculos) {
		    Scanner ent = new Scanner(System.in);
		    System.out.println("Digite a marca do veículo: ");
		    String marca = ent.nextLine();
		    System.out.println("Digite o modelo do veículo: ");
		    String modelo = ent.nextLine();

		    for (Veiculo veiculo : veiculos) {
		        if (veiculo.getMarca().equals(marca) && veiculo.getModelo().equals(modelo)) {
		            veiculo.lerVeiculo();
		            return;
		        }
		    }
		    System.out.println("Veículo não encontrado.");
		}

		public static void atualizarVeiculo(List<Veiculo> veiculos) {
		    Scanner ent = new Scanner(System.in);
		    System.out.println("Digite a marca do veículo que deseja atualizar: ");
		    String marca = ent.nextLine();
		    System.out.println("Digite o modelo do veículo que deseja atualizar: ");
		    String modelo = ent.nextLine();

		    for (Veiculo veiculo : veiculos) {
		        if (veiculo.getMarca().equals(marca) && veiculo.getModelo().equals(modelo)) {
		            System.out.println("Digite a nova marca do veículo: ");
		            marca = ent.nextLine();
		            System.out.println("Digite o novo modelo do veículo: ");
		            modelo = ent.nextLine();
		            System.out.println("Digite o novo ano de fabricação do veículo: ");
		            int anoFabricacao = ent.nextInt();
		            ent.nextLine(); // Consumir a quebra de linha
		            System.out.println("Digite a nova cor do veículo: ");
		            String cor = ent.nextLine();
		            System.out.println("Digite o novo estado do veículo: ");
		            String estadoDoVeiculo = ent.nextLine();
		            System.out.println("Digite a nova quantidade em estoque: ");
		            int quantidade = ent.nextInt();

		            veiculo.atualizarVeiculo(marca, modelo, anoFabricacao, cor, estadoDoVeiculo, quantidade);
		            System.out.println("Veículo atualizado com sucesso!");
		            return;
		        }
		    }
		    System.out.println("Veículo não encontrado.");
		}

		public static void excluirVeiculo(List<Veiculo> veiculos) {
		    Scanner ent = new Scanner(System.in);
		    System.out.println("Digite a marca do veículo que deseja excluir: ");
		    String marca = ent.nextLine();
		    System.out.println("Digite o modelo do veículo que deseja excluir: ");
		    String modelo = ent.nextLine();

		    Veiculo.excluirVeiculo(veiculos, marca, modelo);
		}
	}
}
