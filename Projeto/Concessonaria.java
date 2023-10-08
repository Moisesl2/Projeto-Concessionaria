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
            System.out.println("3. Sair ");
            opcao = ent.nextInt();

            switch (opcao) {
                case 1:
                    menuCliente();
                    break;
            
                case 2:
                    menuVenda();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println(" Opção invalida!");
                    ent.close();
                    break;
            }

        }while (opcao != 3);

            
        

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
}
