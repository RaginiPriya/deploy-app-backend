package com.example.deployapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deployapp.entity.Subscriptions;

public interface SubscriptionRepository extends JpaRepository<Subscriptions, Long> {
	
	List<Subscriptions> findByUserId(String userId);

}
