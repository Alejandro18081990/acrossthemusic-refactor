package com.example.demo.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "instrumento")
public class Instrumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idInstrumento;
	@JsonIgnore
 	@OneToMany(mappedBy = "instrumento" , fetch = FetchType.EAGER)
	Set<MusicoTocaInstrumento> musicoTocaInstrumento;

	@Column(name = "nombreInstrumento")
	private String nombreInstrumento;

}
