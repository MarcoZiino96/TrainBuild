package com.idm.abstractClasses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.entity.Treno;
import com.idm.exception.CargoException;
import com.idm.exception.LocomotivaException;
import com.idm.exception.RistoranteException;
import com.idm.exception.StringaException;
import com.idm.interfaces.Vagone;




public abstract class TrenoBuilderAbstract {
	
	 
	public Treno creaTreno(String input){
		
		Treno treno = new Treno();

	List<AbstractVagone> vagoni  = new ArrayList<>() ;
	
		String strgMaiuscola = input.toUpperCase();
		
		try{
			validaStringa(strgMaiuscola);
			vagoni = creaLocomotiva(strgMaiuscola);


			vagoni.addAll(creaVagoni(strgMaiuscola));
			
			for (AbstractVagone vagone : vagoni) {
	            vagone.setTreno(treno); 
	            System.out.println(vagone);
	        }

			treno.setVagoni(vagoni);
			System.out.println(vagoni);
			

		}catch (StringaException e) {
            throw e;
        } catch (LocomotivaException e) {
            throw e;
        } catch (CargoException e) {
            throw e;
        } catch (RistoranteException e) {
            throw e;
        }

        return treno;
    }

  

	private List<AbstractVagone> creaLocomotiva(String tipo){
		

		char locomotivaTesta = tipo.charAt(0);
		char locomotivaCoda = tipo.charAt(tipo.length() -1);
		List<AbstractVagone> vagoni = new ArrayList<>();
		char[] arrayLocomotive = {locomotivaTesta, locomotivaCoda};

		if (locomotivaTesta != 'H') {
			throw new LocomotivaException("La locomotiva non è in testa al treno", tipo);
		}

		vagoni.add(getCostruisciLocomotiva()); // Aggiungi sempre una locomotiva in testa

		if (locomotivaCoda == 'H') {
			vagoni.add(getCostruisciLocomotiva()); // Aggiungi una seconda locomotiva in coda se presente
		}
		
		return vagoni;
	}

	private List<AbstractVagone> creaVagoni(String composizione) {
		
		String vagoniComposizione = "";
		boolean contieneCargo = composizione.indexOf('C') != -1;
		int ristoranteCount = 0;
		
		if(composizione.charAt(0) == 'H' && composizione.charAt(composizione.length() - 1) == 'H' )
			vagoniComposizione = composizione.substring(1, composizione.length() - 1);
		
		else if (composizione.charAt(0) == 'H')
			vagoniComposizione = composizione.substring(1);
		

		List<AbstractVagone> vagoni = new ArrayList<>();

		if (contieneCargo) {
			for (char tipo : vagoniComposizione.toCharArray()) {
				if (tipo != 'C') {
					throw new CargoException("Se è presente un Cargo ('C'), tutti i vagoni devono essere Cargo.", composizione);
				}
				vagoni.add(getCostruisciVagoneCargo());

			}
			return vagoni;
		}

		for (char tipo : vagoniComposizione.toCharArray()) {

			switch (tipo) {
			case 'P':
				vagoni.add(getCostruisciVagonePasseggieri());
				break;
			case 'R':
				if(ristoranteCount >= 1)
				throw new RistoranteException("Ci può essere solo un ristorante", composizione);
				vagoni.add(getCostruisciVagoneRistorante());
				ristoranteCount++;
				break;
			default:
				throw new LocomotivaException("Le locomotive non possono essere piu di due e vanno aggiunte in testa e in coda: ", composizione);
			}
		}

		return vagoni;
	}

	private void validaStringa(String input){
		if(input.length() < 2 || input.length() > 8)
			throw  new StringaException("La stringa non è valida", input);
	}
	

	abstract protected AbstractVagone getCostruisciVagoneCargo();

	abstract protected AbstractVagone getCostruisciLocomotiva();

	abstract protected AbstractVagone  getCostruisciVagoneRistorante();

	abstract protected AbstractVagone  getCostruisciVagonePasseggieri();
	
	
}

