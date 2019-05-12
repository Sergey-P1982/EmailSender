package second_spring_project.demo.email;

public interface MailService {
    public void send (String fromAddress, String toAddress, String subject, String content) throws Exception;
}
