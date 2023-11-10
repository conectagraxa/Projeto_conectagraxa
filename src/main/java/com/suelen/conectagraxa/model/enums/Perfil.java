package com.suelen.conectagraxa.model.enums;


public enum Perfil {
	//array --> posições 0,1,2
	ADMIN (0,"ROLE_PROFISSIONAL"), CLIENTE (1, "ROLE_EMPRESA");
	
	private Integer codigo;
	private String descricao;
	
	
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}



	public Integer getCodigo() {
		return codigo;
	}



	public String getDescricao() {
		return descricao;
	}

	
	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		
		}
		throw new IllegalArgumentException("Perfil Inválido");
	}
	
	

}
