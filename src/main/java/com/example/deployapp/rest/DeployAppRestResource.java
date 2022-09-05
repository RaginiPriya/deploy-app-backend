package com.example.deployapp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.deployapp.dao.DeployInfoRepository;
import com.example.deployapp.dao.SubscriptionRepository;
import com.example.deployapp.entity.DeployInfoEntity;
import com.example.deployapp.entity.Subscriptions;
import com.example.deployapp.model.DeployInfo;
import com.example.deployapp.model.NotificationId;
import com.example.deployapp.model.SubscriptionsInfo;

@Component
@Scope("request")
@Path("/deploy")
public class DeployAppRestResource {
	
	@Autowired
	DeployInfoRepository deployInfoRepository;
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/info")
	public NotificationId saveDeployInfo(DeployInfo payload) {
		DeployInfoEntity deployInfoEntity = new DeployInfoEntity();
		BeanUtils.copyProperties(payload, deployInfoEntity);
		DeployInfoEntity savedDeployEntity = deployInfoRepository.save(deployInfoEntity);
		NotificationId notificationId = new NotificationId();
		notificationId.setId(savedDeployEntity.getNotificationId());
		return notificationId;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/info")
	public List<DeployInfo> getDeployInfo() {
		List<DeployInfoEntity> deployInfoEntityList = deployInfoRepository.findAll();
		List<DeployInfo> deployInfoList = new ArrayList<>();
		for(DeployInfoEntity deployInfoEntity : deployInfoEntityList) {
			DeployInfo deployInfo = new DeployInfo();
			BeanUtils.copyProperties(deployInfoEntity, deployInfo);
			deployInfoList.add(deployInfo);
		}
		return deployInfoList;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/subscription")
	public void saveSubscriptionInfo(SubscriptionsInfo payload) {
		List<String> subscribes = payload.getSubscribe();
		for(String subscribe : subscribes) {
			Subscriptions sub = new Subscriptions();
			sub.setUserId("ragini");
			sub.setApplication(subscribe);
			subscriptionRepository.save(sub);
		}
		List<String> unsubscribes = payload.getUnsubscribe();
		for(String subscribe : unsubscribes) {
			Subscriptions sub = new Subscriptions();
			sub.setUserId("ragini");
			sub.setApplication(subscribe);
			subscriptionRepository.delete(sub);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/subscription")
	public List<String> getSubscriptionInfo() {
		List<Subscriptions> subscriptionsList = subscriptionRepository.findByUserId("ragini");
		List<String> applications = subscriptionsList.stream().map(s -> s.getApplication()).collect(Collectors.toList());
		return applications;
	}

}
