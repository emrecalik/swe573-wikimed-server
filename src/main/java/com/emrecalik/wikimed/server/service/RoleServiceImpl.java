package com.emrecalik.wikimed.server.service;

import com.emrecalik.wikimed.server.domain.Role;
import com.emrecalik.wikimed.server.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByRoleName(Role.RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
