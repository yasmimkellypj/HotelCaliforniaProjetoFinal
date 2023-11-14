package HotelCalifornia;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class FachadaHotelCalifornia {
	private HotelCaliforniaSistema sistema;
	
	public FachadaHotelCalifornia(){
		this.sistema = new HotelCaliforniaSistema();
	}
	public String cadastrarUsuario(String idAutenticacao, String nome, String tipoUsuario, Long documento) {
        return sistema.cadastrarUsuario(idAutenticacao, nome, tipoUsuario, documento).toString();
    }

    public String atualizarUsuario(String idAutenticacao, String idUsuario, String novoTipoUsuario) {
        return sistema.atualizarUsuario(idAutenticacao, idUsuario, novoTipoUsuario).toString();
    }

    public String exibirUsuario(String idUsuario) {
        return sistema.exibirUsuario(idUsuario).toString();
    }

    public String[] listarUsuarios() {
        return sistema.listarUsuarios().stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String disponibilizarQuartoSingle(String idAutenticacao, Integer idQuartoNum, Double precoBase, Double precoPorPessoa) {
        return sistema.cadastrarQuartoSingle(idAutenticacao, idQuartoNum, precoBase, precoPorPessoa).toString();
    }

    public String disponibilizarQuartoDouble(String idAutenticacao, Integer idQuartoNum, Double precoBase, Double precoPorPessoa, String[] pedidos) {
        return sistema.cadastrarQuartoDouble(idAutenticacao, idQuartoNum, precoBase, precoPorPessoa, pedidos).toString();
    }

    public String disponibilizarQuartoFamily(String idAutenticacao, Integer idQuartoNum, Double precoBase, Double precoPorPessoa, String[] pedidos, Integer qtdMaxPessoas) {
        return sistema.cadastrarQuartoFamily(idAutenticacao, idQuartoNum, precoBase, precoPorPessoa, pedidos, qtdMaxPessoas).toString();
    }

    public String exibirQuarto(Integer idQuartoNum) {
        return sistema.exibirQuarto(idQuartoNum).toString();
    }

    public String[] listarQuartos() {
        return sistema.listarQuartos().stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String reservarQuartoSingle(String idAutenticacao, String idCliente, Integer numQuarto, LocalDateTime dataInicio, LocalDateTime dataFim, String[] idRefeicoes) {
        return sistema.reservarQuartoSingle(idAutenticacao, idCliente, numQuarto, dataInicio, dataFim, idRefeicoes).toString();
    }

    public String reservarQuartoDouble(String idAutenticacao, String idCliente, Integer numQuarto, LocalDateTime dataInicio, LocalDateTime dataFim, String[] idRefeicoes, String[] pedidos) {
        return sistema.reservarQuartoDouble(idAutenticacao, idCliente, numQuarto, dataInicio, dataFim, idRefeicoes, pedidos).toString();
    }

    public String reservarQuartoFamily(String idAutenticacao, String idCliente, Integer numQuarto, LocalDateTime dataInicio, LocalDateTime dataFim, String[] idRefeicoes, String[] pedidos, Integer numPessoas) {
        return sistema.reservarQuartoFamily(idAutenticacao, idCliente, numQuarto, dataInicio, dataFim, idRefeicoes, pedidos, numPessoas).toString();
    }

    public String exibirReserva(String idAutenticacao, Long idReserva) {
        return sistema.exibirReserva(idAutenticacao, idReserva).toString();
    }

    public String[] listarReservasAtivasDoCliente(String idAutenticacao, String idCliente) {
        return sistema.listarReservasAtivasDoCliente(idAutenticacao, idCliente).stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String[] listarReservasAtivasDoClientePorTipo(String idAutenticacao, String idCliente, String tipo) {
        return sistema.listarReservasAtivasDoClientePorTipo(idAutenticacao, idCliente, tipo).stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String[] listarReservasAtivasPorTipo(String idAutenticacao, String tipo) {
        return sistema.listarReservasAtivasPorTipo(idAutenticacao, tipo).stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String[] listarReservasAtivas(String idAutenticacao) {
        return sistema.listarReservasAtivas(idAutenticacao).stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String[] listarReservasTodas(String idAutenticacao) {
        return sistema.listarReservasTodas(idAutenticacao).stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String disponibilizarRefeicao(String idAutenticacao, String tipoRefeicao, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, Double valor, Boolean disponivel) {
        return sistema.disponibilizarRefeicao(idAutenticacao, tipoRefeicao, titulo, horarioInicio, horarioFinal, valor, disponivel).toString();
    }

    public String alterarRefeicao(Long idRefeicao, LocalTime horarioInicio, LocalTime horarioFinal, Double valorPorPessoa, Boolean disponivel) {
        return sistema.alterarRefeicao(idRefeicao, horarioInicio, horarioFinal, valorPorPessoa, disponivel).toString();
    }

    public String exibirRefeicao(Long idRefeicao) {
        return sistema.exibirRefeicao(idRefeicao).toString();
    }

    public String[] listarRefeicoes() {
        return sistema.listarRefeicoes().stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String reservarRestaurante(String idAutenticacao, String idCliente, LocalDateTime dataInicio, LocalDateTime dataFim, Integer qtdePessoas, String refeicao, Integer idPag) {
        return sistema.reservarRestaurante(idAutenticacao, idCliente, dataInicio, dataFim, qtdePessoas, refeicao, idPag).toString();
    }

    public String disponibilizarFormaDePagamento(String idAutenticacao, String formaPagamento, Double percentualDesconto) {
        return sistema.disponibilizarFormaDePagamento(idAutenticacao, formaPagamento, percentualDesconto).toString();
    }

    public String alterarFormaDePagamento(String idAutenticacao, Integer idFormaPagamento, String formaPagamento, Double percentualDesconto) {
        return sistema.alterarFormaDePagamento(idAutenticacao, idFormaPagamento, formaPagamento, percentualDesconto).toString();
    }

    public String exibirFormaPagamento(Integer idFormaPagamento) {
        return sistema.exibirFormaPagamento(idFormaPagamento).toString();
    }

    public String[] listarFormasPagamentos() {
        return sistema.listarFormasPagamentos().stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String pagarReservaComDinheiro(String idCliente, Long idReserva, String nomeTitular) {
        return sistema.pagarReservaComDinheiro(idCliente, idReserva, nomeTitular).toString();
    }

    public String pagarReservaComCartao(String idCliente, Long idReserva, String nomeTitular, String numCartao, String validade, String codigoDeSeguranca, Integer qtdeParcelas) {
        return sistema.pagarReservaComCartao(idCliente, idReserva, nomeTitular, numCartao, validade, codigoDeSeguranca, qtdeParcelas).toString();
    }

    public String pagarReservaComPix(String idCliente, Long idReserva, String nomeTitular, String cpf, String banco) {
        return sistema.pagarReservaComPix(idCliente, idReserva, nomeTitular, cpf, banco).toString();
    }

    public String cancelarReserva(String idCliente, String idReserva) {
        return sistema.cancelarReserva(idCliente, idReserva).toString();
    }

    public String disponibilizarAreaComum(String idAutenticacao, String tipoAreaComum, String titulo, LocalTime horarioInicio, LocalTime horarioFinal, Double valorPessoa, Boolean disponivel, Integer qtdMaxPessoas) {
        return sistema.disponibilizarAreaComum(idAutenticacao, tipoAreaComum, titulo, horarioInicio, horarioFinal, valorPessoa, disponivel, qtdMaxPessoas).toString();
    }

    public String alterarAreaComum(String idAutenticacao, Long idAreaComum, LocalTime novoHorarioInicio, LocalTime novoHorarioFinal, Double novoPreco, Integer capacidade, Boolean ativa) {
        return sistema.alterarAreaComum(idAutenticacao, idAreaComum, novoHorarioInicio, novoHorarioFinal, novoPreco, capacidade, ativa).toString();
    }

    public String exibirAreaComum(Long idAreaComum) {
        return sistema.exibirAreaComum(idAreaComum).toString();
    }

    public String[] listarAreasComuns() {
        return sistema.listarAreasComuns().stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public String reservarAuditorio(String idAutenticacao, String idCliente, Long idAuditorio, LocalDateTime dataInicio, LocalDateTime dataFim, Integer qtdMaxPessoas) {
        return sistema.reservarAuditorio(idAutenticacao, idCliente, idAuditorio, dataInicio, dataFim, qtdMaxPessoas).toString();
    }

}
