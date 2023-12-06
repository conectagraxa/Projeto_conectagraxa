package com.conecta.conectagraxa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.BeanUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="seguidores")

public class Seguidores implements Serializable {
	private static final long serialVersionUID = 1L;

	public Seguidores(Seguidores obj) {
		BeanUtils.copyProperties(obj, this);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "seguidores_id")
	private Profissional seguidoresId;
	
	@ManyToOne
    @JoinColumn(name = "seguindo_id")
	private Profissional seguindoId;
}
