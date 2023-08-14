package client_server;

import model.Veiculo;

public class Tree <T>{
	No<T> raiz;
	int rotacoesE;
	int rotacoesD;
	
	public int getRotacoesD() {
		return rotacoesD;
	}

	public void setRotacoesD(int rotacoesD) {
		this.rotacoesD = rotacoesD;
	}

	public int getRotacoesE() {
		return rotacoesE;
	}

	public void setRotacoesE(int rotacoes) {
		this.rotacoesE = rotacoes;
	}

	public Tree() {
		this.setRaiz(null);
		this.rotacoesE = 0;
		this.rotacoesD = 0;
	}

	public No<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(No<T> raiz) {
		this.raiz = raiz;
	}
	public void ordem() {
		this.ordem(getRaiz());
	}
	
	private void ordem(No<T> a){
		
		if(a != null) {
			this.ordem(a.getEsq());
			System.out.println(a.getValor());
			this.ordem(a.getDir());
		}

	}
	
	public int altura(){
		return this.altura(this.getRaiz());
	}
	private Integer altura(No<T> a) {
		
		if(a == null){			
			return -1;}

		return a.alturaNo;
		
	}
	
	private Integer maior(Integer a, Integer b) {
		
		return (a > b) ? a : b;

	}
	
	private Integer obterFB(No<T> a) {
		
		if(a == null)
			return 0;

		return this.altura(a.getEsq()) - this.altura(a.getDir());
	}

	public void inserir(Long k, T v) {

		this.raiz = this.inserir(getRaiz(), k, v);
	}
	
	private No<T> inserir(No<T> a, Long k, T v) {
		
		if(a == null)
			return new No<T>(k, v);
		
		if(a.compareTo(k) > 0)
			a.esq = this.inserir(a.getEsq(), k, v);
		
		else if(a.compareTo(k) < 0)
			a.dir = this.inserir(a.getDir(), k, v);
		
		else
			return a;
		
		/*2. Atualiza altura do ancestral do nó inserido */
		
		a.alturaNo = 1 + 
				this.maior(this.altura(a.getEsq()), this.altura(a.getDir()));
		
		/*3. Obter FB */
		
		int fb = this.obterFB(a);
		int fbEsq = this.obterFB(a.getEsq());
		int fbDir = this.obterFB(a.getDir());
		
		
		if(fb > 1 && fbEsq >= 0){
			return this.rds(a);
		}
		if(fb > 1 && fbEsq < 0) {
			
			 a.esq = this.res(a.esq);
			 return rds(a);
		}	 
			
		if(fb < -1 && fbDir <= 0){
			return this.res(a);
	}
		if(fb < -1 && fbDir > 0) {
			
			a.dir = this.rds(a.dir);
			return res(a);
		}	
		return a;
	}
	
	private No<T> res(No<T> x) {
		rotacoesE++;
		No<T> y = x.getDir();
		No<T> z = y.getEsq();
		
		// executa rotação
		
		y.setEsq(x);
		x.setDir(z);
		
		x.alturaNo = 1 + this.maior(altura(x.getEsq()), altura(x.getDir()));
		y.alturaNo = 1 + this.maior(altura(y.getEsq()), altura(y.getDir()));

		return y;
	}
	
