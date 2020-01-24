package studentdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import studentdata.pojos.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@Controller
@RequestMapping("/email")
public class SendMailController {
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping
	public String showForm(Email e)
	{
	//	m.addAttribute(new Email());
		return "send_mail";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String processForm( Email em,BindingResult res)
	{
		System.out.println(em.getDestEmail()+"  "+em.getMessage());
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(em.getDestEmail());
		mesg.setSubject(em.getSubject());
		mesg.setText(em.getMessage());
		sender.send(mesg);
		return "sent-mail";
	}
}
