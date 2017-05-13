package medical_dataManager;

public class Patient {
	
	private int patientId;
	private String name;
	
	private int socialSec;
	private String gender;
	private String birthDate;
	private int age;
	private String pills;
	private String treatments;
	private String artefact;
	private String diagnosis;
	private String visitDate;
	


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	

	public Patient() {
	
	}

	
	
	public Patient(int patientId, String name, int socialSec, String gender, String birthDate, int age, String pills, String treatments,
			String artefact, String diagnosis, String visitDate) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.socialSec = socialSec;
		this.gender = gender;
		this.birthDate = birthDate;
		this.age = age;
		this.pills = pills;
		this.treatments = treatments;
		this.artefact = artefact;
		this.diagnosis = diagnosis;
		this.visitDate = visitDate;
	}

	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getVisitDate() {
		return visitDate;
	}


	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getArtefact() {
		return artefact;
	}


	public void setArtefact(String artefact) {
		this.artefact = artefact;
	}


	public String getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


	public int getSocialSec() {
		return socialSec;
	}


	public void setSocialSec(int socialSec) {
		this.socialSec = socialSec;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getPills() {
		return pills;
	}


	public void setPills(String pills) {
		this.pills = pills;
	}


	public String getTreatments() {
		return treatments;
	}


	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}


	
	
	
}
