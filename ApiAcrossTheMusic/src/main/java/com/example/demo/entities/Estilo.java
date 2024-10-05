package com.example.demo.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="estilo")
@Table(name = "Estilo")
public class Estilo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstilo;

/* 	@OneToMany(mappedBy = "estilo")
	Set<MusicoTocaEstilo> musicoTocaEstilo;
 */
	@Column(name = "nombreEstilo")
	private String nombreEstilo;

	//@OneToMany(mappedBy = "estilo")
	//private List<JamSession> listadoJamsSessions;
}
