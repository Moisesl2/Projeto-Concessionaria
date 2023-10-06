import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vendedor extends Pessoa {
    private double comissao;
    private double salario;

    public Vendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double comissao,
        double salario) {
        super(nomeCompleto, cpf, idade, endereco, email);
        this.comissao = comissao;
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    private static List<Vendedor> vendedores = new ArrayList<>();
    
    public static void criarVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
    }

    public static List<Vendedor> listarVendedor(){
        return vendedores;
    }

    public static Vendedor consultarVendedor(String cpf){
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return vendedor;
            }
        }
        return null;
    }

    public static void atualizarVendedor(String cpf, Vendedor novovVendedor){
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getCpf().equals(cpf)){
                vendedores.set(i, novovVendedor);
                return;
            }
        }
    }

    public static void excluirVendedor(String cpf){
        vendedores.removeIf(vendedor -> vendedor.getCpf().equals(cpf));

    }

    public static void lerVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do vendedor que deseja ler: ");
        String cpf = scanner.nextLine();

        Vendedor vendedor = consultarVendedor(cpf);

        if (vendedor != null) {
            System.out.println("\nInformações do Vendedor:");
            System.out.println("Nome: " + vendedor.getNomeCompleto());
            System.out.println("CPF: " + vendedor.getCpf());
            System.out.println("Email: " + vendedor.getEmail());
            System.out.println("Idade: " + vendedor.getIdade());
            System.out.println("Endereço: " + vendedor.getEndereco());
            System.out.println("Salário: " + vendedor.getSalario());
            System.out.println("Comissão: " + vendedor.getComissao());
        } else {
            System.out.println("Vendedor não encontrado.");
        }
        scanner.close();
    }

    public double calcularSalario() {
        // O salário total é a soma do salário fixo e da comissão
        return salario + comissao;
    }
    //CLASSE PROVISORIA

}