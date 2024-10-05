package com.example.demo.services;

import com.common_microservicios.common_microservicios.commons.services.CommonService;
import com.example.demo.entities.JamSession;
import com.example.demo.entities.Musico;
import org.springframework.stereotype.Service;

@Service
public interface MusicoService extends CommonService<Musico> {
}
