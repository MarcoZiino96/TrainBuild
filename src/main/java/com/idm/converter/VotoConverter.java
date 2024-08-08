package com.idm.converter;

import com.idm.dto.TrenoDTO;
import com.idm.dto.UtenteDTO;
import com.idm.dto.VotoDTO;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.entity.Voto;
import com.idm.vo.VotoVO;

public class VotoConverter {

    
    public static VotoDTO fromVoToDto(VotoVO vo, UtenteDTO utente, TrenoDTO treno) {
        VotoDTO dto = new VotoDTO();
        dto.setId(vo.getId()); 
        dto.setVoto(vo.getVoto());
        dto.setUtente(utente); 
        dto.setTreno(treno);  
        return dto;
    }

   
    public static Voto fromDtoToEntity(VotoDTO dto, Utente utente, Treno treno) {
        Voto entity = new Voto();
     
        entity.setId(dto.getId());
        entity.setVoto(dto.getVoto());
        entity.setUtente(utente);
        entity.setTreno(treno);

        return entity;
    }

  
    public static VotoDTO fromEntityToDto(Voto entity) {
        VotoDTO dto = new VotoDTO();
        dto.setId(entity.getId());
        dto.setVoto(entity.getVoto());
        dto.setUtente(UtenteConverter.fromEntityToDto(entity.getUtente())); 
        dto.setTreno(TrenoConverter.fromEntityToDto(entity.getTreno()));     
        return dto;
    }

    
    public static VotoVO fromDtoToVo(VotoDTO dto) {
        VotoVO vo = new VotoVO();
        vo.setId(dto.getId()); 
        vo.setVoto(dto.getVoto());
        vo.setUtenteId(dto.getUtente().getId());
        vo.setTrenoId(dto.getTreno().getId());
        
        return vo;
    }
}


