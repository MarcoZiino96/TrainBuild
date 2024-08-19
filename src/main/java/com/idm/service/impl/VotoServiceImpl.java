package com.idm.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.idm.dao.VotoDao;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.entity.Voto;
import com.idm.service.TrenoService;
import com.idm.service.UtenteService;
import com.idm.service.VotoService;
import com.idm.vo.VotoVO;

@Component
public class VotoServiceImpl implements VotoService {

    @Autowired
    private VotoDao votoDao;
    
    @Autowired 
    private TrenoService trenoService;
    
    @Autowired 
    private UtenteService utenteService;
    
    @Override
    public Voto findVoto(int id) {
        Voto p = votoDao.find(id);
        if (p == null)
            throw new RuntimeException("Voto non trovato!!!");
        return p;
    }

    @Override
    public Voto creaVoto(Voto voto) {    
        Voto v = new Voto();
        v.setTreno(voto.getTreno());
        v.setUtente(voto.getUtente());
        v.setVoto(voto.getVoto());
        votoDao.add(v);
        return v;
    }

    @Override
    public void deleteVoto(int id) {
        Voto voto = findVoto(id);
        votoDao.delete(voto.getId());    
    }

    @Override
    public Voto updateVoto(Voto voto, int id) {
        Voto vOld = findVoto(id);
        vOld.setTreno(voto.getTreno());
        vOld.setUtente(voto.getUtente());
        vOld.setVoto(voto.getVoto());
        votoDao.update(vOld);
        return vOld;
    }

    @Override
    public Voto votoEsistente(Integer utente, Integer treno) {
        return votoDao.votoEsistente(utente, treno);
    }
    
    @Override
    public Voto salvaOUpdateVoto(VotoVO votoVo) {
        Voto exsistingVoto = votoEsistente(votoVo.getUtenteId(), votoVo.getTrenoId());
        Utente utente = utenteService.find(votoVo.getUtenteId());
        Treno treno = trenoService.find(votoVo.getTrenoId());
        Voto voto;
        if (exsistingVoto == null) {
            voto = new Voto();
            voto.setUtente(utente);
            voto.setTreno(treno);
            BeanUtils.copyProperties(votoVo, voto, "id");
            creaVoto(voto);        
        } else {
            voto = new Voto();
            voto.setVoto(votoVo.getVoto());
            voto.setUtente(exsistingVoto.getUtente());  
            voto.setTreno(exsistingVoto.getTreno());
            BeanUtils.copyProperties(votoVo, voto, "id");             
            updateVoto(voto, exsistingVoto.getId());    
        }
        return voto;
    }
}
