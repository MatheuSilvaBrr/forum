package forum17042020;

import java.math.BigDecimal;
import java.util.Calendar;

public class AppBoleto {
	public static void main(String[] args) {
		Boleto boleto = new Boleto();
		
		Calendar dataAnterior = Calendar.getInstance();
		dataAnterior.set(Calendar.DAY_OF_MONTH, 20);
		try {
			boleto.setDataVencimento(dataAnterior);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			boleto.setValorBoleto(new BigDecimal(-35.0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Boleto boletoInternet = new Boleto("Matheus da Silva", "Mercado Pago LTDA", Calendar.getInstance(), new BigDecimal(399.00));
		System.out.println(boletoInternet.getValorBoleto());
		
		boletoInternet.setNomeBeneficiario("Cleber");
		
		System.out.println(boletoInternet.getNomeBeneficiario());
		
		try {
			boletoInternet.setNomePagador("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	}
}
