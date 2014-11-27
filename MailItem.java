/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/**
 * 3 atributos de tipo `String` llamados `from`, `to` y `message`.
 */
public class MailItem
{
    private String from;
    private String to;
    private String message;
    private String subject;
    /**
     *Disponga de un constructor que permita crear un objeto `MailItem` inicializando 
     *sus atributos por medio de parámetros.
     */
    public MailItem(String from, String to, String message, String subject)
    {
        this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
    }

    /**
     * Disponga de 3 métodos getter. Devuelve la direccion de origen.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * Devuelve la direccion de destino del mensaje
     */
    public String getTo()
    {
        return to;
    }

    /**
     * Devuelve el contenido del mensaje.
     */
    public String getMessage()
    {
        return message;
    }

    public String getSubject()
    {
        return subject;
    }

    /**
     *Disponga de un método `print` que no tenga parámetros y que muestre por     
     *pantalla los atributos del objeto.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Message: " + message);
        System.out.println("Subject: " + subject);
    }
}
