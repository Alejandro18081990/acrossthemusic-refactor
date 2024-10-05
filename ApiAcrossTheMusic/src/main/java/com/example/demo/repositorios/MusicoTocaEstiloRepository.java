package com.example.demo.repositorios;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MusicoTocaEstilo;
@Repository
public interface MusicoTocaEstiloRepository extends JpaRepository<MusicoTocaEstilo, Long> {

	@Transactional
	void deleteMusicoTocaEstiloByMusicoIdMusico(Long idMusico);
	
}
