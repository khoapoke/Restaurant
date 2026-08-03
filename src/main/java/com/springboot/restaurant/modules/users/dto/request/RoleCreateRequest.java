package com.springboot.restaurant.modules.users.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleCreateRequest {
    
    @Size(min = 3, message="name role must be at least 3 characters")
    private String tenVaiTro;
    
    
}
