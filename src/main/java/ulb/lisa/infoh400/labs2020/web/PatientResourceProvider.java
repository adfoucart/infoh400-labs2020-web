/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.infoh400.labs2020.web;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.IResourceProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.instance.model.api.IIdType;

/**
 *
 * @author Adrien Foucart
 */
public class PatientResourceProvider implements IResourceProvider {
    @Override
    public Class<Patient> getResourceType() {
        return Patient.class;
    }
    
    // Read method will be accessed by:
    // /fhir/Patient/{id}    
    @Read()
    public Patient getResourceById(@IdParam IIdType pid){        
        Patient p = new Patient();
        p.addName().setFamily("Test");
        p.getNameFirstRep().addGiven("Test");
        p.setBirthDate(new Date());
        p.addTelecom().setValue("0123456789");
        p.setId(new IdType("Patient", "1234"));
        
        return p;
    }
    
    
    // Search method will be accessed by:
    // /fhir/Patient?family={name}
    @Search()
    public List<Patient> getPatient(@RequiredParam(name = Patient.SP_FAMILY) StringParam name) { 
        Patient p = new Patient();
        p.addName().setFamily("Test");
        p.getNameFirstRep().addGiven("Test");
        p.setBirthDate(new Date());
        p.addTelecom().setValue("0123456789");
        p.setId(new IdType("Patient", "1234"));
        
        List<Patient> searchResults = new ArrayList();
        searchResults.add(p);

        return searchResults;
    }
}
