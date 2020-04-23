package forum17042020;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;
import java.util.Optional;

public class Boleto {
	private String nomePagador;
	private String nomeBeneficiario;
	private Calendar dataVencimento;
	private BigDecimal valorBoleto;
	
	public Boleto() {}

	public Boleto(String nomePagador, String nomeBeneficiario, Calendar dataVencimento, BigDecimal valorBoleto) {
		setNomePagador(nomePagador);
		setNomeBeneficiario(nomeBeneficiario);
		setDataVencimento(dataVencimento);
		setValorBoleto(valorBoleto);
	}


	public String getNomePagador() {
		if(!Optional.ofNullable(nomePagador).isPresent()) {
			throw new IllegalArgumentException("Nome do pagador esta null");
		}
		return nomePagador; 
	}

	public String getNomeBeneficiario() {
		if(!Optional.ofNullable(nomeBeneficiario).isPresent()) {
			throw new IllegalArgumentException("Nome do beneficiario esta null");
		}
		return nomeBeneficiario;
	}

	public Calendar getDataVencimento() {
		if(!Optional.ofNullable(dataVencimento).isPresent()) {
			throw new IllegalArgumentException("Data de vencumento esta null");
		}
		return dataVencimento;
	}
	
	public BigDecimal getValorBoleto() {
		if(!Optional.ofNullable(valorBoleto).isPresent()) {
			throw new IllegalArgumentException("Valor do boleto null");
		}
		return valorBoleto;
	}
	
	public void setNomePagador(String nomePagador) {
		if(Objects.isNull(nomePagador)  || nomePagador.isEmpty()) {
			throw new IllegalArgumentException("Não é permitido nome vazio ou nulo");
		}
		this.nomePagador = nomePagador;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		if(Objects.isNull(nomeBeneficiario)  || nomeBeneficiario.isEmpty()) {
			throw new IllegalArgumentException("Não é permitido nome vazio ou nulo");
		}
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);

		if(Objects.isNull(dataVencimento) || dataVencimento.before(dataAtual)) {
			throw new IllegalArgumentException("Data de vencimento não pode ser menor que a data atual ");
		}
		this.dataVencimento = dataVencimento;
	}

	public void setValorBoleto(BigDecimal valorBoleto) {
		if(Objects.isNull(valorBoleto) || valorBoleto.doubleValue() < 0.00) {
			throw new IllegalArgumentException("Valor não pode ser menor que R$0.00");
		}
		this.valorBoleto = valorBoleto;
	}

}
