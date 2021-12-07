package br.com.aciolecontabilidade.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "AUTHORITIES")
@AllArgsConstructor
@NoArgsConstructor
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "USERNAME", nullable = false, unique = true)
	private String username;
	
	@Column(name = "AUTHORITY", nullable = false, length = 50)
	private String authority;

}
