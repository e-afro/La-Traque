 

/**
 * classe receuillant les commandes du joueur
 * 
 * @author Pavius Pascal
 * @version 2015.09.21
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;

/**
 * constructeur naturel
 */
public Command(final String pCommandWord, final String pSecondWord)
{
    this.aCommandWord=pCommandWord;
    this.aSecondWord=pSecondWord;
} //Command()

/**
 * donne accès à la commande
 */
public String getCommandWord()
{
    return this.aCommandWord;
} //getCommandWord()

/**
 * donne accès au second terme de la commande
 */
public String getSecondWord()
{
    return this.aSecondWord;
} //getCommandWord()

/**
 * detecte si la commande possède un second terme (ou non)
 */
public boolean hasSecondWord()
{
    return this.getSecondWord()!=null;    
}//hasSecondWord()

/**
 * detecte si la commande passée est valide (ou non)
 */
public boolean isUnknown()
{
    return this.getCommandWord()==null;
}//isUnknown()
} // Command
