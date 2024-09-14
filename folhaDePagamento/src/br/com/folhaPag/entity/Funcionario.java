package br.com.folhaPag.entity;

import java.time.LocalDate;

import br.com.folhaPag.enums.EnumIR;
import br.com.folhaPag.enums.EnumInss;
import br.com.folhaPag.interfaces.ImpostoRenda;
import br.com.folhaPag.interfaces.Inss;

public class Funcionario extends Pessoa implements Inss, ImpostoRenda {

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
			descontoInss = this.salarioBruto * (EnumInss.C1.getAliquota() / 100) - EnumInss.C1.getDeducao();

		} else if (this.salarioBruto <= 2666.68) {
			descontoInss = this.salarioBruto * (EnumInss.C2.getAliquota() / 100) - EnumInss.C2.getDeducao();

		} else if (this.salarioBruto <= 4000.03) {
			descontoInss = this.salarioBruto * (EnumInss.C3.getAliquota() / 100) - EnumInss.C3.getDeducao();

		} else if (this.salarioBruto <= 7786.02 || this.salarioBruto >= 7786.02) {
			descontoInss = this.salarioBruto * (EnumInss.C4.getAliquota() / 100) - EnumInss.C4.getDeducao();
		}

		return descontoInss;

	}

	@Override
	public Double calculoIR() {
		if (this.salarioBruto <= 2259.0) {
			descontoIR = 0.0;

		} else if (this.salarioBruto <= 2826.65) {
			descontoIR = ((this.salarioBruto - dependente.getValor() - this.descontoInss) * EnumIR.C2.getAliquota()
					/ 100) - EnumIR.C2.getDecucao();

		} else if (this.salarioBruto <= 3751.05) {
			descontoIR = ((this.salarioBruto - dependente.getValor() - this.descontoInss) * EnumIR.C3.getAliquota()
					/ 100) - EnumIR.C3.getDecucao();

		} else if (this.salarioBruto <= 4664.68) {
			descontoIR = ((this.salarioBruto - dependente.getValor() - this.descontoInss) * EnumIR.C4.getAliquota()
					/ 100) - EnumIR.C4.getDecucao();

		} else if (this.salarioBruto <= 4664.68 || this.salarioBruto >= 4664.68) {
			descontoIR = ((this.salarioBruto - dependente.getValor() - this.descontoInss) * EnumIR.C5.getAliquota()
					/ 100) - EnumIR.C5.getDecucao();

		}

		return descontoIR;
	}

}
