package com.vivek.simplemedicinedb.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.simplemedicinedb.data.MedicineData;
import com.vivek.simplemedicinedb.data.Person;
import com.vivek.simplemedicinedb.data.PrescribedMedicine;
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
	 *  url payload..(get every data from client side itself).
	 *   ::::::Currently doing both i.e. increased payload and increased service headache.::::
	 */

	public Person addUpdatePrescription(Person p) {

		/**
		System.out.println("\n\n------LENGTH:: "+p.getPhone().length()+" ::"+p.getPhone()+"::");
		System.out.println(p.getPrescribed_medicines()+" "
				+p.getPrescribed_medicines().size()+" "
				+p.getPrescribed_medicines().iterator().next().getMd().getId()+" "
				+p.getId()+" "
				+p.getPrescribed_medicines().iterator().next().getId());
		*/
		
		Iterator<PrescribedMedicine> itr= p.getPrescribed_medicines().iterator();
		while(itr.hasNext()) {

			//check whether medicine data exist or not...
			//if not exist -> save 
			//else fetch and use that.
			PrescribedMedicine pm	=	itr.next();
			checkMedicineDataRedundance(pm);
		}
		return p=pr.save(p);
	}

	private PrescribedMedicine checkMedicineDataRedundance(PrescribedMedicine pm) {
		MedicineData md	=	pm.getMd();
		Integer md_id	= 	md.getId();
		if(md_id!=null) {
			md	=	mdr.findById(md_id).orElse(md);
		}
		pm.setMd(md);
		return pm;
	}


	public List<PrescribedMedicine> getPrescriptions(int person_id){
		List<PrescribedMedicine> list = pmr.getAllByPersonId(person_id);

		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				MedicineData md	=	mdr.findById(list.get(i).getMd().getId()).orElse(null);//else throw exception

				list.get(i).setMd(md);
			}
		}
		return list;
	}

}
