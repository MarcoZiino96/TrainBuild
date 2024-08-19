package com.idm.dao;

import org.springframework.stereotype.Component;

import com.idm.entity.Voto;

@Component
public interface VotoDao {
    
    public Voto add(Voto p);
    
    public Voto update(Voto p);

    public Voto find(Integer id);
    
    public void delete(int id);
    
    public Voto votoEsistente(Integer utente, Integer treno);
}
