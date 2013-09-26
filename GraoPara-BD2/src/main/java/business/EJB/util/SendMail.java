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
/**
 * Classe para envio de email.
 */
public class SendMail {
	/**
	 * Conta de usuário.<br>
	 * Nota: Alguns servidores necessitam do endereço completo (i.e. nome@servidor.com.br)
	 */
	private static String account = "graoparaproject";
	/**
	 * Senha do email.
	 */
	private static String password = "g1r2a3o4";
	
	
	private static String host = "smtp.gmail.com";	// SMTP
	private static String port = "465";				// Porta
	private static String socketPort = "465";		// Socket
	
	private SendMail(){}	// Impedir instância
	
	/**
	 * Envia um novo email.
	 * @param to - Email do destinatário.
	 * @param subject - Assunto no email
	 * @param msg - Corpo da menssagem (formato MIME)
	 */
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