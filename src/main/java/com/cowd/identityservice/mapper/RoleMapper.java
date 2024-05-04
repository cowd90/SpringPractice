package com.cowd.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cowd.identityservice.dto.request.RoleRequest;
import com.cowd.identityservice.dto.response.RoleResponse;
import com.cowd.identityservice.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
