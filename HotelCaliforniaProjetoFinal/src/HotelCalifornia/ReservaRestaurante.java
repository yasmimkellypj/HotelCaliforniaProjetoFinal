package HotelCalifornia;

import java.time.LocalDateTime;


public class ReservaRestaurante extends Reserva{
	private Refeicao refeicao;
	private Pagamento pagamento;
	
	public ReservaRestaurante(Long id, Usuario cli, LocalDateTime dataInicio, LocalDateTime dataFim, Integer qtdePessoas, Refeicao refeicao, Pagamento pagamento) {
		super(id, cli, dataInicio, dataFim, qtdePessoas);
		this.pagamento = pagamento;
		this.refeicao = refeicao;
	}
	
	public Refeicao getRefecao() {
		return refeicao;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public Double valorTotal() {
		return 0.0;
	}
	
	@Override
	public void setTipo() {
		super.defineTipo("RESTAURANTE");
		
	}
}
