package com.conecta.conectagraxa.model.enums;

public enum Categoria {

SOM (0,"AUDIO"), ILUMINACAO (1, "ILUMINAÇÃO"),PALCO(2,"PALCO"),EQUIPAMENTO(3,"EQUIPAMENTOS"),TODOS(4,"TODOS") ;
	private Integer codigo;
	private String descricao;



	private Categoria(Integer codigo, String descricao) {
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
