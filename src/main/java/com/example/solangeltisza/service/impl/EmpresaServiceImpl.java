package com.example.solangeltisza.service.impl;

import com.example.solangeltisza.dao.EmpresaRepository;
import com.example.solangeltisza.entity.EmpresaEntity;
import com.example.solangeltisza.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    //Guardar en BD
    @Override
    public EmpresaEntity crear(EmpresaEntity empresaEntity) {
        return empresaRepository.save(empresaEntity);
    }

    //Buscar por ID
    @Override
    public Optional<EmpresaEntity> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    //Buscar todos
    @Override
    public List<EmpresaEntity> buscarTodos() {
        return empresaRepository.findAll();
    }

    //Actualizar//
    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity) {
       Optional<EmpresaEntity> empresaActualizada =empresaRepository.findById(id);
       if(empresaActualizada.isPresent()){
           EmpresaEntity empresa = empresaActualizada.get();
           empresa.setId(empresaEntity.getId());
           empresa.setRazonSocial(empresaEntity.getRazonSocial());
           empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
           empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
           empresa.setCondicion(empresaEntity.getCondicion());
           empresa.setDistrito(empresaEntity.getDistrito());
           empresa.setProvincia(empresaEntity.getProvincia());
           empresa.setDepartamento(empresaEntity.getDepartamento());
           //empresa.setEstado(personaEntity.getEstado());//
           return empresaRepository.save(empresa);
       }
        return null;
    }
//Eliminar de forma logica//
    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaActualizada =empresaRepository.findById(id);
        if(empresaActualizada.isPresent()){
            empresaActualizada.get().setEstado(0);
            return empresaRepository.save(empresaActualizada.get());
        }
        return null;
    }

}


