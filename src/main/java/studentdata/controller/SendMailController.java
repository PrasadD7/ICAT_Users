package studentdata.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentdata.pojos.Email;
import studentdata.pojos.Student;
import studentdata.services.EmailService;
import studentdata.services.IStudentService;

@RestController 
@RequestMapping("/sendmail")
@CrossOrigin(origins = "*")
public class SendMailController{
	
	@Autowired
	private EmailService em;
	
	@Autowired
	private IStudentService service;
	
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + this.em);
	}
	
	@GetMapping("/{stuId}")
	public void sentResultEmail(@PathVariable int stuId) {
		Student s = service.getStudent(stuId);
		Email email=new Email();
		try {
			email.setSubject("SubYourMarks");
			
				email.setDestEmail(s.getEmail());
				email.setMessage("You Scored : "+s.getResult());
				em.sendEmail(email);
			
		} catch (MailException e) {
			
		}
		}
	
	
	 @PostMapping 
	  public ResponseEntity<?> sendMail(@RequestBody Email e) {

		  try {  
			  em.sendEmail(e);
			  return new ResponseEntity<String>("Mail sent successfully", HttpStatus.OK); }
		  catch (RuntimeException e1) 
		  {
			  e1.printStackTrace();// only for debugging

			  return new ResponseEntity<Void> (HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
}