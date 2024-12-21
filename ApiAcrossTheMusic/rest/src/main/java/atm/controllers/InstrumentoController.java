package atm.controllers;


import com.common_microservicios.commons.controller.CommonController;
import entities.Instrumento;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("apiATM/instrumentos")
@Tag(name = "PI Across the music - Controlador instrumentos")
public class InstrumentoController extends CommonController<Instrumento, dto.instrumentoDTO.InstrumentoDTO, services.InstrumentoService> {


}
