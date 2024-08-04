package com.example.bank.services;

import com.example.bank.DTO.ED807DTO;
import com.example.bank.entities.ED807Entity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.ED807Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ED807Service {

    @Autowired
    private ED807Repository repository;

    @Autowired
    private DTOMapper mapper;
    @Transactional(readOnly = true)
    public List<ED807DTO> getAllED807() {
        List<ED807Entity> entities = repository.findAll();
        return mapper.toEd807ListDto(entities);
    }
    @Transactional(readOnly = true)
    public ED807DTO getEd807ById(Long id) {
        ED807Entity entity = repository.findById(id).orElse(null);
        return mapper.toEd807Dto(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
