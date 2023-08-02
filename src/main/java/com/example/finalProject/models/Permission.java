package com.example.finalProject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="permission")
@Getter
@Setter
public class Permission extends BaseModel implements GrantedAuthority {
     @Column(name="role")
     private String role;

     @Override
     public String getAuthority() {
          return this.role;
     }
}
