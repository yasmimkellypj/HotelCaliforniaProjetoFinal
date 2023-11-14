package HotelCalifornia;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class QuartoSingle extends Quarto {
	
	public QuartoSingle(Integer id, double precoB, double precoP) {
		super(id, precoB, precoP);
	}
	
	public double valorDaDiaria() {
		return super.getPrecoBase() + super.getPrecoPessoa();
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.CEILING);
		return "[" + super.getIdQuarto() + "] Quarto Single (custo basico: R$)" + df.format(super.getPrecoBase()) + "; por pessoa R$" + df.format(super.getPrecoPessoa()) + ">>> R$" + df.format(valorDaDiaria()) + " diária)";
	}
	
	public int getCapacidade() {
		return 1;
	}
	
	@Override
	public String getTipoInstalacao() {
		return "Quarto single".toUpperCase();
	}
}
