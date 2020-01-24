package studentdata.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentdata.dao.IStudentDAO;
import studentdata.pojos.Student;
@Service
@Transactional
public class StudentServiceIMPL implements IStudentService {
	@Autowired
	IStudentDAO dao;

	@Override
	public Student addNewStudent(Student student) {
		
		
		return dao.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
	
		return dao.findAll();
	}

	@Override
	public Student getStudent(Integer id) {
	
		return dao.findById(id).get();
	}

	

	@Override
	public void deleteStudent(Integer id) {
		dao.deleteById(id);
	
	}

	
	@Override
	public  Student findByEmailIgnoreCase(String email) {
		
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		
		return dao.save(student);
	}

}
