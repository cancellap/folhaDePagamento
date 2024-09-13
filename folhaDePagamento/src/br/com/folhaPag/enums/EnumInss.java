package br.com.folhaPag.enums;

public enum EnumInss {
	
	C1(7.5,0.0), C2(9.0,21.18), C3(12.0,101.18), C4(14.0,181.18);
	
	public final Double aliquota;
	public final Double deducao;
	
	
	private EnumInss(Double aliquota, Double deducao) {
		this.aliquota = aliquota;
		this.deducao = deducao;
	}


	public Double getAliquota() {
		return aliquota;
	}


	public Double getDeducao() {
		return deducao;
	}
	
	
	

}
