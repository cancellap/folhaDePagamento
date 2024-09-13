package br.com.folhaPag.enums;

public enum EnumIR {
	
	 C2(7.5,169.44), C3(15.0,381.44), C4(22.5,662.77), C5(27.5,898.00);
	
	private Double aliquota;
	private Double decucao;
	
	
	private EnumIR(Double aliquota, Double decucao) {
		this.aliquota = aliquota;
		this.decucao = decucao;
	}
	
	public Double getAliquota() {
		return aliquota;
	}
	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}
	public Double getDecucao() {
		return decucao;
	}
	public void setDecucao(Double decucao) {
		this.decucao = decucao;
	}
	
	
	
}
