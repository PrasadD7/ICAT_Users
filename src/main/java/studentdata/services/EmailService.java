package studentdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import studentdata.pojos.Email;
import studentdata.pojos.Student;
@Service("emailService")
public class EmailService {
	
	public EmailService(){
		
	}
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	/*@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender =javaMailSender;
	}*/
	
	public void sendEmail(Email em) throws MailException {
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(em.getDestEmail());
		//mail.setFrom("");
		mail.setSubject(em.getSubject());
		mail.setText(em.getMessage());
		javaMailSender.send(mail);
	}
	

}
