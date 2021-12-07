package br.com.aciolecontabilidade.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USERNAME", nullable = false, length = 50, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;
	
	@Column(name = "ENABLED", nullable = false)
	private boolean enabled;
	
	

}
