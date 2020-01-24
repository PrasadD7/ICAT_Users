package studentdata.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import studentdata.pojos.Student;

@Repository
public interface IStudentDAO extends JpaRepository<Student, Integer> {
	
	
	
}
