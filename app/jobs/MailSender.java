package jobs;

import org.apache.commons.mail.SimpleEmail;

import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Mail;

@OnApplicationStart
public class MailSender extends Job{

	@Override
	public void doJob() throws Exception {
//		SimpleEmail email = new SimpleEmail();
//		email.setFrom("sender@zenexity.fr");
//		email.addTo("joaohelis.bernardo@gmail.com");
//		email.setSubject("subject");
//		email.setMsg("Message");
//		Mail.send(email); 
	}
	
}
