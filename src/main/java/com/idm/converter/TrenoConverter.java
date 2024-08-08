package com.idm.converter;
import com.idm.dto.TrenoDTO;
import com.idm.entity.Treno;
import com.idm.vo.TrenoVO;
import com.idm.entity.Utente;
import com.idm.dto.UtenteDTO;

public class TrenoConverter {

    public static TrenoDTO fromVoToDto(TrenoVO vo, UtenteDTO utente) {
        TrenoDTO dto = new TrenoDTO();
        dto.setId(vo.getId());
        dto.setPrezzo(vo.getPrezzo());
        dto.setPeso(vo.getPeso());
        dto.setLunghezza(vo.getLunghezza());
        dto.setSigla(vo.getSigla());
        dto.setCompagnia(vo.getCompagnia());
        dto.setUtente(utente.getId());
        
        
        return dto;
    }

    public static Treno fromDtoToEntity(TrenoDTO dto, Utente utente) {
        Treno entity = new Treno();
        entity.setId(dto.getId());
        entity.setUtente(utente);
        entity.setPrezzo(dto.getPrezzo());
        entity.setPeso(dto.getPeso());
        entity.setLunghezza(dto.getLunghezza());
        entity.setSigla(dto.getSigla());
        entity.setCompagnia(dto.getCompagnia());
        return entity;
    }

    public static TrenoDTO fromEntityToDto(Treno entity) {
        TrenoDTO dto = new TrenoDTO();
        dto.setId(entity.getId());
        dto.setPrezzo(entity.getPrezzo());
        dto.setPeso(entity.getPeso());
        dto.setLunghezza(entity.getLunghezza());
        dto.setSigla(entity.getSigla());
        dto.setCompagnia(entity.getCompagnia());
        dto.setUtente(UtenteConverter.fromEntityToDto(entity.getUtente()).getId());
 
        return dto;
    }

    public static TrenoVO fromDtoToVo(TrenoDTO dto) {
        TrenoVO vo = new TrenoVO();
        vo.setId(dto.getId());
        vo.setPrezzo(dto.getPrezzo());
        vo.setPeso(dto.getPeso());
        vo.setLunghezza(dto.getLunghezza());
        vo.setSigla(dto.getSigla());
        vo.setCompagnia(dto.getCompagnia());
        vo.setUtente(dto.getUtente());
        

        return vo;
    }
}