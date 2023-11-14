package HotelCalifornia;

public abstract class Pagamento {
	private int id;
	private double percentual;
	private double valorDoPagamento;
	private String tipoPagamento;
	private String status;
	private Usuario user;

	public Pagamento(Integer id,String tipo, double percentual, double valorDoPagamento, Usuario user) {
		this.id = id;
		this.percentual = percentual;
		this.valorDoPagamento = valorDoPagamento;
		this.status = "Não pago";
		this.tipoPagamento = tipo;
		this.user = user;
	}
	
	public abstract double calcularDesconto();
	
	public void alterarPagamento(double percentual) {
		this.percentual = percentual;
	}
	
	public String toString() {
		return "[" + id+ "] Forma de pagamento: " + tipoPagamento + "(" + percentual + "% de desconto em pagamento)";
	}
	
	public double getValor() {
		return valorDoPagamento;
	}
	
	public double getPercentual() {
		return percentual;
	}
	
	public int getId() {
		return id;
	}
	
	public void setStatus(String a) {
		this.status = a;
	}
	
	public void setPercentual(double p) {
		this.percentual = p;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getTipo() {
		return tipoPagamento;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
}
