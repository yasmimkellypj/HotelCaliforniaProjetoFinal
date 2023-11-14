package HotelCalifornia;

import java.time.LocalDateTime;

public abstract class Reserva {
	private Long id;
	private Usuario cliente;
	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private Integer qtdHospedes;
	private Pagamento pagamento;
	private String tipo;
	
	public Reserva(Long id, Usuario cliente, LocalDateTime dataInicial, LocalDateTime dataFinal, Integer qtdHospedes) {
		this.cliente = cliente;
		this.dataFinal = dataFinal;
		this.dataInicial = dataInicial;
		this.qtdHospedes = qtdHospedes;
		this.id = id;
	}
	
	public void setPagamento(Pagamento pag) {
		this.pagamento = pag;
	}
	
	public Usuario getUsuario() {
		return cliente;
	}
	
	public LocalDateTime getDataInicial() {
		return dataInicial;
	}
	
	public LocalDateTime getDataFinal() {
		return dataFinal;
	}
	
	public Long getId() {
		return id;
	}
	
	public Integer getHospedes() {
		return qtdHospedes;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public String verificaPagamento() {
		if(pagamento == null) {
			return"PENDENTE";
		}
		return "REALIZADO";
	}
	
	public abstract Double valorTotal();
	
	public abstract void setTipo();
	
	public void defineTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
