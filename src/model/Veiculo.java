
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
		StringBuilder output = new StringBuilder();
	
		String separator = "+--------------------------------------------------------------------+";
	
		int columnWidth = 50;
	
		output.append(separator).append("\n");
		output.append("|                              Veículo                               |\n");
		output.append(separator).append("\n");
		output.append("| Modelo:          ").append(String.format("%-" + columnWidth + "s", modelo)).append("|\n");
		output.append("| Condutor:        ").append(String.format("%-" + columnWidth + "s", condutor.getName())).append("|\n");
		output.append("| CPF do Condutor: ").append(String.format("%-" + columnWidth + "s", condutor.getCPF())).append("|\n");
		output.append("| Renavan:         ").append(String.format("%-" + columnWidth + "s", renavan)).append("|\n");
		output.append("| Placa:           ").append(String.format("%-" + columnWidth + "s", placa)).append("|\n");
		output.append("| Data:            ").append(String.format("%-" + columnWidth + "s", data)).append("|\n");
		output.append(separator).append("\n");
	
		return output.toString();
	}
	

}
