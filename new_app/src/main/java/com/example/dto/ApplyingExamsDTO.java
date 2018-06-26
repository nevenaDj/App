package com.example.dto;

public class ApplyingExamsDTO {
	private Integer id;
	private StudentDTO student;
	private ExaminationPeriodDTO examinationPeriod;
	private boolean flag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public ExaminationPeriodDTO getExaminationPeriod() {
		return examinationPeriod;
	}

	public void setExaminationPeriod(ExaminationPeriodDTO examinationPeriod) {
		this.examinationPeriod = examinationPeriod;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
