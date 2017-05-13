package medical_dataManager;

public class Visit {
	
	private int visitPatientId;
	private String visitPatientName;
	private String visitPatientGender;
	private int visitPatientSocialSec;
	private int visitPatientAge;
	private String visitPatientArtefact;
	private String visitPatientDiagnosis;
	private String visitPatientTreatment;
	private String visitPatientPills;
	
	

	public Visit() {
	
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


	public String getVisitPatientGender() {
		return visitPatientGender;
	}


	public void setVisitPatientGender(String visitPatientGender) {
		this.visitPatientGender = visitPatientGender;
	}


	public int getVisitPatientSocialSec() {
		return visitPatientSocialSec;
	}


	public void setVisitPatientSocialSec(int visitPatientSocialSec) {
		this.visitPatientSocialSec = visitPatientSocialSec;
	}


	public int getVisitPatientAge() {
		return visitPatientAge;
	}


	public void setVisitPatientAge(int visitPatientAge) {
		this.visitPatientAge = visitPatientAge;
	}


	public String getVisitPatientArtefact() {
		return visitPatientArtefact;
	}


	public void setVisitPatientArtefact(String visitPatientArtefact) {
		this.visitPatientArtefact = visitPatientArtefact;
	}


	public String getVisitPatientDiagnosis() {
		return visitPatientDiagnosis;
	}


	public void setVisitPatientDiagnosis(String visitPatientDiagnosis) {
		this.visitPatientDiagnosis = visitPatientDiagnosis;
	}


	public String getVisitPatientTreatment() {
		return visitPatientTreatment;
	}


	public void setVisitPatientTreatment(String visitPatientTreatment) {
		this.visitPatientTreatment = visitPatientTreatment;
	}


	public String getVisitPatientPills() {
		return visitPatientPills;
	}


	public void setVisitPatientPills(String visitPatientPills) {
		this.visitPatientPills = visitPatientPills;
	}
	
	
	public Visit(int visitPatientId, String visitPatientName, String visitPatientGender, int visitPatientSocialSec,
			int visitPatientAge, String visitPatientArtefact, String visitPatientDiagnosis,
			String visitPatientTreatment, String visitPatientPills) {
		super();
		this.visitPatientId = visitPatientId;
		this.visitPatientName = visitPatientName;
		this.visitPatientGender = visitPatientGender;
		this.visitPatientSocialSec = visitPatientSocialSec;
		this.visitPatientAge = visitPatientAge;
		this.visitPatientArtefact = visitPatientArtefact;
		this.visitPatientDiagnosis = visitPatientDiagnosis;
		this.visitPatientTreatment = visitPatientTreatment;
		this.visitPatientPills = visitPatientPills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + visitPatientAge;
		result = prime * result + ((visitPatientArtefact == null) ? 0 : visitPatientArtefact.hashCode());
		result = prime * result + ((visitPatientDiagnosis == null) ? 0 : visitPatientDiagnosis.hashCode());
		result = prime * result + ((visitPatientGender == null) ? 0 : visitPatientGender.hashCode());
		result = prime * result + visitPatientId;
		result = prime * result + ((visitPatientName == null) ? 0 : visitPatientName.hashCode());
		result = prime * result + ((visitPatientPills == null) ? 0 : visitPatientPills.hashCode());
		result = prime * result + visitPatientSocialSec;
		result = prime * result + ((visitPatientTreatment == null) ? 0 : visitPatientTreatment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		if (visitPatientAge != other.visitPatientAge)
			return false;
		if (visitPatientArtefact == null) {
			if (other.visitPatientArtefact != null)
				return false;
		} else if (!visitPatientArtefact.equals(other.visitPatientArtefact))
			return false;
		if (visitPatientDiagnosis == null) {
			if (other.visitPatientDiagnosis != null)
				return false;
		} else if (!visitPatientDiagnosis.equals(other.visitPatientDiagnosis))
			return false;
		if (visitPatientGender == null) {
			if (other.visitPatientGender != null)
				return false;
		} else if (!visitPatientGender.equals(other.visitPatientGender))
			return false;
		if (visitPatientId != other.visitPatientId)
			return false;
		if (visitPatientName == null) {
			if (other.visitPatientName != null)
				return false;
		} else if (!visitPatientName.equals(other.visitPatientName))
			return false;
		if (visitPatientPills == null) {
			if (other.visitPatientPills != null)
				return false;
		} else if (!visitPatientPills.equals(other.visitPatientPills))
			return false;
		if (visitPatientSocialSec != other.visitPatientSocialSec)
			return false;
		if (visitPatientTreatment == null) {
			if (other.visitPatientTreatment != null)
				return false;
		} else if (!visitPatientTreatment.equals(other.visitPatientTreatment))
			return false;
		return true;
	}

}
