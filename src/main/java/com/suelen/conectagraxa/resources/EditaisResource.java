package com.suelen.conectagraxa.resources;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.suelen.conectagraxa.model.Editais;
import com.suelen.conectagraxa.model.dto.EditaisDTO;
import com.suelen.conectagraxa.repositories.EditaisRepository;

import lombok.Data;

@Service
@Data
public class EditaisResource {
/*public static void main(String[] args) throws IOException {
	obtemEdital();
}*/
	
	private static final String BASE_URL_FUNCULTURA = "https://www.cultura.pe.gov.br/tipo/funcultura/";
	
	@Autowired
	static
	EditaisRepository repository;

	static String[] headerSeparado = new String[0];


	public static void obtemEdital() throws IOException {
		String url = BASE_URL_FUNCULTURA;
		Document doc;
		doc = Jsoup.connect(url).timeout(6000).get();
		Elements article = doc.select("article.article-editais");
		String header = article.select("header.editais-header.clr").text();
		headerSeparado = header.split("Edital");

		/*	System.out.print(headerSeparado.length);

		for (String x : headerSeparado) {
			System.out.print(x);

		}*/
		
		Editais editais = new Editais(null, url, headerSeparado);
	    editais.setDataTitulo(headerSeparado);
	    editais.setUrl(BASE_URL_FUNCULTURA);
	    repository.save(editais);
	}
	
	public Editais create() {
		EditaisDTO objDTO = new EditaisDTO();
		objDTO.setDataTitulo(headerSeparado);
		objDTO.setUrl(BASE_URL_FUNCULTURA);
		Editais newObj = new Editais(objDTO);
		return repository.save(newObj);
	}
	

	public List<Editais> findAll() {
		return repository.findAll();
	}
	
}