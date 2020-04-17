package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByusername(String username);
	List<UserEntity> findByRoles_code(String code);
	List<UserEntity> findByBuildings_Id(Long buildingId);
}
