package HotelCalifornia;
import java.time.LocalDate;

public class Cartao extends Pagamento {
	private String titular;
	private String numeroDoCartao;
	private String codigoDoCartao;
	private String data;
	private int parcelas;
	
	
	public Cartao(Integer id, double p, double v, String nomeTitular, String numCartao, String validade, String digitoVerificador, int qtdeParcelas, Usuario user) {
		super(id, "CARTÃO", p, v, user);
		this.titular = nomeTitular;
		this.codigoDoCartao = digitoVerificador;
		this.data = validade;
		this.numeroDoCartao = numCartao;
		this.parcelas = qtdeParcelas;
	}
	
	public double calcularDesconto() {
		super.setPercentual(0);
		return super.getPercentual();
	}
	
	public String getTitular() {
		return titular;
	}
	
	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}
	
	public String getCodigoDoCartao() {
		return codigoDoCartao;
	}
	
	public String getData() {
		return data;
	}
	
	public int getParcelas() {
		return parcelas;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public void setNumeroDoCartao(String num) {
		this.numeroDoCartao = num;
	}
	
	public void setCodigoDoCartao(String cod) {
		this.codigoDoCartao = cod;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setParcelar(int parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
