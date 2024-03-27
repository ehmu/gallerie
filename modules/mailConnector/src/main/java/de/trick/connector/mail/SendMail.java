package de.trick.connector.mail;

import de.trick.connector.mail.config.SendMailConfig;
import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Versendet E-Mails
 *
 * Created with IntelliJ IDEA.
 * User: dehmann
 * Date: 04.02.15
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */

public class SendMail {

    private static Logger LOG = Logger.getLogger(SendMail.class);

    private SendMailConfig config;

    private MimeMessageHelper helper = null;

    private MimeMessage message = null;

    private JavaMailSenderImpl sender = new JavaMailSenderImpl();

    public SendMail(SendMailConfig config){
        this.config = config;
        sender.setHost(this.config.getHost());
        sender.setPort(config.getPort());
        sender.setDefaultEncoding("UTF-8");
        this.message = sender.createMimeMessage();
        try {
            helper = new MimeMessageHelper(message, true);
        } catch (MessagingException e) {
            LOG.error(e.getMessage());
        }
    }

    public void sendMail(){
        sender.send(message);
    }

    public  void addRecipient(String email) throws MessagingException {
        this.helper.addTo(email);
    }

    public void setPlainText(String text) throws MessagingException {
        this.helper.setText(text, false);
    }

    public void setHTMLText(String text) throws MessagingException {
        this.helper.setText(text, true);
    }

    public void setFrom(String email) throws MessagingException {
        this.helper.setFrom(email);
    }

    public void setSubject(String text)  throws MessagingException {
        this.helper.setSubject(text);
    }

    public void addAttachement(String filename, DataSource source) throws MessagingException {
        this.helper.addAttachment(filename, source);
    }
}
