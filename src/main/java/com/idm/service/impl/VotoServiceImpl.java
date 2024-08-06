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
    VotoDao votoDao;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private TrenoService trenoService;

    @Override
    public Voto creaVoto(VotoVO votoVo) {
        Voto voto = new Voto();
        voto.setTreno(trenoService.find(votoVo.getTrenoId()));
        voto.setUtente(utenteService.find(votoVo.getUtenteId()));
        voto.setVoto(votoVo.getVoto());
        return votoDao.add(voto);
    }

    @Override
    public Voto findVoto(int id) {
        return votoDao.find(id);
    }

    @Override
    public Voto updateVoto(VotoVO votoVo, int id) {
        Voto vOld = findVoto(id);
        vOld.setTreno(trenoService.find(votoVo.getTrenoId()));
        vOld.setUtente(utenteService.find(votoVo.getUtenteId()));
        vOld.setVoto(votoVo.getVoto());
        return votoDao.update(vOld);
    }

    @Override
    public void deleteVoto(int id) {
        votoDao.delete(id);
    }

   
}
