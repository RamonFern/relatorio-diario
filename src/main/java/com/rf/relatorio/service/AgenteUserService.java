package com.rf.relatorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rf.relatorio.entity.AgenteUser;
import com.rf.relatorio.exception.AgenteUserNotFoundException;
import com.rf.relatorio.repository.AgenteUserRepository;

@Service
public class AgenteUserService {

	private AgenteUserRepository agenteRepository;
	
	@Autowired
	public AgenteUserService(AgenteUserRepository agenteRepository) {
		this.agenteRepository = agenteRepository;
	}
	
	public AgenteUser createAgenteUser(AgenteUser agenteUser) {
		return agenteRepository.save(agenteUser); 
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<AgenteUser> findAll() {
		return agenteRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public AgenteUser findById(Long id) {
		return agenteRepository.findById(id).orElseThrow(() -> new AgenteUserNotFoundException(id));
	}
	
    @Transactional
	public void delete(Long id) {
		findById(id);
		agenteRepository.deleteById(id);
	}
    
    @Transactional
	public AgenteUser update(Long id, AgenteUser agenteUser) {
    	AgenteUser agenteUserUpdate = findById(id);
    	agenteUserUpdate.setNome(agenteUser.getNome());
    	agenteUserUpdate.setFuncao(agenteUser.getFuncao());
    	agenteUserUpdate.setCodigo(agenteUser.getCodigo());
    	agenteRepository.save(agenteUserUpdate);
		return agenteUserUpdate;
	}
}
