package com.cowd.identifyservice.mapper;

import com.cowd.identifyservice.dto.request.PermissionRequest;
import com.cowd.identifyservice.dto.request.RoleRequest;
import com.cowd.identifyservice.dto.response.PermissionResponse;
import com.cowd.identifyservice.dto.response.RoleResponse;
import com.cowd.identifyservice.entity.Permission;
import com.cowd.identifyservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
