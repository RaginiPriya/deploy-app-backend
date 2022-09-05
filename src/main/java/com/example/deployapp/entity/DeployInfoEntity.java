package com.example.deployapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class DeployInfoEntity {
	
//	@Id
//	@Column
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
	
    @Id
    @GenericGenerator(name = "notification_id", strategy = "com.example.deployapp.entity.NotificationIdGenerator")
    @GeneratedValue(generator = "notification_id")  
    @Column(name="notification_id")
    private String notificationId;
	
	@Column
	String application;
	
	@Column
	String description;
	

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}


	public String getApplication() {
		return application;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
