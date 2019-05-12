package second_spring_project.demo.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class EmailRunner {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "25");
        String fromAddress = "frommail@gmail.com";
        String toAddress = "tomail@gmail.com";
        String subject = "UPDATE PROFILE";
        String content = "Your profile was updated";

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromAddress, "******");
            }
        });
        MailService mailService = new MailServiceImpl(session);
        try {
            mailService.send(fromAddress, toAddress, subject, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
