package HotelCalifornia;

public abstract class Quarto implements InterfaceQuarto{
	private Integer idQuarto;
	private double precoBase;
	private double precoPessoa;
	
	public Quarto(Integer idQuarto, double precoBase, double precoPessoa) {
		this.idQuarto = idQuarto;
		this.precoBase = precoBase;
		this.precoPessoa = precoPessoa;
	}
	
	@Override
	public abstract double valorDaDiaria();
	
	public Integer getIdQuarto() {
		return idQuarto;
	}
	
	public double getPrecoBase() {
		return precoBase;
	}
	
	public double getPrecoPessoa() {
		return precoPessoa;
	}
	
	public String toString() {
		return null;
	}
	
	public abstract int getCapacidade();
	
	@Override
	public abstract String getTipoInstalacao();
}
