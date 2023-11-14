package HotelCalifornia;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class QuartoDouble extends Quarto {
	private List<String> pedidos;
	
	public QuartoDouble(Integer id, double precoB, double precoP, List<String> lista) {
		super(id, precoB, precoP);
		this.pedidos = lista;
	}
	
	public double valorDaDiaria() {
		return super.getPrecoBase() + (super.getPrecoPessoa() * 2);
	}

	public List<String> getListaDeMelhorias() {
		return pedidos;
	}

	public void setListaDeMelhorias(List<String> listaDeMelhorias) {
		this.pedidos = listaDeMelhorias;
	}
	
	public String verificaPedido() {
		if(pedidos == null) {
			return "(nenhum)";
		}
		return Arrays.toString(pedidos.toArray());
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.CEILING);
		return "[" + super.getIdQuarto() + "] Quarto Double (custo basico: R$)" + df.format(super.getPrecoBase()) + 
				"; por pessoa R$" + df.format(super.getPrecoPessoa()) + ">>> R$" + df.format(valorDaDiaria()) + " diária). Pedidos: " 
		+ verificaPedido() ;
	}
	
	public int getCapacidade() {
		return 2;
	}
	
	@Override
	public String getTipoInstalacao() {
		return "Quarto double".toUpperCase();
	}
	
}
