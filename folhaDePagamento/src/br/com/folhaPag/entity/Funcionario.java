package br.com.folhaPag.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import br.com.folhaPag.enums.EnumIR;
import br.com.folhaPag.enums.EnumInss;
import br.com.folhaPag.interfaces.ImpostoRenda;
import br.com.folhaPag.interfaces.Inss;

public class Funcionario extends Pessoa implements Inss, ImpostoRenda {

	private Double salarioBruto;
	private Double descontoInss;
	private Double descontoIR;
	private List<Dependente> dependentes;
	private Double soma;
	private Double salarioLiquido;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto,
			List<Dependente> dependentes) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.dependentes = dependentes;
	}

	public Funcionario(String nome, String cpf, LocalDate dataNascimento) {
		super(nome, cpf, dataNascimento);
	}

	@Override
	public String toString() {
		return super.toString() + "; Salário Bruto: " + salarioBruto + "; Desconto Inss:"
				+ String.format("%.2f", descontoInss) + "; Desconto IR: " + String.format("%.2f", descontoIR) + "\n "
				+ dependentes;
	}

	public Double getSoma() {
		return soma;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public List<Dependente> getDependentes() {

		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Double somaDependente() {

		if (dependentes == null || dependentes.isEmpty()) {
			soma = 0.0; // Se não houver dependentes, retorna 0
			return soma;
		}

		soma = 0.0;
		for (Dependente dp : dependentes) {
			soma += dp.getValor();
		}
		return this.soma;
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
		descontoInss = 0.;
		if (this.salarioBruto <= 1412.0) {
			descontoInss = this.salarioBruto * (EnumInss.C1.getAliquota() / 100) - EnumInss.C1.getDeducao();

		} else if (this.salarioBruto <= 2666.68) {
			descontoInss = this.salarioBruto * (EnumInss.C2.getAliquota() / 100) - EnumInss.C2.getDeducao();

		} else if (this.salarioBruto <= 4000.03) {
			descontoInss = this.salarioBruto * (EnumInss.C3.getAliquota() / 100) - EnumInss.C3.getDeducao();

		} else if (this.salarioBruto <= 7786.02) {
			descontoInss = this.salarioBruto * (EnumInss.C4.getAliquota() / 100) - EnumInss.C4.getDeducao();
		} else {
			descontoInss = 7786.02 * (EnumInss.C4.getAliquota() / 100) - EnumInss.C4.getDeducao();
		}

		return descontoInss;

	}

	@Override
	public Double calculoIR() {
		this.somaDependente();
		if (this.salarioBruto <= 2259.0) {
			descontoIR = 0.0;

		} else if (this.salarioBruto <= 2826.65) {
			descontoIR = (((this.salarioBruto - this.soma - this.descontoInss) * EnumIR.C2.getAliquota() / 100)
					- EnumIR.C2.getDecucao());

		} else if (this.salarioBruto <= 3751.05) {
			descontoIR = (((this.salarioBruto - this.soma - this.descontoInss) * EnumIR.C3.getAliquota() / 100)
					- EnumIR.C3.getDecucao());

		} else if (this.salarioBruto <= 4664.68) {
			descontoIR = (((this.salarioBruto - this.soma - this.descontoInss) * EnumIR.C4.getAliquota() / 100)
					- EnumIR.C4.getDecucao());

		} else if (this.salarioBruto >= 4664.68) {
			descontoIR = (((this.salarioBruto - this.soma - this.descontoInss) * EnumIR.C5.getAliquota() / 100)
					- EnumIR.C5.getDecucao());
		}

		if (descontoIR < 0) {
			descontoIR = 0.0;
		}

		return descontoIR;

	}

	public Double calcularSalarioLiquido() {
		return salarioBruto - descontoInss - descontoIR;
	}

}
