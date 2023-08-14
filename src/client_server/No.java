package client_server;

public class No<T> implements Comparable<Long>{

	Long chave;
	T valor;
	Integer alturaNo;
	No<T> esq, dir;
	
	public No(Long k, T v) {
		
		this.setChave(k);
		this.setValor(v);
		this.setAlturaNo(0);
		this.setEsq(null);
		this.setDir(null);
		
	}
	
	public int getAlturaNo() {
		return alturaNo;
	}

	public void setAlturaNo(int alturaNo) {
		this.alturaNo = alturaNo;
	}

	public Long getChave() {
		return chave;
	}
	public void setChave(Long chave) {
		this.chave = chave;
	}
	public T getValor() {
		
		return valor;
	}
	public void setValor(T v) {
		this.valor = v;
	}
	public No<T> getEsq() {
		return esq;
	}
	public void setEsq(No<T> esq) {
		this.esq = esq;
	}
	public No<T> getDir() {
		return dir;
	}
	public void setDir(No<T> dir) {
		this.dir = dir;
	}
	
	@Override
	public int compareTo(Long o) {
		
		if(this.getChave() < o)
			return -1;
		if(this.getChave() > o)
			return 1;
		
		return 0;
	}

	
	
}
