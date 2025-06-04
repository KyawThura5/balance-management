package com.online.balances.model.entity;

import java.time.LocalDate;

import com.online.balances.model.entity.consts.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Member extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(optional = false)
	private Account account;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String phone;
	private LocalDate dob;
	private Gender gender;
	private String profileImage;
	private String email;

	@ManyToOne
	private Township township;
	private String address;
}
