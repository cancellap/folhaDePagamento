package br.com.folhaPag.enums;

public enum EnumIR {

	C2(7.5, 169.44), C3(15.0, 381.44), C4(22.5, 662.77), C5(27.5, 896.00);

	private final Double aliquota;
	private final Double deducao;

	private EnumIR(Double aliquota, Double decucao) {
		this.aliquota = aliquota;
		this.deducao = decucao;
	}

	
	public Double getAliquota() {
		return aliquota;
	}

	public Double getDecucao() {
		return deducao;
	}

}
