package br.ifpb.edu.dac.tarcizo.atividade2;


import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.SystemPropertyUtils;

import br.ifpb.edu.dac.tarcizo.atividade2.controler.CarroControler;
import br.ifpb.edu.dac.tarcizo.atividade2.controler.VendaController;
import br.ifpb.edu.dac.tarcizo.atividade2.controler.VendedorController;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Carro;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Venda;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Vendedor;
import br.ifpb.edu.dac.tarcizo.atividade2.model.enums.Sexo;


@SpringBootApplication
public class ProjetoJpaApplication implements CommandLineRunner{

	@Autowired
	private CarroControler carroController;
	
	@Autowired
	private VendedorController vendedorController;
	
	@Autowired
	private VendaController vendaController;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Scanner leitor = new Scanner(System.in);
		
		boolean controle = true;
		 
		while(controle) {
			System.out.println("====Menu====");
			System.out.println("1 - Criar Carro | 2 - Criar Vendedor"
					+ "\n3 - Listar Carros | 4 - Listar Vendedores"
					+ "\n5 - Criar Venda | 6 - Listar Vendas"
					+ "\n7 - Deletar todos os Carros"
					+ "\n8 - Deletar todos os Vendedores"
					+ "\n9 - Deletar todos as Vendas"
					+ "\n10 - Deletar Carro por ID | 11 - Atualizar Carro por ID"
					+ "\n12 - Deletar Vendedor por ID | 13 - Atualizar Vendedor por ID"
					+ "\n14 - Deletar Venda por ID | 15 - Atualizar Venda por ID"
					+ "\n0 - Sair");
			String op = leitor.nextLine();
			
			switch (op) {
			
			case "1": {
				System.out.println("===Criar Carro===");
				System.out.println("Qual a Marca do Carro:");
				String marca = leitor.nextLine();
				
				System.out.println("Qual a Modelo do Carro:");
				String modelo = leitor.nextLine();
				
				carroController.save(marca, modelo);				
				break;
			}
			
			case "2":{
				System.out.println("===Criar Vendedor===");
				System.out.println("Qual o Nome do Vendedor:");
				String nome = leitor.nextLine();
				
				System.out.println("Qual o CPF do Vendedor:");
				String cpf = leitor.nextLine();
				
				System.out.println("Qual o Sexo do Vendedor:"
						+ "H(Homem)"
						+ "M(Mulher)");
				
				String opSexo = leitor.nextLine().toUpperCase();
				Sexo sexo = null;
				while(sexo == null) {
					if(opSexo.equals("H")) {
						sexo = Sexo.HOMEM;
					}else if(opSexo.equals("M")) {
						sexo = Sexo.MULHER;
					}else {
						System.out.println("Valor Invalido...");
					}
					
				}

				vendedorController.save(nome, cpf, sexo);
							
				break;
			}
			case "3":{				
				List<Carro> carros = carroController.listarTodosCarros();
				System.out.println("===Listar Carros===");
				if(!carros.isEmpty()) {
					for (Carro carro : carros) {
						System.out.println("ID: " + carro.getId()
						+ "\nMarca: " + carro.getMarca()
						+ "\nModelo: " + carro.getModelo());
					}
					
				}else {
					System.out.println("Não a carros....");
				}

				break;
			}
			case"4":{
				
				List<Vendedor> vendedores = vendedorController.listarTodosVendedores();
				System.out.println("===Listar Vendedores===");
				if(vendedores != null) {
					for (Vendedor vendedor : vendedores) {
						System.out.println("ID: " + vendedor.getId()
								+ "\nNome: " + vendedor.getNome()
								+ "\nSexo: " + vendedor.getSexo()
								+ "\nCPF: " + vendedor.getCpf());
					}
				}else {
					System.out.println("Não a vendedores....");
				}

				break;
			}
			case"5":{
				System.out.println("===Criar Venda===");
				System.out.println("Qual o Id do Vendedor:");
				Long idVendedor = Long.parseLong(leitor.nextLine());
				
				System.out.println("Qual o Id do Carro:");
				Long idCarro = Long.parseLong(leitor.nextLine());
				
				System.out.println("Qual o valor da venda:");
				float valorVenda = Float.parseFloat(leitor.nextLine());
				
				System.out.println("Qual a data da Venda: (Dia/Mes/Ano)");
				String dataVenda = leitor.nextLine();
				
				vendaController.save(valorVenda, idVendedor, idCarro, dataVenda);
				break;
			}
			
			case"6":{
				
				List<Venda> venda = vendaController.listarTodasVendas();
				System.out.println("===Listar Vendas===");
				if(venda != null) {
					for (Venda vendas : venda) {
						System.out.printf("Id venda: " + vendas.getId()
								+ "\nId Carro: " + vendas.getCarro().getId()
								+ "\nMarca do Carro: " + vendas.getCarro().getMarca()
								+ "\nId Vendedor: " + vendas.getVendedor().getId()
								+ "\nVendedor: " + vendas.getVendedor().getNome()
								+ "\nValor da Venda: " + "%0,3.2f"
								+ "\n", vendas.getValorDaVenda());
					}
				}else {
					System.out.println("Não a vendas....");
				}

				break;
			}
			case"7":{
				System.out.println("===Deletar Todos Os Carros===");
				carroController.deletarTodos();
				break;
			}
			case"8":{
				System.out.println("===Deletar Todos Os Vendedores===");
				vendedorController.deletarTodos();
				break;
			}
			case"9":{
				System.out.println("===Deletar Todos As Vendas===");
				vendaController.deletarTodos();
				break;
			}
			case"10":{
				System.out.println("===Deletar Carro Por ID===");
				System.out.println("Qual o ID do carro que deseja Deletar:");
				Long id = Long.parseLong(leitor.nextLine());
				carroController.deletById(id);
				break;
			}
			case"11":{
				System.out.println("===Atualizar Carro Por ID===");
				System.out.println("Qual o ID do Carro que deseja Atualizar:");
				Long id = Long.parseLong(leitor.nextLine());
				
				System.out.println("Qual a Marca do Carro:");
				String marca = leitor.nextLine();
				
				System.out.println("Qual a Modelo do Carro:");
				String modelo = leitor.nextLine();
				
				carroController.update(id, marca, modelo);
				break;
			}
			case"12":{
				System.out.println("===Deletar Vendedor Por ID===");
				System.out.println("Qual o ID do Vendedor que deseja Deletar:");
				Long id = Long.parseLong(leitor.nextLine());
				vendedorController.deletById(id);
				break;
			}
			case"13":{
				System.out.println("===Atualizar Vendedor Por ID===");
				System.out.println("Qual o ID do Vendedor que deseja Atualizar:");
				Long id = Long.parseLong(leitor.nextLine());
				
				System.out.println("Qual o Nome do Vendedor:");
				String nome = leitor.nextLine();
				
				System.out.println("Qual o CPF do Vendedor:");
				String cpf = leitor.nextLine();
				
				System.out.println("Qual o Sexo do Vendedor:"
						+ "H(Homem)"
						+ "M(Mulher)");
				
				String opSexo = leitor.nextLine().toUpperCase();
				Sexo sexo = null;
				while(sexo == null) {
					if(opSexo.equals("H")) {
						sexo = Sexo.HOMEM;
					}else if(opSexo.equals("M")) {
						sexo = Sexo.MULHER;
					}else {
						System.out.println("Valor Invalido...");
					}
					
				}
				
				vendedorController.uptade(id, nome, cpf, sexo);
				break;
			}
			case"14":{
				System.out.println("===Deletar Venda Por ID===");
				System.out.println("Qual o ID do Venda que deseja Deletar:");
				Long id = Long.parseLong(leitor.nextLine());
				vendaController.deletById(id);
				break;
			}
			case"15":{
				System.out.println("===Atualizar Venda Por ID===");
				System.out.println("Qual o ID do Venda que deseja Atualizar:");
				Long id = Long.parseLong(leitor.nextLine());
				
				System.out.println("Qual o Id do Vendedor:");
				Long idVendedor = Long.parseLong(leitor.nextLine());
				
				System.out.println("Qual o Id do Carro:");
				Long idCarro = Long.parseLong(leitor.nextLine());
				
				System.out.println("Qual o valor da venda:");
				float valorVenda = Float.parseFloat(leitor.nextLine());
				
				System.out.println("Qual a data da Venda: (Dia/Mes/Ano) ");
				String dataVenda = leitor.nextLine();
				
				vendaController.update(id, idCarro, idVendedor, valorVenda, dataVenda);
				break;
			}
			case"0":{
				controle = false;
				break;
			}
			default:
				System.out.println();
			}
			
		}

				

	}

}
