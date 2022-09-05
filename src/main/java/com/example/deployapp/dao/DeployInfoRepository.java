package com.example.deployapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deployapp.entity.DeployInfoEntity;

public interface DeployInfoRepository extends JpaRepository<DeployInfoEntity, Long> {

}
