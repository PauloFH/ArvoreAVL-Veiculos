package client;

import java.util.Scanner;

import protocol.Protocol;

public class Client {
	Protocol protocol = new Protocol();

	public void client() {
		Scanner lerx = new Scanner(System.in);
		int x = 1;
		do {
			System.out.println("Escolha como interagir com o servidor de veículos");
			System.out.println("  1 - Adicionar Veículos \n 2 - Alterar Veículos \n 3- Remover Veículos \n 4- Acessar a Quantidade \n 5- Listar Veículos \n 6 - buscar veiculo \n 0 - Fechar o sistema cliente");
			x = lerx.nextInt();
			lerx.nextLine();
			switch (x) {
				case 1:
					protocol.openAcess();
					protocol.cadVeiculos();
					protocol.closeAcess();
					break;
				case 2:
					protocol.openAcess();
					protocol.alterarVeiculos();
					protocol.closeAcess();
					
					break;
				case 3:
				protocol.openAcess();
				protocol.removeVeiculos();
				protocol.closeAcess();
					
					break;
				case 4:
					protocol.openAcess();
					protocol.quantidade();
					protocol.closeAcess();
					break;
				case 5:
					protocol.openAcess();
					protocol.listar();
					protocol.closeAcess();
				break;
				case 6:
					protocol.openAcess();
					protocol.buscar();
					protocol.closeAcess();

				case 0:
					
					break;
			}
		} while (x != 0);
		System.out.println("Fechando Sistema Cliente");
		
		lerx.close();
	}
}
