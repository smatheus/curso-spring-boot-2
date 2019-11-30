package com.projeto.curso.entidades.enums;

public enum PedidoStatus {
	
	AguardandoPagamento(1),
	Pago(2),
	Enviado(3),
	Entregue(4),
	Cancelado(5);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PedidoStatus valueOf(int code) {
		for(PedidoStatus value : PedidoStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Este código informado é inválido");
	}
}
