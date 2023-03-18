package com.fpt.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "user_entity")
@Data
public class UserEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private int id;
		
		@NotNull(message = "Name may not be empty")
		@NotBlank(message = "Name may not be blank")
		@Column(name = "user_name")
		private String userName;
		
		@Email
		@Column(name = "email")
		private String email;
		
		@Column(name = "address")
		private String address;
		
//		@Size(min = 8, max = 10,message = "abc")
		@Column(name = "phone_number")
		private int phoneNumber;
}
