package studentdata.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import studentdata.pojos.Student;
import studentdata.services.IStudentService;

@RestController 
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get all students
	@GetMapping
	public ResponseEntity<?> getAllStudents() {
		
		List<Student> allStudents = service.getAllStudents();
		if (allStudents.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}
	// REST request handling method to get students details by id
		@GetMapping("/{stuId}")
		public ResponseEntity<?> getStudentDetails(@PathVariable int stuId) {
			System.out.println("get student details: " + stuId);
			Student stuDetails = service.getStudent(stuId);
			if (stuDetails == null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Student>(stuDetails, HttpStatus.OK);
		}
		
		// REST request handling method to add student details
	
	  @PostMapping 
	  public ResponseEntity<?> saveStudentDetails(@RequestBody Student s) {
		  System.out.println("in save student " + s); 
		  try { 
			  return new ResponseEntity<Student>( service.addNewStudent(s), HttpStatus.CREATED); }
		  catch (RuntimeException e1) 
		  {
			  e1.printStackTrace();// only for debugging

			  return new ResponseEntity<Void> (HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	  
	  
	  @DeleteMapping("/{stuId}")
	  public ResponseEntity<Void> deleteStudentDetails(@PathVariable int stuId) {
		  System.out.println("del stu dtls " + stuId);
		  service.deleteStudent(stuId);
		  return new ResponseEntity<>(HttpStatus.OK);
		  }
	  
	  @PostMapping("/addresult/{stuId}")
		public ResponseEntity<?> updateStudentDetails(@RequestParam Double marks,
				@RequestParam int totalTime,
				@PathVariable int stuId) {
			System.out.println("in update stu " + stuId + " " + marks + " " + totalTime);

			Student stuDetails = service.getStudent(stuId);
			if (stuDetails == null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // stu found 
			try {
				
			stuDetails.setResult(marks,totalTime);
							return new ResponseEntity<Student>(service.updateStudent(stuDetails), HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace(); // only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	 

}
