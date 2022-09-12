package br.ifpb.edu.dac.tarcizo.projetojpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ifpb.edu.dac.tarcizo.projetojpa.control.CarroControler;
import br.ifpb.edu.dac.tarcizo.projetojpa.model.entity.Carro;


@SpringBootApplication
public class ProjetoJpaApplication implements CommandLineRunner{

	@Autowired
	private CarroControler carroController;
	
	
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
			System.out.println("1 - Criar "
					+ "\n2 - Listar Tudo"
					+ "\n3 - Deletar Tudo"
					+ "\n4 - Sair");
			String op = leitor.nextLine();
			switch (op) {
			case "1": {
				carroController.create();
				
				break;
			}
			
			case "2":{
				List<Carro> carro = carroController.list();
				
				for (Carro carro2 : carro) {
					System.out.println(carro2.toString());
				}
				
				break;
			}
			case "3":{
				carroController.delet();
				
				break;
			}
			case"4":{
				controle = false;
				break;
			}
			default:
				System.out.println();
			}
			
		}

				

	}

}
