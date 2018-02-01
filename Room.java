


import java.util.HashMap;
import java.util.Set;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Bumibu's ghost adventure" application which 
 * is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * 
 * @author Ulices Cardenas
 * @version 01.22.2018.
 * 
 * added String description to Room class field.
 * added HashMap to Room class field.
 * added getExit method that gets direction.
 * added getExitString method.
 * refractored the setExits method.
 * added longDescription of the room.
 *
 */


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Exercise 8.8 
     * 
     * Define the exits of this room.  
     * @param directioin, the direction ofthe exit.
     * @param neighbor, the room in the given direction.
     * 
     */
    public void setExits(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
        
    
    }
    
    /**
     * Exercise 8.6 
     * 
     * added a getExit method that uses accessor method to get the direction.
     * @return, direction.
     * 
     **/
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * 8.7
     * Return a description of the room's exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.   
    */
    public String getExitString()
    {
        
        String returnString ="Exits: ";
        Set<String>keys = exits.keySet();
        for(String exit : keys){
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /** Exercise 8.11
     * 
     * Return a long description of the room, of the form:
     *      You are in the kitchen.
     *      Exits: north, west
     * @return A description of the room, including exits.
     * 
     */
    public String getLongDescription(){
        
        return " you are " + description + "./n " + getExitString();
    
    }
}
