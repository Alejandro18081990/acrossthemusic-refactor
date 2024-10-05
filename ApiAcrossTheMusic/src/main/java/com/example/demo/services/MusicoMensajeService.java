package com.example.demo.services;

import com.common_microservicios.common_microservicios.commons.services.CommonService;
import com.example.demo.entities.Musico;
import com.example.demo.entities.MusicoMensaje;
import org.springframework.stereotype.Service;

@Service
public interface MusicoMensajeService extends CommonService<MusicoMensaje> {
}
