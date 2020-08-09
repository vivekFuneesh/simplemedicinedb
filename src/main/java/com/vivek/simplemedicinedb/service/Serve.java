package com.vivek.simplemedicinedb.service;

import java.util.Iterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.simplemedicinedb.data.MedicineData;
import com.vivek.simplemedicinedb.data.Person;
import com.vivek.simplemedicinedb.data.PrescribedMedicine;
import com.vivek.simplemedicinedb.dto.PersonDto;
import com.vivek.simplemedicinedb.glitches.MedicineDataIncompleteException;
import com.vivek.simplemedicinedb.repository.MedicineDataRepo;
import com.vivek.simplemedicinedb.repository.PersonRepo;
import com.vivek.simplemedicinedb.repository.PrescribedMedicineRepo;

@Service
public class Serve{

	@Autowired
	PersonRepo pr;

	@Autowired
	MedicineDataRepo mdr;

	@Autowired
	PrescribedMedicineRepo pmr;

	/**
	 * For the time, keeping it very very simple... i.e. every time all prescribed medicines must be there in list..
	 * as it will overwrite every thing from before.
	 * What should be choosen here? Server headache(recieve only medicinedata Id and fetch details, populate
	 *  prescribedmedicine and save) OR<br>
	 *  url payload..(get every data from client side itself).<br>
	 *   ::::::<b>Currently doing Less payload and DECREASED service headache....</b>::::
	 */

	public PersonDto addUpdatePrescription(PersonDto p) {

		for(int i=0;i<p.getPrescribed_medicines().size();i++) {
			if(p.getPrescribed_medicines().get(i).getDosage_amount() <= 0) {
				p.getPrescribed_medicines().remove(i);i--;
			}
		}
		Person p1=pr.getPersonByPhone(p.getPhone());

		ModelMapper mm=new ModelMapper();
		Person preq=mm.map(p, Person.class);

		if(p1!=null) {
			p1.setName(preq.getName());
			p1.getPrescribed_medicines().clear();			
		}	

		if(preq.getPrescribed_medicines()==null || preq.getPrescribed_medicines().size()==0)
			throw new MedicineDataIncompleteException(" nameless medicine");

		Iterator<PrescribedMedicine> itr=preq.getPrescribed_medicines().iterator();

		while(itr.hasNext()) {
			PrescribedMedicine pm= itr.next();
			MedicineData md=pm.getMd(), tmp;

			if( !isBlank(md.getMfg_By()) && !isBlank(md.getMktd_By()) )
				tmp=mdr.findTopByNameAndMfg_ByAndMktd_By(md.getName(), md.getMfg_By(), md.getMktd_By());
		
			else if( !isBlank(md.getMfg_By()) )
				tmp=mdr.findTopByNameAndMfg_By(md.getName(), md.getMfg_By());
			
			else if( !isBlank(md.getMktd_By()) )
				tmp=mdr.findTopByNameAndMktd_By(md.getName(), md.getMktd_By());
			
			else tmp=mdr.findByName(md.getName());
			//System.out.println(tmp+" tmp found in database.");
			//	System.out.println(tmp+" tmp found in database.."+tmp.getName()+" "+tmp.getMfg_By()+" "+tmp.getMktd_By());
			
			if(tmp!=null) {
				md=tmp;
			}
			else if ( isBlank(md.getMfg_By()) || isBlank(md.getMktd_By()) )
				throw new MedicineDataIncompleteException(md.getName());
			
			pm.setMd(md); 
			if(p1!=null)p1.getPrescribed_medicines().add(pm);
		}

		if(p1!=null)preq=p1;

		return mm.map(pr.save(preq), PersonDto.class);
	}

	private boolean isBlank(String str) {
		if( str==null || "".equals(str.trim()) )return true;
		return false;
	}

	public PersonDto getPrescriptions(String phone){
		Person p=pr.getPersonByPhone(phone);
		PersonDto pdto=null;
		if(p!=null)pdto=new ModelMapper().map(p, PersonDto.class);
		return pdto;
	}

}
