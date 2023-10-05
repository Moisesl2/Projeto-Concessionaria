import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Vendedor extends Pessoa{
private double salario;
	    private double comissao;
	    
	    public Vendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double salario) {
	        super(nomeCompleto, cpf, idade, endereco, email);
	        this.salario = salario;
	        this.comissao = 0 ;
	    }

	    public double getSalario() {
	        return salario;
	    }
	    public void setSalario(double salario) {
	        this.salario = salario;
	    }
	    
	    public double getComissao() {
	        return comissao;
	    }
	    public void setComissao(double comissao) {
	        this.comissao = comissao;
	    }

	    // Metodos de criar, ler, atualizar e excluir
	    public static List<Vendedor> vendedor = new ArrayList<>();

	    public static void criarVendedor(String nomeCompleto, String cpf, int idade, String endereco, String email, double salario){
	        Vendedor novoVendedor = new Vendedor( nomeCompleto, cpf, idade, endereco,  email,  salario);

	        vendedor.add(novoVendedor);
	        System.out.println("Vendedor criado com sucesso!");
	    }

	    //vendedor vai ser procurado pelo CPF
	    // Vendedor encontrado, sair do loop
	    public static void lerVendedor(String cpf) {
	        for (Vendedor vendedor : vendedor) {
	            if (vendedor.getCpf().equals(cpf)) {
	                System.out.println("====== Informações do Vendedor: ======");
	                System.out.println("Nome: " + vendedor.getNomeCompleto());
	                System.out.println("CPF: " + vendedor.getCpf());
	                System.out.println("Endereço: " + vendedor.getEndereco());
	                System.out.println("E-mail: " + vendedor.getEmail());
	                return;
	            }
	        }
	        System.out.println("Vendedor não encontrado.");
	    }

	    public static void atualizarVendedor(String cpf, String novoEndereco, String novoEmail) {
	        for (Vendedor vendedor : vendedor) {
	            if (vendedor.getCpf().equals(cpf)) {
	                vendedor.setEndereco(novoEndereco);
	                vendedor.setEmail(novoEmail);
	                System.out.println("Dados do vendedor atualizado com sucesso!");
	                return;
	            }
	        }
	        System.out.println("Vendedor não encontrado!");
	    }

	    public static void excluirVendedor(String cpf) {
	        Iterator<Vendedor> iterator = vendedor.iterator();
	        while (iterator.hasNext()) {
	            Vendedor vendedor = iterator.next();
	            if (vendedor.getCpf().equals(cpf)) {
	                iterator.remove();
	                System.out.println("Vendedor: "+vendedor.getNomeCompleto()+", excluído com sucesso!");
	                return;
	            }
	        }
	        System.out.println("Vendedor não encontrado¹");
	    }

	    @Override
	    public String toString() {
	    	return toString()+ "Vendedor [salario=" + salario + ", comissao=" + comissao + "]";
	    }
}
