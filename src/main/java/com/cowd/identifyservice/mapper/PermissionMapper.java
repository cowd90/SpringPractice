package com.cowd.identifyservice.mapper;

import com.cowd.identifyservice.dto.request.PermissionRequest;
import com.cowd.identifyservice.dto.request.UserCreationRequest;
import com.cowd.identifyservice.dto.request.UserUpdateRequest;
import com.cowd.identifyservice.dto.response.PermissionResponse;
import com.cowd.identifyservice.entity.Permission;
import com.cowd.identifyservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
