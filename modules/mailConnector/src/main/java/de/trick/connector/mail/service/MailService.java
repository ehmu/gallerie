package de.trick.connector.mail.service;

import de.trick.connector.mail.SendMail;
import de.trick.connector.mail.config.SendMailConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Service für den Versand von E-Mails
 *
 * User: dehmann
 * Date: 04.02.15
 * Time: 12:17
 * To change this template use File | Settings | File Templates.
 */

@Service
public class MailService {

    private static Logger LOG = Logger.getLogger(MailService.class);

    @Autowired
    SendMailConfig sendMailConfig;

    @Autowired
    Environment environment;

    /**
     * Versendet die Nachricht
     * @param templateName
     * @param rootMap
     * @throws Exception
     */
    public void sendMessage(String templateName, Map<String, Object> rootMap, String sender, String recipient, String subject) throws Exception {
        SendMail sendMail = new SendMail(sendMailConfig);
        sendMail.addRecipient(recipient);
        sendMail.setFrom(sender);
        sendMail.setSubject(subject);
        sendMail.setHTMLText(this.getMailtext(templateName, rootMap));
        sendMail.sendMail();
    }

    /**
     * Versendet die Nachricht
     * @param templateName
     * @param rootMap
     * @throws Exception
     */
    public void sendMessage(String templateName, Map<String, Object> rootMap, String sender, String recipient, String subject, DataSource attachement, String attachementName) throws Exception {
        SendMail sendMail = new SendMail(sendMailConfig);
        sendMail.addRecipient(recipient);
        sendMail.setFrom(sender);
        sendMail.setSubject(subject);
        sendMail.setHTMLText(this.getMailtext(templateName, rootMap));
        sendMail.addAttachement(attachementName, attachement);
        sendMail.sendMail();
    }

    private String getMailtext(String templateName, Map<String, Object> rootMap) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(getClass(), "/");
        Template template = cfg.getTemplate(templateName);
        Writer out = new StringWriter();
        template.process(rootMap, out);
        return out.toString();
    }
}
