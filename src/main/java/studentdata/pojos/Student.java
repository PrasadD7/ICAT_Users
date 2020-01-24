package studentdata.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;



@Entity
@Table(name="Students")
public class Student extends AbstractEntity {
	
	 @Column(name = "Name")
	  private String name;
	 @Column(name = "Email")
	  private String email;
	 @Column(name = "Password")
	  private String password;
	 @Column(name = "Mobile NO")
	  private String mobile;
	 @OneToOne(cascade = CascadeType.ALL,optional=true)
	    @JoinColumn(name="result_id",referencedColumnName = "id")
	 private Result result;
	public Student() {
		super();
		
	}
	public Student(String name, String email, String password, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Double marks,Timestamp totalTime) {
		result.setStudentMarks(marks);
		result.setTotalTime(totalTime);
	}
	 
	 


}
