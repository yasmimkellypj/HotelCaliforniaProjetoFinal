package HotelCalifornia;

public class FormaDePagamento {
	private String id;
	private String formaDePagamento;
	private Double desconto;
	
	public FormaDePagamento(String id, String forma, Double des) {
		this.setId(id);
		this.setFormaDePagamento(forma);
		this.setDesconto(des);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public String toString() {
		return "[" + id+ "] Forma de pagamento: " + formaDePagamento + "(" + desconto + "% de desconto em pagamento)";
	}
	
	@Override
	public boolean equals(Object ob) {
		if(!(ob instanceof FormaDePagamento)) {
			return false;
		}
		FormaDePagamento forma = (FormaDePagamento) ob;
		return formaDePagamento.equals(forma.getFormaDePagamento()) && desconto.equals(forma.getDesconto()) ;
	}
}
