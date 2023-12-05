package com.conecta.conectagraxa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.controller.EmpresaController;
import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Feed_Empresa;
import com.conecta.conectagraxa.model.dto.EmpresaDTO;
import com.conecta.conectagraxa.model.dto.Feed_EmpresaDTO;
import com.conecta.conectagraxa.repositories.EmpresaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EmpresaService {

    private final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
   
    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Autowired
	private PasswordEncoder enconder;
	
        
    //criar empresa
    @Transactional
    public Empresa createEmpresa(EmpresaDTO objDTO) throws Exception {

		objDTO.setSenha(enconder.encode(objDTO.getSenha()));

    	validaPorCpfCnpjEEmail(objDTO);
		Empresa newObj = new Empresa(objDTO);
		Feed_EmpresaDTO feedDTO = new Feed_EmpresaDTO(objDTO);
		Feed_Empresa feed = new Feed_Empresa/*feedService.createFeed*/(feedDTO);
		feed.setIdEmpresa(newObj);
		newObj.setId(objDTO.getId());
		newObj.setFeedEmpresa(feed);
		return empresaRepository.save(newObj);
    	
    }
    //procura cnpj ou cpf
    public Empresa findByCpfCnpj(String cpfCnpj) throws Exception {
		Optional<Empresa> obj = empresaRepository.findByCpfCnpj(cpfCnpj);
		return obj.orElseThrow(() -> new Exception("objeto não encontrado CPF/CNPJ: " + cpfCnpj));
    }
    //procura por nome fantasia
	public Empresa findByNomeFantasia(String nome) throws Exception {
	    Optional<Empresa> obj = empresaRepository.findByNomeFantasiaIgnoreCaseContaining(nome); 
		return obj.orElseThrow(() -> new Exception("objeto nome encontrado Nome: " + nome ));
	}
    
    //listar todas empresas
    public List<Empresa> getAllEmpresas() {
        logger.info("Buscando todas as empresas");
        return empresaRepository.findAll();
    }



    //atualiza senha
	public Empresa atualizaSenha(Integer id, EmpresaDTO objDTO) {

		objDTO.setId(id);
		Empresa newObj = new Empresa();
		Optional<Empresa> obj = empresaRepository.findById(objDTO.getId());

		if (obj.isPresent())

			newObj = obj.get();
		if (enconder.matches(objDTO.getAtual(),obj.get().getSenha())) {

			System.out.print("senha válida");
			if (objDTO.getNovaSenha().equals(objDTO.getConfirma())) {
				objDTO.setSenha(objDTO.getNovaSenha());				

				
				newObj.setSenha (enconder.encode(objDTO.getSenha()));

				System.out.print("senha ATUALIZADA");

			}else {
				System.out.print("CONFIRMAÇÃO DE SENHA INCORRETA");
			}
		}else {
			System.out.print("senha NÃO VÁLIDA");
		}

		if (obj.get().getNomeFantasia() != null) {
			newObj.setNomeFantasia(obj.get().getNomeFantasia());
		}
		if (obj.get().getEmail() != null) {
			newObj.setEmail(obj.get().getEmail());
		}
		
	
		if (obj.get().getCpfCnpj() != null) {
			newObj.setCpfCnpj(obj.get().getCpfCnpj());
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
		if (obj.get().getFotoPerfilPath() != null) {
			newObj.setFotoPerfilPath(obj.get().getFotoPerfilPath());
		}
		
	
	Empresa old = (newObj);
	Empresa atualizado = empresaRepository.save(old);
	return atualizado;
	
	}
	public Empresa findById(Integer id) throws ObjectNotFoundException {

		// opcional -> pode ou não encontrar o elemento pelo id
		Optional<Empresa> obj = empresaRepository.findById(id);

		// ou se não encontrar, retorna nulo
		// return obj.orElse(null);

		// ou se não encontrar, retorna uma exceção
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado Id: " + id));
	}

	
	
	
	
	//empresa update
    public Empresa update( Integer id, @Valid EmpresaDTO objDTO) throws Exception {
		objDTO.setId(id);
		Optional<Empresa> obj = empresaRepository.findById(id);
		Empresa newObj = new Empresa();
		validaPorCpfCnpjEEmail(objDTO);

		if (obj.isPresent()) {

		newObj.setId(obj.get().getId());
		if (obj.get().getNomeFantasia() != null) {
			newObj.setNomeFantasia(obj.get().getNomeFantasia());
		}
		if (obj.get().getEmail() != null) {
			newObj.setEmail(obj.get().getEmail());
		}
		
	
		if (obj.get().getCpfCnpj() != null) {
			newObj.setCpfCnpj(obj.get().getCpfCnpj());
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
		if (obj.get().getFotoPerfilPath() != null) {
			newObj.setFotoPerfilPath(obj.get().getFotoPerfilPath());
		}
		if (obj.get().getSenha() != null) {
			newObj.setSenha(obj.get().getSenha());
		}
		

		// atualiza os campos do objeto com os valores preenchidos no body do objeto DTO
		if (objDTO.getNomeFantasia() != null) {
			newObj.setNomeFantasia(objDTO.getNomeFantasia());
		}
		if (objDTO.getEmail() != null) {
			newObj.setEmail(objDTO.getEmail());
		}

		if (objDTO.getCpfCnpj() != null) {
			newObj.setCpfCnpj(objDTO.getCpfCnpj());
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
		if (objDTO.getFotoPerfilPath() != null) {
			newObj.setFotoPerfilPath(objDTO.getFotoPerfilPath());
		}
		
	

	
		}
		
	
		
	Empresa old = (newObj);
	Empresa atualizado = empresaRepository.save(old);
	return atualizado;
    }
    
    //validação email cpf ou cnpj
    private void validaPorCpfCnpjEEmail(EmpresaDTO objDTO) throws Exception {
		Optional<Empresa> obj = empresaRepository.findByCpfCnpj(objDTO.getCpfCnpj());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new Exception("CPF já cadastrado no Sistema! ");
		}

		obj = empresaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new Exception("E-mail já cadastrado no Sistema! ");
		}
		
	
	}
}
