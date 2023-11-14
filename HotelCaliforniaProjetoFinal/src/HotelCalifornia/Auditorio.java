package HotelCalifornia;

import java.time.LocalDateTime;

public class Auditorio extends Reserva{
	public Auditorio(Long id, Usuario cliente, LocalDateTime dataInicial, LocalDateTime dataFinal, Integer qtdHospedes) {
		super(id, cliente, dataInicial, dataFinal,  qtdHospedes);
	}

	@Override
	public Double valorTotal() {
		return null;
	}
	
	public void definePag(Pagamento pag) {
		super.setPagamento(pag);
	}
	
	@Override
	public void setTipo() {
		super.defineTipo("AUDITÓRIO");
	}

}
