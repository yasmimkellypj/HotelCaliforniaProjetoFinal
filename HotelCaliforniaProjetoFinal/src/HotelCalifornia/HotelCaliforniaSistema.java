package HotelCalifornia;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HotelCaliforniaSistema {
   	private HashMap<String, Usuario> usuarios;
   	private HashMap<Integer, Quarto> quartos;
   	private HashMap<Long, Reserva> reservas;
   	private HashMap<Long, Refeicao> refeicoes;
   	private HashMap<Integer, FormaDePagamento> formaDePagamentos;
   	private HashMap<Long, AreaComum> areasComuns;
   	private HashMap<Long, Pagamento> pagamentos;
   	private int controlador;
   	private Long controladorReserva;
   	private Long controladorRefeicao;
   	private Integer controladorPagamento;
   	private Long controladorArea;
   	private Long pagControll;


   	
    public HotelCaliforniaSistema() {
        this.usuarios = new HashMap<>();
        Administrador admin = new Administrador("ADM1", "Joao Costa", (long) 123456);
        this.usuarios.put("ADM1", admin);
        // A ordem desse array é CLI, GER, FUN, ADM!!!
        this.controlador= 1;
        this.controladorReserva = (long) 0;
        this.controladorRefeicao = (long) 0;
        this.controladorPagamento = 0;
        this.controladorArea = (long) 0;
        this.pagControll = (long) 0;
    }
    
    public Usuario cadastrarUsuario(String idAutenticacao, String nome, String tipoUsuario, Long documento) {
    	Usuario a = null;
    	if(idAutenticacao.contains("ADM")) {
    		if(tipoUsuario.equals("ADM")) {
    			String idNovo = tipoUsuario + controlador;
    			this.controlador++;
    			a = new Administrador(idNovo, nome, documento);
    			this.usuarios.put(idNovo, a);
    		} else if( tipoUsuario.equals("GER")) {
    			String idNovo = tipoUsuario + controlador;
    			a = new Gerente(idNovo, nome, documento);
    			this.controlador++;
    			this.usuarios.put(idNovo, a);
    		} else if(tipoUsuario.equals("CLI")) {
    			String idNovo = tipoUsuario + controlador;
    			a = new Cliente(idNovo, nome, documento);
    			this.controlador++;
    			this.usuarios.put(idNovo, a);
    		} else if(tipoUsuario.equals("FUN")) {
    			String idNovo = tipoUsuario + controlador;
    			a = new Funcionario(idNovo, nome, documento);
    			this.controlador++;
    			this.usuarios.put(idNovo, a);
    		}
    	} else if(idAutenticacao.contains("GER")) {
    		 if(tipoUsuario.equals("CLI")) {
     			String idNovo = tipoUsuario + controlador;
     			a = new Cliente(idNovo, nome, documento);
     			this.controlador++;
     			this.usuarios.put(idNovo, a);
     		} else if(tipoUsuario.equals("FUN")) {
    			String idNovo = tipoUsuario + controlador;
    			a = new Funcionario(idNovo, nome, documento);
    			this.controlador++;
    			this.usuarios.put(idNovo, a);
    		} else {
    			throw new HotelCaliforniaException("ESTE USUÁRIO NÃO PODE CADASTRAR ESSE TIPO DE USUÁRIO!");
    		}
    	} else if(idAutenticacao.contains("FUN")) {
    		if(tipoUsuario.equals("CLI")) {
     			String idNovo = tipoUsuario + controlador;
     			a = new Cliente(idNovo, nome, documento);
     			this.controlador++;
     			this.usuarios.put(idNovo, a);
     		} else {
     			throw new HotelCaliforniaException("ESTE USUÁRIO NÃO PODE CADASTRAR ESSE TIPO DE USUÁRIO!");
     		}
    	} else if(idAutenticacao.contains("CLI")) {
    		throw new HotelCaliforniaException("ESTE USUÁRIO NÃO PODE CADASTRAR ESSE TIPO DE USUÁRIO!");
    	}
    	if(a.equals(null)) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO CADASTRADO");
    	}
    	return a;
    }

    public Usuario atualizarUsuario(String idAutenticacao, String idUsuario, String novoTipoUsuario) {
    	Usuario b = null;
        if(idAutenticacao.contains("ADM")) {
        	Usuario a = usuarios.get(idUsuario);
        	if(novoTipoUsuario .equals("ADM")) {
        		b = new Administrador(a.getId(), a.getNome(), a.getDocumento());
        		usuarios.put(idUsuario, b);
        		String novoId = novoTipoUsuario + controlador;
        		usuarios.get(idUsuario).setId(novoId);
        		controlador++;
        	} else if(novoTipoUsuario .equals("GER")) {
        		b = new Gerente(a.getId(), a.getNome(), a.getDocumento());
        		usuarios.put(idUsuario, b);
        		String novoId = novoTipoUsuario + controlador;
        		usuarios.get(idUsuario).setId(novoId);
        		controlador++;
        	} else if(novoTipoUsuario .equals("FUN")) {
        		b = new Funcionario(a.getId(), a.getNome(), a.getDocumento());
        		usuarios.put(idUsuario, b);
        		String novoId = novoTipoUsuario + controlador;
        		usuarios.get(idUsuario).setId(novoId);
        		controlador++;
        	}  else if(novoTipoUsuario .equals("CLI")) {
        		b = new Cliente(a.getId(), a.getNome(), a.getDocumento());
        		usuarios.put(idUsuario, b);
        		String novoId = novoTipoUsuario + controlador;
        		usuarios.get(idUsuario).setId(novoId);
        		controlador++;
        	}
        } else {
        	throw new HotelCaliforniaException("ESTE USER NÃO PODE ATUALIZAR USUÁRIOS"); 
        }
        return b;
    }

    public String exibirUsuario(String idUsuario) {
    	if(!usuarios.containsKey(idUsuario)) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE"); 
    	}
    	return usuarios.get(idUsuario).toString();
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        lista.addAll(usuarios.values());
        return lista;
    }

    public Quarto cadastrarQuartoSingle(String idAutenticacao, Integer idQuartoNum, double precoPorPessoa, double precoBase) {
    	if(!idAutenticacao.contains("ADM")){
    		throw new HotelCaliforniaException("USUÁRIO INVÁLIDO!");
    	}
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO INVÁLIDO!");
    	}
    	if(quartos.containsKey(idQuartoNum)) {
    		throw new HotelCaliforniaException("QUARTO JÁ CADASTRADO!");
    	}
    	Quarto a = new QuartoSingle(idQuartoNum, precoBase, precoPorPessoa);
    	quartos.put(idQuartoNum, a);
    	return a;
    }

    public Quarto cadastrarQuartoDouble(String idAutenticacao, Integer idQuartoNum, double precoPorPessoa, double precoBase, String[] pedidos) {
    	if(!idAutenticacao.contains("ADM")){
    		throw new HotelCaliforniaException("USUÁRIO INVÁLIDO!");
    	}
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO INVÁLIDO!");
    	}
    	if(quartos.containsKey(idQuartoNum)) {
    		throw new HotelCaliforniaException("QUARTO JÁ CADASTRADO!");
    	}
    	Quarto a = new QuartoDouble(idQuartoNum, precoBase, precoPorPessoa, Arrays.asList(pedidos));
    	quartos.put(idQuartoNum, a);
    	return a;
    }

    public Quarto cadastrarQuartoFamily(String idAutenticacao, Integer idQuartoNum, double precoPorPessoa, double precoBase, String[] pedidos, int qtdMaxPessoas) {
    	if(!idAutenticacao.contains("ADM")){
    		throw new HotelCaliforniaException("USUÁRIO INVÁLIDO!");
    	}
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO INVÁLIDO!");
    	}
    	if(quartos.containsKey(idQuartoNum)) {
    		throw new HotelCaliforniaException("QUARTO JÁ CADASTRADO!");
    	}
    	Quarto a = new QuartoFamily(idQuartoNum, precoBase, precoPorPessoa, Arrays.asList(pedidos), qtdMaxPessoas);
    	quartos.put(idQuartoNum, a);
    	return a;
    }

    public Quarto exibirQuarto(Integer idQuartoNum) {
        if(!quartos.containsKey(idQuartoNum)) {
        	throw new HotelCaliforniaException("QUARTO NÃO EXISTE!");
        }
        return quartos.get(idQuartoNum);
    }

    public List<Quarto> listarQuartos() {
    	List<Quarto> lista = new ArrayList<>();
        lista.addAll(quartos.values());
        return lista;
    }

    public Reserva reservarQuartoSingle(String idAutenticacao, String idCliente, Integer numQuarto, LocalDateTime dataInicio, LocalDateTime dataFim, String[] idRefeicoes) {
        if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
        if(idAutenticacao.contains("ADM") || idAutenticacao.contains("CLI")) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR RESERVA!");
        }
        if(!verificaPeriodo(dataInicio, dataFim)) {
        	throw new HotelCaliforniaException("PERÍODO INDISPONÍVEL!");
        }
        if(!quartos.containsKey(numQuarto)) {
        	throw new HotelCaliforniaException("QUARTO NÃO EXISTE");
        }
        Quarto a = quartos.get(numQuarto);
        List<Refeicao> refeicoes = adicionaRefeicao(idRefeicoes);
        controladorReserva++;
        Usuario b = usuarios.get(idCliente);
        Reserva reserv = new ReservaQuarto(controladorReserva, b, a, dataInicio, dataFim, 1, refeicoes);
        reserv.setTipo();
        reservas.put(controladorReserva, reserv);
        return reserv;
    }
    
    private List<Refeicao> adicionaRefeicao(String[] idRefeicoes){
    	List<Refeicao> a = new ArrayList<>();
    	for( Object r : idRefeicoes) {
    		a.add(refeicoes.get(r));
    	}
    	return a;
    }
    
    private boolean verificaPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
    	return reservas.values().stream().allMatch(reservas ->
                        dataInicial.isAfter(reservas.getDataFinal()) || dataFinal.isBefore(reservas.getDataInicial())
                );
    }

    public Reserva reservarQuartoDouble(String idAutenticacao, String idCliente, int numQuarto, LocalDateTime dataInicio, LocalDateTime dataFim, String[] idRefeicoes, String[] pedidos) {
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
        if(idAutenticacao.contains("ADM") || idAutenticacao.contains("CLI")) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR RESERVA!");
        }
        if(!verificaPeriodo(dataInicio, dataFim)) {
        	throw new HotelCaliforniaException("PERÍODO INDISPONÍVEL!");
        }
        if(!quartos.containsKey(numQuarto)) {
        	throw new HotelCaliforniaException("QUARTO NÃO EXISTE");
        }
        Quarto a = quartos.get(numQuarto);
        controladorReserva++;
        List<Refeicao> refeicoes = adicionaRefeicao(idRefeicoes);
        Usuario b = usuarios.get(idCliente);
        Reserva reserv = new ReservaQuarto(controladorReserva, b, a, dataInicio, dataFim, 2, refeicoes);
        reserv.setTipo();
        reservas.put(controladorReserva, reserv);
        return reserv;
    }

    public Reserva reservarQuartoFamily(String idAutenticacao, String idCliente, int numQuarto, LocalDateTime dataInicio, LocalDateTime dataFim, String[] idRefeicoes, String[] pedidos, int numPessoas) {
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
        if(idAutenticacao.contains("ADM") || idAutenticacao.contains("CLI")) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR RESERVA!");
        }
        if(!verificaPeriodo(dataInicio, dataFim)) {
        	throw new HotelCaliforniaException("PERÍODO INDISPONÍVEL!");
        }
        if(!quartos.containsKey(numQuarto)) {
        	throw new HotelCaliforniaException("QUARTO NÃO EXISTE");
        }
        Quarto a = quartos.get(numQuarto);
        List<Refeicao> refeicoes = adicionaRefeicao(idRefeicoes);
        Usuario b = usuarios.get(idCliente);
        controladorReserva++;
        Reserva reserv = new ReservaQuarto(controladorReserva, b, a, dataInicio, dataFim, numPessoas, refeicoes);
        reserv.setTipo();
        reservas.put(controladorReserva, reserv);
        return reserv;
    }

    public Reserva exibirReserva(String idAutenticacao, long idReserva) {
    	if(!reservas.containsKey(idReserva)) {
        	throw new HotelCaliforniaException("QUARTO NÃO EXISTE!");
        }
    	if(idAutenticacao.contains("ADM") || idAutenticacao.contains("CLI")) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO PODE CONFERIR RESERVA!");
    	}
        return reservas.get(idReserva);
    }

    public List<Reserva> listarReservasAtivasDoCliente(String idAutenticacao, String idCliente) {
    	if(!usuarios.containsKey(idCliente)) {
    		throw new HotelCaliforniaException("CLIENTE NÃO ENCONTRADO");
    	}
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO ENCONTRADO!");
    	}
    	LocalDateTime data = LocalDateTime.now();
        Usuario a = usuarios.get(idCliente);
        List<Reserva> lista = new ArrayList<Reserva>();
        for(Reserva r : reservas.values()) {
        	if(!data.isAfter(r.getDataFinal())){
        		if(a.equals(r.getUsuario())) {
        			lista.add(r);
        		}
        	}
        }
        if(lista.isEmpty()) {
        	throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
        }
        return lista;
    }

    public List<Reserva> listarReservasAtivasDoClientePorTipo(String idAutenticacao, String idCliente, String tipo) {
    	if(!usuarios.containsKey(idCliente)) {
    		throw new HotelCaliforniaException("CLIENTE NÃO ENCONTRADO");
    	}
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO ENCONTRADO!");
    	}
    	LocalDateTime data = LocalDateTime.now();
        Usuario a = usuarios.get(idCliente);
        List<Reserva> lista = new ArrayList<Reserva>();
        for(Reserva r : reservas.values()) {
        	if(!data.isAfter(r.getDataFinal())){
        		if(a.equals(r.getUsuario())) {
        			if(r.getTipo().equals(tipo.toUpperCase())) {
        				lista.add(r);
        			}
        		}
        	}
        }
        if(lista.isEmpty()) {
        	throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
        }
        return lista;
    }

    public List<Reserva> listarReservasAtivasPorTipo(String idAutenticacao, String tipo) {
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO ENCONTRADO!");
    	}
    	LocalDateTime data = LocalDateTime.now();
        List<Reserva> lista = new ArrayList<Reserva>();
        for(Reserva r : reservas.values()) {
        	if(!data.isAfter(r.getDataFinal())){
        		if(r.getTipo().equals(tipo.toUpperCase())) {
    				lista.add(r);
    			}
        	}
        }
        if(lista.isEmpty()) {
        	throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
        }
        return lista;
    }

    public List<Reserva> listarReservasAtivas(String idAutenticacao) {
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO ENCONTRADO!");
    	}
    	LocalDateTime data = LocalDateTime.now();
        List<Reserva> lista = new ArrayList<Reserva>();
        for(Reserva r : reservas.values()) {
        	if(!data.isAfter(r.getDataFinal())){    
        		lista.add(r);
        	}
        }
        if(lista.isEmpty()) {
        	throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
        }
        return lista;
    }

    public List<Reserva> listarReservasTodas(String idAutenticacao) {
    	if(!usuarios.containsKey(idAutenticacao)) {
    		throw new HotelCaliforniaException("USUÁRIO NÃO ENCONTRADO!");
    	}
    	List<Reserva> lista = new ArrayList<Reserva>();
    	for(Reserva r : reservas.values()) {
        	lista.add(r);
        }
        if(lista.isEmpty()) {
        	throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
        }
        return lista;
    }

    public Refeicao disponibilizarRefeicao(String idAutenticacao, String tipoRefeicao, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, double valor, boolean disponivel) {
    	 if(idAutenticacao.contains("ADM") || idAutenticacao.contains("CLI")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE DISPONIBILIZAR REFEIÇÃO!");
         }
    	 controladorRefeicao++;
    	 Refeicao ref = new Refeicao(controladorRefeicao, tipoRefeicao, titulo, horarioInicio, horarioFinal, valor, disponivel);
    	 return ref;
    }

    public Refeicao alterarRefeicao(Long idRefeicao, LocalTime horarioInicio, LocalTime horarioFinal,Double valor, Boolean disponivel) {
        refeicoes.get(idRefeicao).setInicioRefeicao(horarioInicio); 
        refeicoes.get(idRefeicao).setValor(valor);
        refeicoes.get(idRefeicao).setFimRefeicao(horarioFinal);
        refeicoes.get(idRefeicao).setAtivo(disponivel);
        return refeicoes.get(idRefeicao);
    }

    public Refeicao exibirRefeicao(long idRefeicao) {
    	if(!refeicoes.containsKey(idRefeicao)) {
    		throw new HotelCaliforniaException("REFEIÇÃO NÃO ENCONTRADA");
    	}
        refeicoes.get(idRefeicao).toString();
        return refeicoes.get(idRefeicao);
    }

    public List<Refeicao> listarRefeicoes() {    	
    	List<Refeicao> lista = new ArrayList<Refeicao>();
    	for(Refeicao r : refeicoes.values()) {
    		lista.add(r);
    	}
    	if(lista.isEmpty()) {
    		throw new HotelCaliforniaException("REFEIÇÕES NÃO ENCONTRADAS!");
    	}
        return lista;
    }

    public Reserva reservarRestaurante(String idAutenticacao, String idCliente, LocalDateTime dataInicio, LocalDateTime dataFim, Integer qtdePessoas, String refeicao, Integer idPagamento) {
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(!usuarios.containsKey(idCliente)) {
        	throw new HotelCaliforniaException("CLIENTE NÃO EXISTE!");
        }
        if(idAutenticacao.contains("ADM") || idAutenticacao.contains("CLI")) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR RESERVA!");
        }
        controladorReserva++;
        Usuario cli = usuarios.get(idCliente);
        @SuppressWarnings("removal")
		Long num = new Long(idPagamento);
        Pagamento pag = pagamentos.get(num);
        Refeicao ref = null;
        for(Refeicao r : refeicoes.values()) {
        	if(r.getTitulo().contains(refeicao)) {
        		ref = r;
        	}
        }
        if(ref.equals(null)) {
        	throw new HotelCaliforniaException("REFEIÇÃO NÃO ENCONTRADA!");
        }
        controladorReserva++;
        Reserva resev = new ReservaRestaurante(controladorReserva, cli, dataInicio, dataFim, qtdePessoas, ref, pag);
        resev.setTipo();
        return resev;
    }

    public FormaDePagamento disponibilizarFormaDePagamento(String idAutenticacao, String formaPagamento, double percentualDesconto) {
    	if(!idAutenticacao.contains("ADM")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE DISPONIBILIZAR FORMA DE PAGAMENTO!");
         }
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	controladorPagamento++;
    	FormaDePagamento pag = new FormaDePagamento("" + controladorPagamento, formaPagamento, percentualDesconto);
    	for(FormaDePagamento forma : formaDePagamentos.values()) {
    		if(forma.equals(pag)) {
    			throw new HotelCaliforniaException("FORMA DE PAGAMENTO NÃO PODE SER CADASTRADAS DUAS VEZES");
    		}
    	}
    	formaDePagamentos.put(controladorPagamento, pag);
    	return pag;
    }

    public FormaDePagamento alterarFormaDePagamento(String idAutenticacao, int idFormaPagamento, String formaPagamento, double percentualDesconto) {
    	if(!idAutenticacao.contains("ADM")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE DISPONIBILIZAR FORMA DE PAGAMENTO!");
         }
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(!formaDePagamentos.containsKey(idFormaPagamento)) {
    		throw new HotelCaliforniaException("FORMA DE PAGAMENTO NÃO ENCONTRADA!");
    	}
    	if(formaDePagamentos.get(idFormaPagamento).equals(null)) {
        	throw new HotelCaliforniaException("FORMA DE PAGAMENTO NÃO REGISTRADA!");
        }
    	formaDePagamentos.get(idFormaPagamento).setFormaDePagamento(formaPagamento);
    	formaDePagamentos.get(idFormaPagamento).setDesconto(percentualDesconto);;
    	return formaDePagamentos.get(idFormaPagamento);
    }

    public FormaDePagamento exibirFormaPagamento(int idFormaPagamento) {
    	if(formaDePagamentos.get(idFormaPagamento).equals(null)) {
        	throw new HotelCaliforniaException("FORMA DE PAGAMENTO NÃO REGISTRADA!");
        }
        return formaDePagamentos.get(idFormaPagamento);
    }

    public List<FormaDePagamento> listarFormasPagamentos() {
    	List<FormaDePagamento> pags = new ArrayList<FormaDePagamento>();
        for(FormaDePagamento p: formaDePagamentos.values()) {
        	pags.add(p);
        }
        if(pags.isEmpty()) {
    		throw new HotelCaliforniaException("REFEIÇÕES NÃO ENCONTRADAS!");
    	}
        return pags;
    }
    
    public Cartao pagarReservaComCartao(String idCliente, Long idReserva, String nomeTitular, String numCartao, String validade, String digitoVerificador, Integer qtdeParcelas) {
    	if(!idCliente.contains("CLI")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR PAGAMENTO!");
         }
    	if(!usuarios.containsKey(idCliente)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(!reservas.containsKey(idReserva)) {
    		throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
    	}
    	Usuario cli = usuarios.get(idCliente);
    	Reserva r = reservas.get(idReserva);
    	Cartao pag = new Cartao(controladorPagamento, 0, r.valorTotal(), nomeTitular, numCartao, validade, digitoVerificador, qtdeParcelas, cli);
    	r.setPagamento(pag);
    	controladorPagamento++;
    	return pag;
    }

    public Dinheiro pagarReservaComDinheiro(String idCliente, Long idReserva, String nomeTitular) {
    	if(!idCliente.contains("CLI")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR PAGAMENTO!");
         }
    	if(!usuarios.containsKey(idCliente)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(!reservas.containsKey(idReserva)) {
    		throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
    	}
    	Usuario cli = usuarios.get(idCliente);
    	Reserva r = reservas.get(idReserva);
    	Dinheiro pag = new Dinheiro(controladorPagamento, r.valorTotal(), (10/100), cli);
    	r.setPagamento(pag);
    	controladorPagamento++;
    	return pag;
    }

    public PIX pagarReservaComPix(String idCliente, Long idReserva, String nomeTitular, String cpf, String banco) {
    	if(!idCliente.contains("CLI")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR PAGAMENTO!");
         }
    	if(!usuarios.containsKey(idCliente)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(!reservas.containsKey(idReserva)) {
    		throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
    	}
    	FormaDePagamento formaPag = null;
    	Usuario cli = usuarios.get(idCliente);
    	for(FormaDePagamento forma : formaDePagamentos.values()) {
    		if(forma.getFormaDePagamento().toUpperCase().equals("PIX")) {
    			formaPag = forma;
    		}
    	}
    	if(formaPag == null) {
    		throw new HotelCaliforniaException("FORMA DE PAGAMENTO NÃO REGISTRADA");
    	}
    	Reserva r = reservas.get(idReserva);
    	PIX pag = new PIX(controladorPagamento, (5/100),r.valorTotal(), cpf, banco, cli);
    	pagControll++;
    	pagamentos.put(pagControll, pag);
    	r.setPagamento(pag);
    	controladorPagamento++;
    	return pag;
    }

    public Reserva cancelarReserva(String idCliente, String idReserva) {
    	if(!idCliente.contains("CLI")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE REALIZAR PAGAMENTO!");
         }
    	if(!usuarios.containsKey(idCliente)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	
    	Long identificador = (long) 0;
    	for(Reserva r : reservas.values()) {
    		if(!r.getId().equals(Long.valueOf(idReserva))) {
    			throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
    		}
    		identificador = r.getId();
    	}
    	Reserva res = reservas.get(identificador);
    	 if(res == null) {
    	        throw new HotelCaliforniaException("RESERVA NÃO ENCONTRADA!");
    	    }

    	LocalDateTime dataAtual = LocalDateTime.now();
    	LocalDateTime dataInicialReserva = res.getDataInicial();

    	long diferencaDias = ChronoUnit.DAYS.between(dataAtual, dataInicialReserva);
    	if(!(diferencaDias <= 1)) {
    		throw new HotelCaliforniaException("NÃO É POSSÍVEL REMOVER RESERVA. DATA MUITO PRÓXIMA!");
    	}
    	reservas.remove(identificador);
        return res;
    }

    public AreaComum disponibilizarAreaComum(String idAutenticacao, String tipoAreaComum, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, Double valorPessoa, Boolean disponivel, Integer qtdMaxPessoas) {
    	if(!idAutenticacao.contains("ADM")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE DISPONIBILIZAR ÁREA COMUM!");
         }
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(horarioInicio.isAfter(horarioFinal)) {
    		throw new HotelCaliforniaException("HORÁRIO INVÁLIDO!");
    	}
    	controladorArea++;
    	AreaComum area = new AreaComum(controladorArea, tipoAreaComum, titulo, horarioInicio, horarioFinal, valorPessoa, disponivel, qtdMaxPessoas);
    	areasComuns.put(controladorArea, area);
    	return area;
    }

    public AreaComum alterarAreaComum(String idAutenticacao, Long idAreaComum, LocalTime novoHorarioInicio, LocalTime novoHorarioFinal, Double novoPreco, Integer capacidade, Boolean ativa) {
    	if(!idAutenticacao.contains("ADM")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE DISPONIBILIZAR ÁREA COMUM!");
         }
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(novoHorarioInicio.isAfter(novoHorarioFinal)) {
    		throw new HotelCaliforniaException("HORÁRIO INVÁLIDO!");
    	}
    	if(!areasComuns.containsKey(idAreaComum)) {
    		throw new HotelCaliforniaException("ÁREA COMUM NÃO ENCONTRADA");
    	}
        areasComuns.get(idAreaComum).setInicio(novoHorarioInicio);
        areasComuns.get(idAreaComum).setFim(novoHorarioFinal);
        areasComuns.get(idAreaComum).setValor(novoPreco);
        areasComuns.get(idAreaComum).setQtdeMaxima(capacidade);
        areasComuns.get(idAreaComum).setDisponibilidade(ativa);
        return areasComuns.get(idAreaComum);
    }

    public AreaComum exibirAreaComum(long idAreaComum) {
        if(!areasComuns.containsKey(idAreaComum)) {
        	throw new HotelCaliforniaException("ÁREA COMUM NÃO ENCONTRADA");
        }
        return areasComuns.get(idAreaComum);
    }

    public List<AreaComum> listarAreasComuns() {
    	List<AreaComum> area = new ArrayList<AreaComum>();
        for(AreaComum a: areasComuns.values()) {
        	area.add(a);
        }
        if(area.isEmpty()) {
    		throw new HotelCaliforniaException("ÁREAS NÃO ENCONTRADAS!");
    	}
        return area;
    }

    public Auditorio reservarAuditorio(String idAutenticacao, String idCliente, Long idAuditorio, LocalDateTime dataInicio, LocalDateTime dataFim, Integer qtdMaxPessoas) {
    	if(!idAutenticacao.contains("ADM")) {
         	throw new HotelCaliforniaException("USUÁRIO NÃO PODE DISPONIBILIZAR ÁREA COMUM!");
         }
    	if(!usuarios.containsKey(idAutenticacao)) {
        	throw new HotelCaliforniaException("USUÁRIO NÃO EXISTE!");
        }
    	if(!usuarios.containsKey(idCliente)) {
    		throw new HotelCaliforniaException("USUARIO NÃO EXISTE!");
    	}
    	if(!(areasComuns.containsKey(idAuditorio))) {
    		throw new HotelCaliforniaException("ÁREA COMUM NÃO ENCONTRADA");
    	}
    	controladorReserva++;
    	Usuario user = usuarios.get(idCliente);
    	Auditorio a = new Auditorio(controladorReserva, user, dataInicio, dataFim,  qtdMaxPessoas);
    	a.setTipo();
        return a;
    }    
}