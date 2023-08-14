package server;

import java.util.Scanner;


import model.*;

public class Server {
	public static Tree<Veiculo> avl;

	Scanner ler = new Scanner(System.in);
	
	public Server() {
		avl = new Tree<Veiculo>();

	}
    public void inserir(Long renavan, Veiculo v) {
		avl.inserir(renavan, v);
    }
	public void remover(Long renavan) {
		avl.remover(renavan);
	}
	public void alterar(Long renavan, Veiculo v) {
		avl.alterar(renavan, v);
	}
	
	public No<Veiculo> buscar(Long renavan, String placa) {
		return avl.buscar(renavan, placa);
	}
	public int quantidade() {
		return avl.quantidade();
	}




	

}
