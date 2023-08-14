package client_server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.InvalidDataException;
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
          Scanner lex1;
        try{
         lex1 = new Scanner(System.in);
		 	String modelo;
			String cpf;
			String nome;
			Long renavan;	
			String placa;
			int data = 0;
			System.out.println("Adicionar Veículos\n");
			System.out.print("marca do veículo: ");
			modelo = lex1.nextLine();
			System.out.print("placa do veículo: ");
			placa = lex1.nextLine();
			System.out.print("renavan do veículo: ");
			renavan = lex1.nextLong();
			System.out.print("data de fabricação do veículo: ");
			data = lex1.nextInt();
			lex1.nextLine();
			System.out.print("nome do condutor do veículo do veículo: ");
			nome = lex1.nextLine();
			System.out.print("CPF do condutor do veículo do veículo: ");
			cpf = lex1.nextLine();
			Veiculo v = new Veiculo(modelo,renavan , placa, data, nome, cpf);
        if (dadosInvalidos(modelo, placa, renavan, data, nome, cpf)) {
            throw new InvalidDataException("Dados de entrada inválidos. Verifique as informações e tente novamente.");
        }

                 writerAc("Adicionado Veiculo placa " + placa);
				server.inserir(renavan, v);
               int a =  Server.avl.altura();
                writerAc("Altura da arvore: "+ a);
                 System.out.println("Adicionado o Veículo placa: " + placa); 
            writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ " rotações a direita");
			} catch (InvalidDataException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
            };

	 }
      
	public void removeVeiculos() {
		  Scanner lex2 = new Scanner(System.in);
        Long renavan;
        System.out.println("Remover Veículos\n");
        
        try{
        System.out.print("Digite renavan do veículo: ");
           renavan = lex2.nextLong();
           server.remover(renavan);
              writerAc("Remoção de veículo Realizada no veiculo: "+ renavan);
               writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ " rotações a direita");
                int a =  Server.avl.altura();
                writerAc("Altura da arvore: "+ a);
              System.out.println("Veículo removido com sucesso");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
    
    public void alterarVeiculos(){
        try{
         Scanner lex3 = new Scanner(System.in);
		 	String modelo;
			String cpf;
			String nome;
			Long renavan = (long) 0;	
			String placa;
			int data = 0;
            System.out.print("Digite o renavam do veículo que você quer alterar: ");
			renavan = lex3.nextLong();
			lex3.nextLine();
			System.out.print("marca do veículo: ");
			modelo = lex3.nextLine();
			System.out.print("placa do veículo: ");
			placa = lex3.nextLine();
			System.out.print("data de fabricação do veículo: ");
			data = lex3.nextInt();
			lex3.nextLine();
			System.out.print("nome do condutor do veículo do veículo: ");
			nome = lex3.nextLine();
			System.out.print("CPF do condutor do veículo do veículo: ");
			cpf = lex3.nextLine();
			Veiculo v = new Veiculo(modelo,renavan , placa, data, nome, cpf);
            if (dadosInvalidos(modelo, placa, renavan, data, nome, cpf)) {
            throw new InvalidDataException("Dados de entrada inválidos. Verifique as informações e tente novamente.");
        }
			
				server.alterar(renavan, v);
                System.out.println("Veículo alterado com sucesso");
                writerAc("Altura da arvore: "+ Server.avl.altura());
                 writerAc("Alteraçao de veiculo Realizada no veiculo: "+ renavan);
        writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ " rotações a direita");
			} catch (InvalidDataException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
            };
    }
    public No<Veiculo> buscarVeiculos(){
        
        Scanner lex4= new Scanner(System.in);
        Long renavan;
        System.out.println("Buscar Veículos\n");
        
        
        System.out.print("Digite renavan do veículo: "); 
           renavan = lex4.nextLong();
           lex4.nextLine();
                System.out.print("Digite a placa do veículo: ");
                String placa = lex4.nextLine();

           No<Veiculo> v = server.buscar(renavan, placa);
          if(v != null){
                System.out.println("Veículo encontrado");
                System.out.println(v.getValor().toString());
          }else{
            System.out.println("Veículo Não encontrado");
          }              
          writerAc("Busca de veiculos Realizada");

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
             writerAc("Foram realizadas "+ server.rotacoesE()+ " rotações a esquerda e "+ server.rotacoesD()+ " rotações a direita");
       
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
    Scanner l = new Scanner(System.in);
    Long renavan;
    System.out.println("Buscar Veículos\n");
    
    
    System.out.print("Digite renavan do veículo: ");
       renavan = l.nextLong();
       l.nextLine();
         System.out.print("Digite a placa do veículo: ");
         String placa = l.nextLine();
       No<Veiculo> v = server.buscar(renavan, placa);
      if(v != null){
            System.out.println("Veículo encontrado");
            System.out.println(v.getValor().toString());
      }                   
      writerAc("Busca de veículos Realizada");

}
public  boolean dadosInvalidos(String modelo, String placa, Long renavan, int data, String nome, String cpf) {

    if (modelo == null || placa == null || renavan == null || nome == null || cpf == null) {
        return true;
    }
    if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
        return true;
    }

    
    if (String.valueOf(renavan).length() > 12) {
        return true;
    }

    return false;
}
}