	private No<T> rds(No<T> y) {
	rotacoesD++;
		No<T> x = y.getEsq();
		No<T> z = x.getDir();
		
		// executa rotação
		
		x.setDir(y);
		y.setEsq(z);;
		
		y.alturaNo = 1 + this.maior(altura(y.getEsq()), altura(y.getDir()));
		x.alturaNo = 1 + this.maior(altura(x.getEsq()), altura(x.getDir()));
		
		return x;
	}
	public void remover(Long k) {

		No<T> x = buscar(k);
		this.raiz = this.remover(getRaiz(), k, x.valor);
	}
	private No<T> remover(No<T> arv,Long ch , T v) {
		
		No<T> x = buscar(ch);

		/* Executar remoção em ABB */
		if(arv == null)
			return arv;
		if(ch < arv.getChave()) {
			arv.esq = remover(arv.esq, ch, x.valor);
		}else if(ch > arv.chave) {
			arv.dir = remover(arv.dir, ch, x.valor);
		}
		/* chave ch == no.chave: nó a ser removido */
			else {
				/* achou o nó a remover */
				/* caso 1: nó sem filhos */
				if(arv.esq == null && arv.dir ==null) {
					arv = null;
				}
				/* caso 2: nó só tem filho à direita */
				else if(arv.esq ==null){
					No<T> temp = arv;
					arv = temp.dir;
					temp = null;
				}
				/* caso 2: só tem filho à esquerda */
				else if(arv.dir == null) {
					No<T> temp = arv;
					arv = temp.esq;
					temp = null;
				}
				else {
					
				/*Nó com 2 filhos: pegue o sucessor do percurso em ordem
				* Menor chave da subárvore direita do nó */
					No<T> temp = MenorChave(arv.dir);
					arv.chave = temp.chave;
					arv.valor = temp.valor;
					temp.chave = ch;
					arv.dir = remover(arv.dir, ch,  x.valor);
				}
		}
		if(arv == null) {
			return arv;
		}
		/* 2. Atualiza altura do ancestral (pai) do nó inserido */
		arv.alturaNo = 1 + maior(altura(arv.esq), altura(arv.dir));

		/* 3. Obtenha o fator de balanceamento deste nó ancestral
		* para verificar se ele se tornou desbalanceado */
	
		int fb = obterFB(arv);
		int fbSubArvEsq = obterFB(arv.esq);
		int fbSubArvDir = obterFB(arv.dir);
	
		/* Se ele se tornar desbalanceado, então são 4 casos
		* a serem analisados */
		
		// Rotação direita simples
		if(fb > 1 && fbSubArvEsq >= 0)
		return rds(arv);
		// Rotação esquerda simples
		if(fb < -1 && fbSubArvDir <= 0 )
		return res(arv);
		// Rotação dupla direita
		if(fb > 1 && fbSubArvEsq < 0) {
		arv.esq = res(arv.esq);
		return rds(arv);
		}
		// Rotação dupla esquerda
		if (fb < -1 && fbSubArvDir > 0) {
		arv.dir = rds(arv.dir);
		return res(arv);
		}
		return arv;
	}
	
	
	
	No<T> MenorChave(No<T> arv){
		No<T> temp = arv;
		if(temp == null)
		return null;
		while(temp.esq != null)
		temp = temp.esq;
		return temp;
		}
	






	public No<T> buscar(Long ch) {

		return this.buscar(this.getRaiz(), ch);
	}
	private No<T> buscar(No<T> arv, long ch){
		if(arv == null)
		 return null;
		else if(arv.chave > ch)
		return buscar(arv.esq, ch);
		else if(arv.chave < ch)
		return buscar(arv.dir, ch);
		else
			
		return arv;
		}
	
		public No<Veiculo> buscar(Long ch, String placa) {
			return this.buscar((No<Veiculo>) this.getRaiz(), ch, placa);
			
		}
	private No<Veiculo> buscar(No<Veiculo> arv,long ch ,String placa){
		if(arv == null)
		 return null;
		else if(arv.chave > ch)
		return buscar(arv.esq, ch, placa);
		else if(arv.chave < ch)
		return buscar(arv.dir, ch,placa);
		else
			if(arv.valor.getPlaca() == placa){
				return arv;
			}
			else{
				System.out.println("Erro: Placa do carro não bate com o renavam");
				return	null;
			}
		
		}











		
	public No<T> alterar(Long renavan, T v) {
		return this.alterar(this.getRaiz(), renavan, v);
	}

	private No<T> alterar(No<T> arv, Long ch, T v) {

		No<T> b = buscar(ch);
			if(b != null) {
				b.setValor(v);
				return b;
			}else{
				return null;
			}
	
	}
		public int quantidade(){
			return quantidade(this.raiz);
		}
		private int quantidade(No<T> arv){

		if(arv == null)
			return 0;
		else
			return 1 + quantidade(arv.esq) + quantidade(arv.dir);
	}

}

	


