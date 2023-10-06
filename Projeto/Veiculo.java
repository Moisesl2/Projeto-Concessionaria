package concessionaria;
import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Veiculo {
    private int codigo;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private String cor;
    private String estadoDoVeiculo;
    private int quantidade;

    // Construtor
    public Veiculo(int codigo, String marca, String modelo, int anoFabricacao, String cor, String estadoDoVeiculo, int quantidade) {
        this.codigo= codigo;
    	this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.estadoDoVeiculo = estadoDoVeiculo;
        this.quantidade = quantidade;
    }
    
    //Getters e Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAnoFabricacao() {
		return anoFabricacao;
	}


	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getEstadoDoVeiculo() {
		return estadoDoVeiculo;
	}


	public void setEstadoDoVeiculo(String estadoDoVeiculo) {
		this.estadoDoVeiculo = estadoDoVeiculo;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	// Método para cadastrar um novo veículo
	 public static void cadastrarVeiculo(List<Veiculo> listaVeiculos, int codigo, String marca, String modelo, int anoFabricacao, String cor, String estadoDoVeiculo, int quantidade) {
	        Veiculo novoVeiculo = new Veiculo(codigo, marca, modelo, anoFabricacao, cor, estadoDoVeiculo, quantidade);
	        listaVeiculos.add(novoVeiculo);
	 }

       // Método para editar  veículo
	 public void editarVeiculo(int codigo, String novaMarca, String novoModelo, int novoAnoFabricacao, String novaCor, String novoEstadoDoVeiculo, int novaQuantidade) {
	        this.codigo = codigo;
		    this.marca = novaMarca;
	        this.modelo = novoModelo;
	        this.anoFabricacao = novoAnoFabricacao;
	        this.cor = novaCor;
	        this.estadoDoVeiculo = novoEstadoDoVeiculo;
	        this.quantidade = novaQuantidade;
	 }

        // Método para ver os dados de um veículo
	 public void verDadosVeiculo() {
		    System.out.println("Detalhes do Veículo:");
		    System.out.println("+-----------------------------------------------------------------------+");
		    System.out.printf("| %-15s | %-15s | %-8s |%n", "Atributo", "Valor", " ");
		    System.out.println("+-----------------------------------------------------------------------+");
		    System.out.printf("| %-15s | %-15d | %-8s |%n", "Codigo", this.codigo, " ");
		    System.out.printf("| %-15s | %-15s | %-8s |%n", "Marca", this.marca, " ");
		    System.out.printf("| %-15s | %-15s | %-8s |%n", "Modelo", this.modelo, " ");
		    System.out.printf("| %-15s | %-15d | %-8s |%n", "Ano de Fabricação", this.anoFabricacao,   " ");
		    System.out.printf("| %-15s | %-15s | %-8s |%n", "Cor", this.cor, " ");
		    System.out.printf("| %-15s | %-15s | %-8s |%n", "Estado do Veículo", this.estadoDoVeiculo, " ");
		    System.out.printf("| %-15s | %-15d | %-8s |%n", "Quantidade", this.quantidade, " ");
		    System.out.println("+-----------------------------------------------------------------------+");
        }

         // Método para listar  veículos
	 public static void listarVeiculos(List<Veiculo> listaVeiculos) {
	        System.out.println("+----------------------------------------------------------------------------------------+");
	        System.out.printf(" |%-15s | %-15s | %-15s | %-15s | %-15s | %-20s | %-15s |%n", "Codigo", "Marca", "Modelo", "Ano de Fabricação", "Cor", "Estado do Veículo", "Quantidade");
	        System.out.println("+----------------------------------------------------------------------------------------+");

	        for (Veiculo veiculo : listaVeiculos) {
	            System.out.printf("|%-15d | %-15s | %-15s | %-15d | %-15s | %-20s | %-15d |%n",
	                   veiculo.getCodigo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),
	                    veiculo.getCor(), veiculo.getEstadoDoVeiculo(), veiculo.getQuantidade());
	        }
	        System.out.println("+----------------------------------------------------------------------------------------+");
	  }
	 
	// Método para excluir um veículo com base no código, marca e modelo
	 public static void excluirVeiculo(List<Veiculo> veiculos, int codigo, String marca, String modelo) {
	        Iterator<Veiculo> iterator = veiculos.iterator();
	        while (iterator.hasNext()) {
	            Veiculo veiculo = iterator.next();
	            if (veiculo.getCodigo() == codigo && veiculo.getMarca().equals(marca) && veiculo.getModelo().equals(modelo)) {
	                iterator.remove();
	                System.out.println("Veículo removido com sucesso.");
	                return;
	            }
	        }
	        System.out.println("Veículo não encontrado com o código, marca e modelo especificados.");
	    } 
	 // Método para salvar os dados dos veículos em um arquivo
	    public static void salvarEmArquivoP(String nomeArquivo, List<Veiculo> veiculos) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
	            for (Veiculo veiculo : veiculos) {
	                writer.write("Marca: " + veiculo.getMarca() + "\n");
	                writer.write("Modelo: " + veiculo.getModelo() + "\n");
	                writer.write("Ano de Fabricação: " + veiculo.getAnoFabricacao() + "\n");
	                writer.write("Cor: " + veiculo.getCor() + "\n");
	                writer.write("Estado do Veículo: " + veiculo.getEstadoDoVeiculo() + "\n");
	                writer.write("Quantidade: " + veiculo.getQuantidade() + "\n");
	                writer.write("\n"); // Linha em branco para separar os registros
	            }
	            System.out.println("Dados dos veículos salvos com sucesso no arquivo: " + nomeArquivo);
	        } catch (IOException e) {
	            System.err.println("Erro ao salvar os dados dos veículos no arquivo: " + e.getMessage());
	        }
	    }
	    
	    // Método para ler os dados dos veículos de um arquivo
	    public static List<Veiculo> lerArquivoV(String nomeArquivo) {
	        List<Veiculo> veiculos = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
	            String linha;
	            Veiculo veiculo = null;

	            while ((linha = reader.readLine()) != null) {
	                if (linha.trim().isEmpty()) {
	                    // Linha em branco indica o final de um registro, então adicionamos o veículo à lista
	                    if (veiculo != null) {
	                        veiculos.add(veiculo);
	                        veiculo = null; // Reinicializa o veículo
	                    }
	                } else {
	                    String[] partes = linha.split(": ");
	                    if (partes.length == 2) {
	                        String atributo = partes[0];
	                        String valor = partes[1];

	                        switch (atributo) {
	                            case "Marca":
	                                veiculo = new Veiculo();
	                                veiculo.setMarca(valor);
	                                break;
	                            case "Modelo":
	                                veiculo.setModelo(valor);
	                                break;
	                            case "Ano de Fabricação":
	                                veiculo.setAnoFabricacao(Integer.parseInt(valor));
	                                break;
	                            case "Cor":
	                                veiculo.setCor(valor);
	                                break;
	                            case "Estado do Veículo":
	                                veiculo.setEstadoDoVeiculo(valor);
	                                break;
	                            case "Quantidade":
	                                veiculo.setQuantidade(Integer.parseInt(valor));
	                                break;
	                            default:
	                                // Ignora atributos desconhecidos
	                                break;
	                        }
	                    }
	                }
	            }

	            // Adiciona o último veículo se houver um no final do arquivo
	            if (veiculo != null) {
	                veiculos.add(veiculo);
	            }

	        } catch (IOException e) {
	            System.err.println("Erro ao ler o arquivo de veículos: " + e.getMessage());
	        }

	        return veiculos;
	    }

	    
	 @Override
	 public String toString() {
		return "Veiculo [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricacao=" + anoFabricacao
				+ ", cor=" + cor + ", estadoDoVeiculo=" + estadoDoVeiculo + ", quantidade=" + quantidade + "]";
	}
    	
}
