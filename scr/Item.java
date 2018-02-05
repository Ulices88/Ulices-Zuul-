/**
 * Exercise 8.20
 *
 * This class is part of the "Bumi bu's ghost adventure" application. 
 * a text based adventure game. This class creates an item with a name,
 * description and weight.
 *
 *
 * @author Ulices Cardenas
 * @version 1.26.2018
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int weight;

    /**
     * Constructor for objects of class Item creates an item with a name,
     * description and weight.
     * @param name
     * @param description
     * @param weight
     */
    public Item(String name, String description, int weight)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    /**
     * method that returns item name.
     * @return    item name
     */
    public String getItem()
    {

        return name;
    }

    /**
     * method that returns item description.
     * @return description
     */
    public String getItemDescription()
    {

        return description;
    }


    /**
     * method that return the items weight.
     * @return weight
     */
    public int getItemWeight()
    {
        return weight;
    }
}