package com.example.demo.dto.mteDTO;

import com.common_microservicios.commons.dto.CommonDTO;
import com.example.demo.dto.estiloDTO.EstiloDTO;
import lombok.Data;

@Data
public class MusicoTocaEstiloDTO extends CommonDTO {

    private EstiloDTO estilo;
}
