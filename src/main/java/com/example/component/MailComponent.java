package com.example.component;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class MailComponent {

    @Autowired
    private JavaMailSender javaMailSender;

    private String[] mailTo;

    private String mailSubject;

    private String mailBody;

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtpd01.ktb.co.th");
        mailSender.setPort(25);

//	    mailSender.setUsername("game.np@mailbase.local");
//	    mailSender.setPassword("P@ssw0rd");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "false");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");

        return mailSender;
    }

    public void send() throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(getMailTo());
        mail.setSubject(getMailSubject());
        mail.setText(getMailBody());

        javaMailSender = getJavaMailSender();
        javaMailSender.send(mail);

    }

    public void sendWithAttachment(File[] listOfFiles) throws MailException, MessagingException {

        javaMailSender = getJavaMailSender();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(getMailTo());
        helper.setSubject(getMailSubject());
        helper.setText(getMailBody());

        for (File file : listOfFiles) {
            helper.addAttachment(file.getName(), file);
        }

        javaMailSender.send(mimeMessage);
    }

}
