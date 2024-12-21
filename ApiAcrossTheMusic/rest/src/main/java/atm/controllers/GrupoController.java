package atm.controllers;





import com.common_microservicios.commons.controller.CommonController;
import entities.Grupo;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "PI Across the music - Controller Grupo")
@RequestMapping("apiATM/grupos")
public class GrupoController extends CommonController<Grupo, dto.grupoDTO.GrupoDTO, services.GrupoService> {


}
