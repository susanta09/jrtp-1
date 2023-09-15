package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPhNo;
	private String userGender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@Column(insertable = true,updatable = false)
	private LocalDate userDob;
	private Integer userSsn;
	private String userAction;
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDate userCreatDate;
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private LocalDate userUpdateDate;
}
