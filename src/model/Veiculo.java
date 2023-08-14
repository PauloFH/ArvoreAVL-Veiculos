
package model;

public class Veiculo {
	private String modelo;
	private Condutor condutor;
	private Long renavan;	
	private String placa;
	private int data;
	
	public Veiculo( String modelo,Long renavan, String placa, int data,String nomecondutor, String cpf) {
			this.condutor = new Condutor(nomecondutor, cpf);
			this.modelo  = modelo;
			this.data= data;
			this.placa = placa;
			this.renavan = renavan;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		
		this.condutor = condutor;
	}
	public void setCondutor(String name, String cpf) {
		
		this.condutor =  new Condutor(name, cpf);
		
	}
	public Long getRenavan() {
		return renavan;
	}
	public void setRenavan(Long renavan) {
		this.renavan = renavan;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Veiculo \n modelo=" + modelo + "\n nome do condutor=" + condutor.getName() +"\ncpf do condutor =" + condutor.getCPF()+ "\n renavan=" + renavan + "\n placa=" + placa
				+ "\n data=" + data + "\n\n\n\n";
	}
	

	

}
