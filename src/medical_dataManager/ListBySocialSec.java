package medical_dataManager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean (name="listControl_ctr")
@SessionScoped
public class ListBySocialSec {

private Database database = new Database();
    
    private List<Patient> socialSecList;
    

    
  
    
    public ListBySocialSec() {
    	int test = 0;
		socialSecList = database.ListPatientsBySocialSec(test);
    }

	public List<Patient> getSocialSecList() {
		int test = 0;
		socialSecList = database.ListPatientsBySocialSec(test);
		return socialSecList;
	}

	public void setSocialSecList(List<Patient> socialSecList) {
		this.socialSecList = socialSecList;
	}
	
}
