package com.conecta.conectagraxa.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.dto.Feed_ProfissionalDTO;
import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.repositories.ProfissionalRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;
	
	
	
	
	//criar profissional + feed
	public Profissional createProfissional(ProfissionalDTO objDTO) throws Exception {
		objDTO.setSenha(objDTO.getSenha());

	
		validaPorEmail(objDTO);
		Profissional newObj = new Profissional(objDTO);
		
		
		Feed_ProfissionalDTO feedDTO = new Feed_ProfissionalDTO(objDTO);
		Feed_Profissional feed = new Feed_Profissional/*feedService.createFeed*/(feedDTO);
		feed.setIdProfissional(newObj);
		newObj.setId(objDTO.getId());
		newObj.setFeedProfissional(feed);
		repository.save(newObj);
		
		
		return newObj;

	}
	
	


//busca pelo id profissional
	public Profissional findById(Integer id) throws ObjectNotFoundException {

		Optional<Profissional> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado Id: " + id));
	}

	//trazer por nome
	public Profissional findByNome(String nome) throws Exception {
	    Optional<Profissional> obj = repository.findByNomeIgnoreCaseContaining(nome); 
		return obj.orElseThrow(() -> new Exception("objeto nome encontrado Nome: " + nome ));
	}

	//todos os profissionais
	public List<Profissional> getAllProfissional() {
		return repository.findAll();
	}

	public Profissional getProfissionalById(Integer id) throws Exception {
		Optional<Profissional> obj = repository.findById(id);
		return obj.orElseThrow(() -> new Exception("objeto não encontrado Id: " + id));

	}

	//método atualizar senha
	public Profissional atualizaSenha(Integer id, ProfissionalDTO objDTO) {
		objDTO.setId(id);
		Profissional newObj = new Profissional();
		Optional<Profissional> obj = repository.findById(objDTO.getId());

		if (obj.isPresent())

			newObj.setId(obj.get().getId());
		
		if ((obj.get().getSenha().equals(objDTO.getAtual()))) {
			System.out.print("senha válida");
			if (objDTO.getNovaSenha().equals(objDTO.getConfirma())) {
				objDTO.setSenha(objDTO.getNovaSenha());				
				obj.get().setSenha(objDTO.getSenha());

				System.out.print("senha ATUALIZADA");

			}else {
				System.out.print("CONFIRMAÇÃO DE SENHA INCORRETA");
			}
		}else {
			System.out.print("senha NÃO VÁLIDA");
			
		}
		
		if (obj.get().getNome() != null) {
			newObj.setNome(obj.get().getNome());
		}
		if (obj.get().getEmail() != null) {
			newObj.setEmail(obj.get().getEmail());
		}
		if (obj.get().getEtnia() != null) {
			newObj.setEtnia(obj.get().getEtnia());
		}
		if (obj.get().getTelefone() != null) {
			newObj.setTelefone(obj.get().getTelefone());
		}
		if (obj.get().getEndereco() != null) {
			newObj.setEndereco(obj.get().getEndereco());
		}
		if (obj.get().getCep() != null) {
			newObj.setCep(obj.get().getCep());
		}
		if (obj.get().getComplemento() != null) {
			newObj.setComplemento(obj.get().getComplemento());
		}
		if (obj.get().getCidade() != null) {
			newObj.setCidade(obj.get().getCidade());
		}
		if (obj.get().getEstado() != null) {
			newObj.setEstado(obj.get().getEstado());
		}
		if (obj.get().getFotoPerfil() != null) {
			newObj.setFotoPerfil(obj.get().getFotoPerfil());
		}
		if (obj.get().getSenha() != null) {
			newObj.setSenha(obj.get().getSenha());
		}
		if (obj.get().getDataNascimento() != null) {
			newObj.setDataNascimento(obj.get().getDataNascimento());
		}
		if (obj.get().getSexo() != null) {
			newObj.setSexo(obj.get().getSexo());
		}



		if (objDTO.getNome() != null) {
			newObj.setNome(objDTO.getNome());
		}
		if (objDTO.getEmail() != null) {
			newObj.setEmail(objDTO.getEmail());
		}
		if (objDTO.getEtnia() != null) {
			newObj.setEtnia(objDTO.getEtnia());
		}
		if (objDTO.getTelefone() != null) {
			newObj.setTelefone(objDTO.getTelefone());
		}
		if (objDTO.getEndereco() != null) {
			newObj.setEndereco(objDTO.getEndereco());
		}
		if (objDTO.getCep() != null) {
			newObj.setCep(objDTO.getCep());
		}
		if (objDTO.getComplemento() != null) {
			newObj.setComplemento(objDTO.getComplemento());
		}
		if (objDTO.getCidade() != null) {
			newObj.setCidade(objDTO.getCidade());
		}
		if (objDTO.getEstado() != null) {
			newObj.setEstado(objDTO.getEstado());
		}
		if (objDTO.getFotoPerfil() != null) {
			newObj.setFotoPerfil(objDTO.getFotoPerfil());
		}
		
		if (objDTO.getDataNascimento() != null) {
			newObj.setDataNascimento(obj.get().getDataNascimento());
		}
		if (objDTO.getSexo() != null) {
			newObj.setSexo(obj.get().getSexo());
		}

		Profissional old = (newObj);
		Profissional atualizado = repository.save(old);

		return repository.save(atualizado);
	}

	
	//update profissional
	public Profissional update(Integer id, @Valid ProfissionalDTO objDTO) throws Exception {

		objDTO.setId(id);
		Optional<Profissional> obj = repository.findById(id);
		Profissional newObj = new Profissional();

		if (obj.isPresent()) {
			validaPorEmail(objDTO);

			newObj.setId(obj.get().getId());
			if (obj.get().getNome() != null) {
				newObj.setNome(obj.get().getNome());
			}
			if (obj.get().getEmail() != null) {
				newObj.setEmail(obj.get().getEmail());
			}
			if (obj.get().getEtnia() != null) {
				newObj.setEtnia(obj.get().getEtnia());
			}
			if (obj.get().getTelefone() != null) {
				newObj.setTelefone(obj.get().getTelefone());
			}
			if (obj.get().getEndereco() != null) {
				newObj.setEndereco(obj.get().getEndereco());
			}
			if (obj.get().getCep() != null) {
				newObj.setCep(obj.get().getCep());
			}
			if (obj.get().getComplemento() != null) {
				newObj.setComplemento(obj.get().getComplemento());
			}
			if (obj.get().getCidade() != null) {
				newObj.setCidade(obj.get().getCidade());
			}
			if (obj.get().getEstado() != null) {
				newObj.setEstado(obj.get().getEstado());
			}
			if (obj.get().getFotoPerfil() != null) {
				newObj.setFotoPerfil(obj.get().getFotoPerfil());
			}
			if (obj.get().getSenha() != null) {
				newObj.setSenha(obj.get().getSenha());
			}
			if (obj.get().getDataNascimento() != null) {
				newObj.setDataNascimento(obj.get().getDataNascimento());
			}
			if (obj.get().getSexo() != null) {
				newObj.setSexo(obj.get().getSexo());
			}

			// atualiza os campos do objeto com os valores preenchidos no body do objeto DTO
			if (objDTO.getNome() != null) {
				newObj.setNome(objDTO.getNome());
			}
			if (objDTO.getEmail() != null) {
				newObj.setEmail(objDTO.getEmail());
			}
			if (objDTO.getEtnia() != null) {
				newObj.setEtnia(objDTO.getEtnia());
			}
			if (objDTO.getTelefone() != null) {
				newObj.setTelefone(objDTO.getTelefone());
			}
			if (objDTO.getEndereco() != null) {
				newObj.setEndereco(objDTO.getEndereco());
			}
			if (objDTO.getCep() != null) {
				newObj.setCep(objDTO.getCep());
			}
			if (objDTO.getComplemento() != null) {
				newObj.setComplemento(objDTO.getComplemento());
			}
			if (objDTO.getCidade() != null) {
				newObj.setCidade(objDTO.getCidade());
			}
			if (objDTO.getEstado() != null) {
				newObj.setEstado(objDTO.getEstado());
			}
			if (objDTO.getFotoPerfil() != null) {
				newObj.setFotoPerfil(objDTO.getFotoPerfil());
			}

		}
		Profissional old = (newObj);
		Profissional atualizado = repository.save(old);
		return atualizado;

	}

	//validação de email
	private void validaPorEmail(ProfissionalDTO objDTO) throws Exception {
		Optional<Profissional> obj = repository.findById(objDTO.getId());
		obj = repository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new Exception("E-mail já cadastrado no Sistema! ");
		}

	}
}