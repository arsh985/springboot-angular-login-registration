package com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.repository;

import com.springSecurityAngularJavaTechie.springSecAngularByJavaTechie.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
