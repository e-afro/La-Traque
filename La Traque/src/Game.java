 


/**
 * classe constituant le moteur du jeu d'aventure, en génêrant les salles et en gêrant les déplacements
 * 
 * @author Pavius Pascal 
 * @version 7.9
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    
    /**
     * constructeur par defaut
     */
    public Game()
    {
        this.createRooms();
        this.aParser=new Parser();
    }//Room()
    
    /**
     * crée les salles
     * positionne les sorties
     * initialise le lieu courant
     * 
     */
    private void createRooms()
    {
       //création des cinq lieux
       Room vSeuil= new Room("sur le seuil de la maison");
       Room vEntr�e= new Room("dans l'entrée");
       Room vVestiaire= new Room("dans le vestiaire");
       Room vSalon= new Room("dans le salon");
       Room vSalleAManger= new Room("dans la salle à manger");
       Room vCuisine= new Room("dans la cuisine");
       Room vBalcon= new Room("sur le balcon");
       Room vChambreP= new Room("dans la chambre des parents de Sally");
       Room vChambreF= new Room("dans la chambre du frère de Sally");
       Room vSalleDeBain1= new Room("dans une salle de bain");
       Room vSalleDeBain2= new Room("dans une salle de bain");
       Room vSalleDeBain3= new Room("dans une salle de bain");
       Room vEscalier= new Room("dans la cage d'escalier");
       Room vChambreS= new Room("dans la chambre de Sally");
       Room vChambre1= new Room("dans la première chambre d'invité");
       Room vChambre2= new Room("dans la deuxième chambre d'invité");
       Room vChambre3= new Room("dans la troisième chambre d'invité");
       Room vCouloir= new Room("dans un couloir");
       Room vCouloir1= new Room("dans un couloir");
       Room vCouloir2= new Room("dans un couloir");
       Room vCouloir3= new Room("dans un couloir");
       //Room vCouloir4= new Room("dans un couloir");
        
       //position des sorties
      vSeuil.setExits("East",vEntr�e);
      vEntr�e.setExits("East", vSalleAManger);
      vEntr�e.setExits("South",vVestiaire);
      vVestiaire.setExits("East",vSalon);
      vVestiaire.setExits("North",vEntr�e);
      vSalon.setExits("North",vSalleAManger); 
      vSalon.setExits("East",vCouloir);
      vSalon.setExits("South",vEscalier);
      vSalon.setExits("West",vVestiaire);
      vSalleAManger.setExits("North",vCuisine);
      vSalleAManger.setExits("South",vSalon);
      vSalleAManger.setExits("West", vEntr�e);
      vCuisine.setExits("North",vBalcon);
      vCuisine.setExits("East",vChambreP);
      vCuisine.setExits("South", vSalleAManger);
      vCuisine.setExits("West",vEntr�e);
      vBalcon.setExits("North",vSalleDeBain3);
      vBalcon.setExits("South", vCuisine);
      vBalcon.setExits("up",vSalleDeBain3);
      vChambreP.setExits("South", vCouloir);
      vChambreP.setExits("West", vCuisine);
      vChambreF.setExits("West",vCouloir);
      vSalleDeBain1.setExits("North",vCouloir);
      vSalleDeBain2.setExits("South", vChambre2);
      vSalleDeBain3.setExits("East", vChambre3);
      vSalleDeBain3.setExits("West", vChambre1);
      vEscalier.setExits("North",vSalon);
      vEscalier.setExits("up", vCouloir1);
      vChambre1.setExits("East", vSalleDeBain3);
      vChambre1.setExits("West", vCouloir1);
      vChambreS.setExits("South", vCouloir1);
      vChambre2.setExits("North",vSalleDeBain2);
      vChambre2.setExits("East", vCouloir3);
      vCouloir.setExits("North",vChambreP);
      vCouloir.setExits("East", vChambreF);
      vCouloir.setExits("South", vSalleDeBain1);
      vCouloir.setExits("West", vSalon);
      vCouloir1.setExits("North",vCouloir2);
      vCouloir1.setExits("down", vEscalier);
      vCouloir2.setExits("North",vChambre3);
      vCouloir2.setExits("East", vChambreS);
      vCouloir2.setExits("South", vCouloir1);
      vCouloir2.setExits("West", vCouloir3);
      vCouloir3.setExits("South", vCouloir2);
      vCouloir3.setExits("West", vChambre2);
      vChambre3.setExits("South", vCouloir2);
      vChambre3.setExits("West", vSalleDeBain3);
       //composition des étages
       
       
       //initialisation du lieu courant
       this.aCurrentRoom=vSeuil;
       
       //initialisation de l'étage courant
      
    }//createRooms()
    
    /**
     * Affiche d'introduction du jeu ainsi que les actions possibles
     */
     private void printWelcome()
    {
        System.out.println("Bienvenue dans La Traque");
        System.out.println("Le soleil est à son zenith");
        System.out.println("Vous arpentez calmement une avenue deserte et baignée de soleil");
        System.out.println("Soudain, vous vous arretés devant une imposante demeure");
        System.out.println("Un sourire malsain illumine votre visage, enfoui sous les replis déssechés d'un masque de cuir en lambeaux");
        System.out.println("Tape 'aide' si tu a besoin d' aide");
        System.out.println("");
        
        this.printLocationInfo();
    }//printWelcome()
    
    /**
     * gère les déplacements
     */
    public void goRoom(final Command pDirection)
    {
       if ( ! pDirection.hasSecondWord()){
            System.out.println("go Where");
            return ;
        }
        
       String vDirection=pDirection.getSecondWord();
       Room vNextRoom= aCurrentRoom.getExits(vDirection.toLowerCase());
        
        
       if (vNextRoom==null){
           System.out.println("there is no door!");
        }
       else{
           this.aCurrentRoom=vNextRoom;
        } 
       
      this.printLocationInfo();
    }//goRoom()
    
    /**
     * Affiche le sinformation liées au (nouveau) lieu courant
     */
    private void printLocationInfo()
    {
        System.out.print(aCurrentRoom.getLongDescription());
    }//printLocationInfo()
    
    /**
     * 
     */
    private void printHelp()
    {
        System.out.println("Vous êtes seul");
        System.out.println("Rongé par votre désir de vengeance");
        System.out.println("");
        System.out.println("Your command words are:");
        
        System.out.println(aParser.showCommands());
        System.out.println("");
    }// printHelp()
   
    /**
     * retourne vrai si la commande est bien quit
     */
    private boolean quit(final Command pCommande1)
    {
       if (pCommande1.hasSecondWord()){
            System.out.println("Quit What ?");
            return false;
            }
        
       else{
           return true;
           }
           
    }// quit()
    
    /**
     * assigne à chaque commande la methode correspondante
     */
    private boolean processCommand(final Command pCommand)
    {
  
        if (pCommand.getCommandWord()==null){
            System.out.println("I don't know what you mean");
            return false;
        }
        
        else if (pCommand.getCommandWord().equals("quit")){
            return this.quit(pCommand);
        }
        
        else if (pCommand.getCommandWord().equals("help")){
            this.printHelp();
        }
         
        else if (pCommand.getCommandWord().equals("go")){
            this.goRoom(pCommand);
        }
        
        else if (pCommand.getCommandWord().equals("look")){
            this.look(pCommand);
        }
        
         else if (pCommand.getCommandWord().equals("eat")){
            System.out.println("Vous avez fait taire votre faim, pour l'instant...");
        }
        return false;
        
    }// processCommand()
    
    /**
     * Affiche la description de la CurrentRoom
     * @param pCommand 
     */
    private void look(Command pCommand)
    {
        System.out.println(aCurrentRoom.getLongDescription());
    }
    
    /**
     * gère la partie en attribuant à chaque entrée clavier la methode appropriée
     */
    public void play()
    {
       this.printWelcome();
       boolean vFinished=false;
       
      while (vFinished==false){
           Command Commande=aParser.getCommand();
           vFinished=this.processCommand(Commande);
       }
       System.out.println("");
       System.out.println("Thank you for playing.  Good bye.");
           
          
      }//play()
    
} // Game

