package com.cowd.identifyservice.service;

import com.cowd.identifyservice.dto.request.PermissionRequest;
import com.cowd.identifyservice.dto.request.RoleRequest;
import com.cowd.identifyservice.dto.response.PermissionResponse;
import com.cowd.identifyservice.dto.response.RoleResponse;
import com.cowd.identifyservice.entity.Permission;
import com.cowd.identifyservice.entity.Role;
import com.cowd.identifyservice.mapper.PermissionMapper;
import com.cowd.identifyservice.mapper.RoleMapper;
import com.cowd.identifyservice.repository.PermissionRepository;
import com.cowd.identifyservice.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
                .stream().map(roleMapper::toRoleResponse)
                .toList();
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }

}
