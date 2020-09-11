package be.vdab.mail.mailing;

import be.vdab.mail.domain.Lid;
import be.vdab.mail.exceptions.KanMailNietZendenException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class DefaultLidMailing implements LidMailing{
    private final JavaMailSender sender;
    DefaultLidMailing(JavaMailSender sender) {
        this.sender = sender;
    }
    @Override public void stuurMailNaRegistratie(Lid lid, String ledenURL) {
        try {
            var message = sender.createMimeMessage();
            var helper = new MimeMessageHelper(message);
            helper.setTo(lid.getEmailAdres());
            helper.setSubject("Geregistreerd");
            helper.setText("<h1>Je bent nu lid.</h1>Je nummer is:" + lid.getId(), true); sender.send(message); }
        catch (MailException | MessagingException ex) {
            throw new KanMailNietZendenException(ex);
        }
        /*try {
            var message = new SimpleMailMessage();
            message.setTo(lid.getEmailAdres());
            message.setSubject("Geregistreerd");
            message.setText("Je bent nu lid. Je nummer is:" + lid.getId());
            sender.send(message);
        }
        catch (MailException ex) {
            throw new KanMailNietZendenException(ex);
        }*/
    }
}
