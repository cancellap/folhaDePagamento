package br.com.folhaPag.entity;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

	private Double salarioBruto;
	private Double descontoInss;
	private Double descontoIR;
	private Dependente dependente;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto, Double descontoInss,
			Double descontoIR, Dependente dependente) {

		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIR = descontoIR;
		this.dependente = dependente;

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

}
