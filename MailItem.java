
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
   
   
   /**
    * Disponga de un constructor que permita crear un objeto `MailItem` inicializando 
	sus atributos por medio de parámetros.
    */
   public MailItem(String newFrom, String newTo, String newMessage)
    {
        from = newFrom;
        to = newTo;
        message = newMessage;
    }
}
