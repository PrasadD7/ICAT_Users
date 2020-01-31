package studentdata.pojos;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="Result")
public class Result extends AbstractEntity {
	
	@Column(name="Marks")
    private Double StudentMarks;
	@Column(name="TotalTime")
	private int TotalTime;
	 @OneToOne(mappedBy = "result")
	private Student student;
	public Result() {
		super();
	}
	
	
	
	public Result(Double studentMarks, int totalTime) {
		super();
		StudentMarks = studentMarks;
		TotalTime = totalTime;
	}
	public Double getStudentMarks() {
		return StudentMarks;
	}
	public void setStudentMarks(Double studentMarks) {
		StudentMarks = studentMarks;
	}
	public int getTotalTime() {
		return TotalTime;
	}
	public void setTotalTime(int totalTime) {
		TotalTime = totalTime;
	}
	
	
}
