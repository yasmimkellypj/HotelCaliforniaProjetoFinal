package HotelCalifornia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReservaQuarto extends Reserva{
	private List<Refeicao> refeicoes;
	private Quarto quarto; 
	
	public ReservaQuarto(Long id, Usuario cliente, Quarto quarto, LocalDateTime dataInicial, LocalDateTime dataFinal, Integer qtdHospedes, List<Refeicao> refeicoes)  {
		super(id, cliente, dataInicial, dataFinal, qtdHospedes);
		this.quarto = quarto;
		this.refeicoes = refeicoes;
	}
	
	public List<Refeicao> getRefeicoes(){
		return refeicoes;
	}
	
	public Quarto getQuarto() {
		return quarto;
	}
	
	public String toString() {
		return "[" + getId() + "] Reserva de quarto em favor de: " + getUsuario().toString() + "\nDetalhes da instalacao:\n" + getQuarto().toString()+
				"\nDetalhes da reserva:\n" + "-Periodo: " + getDataInicial().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " ate " +
		getDataFinal().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n-No. Hospedes:" + getHospedes() + "\n-Refeicoes incluidas: "
		+ "[" + listaRefeicao()+ "]\nVALOR TOTAL DA RESERVA: R$" + valorTotal()+ "\nSITUACAO DO PAGAMENTO: "+ verificaPagamento();
	}
	
	private String listaRefeicao() {
		String a = "";
		for(Refeicao r : refeicoes) {
			a += r.toString() + "\n";
		}
		return a;
	}
	
	public Double valorTotal() {
		return (getQuarto().valorDaDiaria() * getQuarto().getCapacidade()) + diarias() * valorRefeicao();
	}
	
	private int diarias(){
        return getDataInicial().toLocalDate().until(getDataFinal().toLocalDate()).getDays();
    }
	
	private double valorRefeicao() {
		double a =0;
		for(Refeicao ref : refeicoes) {
			a+= ref.getValor();
		}
		return a;
	}

	@Override
	public void setTipo() {
		super.defineTipo("QUARTO " + quarto.getTipoInstalacao().toUpperCase());
		
	}
}
