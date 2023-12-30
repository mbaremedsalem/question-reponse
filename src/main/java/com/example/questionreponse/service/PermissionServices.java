package com.example.questionreponse.service;

import java.util.List;

import com.example.questionreponse.entity.Permission;


public interface PermissionServices {
    
    public List<Permission> getAllPermissions();

    public Permission createPermission(Permission permission);

    public Permission getPermissionById(long id);

    public Permission updatePermission(long id, Permission updatedPermission);

    public Boolean deletePermission(long id);
}