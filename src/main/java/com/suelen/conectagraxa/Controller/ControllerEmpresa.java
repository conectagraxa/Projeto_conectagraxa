package com.suelen.conectagraxa.Controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.suelen.conectagraxa.model.Empresa;
import com.suelen.conectagraxa.repositories.EmpresaRepository;

@RestController
@RequestMapping("/api/empresas")
public class ControllerEmpresa {

    private static final Logger logger = LoggerFactory.getLogger(ControllerEmpresa.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        logger.info("Buscando todas as empresas");
        return empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Integer id) {
        logger.info("Buscando empresa com ID: {}", id);
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            logger.info("Empresa encontrada com ID: {}", id);
            return ResponseEntity.ok(empresa.get());
        } else {
            logger.warn("Empresa com ID {} não encontrada", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@Valid @RequestBody Empresa empresa) {
        if (empresa.getId() != null) {
            logger.warn("ID já definido na solicitação POST.");
            return ResponseEntity.badRequest().build();
        }

        logger.info("Criando nova empresa: {}", empresa);

        empresaRepository.save(empresa);

        logger.info("Nova empresa criada com sucesso: {}", empresa);

        return ResponseEntity.ok(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Integer id, @Valid @RequestBody Empresa empresa) {
        logger.info("Atualizando empresa com ID: {}", id);
        Optional<Empresa> existingEmpresa = empresaRepository.findById(id);
        if (existingEmpresa.isPresent()) {
            empresa.setId(id);
            empresaRepository.save(empresa);
            logger.info("Empresa atualizada com ID: {}", id);
            return ResponseEntity.ok(empresa);
        } else {
            logger.warn("Empresa com ID {} não encontrada para atualização", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Integer id) {
        logger.info("Deletando empresa com ID: {}", id);
        empresaRepository.deleteById(id);
        logger.info("Empresa com ID {} deletada com sucesso", id);
        return ResponseEntity.noContent().build();
    }
}
