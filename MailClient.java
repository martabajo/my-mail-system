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
    //Nuevo atributo
    private MailItem lastEmail;
    private int contarEnviar;
    private int contarRecibir;
    private int contarSpam;
    private int contarCaracter;
    private String emailCaracter;
    private MailItem lastMailSpam;

    /**
     * Disponga de un constructor que permita crear un objeto `MailClient` inicializando sus atributos por medio de parámetros.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        contarEnviar = 0;
        contarRecibir = 0;
        contarCaracter = 0;
        emailCaracter = "";

    }

    /**
     * Disponga de un método llamado `getNextMailItem` que recupere del servidor el siguiente correo (un objeto `MailItem`) que tenga el usuario y devuelva dicho objeto.
     */
    public MailItem getNextMailItem()
    {
        lastEmail = server.getNextMailItem(user);
        return lastEmail;
    }

    /**
     * Disponga de un método llamado `printNextMailItem` que recupere del servidor el siguiente correo (un objeto 
     * `MailItem`) que tenga el usuario e imprima por pantalla los datos de dicho mensaje. Si no hay ningun mensaje, 
     * que muestre un mensaje por pantalla informando de ello. 
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem (user);
        lastEmail = item;
        String spam = "viagra";
        String spam2 = "oferta";
        String noSpam = "proyecto";
        boolean found = false;
        boolean found2 = true;
        if (item.getMessage().contains(spam) || item.getMessage().contains(spam2))
        {
            found = true;
        }
        if (item.getMessage().contains(noSpam))
        {
            found2 = true;
        }
        if (item==null)
        {
            System.out.println("No hay mensajes nuevos");
        }
        else if ((found==true)&&(found2==false))
        {
            System.out.println("Este mensaje contenía spam");
        }
        else
        {                
            lastEmail= item;
            item.print();
        }            
    }

    /**
     * Disponga de un método llamado `sendMailItem` que reciba 2 parámetros (un `String` indicando para quién es el mensaje y 
     * otro `String` indicando el contenido del mensaje), cree un email (objeto `MailItem`)
     * basándose en la información de dichos parámetros y lo envíe al servidor asociado a ese cliente.
     */
    public void sendMailItem(String to, String message, String subject)
    {
        MailItem item = new MailItem(user, to, message, subject);
        server.post(item);
    }

    /**
     * Crear un metodo que nos diga cuantos emails tenemos.
     */
    public void howManyMailItems()
    {
        int numero = server.howManyMailItems(user);
        System.out.println("En tu bandeja tienes: " + numero + " mensajes");
    }

    /**
     * Crear un metodo getNextMailItemAndAutorespond que nos devuelva un mensaje.
     */
    public void getNextMailItemAndAutorespond ()
    {
        MailItem item = server.getNextMailItem(user);
        if (item != null)
        {
            String newTo = item.getFrom();
            String newSubject= "RE: " + item.getSubject();
            String newMessage = "Estoy de vacaciones. \n " + item.getMessage();
            MailItem autorespond = new MailItem(user, newTo, newMessage, newSubject);
            server.post(autorespond);
        }

    }

    /**
     * Ver por pantalla cuantas veces queramos los datos del ultimo mensaje recibido.
     */
    public void printLastMailItem()
    {
        if (lastEmail != null)
        {
            lastEmail.print();
        }
        else
        {
            System.out.println("No tienes mensajes nuevos");
        }
    }

    public void datosCorreo()
    {
        float datos;
        if (contarRecibir != 0)
        {
            datos = ((float)contarSpam/contarRecibir) * (100);
        }
        else
        {
            datos = 0;
        }
        System.out.println("Correos enviados:" + contarEnviar + "\n" +
            "Correos recibidos:" + contarRecibir + "\n" +
            "Porcentaje de spam:" + datos + "%" + "\n" +
            "Remitente con nombre de email mas largo:" + emailCaracter);
    }

    public void printLastMailSpam()
    {
        if (lastMailSpam != null)
        {
            lastMailSpam.print();
        }
        else 
        {
            System.out.println ("No hay mensajes de spam");
        }
    }
}
