package studentdata.services;

import java.util.List;

import studentdata.pojos.Student;

public interface IStudentService {
	 Student addNewStudent(Student student);
	 Student findByEmailIgnoreCase(String email);
	 List<Student> getAllStudents();
	 Student getStudent(Integer id);
	 Student updateStudent(Student student);
	 void deleteStudent(Integer id);
	
	


}
