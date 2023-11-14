package HotelCalifornia;

import java.time.LocalTime;

public class Refeicao {
	private Long id;
	private String titulo;
	private LocalTime inicioRefeicao;
	private LocalTime fimRefeicao;
	private Double valor;
	private String tipoRefeicao;
	private Boolean ativo;
	
	public Refeicao(Long id, String tipoRefeicao, String titulo, LocalTime inicioRefeicao, LocalTime fimRefeicao, Double valor, Boolean ativo) {
		this.id = id;
		this.titulo = titulo;
		this.inicioRefeicao = inicioRefeicao;
		this.fimRefeicao = fimRefeicao;
		this.valor = valor;
		this.tipoRefeicao = tipoRefeicao;
		this.ativo = ativo;
	}
	
	public String getTipo() {
		return tipoRefeicao.toUpperCase();
	}
	
	public void setInicioRefeicao(LocalTime inicio) {
		this.inicioRefeicao = inicio;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public void setFimRefeicao(LocalTime fim) {
		this.fimRefeicao = fim;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public LocalTime getInicio() {
		return inicioRefeicao;
	}
	
	public LocalTime getFim() {
		return fimRefeicao;
	}
	
	public String toString() {
		return "[" + id + "] " + tipoRefeicao + ": " + titulo + " (" + inicioRefeicao + "as" + fimRefeicao + "). Valor por pessoa: R$" + valor + ". " + ativo; 
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public double getValor() {
		return valor;
	}
}
