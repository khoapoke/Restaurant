package com.springboot.restaurant.modules.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.restaurant.exception.AppException;
import com.springboot.restaurant.exception.ErrorCode;
import com.springboot.restaurant.modules.user.dto.request.RoleCreateRequest;
import com.springboot.restaurant.modules.user.dto.request.RoleUpdateRequest;
import com.springboot.restaurant.modules.user.dto.response.RoleResponse;
import com.springboot.restaurant.modules.user.entity.Role;
import com.springboot.restaurant.modules.user.mapper.RoleMapper;
import com.springboot.restaurant.modules.user.repository.RoleRepository;
import com.springboot.restaurant.modules.user.service.interfaces.RoleServiceInterface;



@Service
public class RoleService implements RoleServiceInterface {
    
    private final RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;
    
    public RoleService(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository=roleRepository;
    }
    
    
    public List<RoleResponse> getList() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();

    }
    
    @Transactional
    public RoleResponse createdRole(RoleCreateRequest request) {

        if (roleRepository.existsByTenVaiTro(request.getTenVaiTro())) {
            throw new AppException(ErrorCode.ROLE_EXISTED);
        }

        else {
            Role role = roleRepository.save(roleMapper.toEntity(request));

            return roleMapper.toRoleCreateResponse(role);

        }

    }

    public RoleResponse getRole(Long id) {
        
        Role role = roleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        
        RoleResponse response = roleMapper.toRoleResponse(role);
        
        return response;
      }
    @Transactional
      public RoleResponse updateRole(Long id, RoleUpdateRequest request) {

          Role role = roleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

          if (roleRepository.existsByTenVaiTroAndMaVaiTroNot(request.getTenVaiTro(),id)) {
              throw new AppException(ErrorCode.ROLE_EXISTED);

          }

          roleMapper.updateEntityFromRequest(request, role);

          roleRepository.save(role);

          return roleMapper.toRoleUpdatResponse(request);
      }
    
      @Transactional
      public RoleResponse deleteRole(Long id) {
        
          Role role = roleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
         
          roleRepository.delete(role);
          
          return roleMapper.toRoleDeleteResponse(role);
       }
}
