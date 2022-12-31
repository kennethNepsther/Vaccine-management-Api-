package com.vacinas.service.impl;

import com.vacinas.exception.ObjectNotFoundException;
import com.vacinas.model.RoleModel;
import com.vacinas.repository.RoleRepository;
import com.vacinas.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    final RoleRepository roleRepository;

    @Override
    public RoleModel create(RoleModel roleModel) {
        roleModel.setId(null);
        return roleRepository.save(roleModel);
    }

    @Override
    public RoleModel findById(Long id) {
        Optional<RoleModel> role = roleRepository.findById(id);
        return role.orElseThrow(()
                -> new ObjectNotFoundException("Não foi encontrado  objecto com o indetificador " + id));
    }

    @Override
    public List<RoleModel> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        roleRepository.deleteById(id);
    }
}

