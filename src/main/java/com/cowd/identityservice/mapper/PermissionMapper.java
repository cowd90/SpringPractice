package com.cowd.identityservice.mapper;

import com.cowd.identityservice.dto.request.PermissionRequest;
import com.cowd.identityservice.dto.response.PermissionResponse;
import com.cowd.identityservice.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
