package com.focus_group.security.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String role_name;

    public static RoleEntity build(RoleEntity role) {
        return new RoleEntity(
                role.getId(),
                role.getRole_name()
        );
    }
    
}
