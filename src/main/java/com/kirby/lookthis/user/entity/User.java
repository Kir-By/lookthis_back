package com.kirby.lookthis.user.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@DynamicUpdate
@Entity
@Builder
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class User {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String auth;

	private String plateformtype;
	private String accesstoken;
	private String name;
	private LocalDateTime birth;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private Integer point;
	private String phone;
	private Integer removed;
	private String fcmToken;

	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
}
