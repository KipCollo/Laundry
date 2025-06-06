//import jakarta.mail.*;
//import jakarta.mail.internet.*;
//import okhttp3.Authenticator;
//
//import java.io.IOException;
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//public class EmailUtility {
//
//    public static void sendEmail(String toAddress, String subject, String message) throws MessagingException {
//        Properties props = new Properties();
//        try {
//            props.load(EmailUtility.class.getResourceAsStream("/email.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        final String user = props.getProperty("mail.smtp.user");
//        final String password = props.getProperty("mail.smtp.password");
//
//        Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(user, password);
//            }
//        });
//
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress(user));
//        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
//        msg.setRecipients(Message.RecipientType.TO, toAddresses);
//        msg.setSubject(subject);
//        msg.setSentDate(new java.util.Date());
//        msg.setText(message);
//
//        Transport.send(msg);
//    }
//}
