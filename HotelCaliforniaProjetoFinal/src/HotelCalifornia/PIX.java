package HotelCalifornia;

public class PIX extends Pagamento{
	private String titular;
	private String banco;
	
	public PIX(Integer id, double percentual, double valorPag, String titular, String banco, Usuario user) {
		super(id,"PIX",percentual, valorPag, user);
		this.setBanco(banco);
		this.setTitular(titular);
	}
	
	public double calcularDesconto() {
		super.setPercentual(5);
		return super.getPercentual();
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
