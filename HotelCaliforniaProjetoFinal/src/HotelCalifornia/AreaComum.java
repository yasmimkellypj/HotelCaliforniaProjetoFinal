package HotelCalifornia;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AreaComum {
	private String titulo;
	private LocalTime inicio;
	private LocalTime fim;
	private Double valor;
	private Integer qtdeMaxima;
	private Boolean disponibilidade;
	private String tipoArea;
	private Long id;
	
	public AreaComum(Long id, String tipoArea, String titulo, LocalTime inicio, LocalTime fim, Double valor, Boolean disponibilidade, Integer qtdeMaxima) {
		this.setDisponibilidade(disponibilidade);
		this.setFim(fim);
		this.setInicio(inicio);
		this.setValor(valor);
		this.setQtdeMaxima(qtdeMaxima);
		this.setTitulo(titulo);
		this.setTipoArea(tipoArea);
	}
	
	public void setTipoArea(String tipo) {
		this.tipoArea = tipo;
	}
	
	public String getTipoArea() {
		return tipoArea;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}

	public LocalTime getFim() {
		return fim;
	}

	public void setFim(LocalTime fim) {
		this.fim = fim;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQtdeMaxima() {
		return qtdeMaxima;
	}

	public void setQtdeMaxima(Integer qtdeMaxima) {
		this.qtdeMaxima = qtdeMaxima;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	private String disponibilidade() {
		if(getDisponibilidade().equals(false)) {
			return "INDISPONÍVEL";
		} else {
			return "VIGENTE";
		}
	}
	
	public String toString() {
		return "[" + id+ "] "+ tipoArea + ": " + titulo + getInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " ate " +
				getFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ". Valor por pessoa: R$"+ getValor().toString() + ". Capacidade: " + 
				qtdeMaxima + " pessoa(s). " + disponibilidade();
	}
	

}
