package HotelCalifornia;

public class Dinheiro extends Pagamento{
	
	public Dinheiro(Integer  id, double v, double p, Usuario user) {
		super(id, "Dinheiro",v, p, user);
	}
	
	public double calcularDesconto() {
		super.setPercentual(10);
		return super.getPercentual();
	}

}
