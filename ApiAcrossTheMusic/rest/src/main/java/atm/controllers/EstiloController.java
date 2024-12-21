package atm.controllers;



import com.common_microservicios.commons.controller.CommonController;
import entities.Estilo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.EstiloService;


@RestController
@RequestMapping("apiATM/estilos")
@Tag(name = "PI Across the music - Controller Estilos")
public class EstiloController extends CommonController<Estilo, dto.estiloDTO.EstiloDTO, EstiloService> {

}
