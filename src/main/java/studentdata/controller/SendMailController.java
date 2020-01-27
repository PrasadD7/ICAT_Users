package studentdata.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentdata.pojos.Email;
import studentdata.services.EmailService;

@RestController 
@RequestMapping("/sendmail")
@CrossOrigin // origins=*
public class SendMailController{
	
	@Autowired
	private EmailService em = new EmailService();
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + this.em);
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