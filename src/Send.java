import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send {

    private static final String FROM = "J7xCSLLwLiEC8IJU3CLK@gmail.com";
    private static final String FROMNAME = "μπγδν";

    private static final String SMTP_USERNAME = "AKIAI3V2XPAYHKWBNGJA";

    private static final String SMTP_PASSWORD =
            "Ai5eDpxRe8zTg1ewRoUL7qBLU8Fy6qnjy2ti1O7PwtyF";

    private static final String HOST = "email-smtp.us-east-1.amazonaws.com";

    private static final int PORT = 587;

    private static final String SUBJECT = "ασσασιν (trial week)";

    public static void Email(String object, String target) throws Exception {
        String BODY = String.join(
                System.getProperty("line.separator"),
                "<p>You have to assassinate " + target +
                        " within the next week (read the rules). This is a " +
                        "trial week, just to see what works. Reply \"bitch " +
                        "lasagna\" to this email if you want to opt out.<p>" +
                        "<a href=https://docs.google.com/document/d" +
                        "/1r9iQfvvECtuXMng2yDtKTHw4OX7Ybz6jtB0cnHnJkIE/edit" +
                        "?usp=sharing>Rules</a><p><a href=https://docs.google" +
                        ".com/spreadsheets/u/1/d" +
                        "/1ryP2Dh_Yi0BnsPf8FGCyCBvkxeKt1mDEd5rGvzWJMIo/edit" +
                        "?usp=drive_web&ouid=104181164550766554509>Death " +
                        "Records</a></p>"
        );

        String emailName = object.toLowerCase().replace(' ','.');
        emailName += "@roxburylatin.org";

        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO,
                new InternetAddress(emailName));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");

        Transport transport = session.getTransport();

        try {
            System.out.println("Sending...");

            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent to " + emailName + "@roxburylatin" +
                            ".org");
            //System.out.println("Email sent to " + emailName +
            // "@roxburylatin" +
            //        ".org with " + target + " as the target.");
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        } finally {
            transport.close();
        }
    }
}