package com.idm.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.idm.dto.UtenteDTO;
import com.idm.entity.Utente;
import com.idm.vo.UtenteVO;

public class UtenteConverter {

   
    public static UtenteDTO fromVoToDto(UtenteVO vo) {
        UtenteDTO dto = new UtenteDTO();
        dto.setId(vo.getId());
        dto.setNome(vo.getNome());
        dto.setCognome(vo.getCognome());
       dto.setDataNascita(vo.getDataNascita());
        dto.setUsername(vo.getUsername());
        dto.setEmail(vo.getEmail());
        dto.setPassword(vo.getPassword());
        return dto;
    }

  
    public static Utente fromDtoToEntity(UtenteDTO dto) {
        Utente entity = new Utente();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCognome(dto.getCognome());
        entity.setDataNascita(LocalDate.parse(dto.getDataNascita()));
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword()); 
        return entity;
    }

  
    public static UtenteDTO fromEntityToDto(Utente entity) {
        UtenteDTO dto = new UtenteDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCognome(entity.getCognome());
        String dataNascitaString = entity.getDataNascita().format(formatter);
        dto.setDataNascita(dataNascitaString);
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword()); 
        return dto;
    }

  
    public static UtenteVO fromDtoToVo(UtenteDTO dto) {
        UtenteVO vo = new UtenteVO();
        vo.setId(dto.getId());
        vo.setNome(dto.getNome());
        vo.setCognome(dto.getCognome());
        vo.setDataNascita(dto.getDataNascita());
        vo.setUsername(dto.getUsername());
        vo.setEmail(dto.getEmail());
        vo.setPassword(dto.getPassword()); 
        return vo;
    }
}