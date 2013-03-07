package business.EJB.util;

 
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMail {
	
	private static String account = "graoparaproject";
	private static String password = "g1r2a3o4";
	
	private static String host = "smtp.gmail.com";
	private static String port = "465";
	private static String socketPort = "465";
	
	private SendMail(){}
	
	public static void send(String to, String subject, String msg) {
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.socketFactory.port", socketPort);
		props.put("mail.smtp.socketFactory.class",	"javax.net.ssl.SSLSocketFactory");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(account,password);
				}
			});
 
		try {
			Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(account, "Não responder"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(to));
			
			message.setSubject(subject);
			message.setText(msg);
 
			Transport.send(message);
 
//			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}