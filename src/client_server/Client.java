package client_server;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.InputNotAnIntegerException;

public class Client {
	Protocol protocol = new Protocol();

	public void client() {
        
		Scanner lerx;
		int x = 1;
		do {
            try{
                lerx = new Scanner(System.in);
            System.out.println("+----------------------------------------------------+");
            System.out.println("|             Escolha uma opção abaixo              |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| 1 - Adicionar Veículos                            |");
            System.out.println("| 2 - Alterar Veículos                              |");
            System.out.println("| 3 - Remover Veículos                              |");
            System.out.println("| 4 - Acessar a Quantidade                          |");
            System.out.println("| 5 - Listar Veículos                               |");
            System.out.println("| 6 - Buscar Veículo                                |");
            System.out.println("| 0 - Fechar o sistema cliente                      |");
            System.out.println("+----------------------------------------------------+");
            x = lerx.nextInt();
            lerx.nextLine();  // Limpar a nova linha após a leitura do número

            switch (x) {
                case 1:
                    System.out.println("+-- Adicionar Veículos ----------------------------+");
                    protocol.openAccess();
					protocol.cadVeiculos();
					protocol.closeAcess();
                    break;
                case 2:
                    System.out.println("+-- Alterar Veículos ------------------------------+");
                    protocol.openAccess();
					protocol.alterarVeiculos();
					protocol.closeAcess();
                    break;
                case 3:
                    System.out.println("+-- Remover Veículos ------------------------------+");
                    protocol.openAccess();
					protocol.removeVeiculos();
					protocol.closeAcess();
                    break;
                case 4:
                    System.out.println("+-- Acessar a Quantidade --------------------------+");
                	protocol.openAccess();
					protocol.quantidade();
					protocol.closeAcess();
                    break;
                case 5:
                    System.out.println("+-- Listar Veículos -------------------------------+");
                    protocol.openAccess();
					protocol.listar();
					protocol.closeAcess();
                    break;
                case 6:
                    System.out.println("+-- Buscar Veículo --------------------------------+");
                    protocol.openAccess();
					protocol.buscar();
					protocol.closeAcess();
                    break;
                case 0:
                    System.out.println("Fechando Sistema Cliente");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        }catch(InputMismatchException e){
            System.out.println("Entrada inválida. Digite um número inteiro.");
        }catch (InputNotAnIntegerException e) {
            System.out.println(e.getMessage());}

        } while (x != 0);
		
	}
}
