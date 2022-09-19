package com.kirby.lookthis.user.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.entity.UserFlyer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	private Date birth;
	private Date createDate;
	private Date updateDate;
	private Integer point;
	private String phone;

	@OneToOne(mappedBy = "user")
	private Store store;
}
