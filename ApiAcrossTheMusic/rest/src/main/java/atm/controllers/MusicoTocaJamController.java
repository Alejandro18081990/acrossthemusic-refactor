package atm.controllers;



import com.common_microservicios.commons.controller.CommonController;
import entities.MusicoTocaJam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiATM/jams/mtj")
@Tag(name = "PI: Across the music - Controlador MusicoTocaJam")
public class MusicoTocaJamController extends CommonController<MusicoTocaJam, dto.mtj.MusicoTocaJamDTO, services.MusicoTocaJamService> {


    @Autowired
    services.impl.MusicoTocaJamServiceImpl musicoTocaJamService;

    @Operation(summary = "Borra a un músico de la jam")
    @DeleteMapping("/musicoJam/{idMusico}/{idJamSession}")
    public void deleteMusicoJam(@PathVariable long idMusico, @PathVariable long idJamSession) {
        musicoTocaJamService.deleteByMusicoAndJamSession(idMusico, idJamSession);
    }

    @Operation(summary = "Borra todos los registros de la tabla MusicoTocaJam mediante el id del musico recibido")
    @DeleteMapping("/musico/{id}")
    public void deleteMusicoJamByIdMusico(@PathVariable Long id) {
        musicoTocaJamService.deleteMusicoJamByMusicoIdMusico(id);
    }
}
