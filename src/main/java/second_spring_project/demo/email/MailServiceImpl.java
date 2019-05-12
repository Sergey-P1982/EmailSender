package second_spring_project.demo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class MailServiceImpl implements MailService {

    Session session;

    public MailServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public void send(String fromAddress, String toAddress, String subject, String content) throws Exception {
        try {

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(fromAddress));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(content);
            mimeMessage.setSentDate(new Date());
            Transport.send(mimeMessage);
            System.out.println("Email was sent successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
