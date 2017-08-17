package br.edu.unoesc.revisaoOO.modelo;

public class Conta {

	private Integer numero;
	private Cliente cliente;
	private Double saldo;

	// Método construtor vazio, sem parametros de incialização.
	public Conta() {
		saldo = 0.0;
	}

	// Método construtor para criar objetos com valores inicializados.
	public Conta(Integer numero, Cliente cliente) {
		this();
		this.numero = numero;
		this.cliente = cliente;
	}

	/**
	 * Método depositar,recebe como parametro um valor e soma esse valor no
	 * saldo.
	 * 
	 * @param valor
	 */
	public void depositar(Double valor) {
		this.saldo += valor;
	}

	/**
	 * Método sacar, recebe como parametro um valor e diminui esse valor do
	 * saldo.
	 * 
	 * @param valor
	 */
	public boolean sacar(Double valor) {
		if(this.saldo >= valor){
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public void transferir(Double valor, Conta destino){
		if(this.sacar(valor)){
			destino.depositar(valor);
		}
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

}
