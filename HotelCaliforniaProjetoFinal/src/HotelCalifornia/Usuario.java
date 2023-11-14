package HotelCalifornia;

public class Usuario {
	private String id;
	private String nome;
	private String tipoUsuario;
	private long documento;
	
	public Usuario(String id, String nome, String tipo, Long documento) {
        this.id = id;
        this.nome = nome;
        this.tipoUsuario = tipo;
        this.documento = documento;
    }

	public String getId(){
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipoUsuario;
	}
	
	public long getDocumento() {
		return documento;
	}
	
	public void setId(String a) {
		this.id = a;
	}
	
	public String toString() {
		return "[" + id+ "] " + nome + " (No. Doc " + documento + ")";
	}
	
}
