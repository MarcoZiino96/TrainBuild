package com.idm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.idm.dao.VotoDao;
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
    private UtenteService utenteService;

    @Autowired
    private TrenoService trenoService;

    @Override
    public Voto creaVoto(Voto votoVo) {
        Voto voto = new Voto();
        voto.setTreno(votoVo.getTreno());
        voto.setUtente(votoVo.getUtente());
        voto.setVoto(votoVo.getVoto());
        return votoDao.add(voto);
    }

    @Override
    public Voto findVoto(int id) {
        return votoDao.find(id);
    }

    @Override
    public void deleteVoto(int id) {
        votoDao.delete(id);
    }

    @Override
    public Voto votoEsistente(Integer utenteId, Integer trenoId) {
        return votoDao.votoEsistente(utenteId, trenoId);
    }

    @Override
    public Voto updateVoto(Voto voto) {
        Voto vOld = findVoto(voto.getId());
        vOld.setTreno(trenoService.find(voto.getTreno().getId()));
        vOld.setUtente(utenteService.find(voto.getUtente().getId()));
        vOld.setVoto(voto.getVoto());
        return votoDao.update(vOld);
    }
}
