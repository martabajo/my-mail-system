
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
    private MailServer server;
    private String user;
    
    /**
     * Disponga de un constructor que permita crear un objeto `MailClient` inicializando sus atributos por medio de parámetros.
     */
    public MailClient(MailServer newServer, String newUser)
    {
        server = newServer;
        user = newUser;
    }
}
