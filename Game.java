/**
 *  This class is the main class of the "Bumi's Ghost Adventure" it is a very 
 *  simple, text based adventure game about a ghost named Bumi.  Users 
 *  can walk around some scenery through a graveyard as they try to make their
 *  way to ghost mountain. 
 *  That's all. 
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * 
 * 
 * @author  Ulices Cardenas
 * Date     1/16/2018
 * @version 2016.02.29
 * 
 * Edits:
 * 
 * changed the goRoom method.
 * setExits in the createRoom method.
 * created printLocationInfo method.
 * added printLocationInfo into the printWelcome method.
 * refactored the goRoom method.
 * added longDescription to the printLocationInfo method.
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Exercise 8.8 setExits
     * 
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room graveyard, lakeside, catacombs, necroRoom,killingFields, wall,
        ghostMountain, ghostLanding;
      
        // create the rooms
        graveyard = new Room("you are in the graveyard");
        lakeside = new Room("near the edge of the lake");
        catacombs = new Room("decending into the catacombs");
        necroRoom = new Room("in the necromancy chamber");
        killingFields = new Room("in the killing fields ");
        wall = new Room ("you are at the wall");
        ghostMountain = new Room ("climbing ghost mountain");
        ghostLanding = new Room ("you've made it to the top of the mountain!");
        
  
        // initialise room exits
        graveyard.setExits("east", lakeside);
        
        lakeside.setExits("east", graveyard);
        lakeside.setExits("south", catacombs);
        
        catacombs.setExits("west", lakeside);
        catacombs.setExits("east", necroRoom);
        
        necroRoom.setExits("west",catacombs);
        necroRoom.setExits("south",killingFields);
        
        killingFields.setExits("north",necroRoom);
        killingFields.setExits("south",wall);
        
        wall.setExits("north",killingFields);
        wall.setExits("south",ghostMountain);
        
        ghostMountain.setExits("north",wall);
        ghostMountain.setExits("up", ghostLanding);
        
        ghostLanding.setExits("down",ghostMountain);
        
       
        currentRoom = graveyard;  // start game in graveyard
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     * Added the new printLocationInfo method to printWelcome().
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Bumi's Ghost Adventure !");
        System.out.println("Bumi's Ghost Adventure is a Zuul based adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
        System.out.println();
    }

    /** Exercise 8.14 added look command into the processCommand method.
     * 
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("look")){
            look();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /** Exercise 8.16
     * added showCommands method call.
     * 
     * Exercise 8.18
     * updated so that it used the getCommandList() method call.
     *  
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the graveyard.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getCommandList());
    }


    /**  Exercise 8.6
     *  
     * changed the method so that it is only doing one thing, going to the next room.
     * , 
     **/
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null){
         System.out.println("there is no exit in this direction");
        }
        else {
          currentRoom = nextRoom;
          printLocationInfo();
        }
    }
    
     /** 
     * Exercise 8.7 create print location method
     * 
     * Exercise 8.11 added long description method so that the room method 
     * returns a discription of the room
     * 
     * 
     */
    private void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());
        
        System.out.println();
        }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    /**
     * Exercise 8.14 added a look method.
     * 
     */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    
    }
    
    /**
     * Exercise 8.15 added hypnosis method.
     */
    private void hypnosis()
    {
        System.out.println("Enemy is fast asleep");
    }
    
    /**
     * Exercise 8.15 added nightmare method.
     */
    private void nightmare()
    {
        System.out.println("foe is having a nightmare");
    }
}
