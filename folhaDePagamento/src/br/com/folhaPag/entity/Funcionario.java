package br.com.folhaPag.entity;

import java.time.LocalDate;

import br.com.folhaPag.enums.EnumInss;
import br.com.folhaPag.interfaces.Inss;

public class Funcionario extends Pessoa implements Inss {

	private Double salarioBruto;
	private Double descontoInss;
	private Double descontoIR;
	private Dependente dependente;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	@Override
	public String toString() {
		return "Funcionario [salarioBruto=" + salarioBruto + ", descontoInss=" + descontoInss + ", descontoIR="
				+ descontoIR + ", dependente=" + dependente + "]";
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Double getDescontoInss() {
		return descontoInss;
	}

	public void setDescontoInss(Double descontoInss) {

		this.descontoInss = descontoInss;
	}

	public Double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(Double descontoIR) {
		this.descontoIR = descontoIR;
	}

	@Override
	public Double calculoInss() {
		if (this.salarioBruto <= 1412.0) {
			descontoInss = this.salarioBruto * (EnumInss.C1.getAliquota()/100) - EnumInss.C1.getDeducao();

		} else if (this.salarioBruto <= 2666.68) {

			descontoInss = this.salarioBruto * (EnumInss.C2.getAliquota()/100) - EnumInss.C2.getDeducao();

		} else if (this.salarioBruto <= 4000.03) {
			descontoInss = this.salarioBruto * (EnumInss.C3.getAliquota()/100) - EnumInss.C3.getDeducao();

		} else if (this.salarioBruto <= 7786.02 || this.salarioBruto >= 7786.02) {
			descontoInss = this.salarioBruto * (EnumInss.C4.getAliquota()/100) - EnumInss.C4.getDeducao();
		}

		return descontoInss;

	}

}
