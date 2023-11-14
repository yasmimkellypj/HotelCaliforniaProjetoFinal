package HotelCalifornia;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class QuartoFamily extends Quarto {
	private List<String> pedidos;
	private int capacidade;
	
	public QuartoFamily(Integer id, double precoB, double precoP, List<String> pedidos, int capacidade) {
		super(id, precoB, precoP);
		this.pedidos = pedidos;
		this.capacidade = capacidade;
	}
	
	public double valorDaDiaria() {
		return super.getPrecoBase() + (super.getPrecoPessoa() * capacidade);
	}

	public List<String> getListaDePedidos() {
		return pedidos;
	}

	public void setListaDePedidos(List<String> listaDePedidos) {
		this.pedidos = listaDePedidos;
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
		return "[" + super.getIdQuarto() + "] Quarto Family (custo basico: R$)" + df.format(super.getPrecoBase()) + 
				"; por pessoa R$" + df.format(super.getPrecoPessoa()) + ">>> R$" + df.format(valorDaDiaria()) + " diária). Capacidade: " +
		capacidade +" pessoa(s). Pedidos: " + verificaPedido() ;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	@Override
	public String getTipoInstalacao() {
		return "Quarto Family".toUpperCase();
	}
}
