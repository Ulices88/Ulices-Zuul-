/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * 
 *@author Ulices Cardenas
 *
 * @version 2018.01.24
 * edits:
 * added "look" to list of valid command words.
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look","hypnosis","nightmare"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    /**
     * Exercise 8.16 
     * implemented showAll method for printing out the command words.
     * 
     * Exercise 8.18
     * changed the showAll to getCommandList which returns a string instead of printing it out.
     * 
     * Print all valid commands to System.out.
     */
    public String getCommandList()
    {
        String commandList = "";
        for(int i = 0; i < validCommands.length;i++){
            commandList += validCommands[i] + " ";
        }
        return commandList;
        
        
    }
}
