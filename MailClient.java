/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/**
 *Disponga de 2 atributos: uno de tipo `MailServer` llamado `server` (que representa el servidor asociado con ese cliente) 
 *y otro de tipo `String` llamado `user` (que representa la dirección de correo del usuario que usa ese cliente).  
 */
public class MailClient
{
    //servidor asociado al cliente.
    private MailServer server;
    //Almacena la direccion de correo del usuario que usa el cliente.
    private String user;
    
    /**
     * Disponga de un constructor que permita crear un objeto `MailClient` inicializando sus atributos por medio de parámetros.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }
    
    /**
     * Disponga de un método llamado `getNextMailItem` que recupere del servidor el siguiente correo (un objeto `MailItem`) que tenga el usuario y devuelva dicho objeto.
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    /**
     * Disponga de un método llamado `printNextMailItem` que recupere del servidor el siguiente correo (un objeto `MailItem`) que tenga el usuario e imprima por pantalla los datos de dicho mensaje. Si no hay ningun mensaje, 
     * que muestre un mensaje por pantalla informando de ello. 
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem (user);
        if (item != null) 
        {
            item.print();
        }
        else {
            System.out.println("Noy hay mensaje nuevo");
        }
    }
    /**
     * Disponga de un método llamado `sendMailItem` que reciba 2 parámetros (un `String` indicando para quién es el mensaje y 
     * otro `String` indicando el contenido del mensaje), cree un email (objeto `MailItem`)
     * basándose en la información de dichos parámetros y lo envíe al servidor asociado a ese cliente.
     */
     public void sendMailItem(String user, String to, String message)
    {
        MailItem item = new MailItem(user, to, message);
        server.post(item);
    }
}
