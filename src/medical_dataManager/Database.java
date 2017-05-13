package medical_dataManager;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.sql.DataSource;
@ManagedBean(name="database")
@ViewScoped
@SessionScoped

public class Database implements Serializable{

	private static final long serialVersionUID = 1L;
	private Connection connection = null;
    private Statement st = null;
    private ResultSet rs = null;
    @Resource(name="jdbc/medical_dataManager")
    private DataSource dss;
    private int test;
    
    //Data fields related to Patients
    
    private int newPatientId;
    private String newPatientName;
    private int newPatientSocialSec;
    private String newPatientGender;
    private String newPatientBirthDate;
    private int newPatientAge;
    private String newPatientPills;
    private String newPatientTreatments;
    private String newPatientArtefact;
    private String newPatientDiagnosis;
    private String newPatientVisitDate;
    private int deletePatientById;

    //Data fields related to Visits
    private int visitPatientId;
	private String visitPatientName;
	private int visitPatientSocialSec;
    private String visitPatientDiagnosis;
    private String newVisitPatientPills;
    private String newVisitPatientTreatment;
    private int deleteVisitPatientById;
      
    
	public void connection() throws SQLException{
    	try {
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_dataManager?verifyServerCertificate=false&useSSL=true", "root","inforendszerBead");
    		
    	  } catch (Exception e) {
    		
    		System.out.println(e.getMessage());
    	  }
    }
	public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	/////
	public List<Patient> ListPatients(){
		
		  List<Patient> patientList = new ArrayList<>();
		  
		
        try {
            connection();
          
            PreparedStatement ps = connection.prepareStatement("Select * From Patients ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patientId"));
                patient.setName(rs.getString("name"));
                patient.setGender(rs.getString("gender"));
                patient.setSocialSec(rs.getInt("socialSec"));
                patient.setBirthDate(rs.getString("birthDate"));
                patient.setPills(rs.getString("pills"));
                patient.setTreatments(rs.getString("treatments"));
                patient.setArtefact(rs.getString("artefact"));
                patient.setDiagnosis(rs.getString("diagnosis"));
                patient.setVisitDate(rs.getString("visitDate"));
                patientList.add(patient);
                
            }
            return patientList;
            
         
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
           close();
        }
	}
	
	
	
	
	
	public List<Patient> ListPatientsBySocialSec(int socialSec){
		
		List<Patient> patients = new ArrayList<>();
		 	
				    try {
				        connection();
				  
				            PreparedStatement ps3 = connection.prepareStatement("Select socialSec, pills, treatments, artefact From patients where socialSec = ?");
				            
				            ps3.setInt(1, socialSec);
				            
				            ResultSet rs2 = ps3.executeQuery();
				            while (rs2.next()) {
				                Patient temp = new Patient();
				                temp.setSocialSec(rs2.getInt("socialSec"));
				                temp.setPills(rs2.getString("pills"));
				                temp.setTreatments(rs2.getString("treatments")); 
				                temp.setArtefact(rs2.getString("artefact"));
				                patients.add(temp);
				                
				            }
				            return patients;
				        
				        
				    } catch (Exception e) {
				         e.printStackTrace();
				        return null;
				     } finally {
				        close();
				     }
				   

	}
	

	

	public List<Visit> ListVisitsOver18(){
		 List<Visit> visitList = new ArrayList<>();
         try {
             connection();
             PreparedStatement ps2 = connection.prepareStatement("Select visitPatientId, visitPatientName, visitPatientGender, visitPatientSocialSec, visitPatientAge From Visits where visitPatientAge > 18 ");
             ResultSet rs = ps2.executeQuery();
             while (rs.next()) {
                 Visit temp = new Visit();
                 temp.setVisitPatientId(rs.getInt("visitPatientId"));
                 temp.setVisitPatientName(rs.getString("visitPatientName"));
                 temp.setVisitPatientGender(rs.getString("visitPatientGender"));
                 temp.setVisitPatientSocialSec(rs.getInt("visitPatientSocialSec"));
                 temp.setVisitPatientAge(rs.getInt("visitPatientAge"));
                 
                 visitList.add(temp);
                 
             }
             return visitList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
           close();
        }
        
	}
	
	
	public List<Visit> ListVisitsOver35Male(){
		 List<Visit> visitList = new ArrayList<>();
        try {
            connection();
            PreparedStatement ps2 = connection.prepareStatement("Select visitPatientId, visitPatientName, visitPatientGender, visitPatientSocialSec, visitPatientAge from Visits where visitPatientAge > 35 and visitPatientGender = 'Male'");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                Visit temp = new Visit();
                temp.setVisitPatientId(rs.getInt("visitPatientId"));
                temp.setVisitPatientName(rs.getString("visitPatientName"));
                temp.setVisitPatientGender(rs.getString("visitPatientGender"));
                temp.setVisitPatientSocialSec(rs.getInt("visitPatientSocialSec"));
                temp.setVisitPatientAge(rs.getInt("visitPatientAge"));
                
                visitList.add(temp);
                
            }
            return visitList;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       } finally {
          close();
       }
       
	}
	
	public List<Visit>	ListVisitsOver45Female(){
		 List<Visit> listVisit = new ArrayList<>();
       try {
           connection();
           PreparedStatement ps2 = connection.prepareStatement("Select visitPatientId, visitPatientName, visitPatientGender, visitPatientSocialSec, visitPatientAge from Visits where visitPatientAge > 45 And visitPatientGender = 'Female'");
           ResultSet rs = ps2.executeQuery();
           while (rs.next()) {
               Visit temp = new Visit();
               temp.setVisitPatientId(rs.getInt("visitPatientId"));
               temp.setVisitPatientName(rs.getString("visitPatientName"));
               temp.setVisitPatientGender(rs.getString("visitPatientGender"));
               temp.setVisitPatientSocialSec(rs.getInt("visitPatientSocialSec"));
               temp.setVisitPatientAge(rs.getInt("visitPatientAge"));
               
               listVisit.add(temp);
               
           }
           return listVisit;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      } finally {
         close();
      }
      
	}
	
	
	public List<Visit> ListVisitsEvery5(){
		 List<Visit> listVisit = new ArrayList<>();
      try {
          connection();
          PreparedStatement ps2 = connection.prepareStatement("Select visitPatientId, visitPatientName, visitPatientGender, visitPatientSocialSec, visitPatientAge from Visits");
          ResultSet rs = ps2.executeQuery();
          while (rs.next()) {
              Visit temp = new Visit();
              temp.setVisitPatientId(rs.getInt("visitPatientId"));
              temp.setVisitPatientName(rs.getString("visitPatientName"));
              temp.setVisitPatientGender(rs.getString("visitPatientGender"));
              temp.setVisitPatientSocialSec(rs.getInt("visitPatientSocialSec"));
              temp.setVisitPatientAge(rs.getInt("visitPatientAge"));
              
              listVisit.add(temp);
              
          }
          return listVisit;
     } catch (Exception e) {
         e.printStackTrace();
         return null;
     } finally {
        close();
     }
     
	}
	
	
	
	
	
	
	
	
	public void editPatient() {
        try {
            connection();
            PreparedStatement ps = connection.prepareStatement("insert into Patients (patientId, name, gender, socialSec, birthDate, pills, treatments, artefact) values (?,?,?,?,?,?,?,?)");
            
            
            
    
            	 ps.setInt(1, newPatientId);
            	 ps.setString(2, newPatientName);
            	 ps.setString(3, newPatientGender);
            	 ps.setInt(4, newPatientSocialSec);
                 ps.setString(5, newPatientBirthDate);
                 ps.setString(6, newPatientPills);
                 ps.setString(7, newPatientTreatments);
                 ps.setString(8, newPatientArtefact);
                
                
                 ps.executeUpdate();
                
              
                 
                 String stryear = newPatientBirthDate;
                 stryear = stryear.substring(6, 10);
                 String strmonth = newPatientBirthDate;
                 strmonth = strmonth.substring(0, 2);
                 String strdday = newPatientBirthDate;
                 strdday = strdday.substring(3, 5);
            
                 int year = Integer.parseInt(stryear);
                 int month = Integer.parseInt(strmonth);
                 int day = Integer.parseInt(strdday);
                 
                 
                 java.util.Date date= new Date();
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(date);
                 int curYear = cal.get(Calendar.YEAR);
                 int curMonth = cal.get(Calendar.MONTH) + 1;
                 int curDay = cal.get(Calendar.DAY_OF_MONTH);
             
                 int ry = 0;
                 
                 if (month > curMonth)
                 {
                	 ry = curYear-year-1;
                 }
                 else if (month == curMonth)
                 {
                	 if(day > curDay)
                	 {
                		 ry = curYear-year-1;
                	 }
                	 if(day == curDay)
                	 {
                		 ry = curYear-year;
                	 }
                	 if(day < curDay)
                	 {
                		 ry = curYear-year;
                	 }
                	 
                 }
                 else if (month < curMonth)
                 {
                		 ry = curYear-year;
 
                 }
                	
                 
               
                 newPatientAge = ry;
                 
                 PreparedStatement pss = connection.prepareStatement("insert into Visits (visitPatientId, visitPatientName, visitPatientGender, visitPatientSocialSec, visitPatientAge) values (?,?,?,?,?)");
                 pss.setInt(1, newPatientId);
                 pss.setString(2, newPatientName);
                 pss.setString(3, newPatientGender);
                 pss.setInt(4, newPatientSocialSec);
                 pss.setInt(5, newPatientAge);
                 pss.executeUpdate();
                 
                 
                 
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
           close();
        }
        
       
          
    }
	
	public void editVisit() {
        try {
            connection();
            PreparedStatement ps = connection.prepareStatement("insert into Patients (PatientId, name, gender, socialSec, birthDate, pills, treatments, artefact) values (?,?,?,?,?,?,?,?)");
            PreparedStatement pss = connection.prepareStatement("insert into Visits (visitPatientId, visitPatientName, visitPatientSocialSec) values (?,?,?)");
            
            
    
            ps.setInt(1, newPatientId);
            	 ps.setString(2, newPatientName);
            	 ps.setString(3, newPatientGender);
            	 ps.setInt(4, newPatientSocialSec);
                 ps.setString(5, newPatientBirthDate);
                 ps.setString(6, newPatientPills);
                 ps.setString(7, newPatientTreatments);
                 ps.setString(8, newPatientArtefact);
                 pss.setInt(1, newPatientId);
                 pss.setString(2, newPatientName);
                 pss.setInt(3, newPatientSocialSec);
                
                 ps.executeUpdate();
                 pss.executeUpdate();
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           close();
        }

    }
	
	

    
	public void editVisits() {
        try {
            connection();
            PreparedStatement ps = connection.prepareStatement("update Patients set pills=?, treatments=?, artefact=?, diagnosis=?, visitDate=? where socialSec=?");
            
            ps.setString(1, newPatientPills);
            ps.setString(2, newPatientTreatments);
            ps.setString(3, newPatientArtefact);
            ps.setString(4, newPatientDiagnosis);
            ps.setString(5, newPatientVisitDate);
            ps.setInt(6, newPatientSocialSec);
            ps.executeUpdate();
            
            /*if(newPatientVisitDate != null)
            { 
            PreparedStatement ps2 = connection.prepareStatement("delete from Patients where socialSec=?");
            ps2.setInt(1, newPatientSocialSec);
            ps2.executeUpdate();
            
            
            PreparedStatement ps3 = connection.prepareStatement("delete from Visits where visitPatientSocialSec=?");
            ps3.setInt(1, newPatientSocialSec);
            ps3.executeUpdate();
            }*/
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           close();
        }

    }
	
	
	 public void deletePatient(){
	    	try {
	            connection();
	            PreparedStatement ps = connection.prepareStatement("Delete from Patients where patientId=?");
	            PreparedStatement pss = connection.prepareStatement("Delete from Visits where visitPatientId=?");
	            
	            ps.setInt(1, deletePatientById);
	            pss.setInt(1, deletePatientById);
	            ps.executeUpdate();
	            pss.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           close();
	        }
	    }
	 
	 public void deleteVisit(){
	    	try {
	            connection();
	            PreparedStatement ps = connection.prepareStatement("Delete from Visits where visitPatientId=?");
	            ps.setInt(1, deletePatientById);
	            ps.executeUpdate();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           close();
	        }
	    }
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public int getNewPatientId() {
		return newPatientId;
	}
	public void setNewPatientId(int newPatientId) {
		this.newPatientId = newPatientId;
	}
	public String getNewPatientName() {
		return newPatientName;
	}
	public void setNewPatientName(String newPatientName) {
		this.newPatientName = newPatientName;
	}
	public int getNewPatientSocialSec() {
		return newPatientSocialSec;
	}
	public void setNewPatientSocialSec(int newPatientSocialSec) {
		this.newPatientSocialSec = newPatientSocialSec;
	}
	public String getNewPatientGender() {
		return newPatientGender;
	}
	public void setNewPatientGender(String newPatientGender) {
		this.newPatientGender = newPatientGender;
	}
	public String getNewPatientBirthDate() {
		return newPatientBirthDate;
	}
	public void setNewPatientBirthDate(String newPatientBirthDate) {
		this.newPatientBirthDate = newPatientBirthDate;
	}
	public int getNewPatientAge() {
		return newPatientAge;
	}
	public void setNewPatientAge(int newPatientAge) {
		this.newPatientAge = newPatientAge;
	}
	public String getNewPatientPills() {
		return newPatientPills;
	}
	public void setNewPatientPills(String newPatientPills) {
		this.newPatientPills = newPatientPills;
	}
	public String getNewPatientTreatments() {
		return newPatientTreatments;
	}
	public void setNewPatientTreatments(String newPatientTreatments) {
		this.newPatientTreatments = newPatientTreatments;
	}
	public String getNewPatientArtefact() {
		return newPatientArtefact;
	}
	public void setNewPatientArtefact(String newPatientArtefact) {
		this.newPatientArtefact = newPatientArtefact;
	}
	public String getNewPatientDiagnosis() {
		return newPatientDiagnosis;
	}
	public void setNewPatientDiagnosis(String newPatientDiagnosis) {
		this.newPatientDiagnosis = newPatientDiagnosis;
	}
	public String getNewPatientVisitDate() {
		return newPatientVisitDate;
	}
	public void setNewPatientVisitDate(String newPatientVisitDate) {
		this.newPatientVisitDate = newPatientVisitDate;
	}
	public int getDeletePatientById() {
		return deletePatientById;
	}
	public void setDeletePatientById(int deletePatientById) {
		this.deletePatientById = deletePatientById;
	}
	public int getVisitPatientId() {
		return visitPatientId;
	}
	public void setVisitPatientId(int visitPatientId) {
		this.visitPatientId = visitPatientId;
	}
	public String getVisitPatientName() {
		return visitPatientName;
	}
	public void setVisitPatientName(String visitPatientName) {
		this.visitPatientName = visitPatientName;
	}
	public int getVisitPatientSocialSec() {
		return visitPatientSocialSec;
	}
	public void setVisitPatientSocialSec(int visitPatientSocialSec) {
		this.visitPatientSocialSec = visitPatientSocialSec;
	}
	public String getVisitPatientDiagnosis() {
		return visitPatientDiagnosis;
	}
	public void setVisitPatientDiagnosis(String visitPatientDiagnosis) {
		this.visitPatientDiagnosis = visitPatientDiagnosis;
	}
	public String getNewVisitPatientPills() {
		return newVisitPatientPills;
	}
	public void setNewVisitPatientPills(String newVisitPatientPills) {
		this.newVisitPatientPills = newVisitPatientPills;
	}
	public String getNewVisitPatientTreatment() {
		return newVisitPatientTreatment;
	}
	public void setNewVisitPatientTreatment(String newVisitPatientTreatment) {
		this.newVisitPatientTreatment = newVisitPatientTreatment;
	}
	public int getDeleteVisitPatientById() {
		return deleteVisitPatientById;
	}
	public void setDeleteVisitPatientById(int deleteVisitPatientById) {
		this.deleteVisitPatientById = deleteVisitPatientById;
	}

	
}
