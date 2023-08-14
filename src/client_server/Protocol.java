package client_server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Veiculo;

public class Protocol {

    Server server;
    public static BufferedWriter gravarArq;
	FileWriter aql;
    public Protocol(){
        try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd_MM_yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("_HH_mm_ss").format(dataHoraAtual);
			String name = data+hora+ "_log";
			aql = new FileWriter(name+".txt");
			gravarArq = new BufferedWriter(aql);
            server = new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}      
    }
	
	public void openAccess() {
        System.out.print("Tentando iniciar conexão");
        
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500); // Aguarda 0.5 segundos
                System.out.print("."); // Imprime um ponto para simular a barra girando
            }
            
            System.out.println("\nConexão com o servidor feita com sucesso");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void cadVeiculos(){
        Scanner lex = new Scanner(System.in);
		 	String modelo;
			String cpf;
			String nome;
			Long renavan;	
			String placa;
			int data = 0;
			System.out.println("Adicionar Veículos\n");
			System.out.print("marca do veículo: ");
			modelo = lex.nextLine();
			System.out.print("placa do veículo: ");
			placa = lex.nextLine();
			System.out.print("renavan do veículo: ");
			renavan = lex.nextLong();
			System.out.print("data de fabricação do veículo: ");
			data = lex.nextInt();
			lex.nextLine();
			System.out.print("nome do condutor do veículo do veículo: ");
			nome = lex.nextLine();
			System.out.print("CPF do condutor do veículo do veículo: ");
			cpf = lex.nextLine();
			Veiculo v = new Veiculo(modelo,renavan , placa, data, nome, cpf);

			try {
                 writerAc("Adicionado Veiculo placa " + placa);
				server.inserir(renavan, v);
               int a =  Server.avl.altura();
                writerAc("Altura da arvore: "+ a);
                 System.out.println("Adicionado o Veículo placa: " + placa); 
            writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ "rotações a direita");
			} catch (Exception e) {
			}
            lex.close();
	 }
      
	public void removeVeiculos() {
		  Scanner leitex = new Scanner(System.in);
        Long renavan;
        System.out.println("Remover Veículos\n");
        
        
        System.out.print("Digite renavan do veículo: ");
           renavan = leitex.nextLong();
           server.remover(renavan);
              writerAc("Remoção de veículo Realizada no veiculo: "+ renavan);
               writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ "rotações a direita");
                int a =  Server.avl.altura();
                writerAc("Altura da arvore: "+ a);
              System.out.println("Veículo removido com sucesso");
              leitex.close();
        }
    
    public void alterarVeiculos(){
         Scanner leitex = new Scanner(System.in);
		 	String modelo;
			String cpf;
			String nome;
			Long renavan = (long) 0;	
			String placa;
			int data = 0;
            System.out.print("Digite o renavam do veículo que você quer alterar: ");
			renavan = leitex.nextLong();
			leitex.nextLine();
			System.out.print("marca do veículo: ");
			modelo = leitex.nextLine();
			System.out.print("placa do veículo: ");
			placa = leitex.nextLine();
			System.out.print("data de fabricação do veículo: ");
			data = leitex.nextInt();
			leitex.nextLine();
			System.out.print("nome do condutor do veículo do veículo: ");
			nome = leitex.nextLine();
			System.out.print("CPF do condutor do veículo do veículo: ");
			cpf = leitex.nextLine();
			Veiculo v = new Veiculo(modelo,renavan , placa, data, nome, cpf);

			try {
				server.alterar(renavan, v);
                System.out.println("Veículo alterado com sucesso");
                writerAc("Altura da arvore: "+ Server.avl.altura());
			} catch (Exception e) {
			}
        writerAc("Alteraçao de veiculo Realizada no veiculo: "+ renavan);
        writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ "rotações a direita");
        leitex.close();
    }
    public No<Veiculo> buscarVeiculos(){
        
        Scanner  leitex = new Scanner(System.in);
        Long renavan;
        System.out.println("Buscar Veículos\n");
        
        
        System.out.print("Digite renavan do veículo: ");
           renavan = leitex.nextLong();
           leitex.nextLine();
                System.out.print("Digite a placa do veículo: ");
                String placa = leitex.nextLine();
           No<Veiculo> v = server.buscar(renavan, placa);
          if(v != null){
                System.out.println("Veículo encontrado");
                System.out.println(v.getValor().toString());
          }else{
            System.out.println("Veículo Não encontrado");
          }              
          writerAc("Busca de veiculos Realizada");
                    leitex.close();
          return v;


    }
    public void quantidade(){

        System.out.println("Quantidade de Veículos\n");
        int x = server.quantidade();
        System.out.println("Quantidade de veículos: "+x);
         writerAc("Contagem de veículos Realizada: " + x);
    }


    public void  closeAcess(){
        System.out.print("Tentando finalizar conexão");
        
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500); // Aguarda 0.5 segundos
                System.out.print("."); // Imprime um ponto para simular a barra girando
            }
            
            System.out.println("\nConexão com o servidor finalizada com sucesso");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void listar(){
        System.out.println("Listar Veículos\n");
        Server.avl.ordem();
        writerAc("Listagem de Veículos Realizada");

    }

   public void inserir(Long k, Veiculo v){
        
        server.inserir(k, v);
          writerAc("Adicionar Veículos realizada de veiculo: " + v.getPlaca());
            int a =  Server.avl.altura();
                writerAc("Altura da arvore: "+ a);
             writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ "rotações a direita");
       
   }
public void  writerAc(String text) {
    try {
        gravarArq.write(text + "\n");
        gravarArq.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void buscar() {
    Scanner leitex = new Scanner(System.in);
    Long renavan;
    System.out.println("Buscar Veículos\n");
    
    
    System.out.print("Digite renavan do veículo: ");
       renavan = leitex.nextLong();
       leitex.nextLine();
         System.out.print("Digite a placa do veículo: ");
         String placa = leitex.nextLine();
       No<Veiculo> v = server.buscar(renavan, placa);
      if(v != null){
            System.out.println("Veículo encontrado");
            System.out.println(v.getValor().toString());
      }                   
      writerAc("Busca de veículos Realizada");
      leitex.close();
}

}