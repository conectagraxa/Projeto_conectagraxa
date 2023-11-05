package com.suelen.conectagraxa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/* 
* ClassName - Brief description of the class
*
* Description of the class (if necessary)
*
* @author Name | Initials (if possible)
* @version Version (if possible)
* @since When the class was first introduced)
* @see Fully qualified class names (if necessary)
* @param Name Description of the parameter (if necessary)
* @return Description of the return value (if necessary)
* @throws Exception Description of the exception (if necessary)
*
*/

import lombok.Data;

/* 
* MethodName - Brief description of the method
*
* Description of the method (if necessary)
*
* @param param1 Description of the first parameter (if necessary)
* @param param2 Description of the second parameter (if necessary)
* @return Description of the return value (if necessary)
* @throws IOException Description of the exception (if necessary)
* @customTag Description of the custom tag (if necessary)
*
*/

@Entity (name="seguidor")

@Data
public class Seguidores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*
	 * diferente da estratégia IDENTITY o SEQUENCE retorna o próxima valor gerado no banco , o generator = indica o nome da table.
	 * 
	 * */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "profissional", referencedColumnName = "id")
	private Integer seguidores_id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "profissional", referencedColumnName = "id")
	private Integer seguindo_id;

	
	
}
