package data.models;

import java.util.Objects;

/**
 * Model of the material data
 * @author 
 */
public class MaterialModel
{

    private int ID;
    private String name;
    private String description;
    private String helptext; 
    private int length;
    private int width;
    private int height;
    private int quantity; 
    private double price;  
    private String unit; 
    private String category;

    public MaterialModel(){
    }

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTOR: ID, name, description, height, length, width">
    /**
     * Constructor for a material to be used in construction of the carport.
     *
     * @param ID Item ID
     * @param name Item name
     * @param description Item description
     * @param height Item height
     * @param length Item length
     * @param width Item width
     */
    public MaterialModel(int ID, String name, String description, int height, int length, int width){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.height = height;
        this.length = length;
        this.width = width;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTOR: ID, description, height, width, length, price, unit, category">
    /**
     * Updated constructor to fit database model.
     *
     * use setters for: helptext, quantity
     *
     * @param ID
     * @param description
     * @param length
     * @param width
     * @param height
     * @param price
     * @param unit
     * @param category
     */
    public MaterialModel(int ID, String description, int height, int width, int length, double price, String unit, String category){
        this.ID = ID;
        this.description = description;
        this.height = height;
        this.width = width;
        this.length = length;
        this.price = price;
        this.unit = unit;
        this.category = category;
    }
     //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTOR: MaterialModel">
    /**
     * Used in raisedRoofCalculator to make a copy of the MaterialModel
     * @param model
     */
    public MaterialModel(MaterialModel model){
        ID = model.ID;
        name = model.name;
        description = model.description;
        helptext = model.helptext; 
        length = model.length;
        width = model.width;
        height = model.height;
        quantity = model.quantity; 
        price = model.price; 
        unit = model.unit; 
        category = model.category;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getCategory">
    /**
     * Get the value of category
     *
     * @return the value of category
     */
    public String getCategory()
    {
        return category;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setCategory">
    /**
     * Set the value of category
     *
     * @param category new value of category
     */
    public void setCategory(String category)
    {
        this.category = category;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getID">
    public int getID()
    {
        return ID;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setID">
    public void setID(int ID)
    {
        this.ID = ID;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getName">
    public String getName()
    {
        return name;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setName">
    public void setName(String name)
    {
        this.name = name;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getDescription">
    public String getDescription()
    {
        return description;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setDescription">
    public void setDescription(String description)
    {
        this.description = description;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getPrice">
    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice()
    {
        return price;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setPrice">
    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getHelptext">
    /**
     * Get the value of helptext
     *
     * @return the value of helptext
     */
    public String getHelptext()
    {
        return helptext;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getUnit">
    /**
     * Get the value of unit
     *
     * @return the value of unit
     */
    public String getUnit()
    {
        return unit;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setUnit">
    /**
     * Set the value of unit
     *
     * @param unit new value of unit
     */
    public void setUnit(String unit)
    {
        this.unit = unit;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setHelptext">
    /**
     * Set the value of helptext
     *
     * @param helptext new value of helptext
     */
    public void setHelptext(String helptext)
    {
        this.helptext = helptext;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getQuantity">
    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity()
    {
        return quantity;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setQuantity">
    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getHeight">
    /**
     * Get the value of height
     *
     * @return the value of height
     */
    public int getHeight()
    {
        return height;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setHeight">
    /**
     * Set the value of height
     *
     * @param height new value of height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getWidth">
    /**
     * Get the value of width
     *
     * @return the value of width
     */
    public int getWidth()
    {
        return width;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setWidth">
    /**
     * Set the value of width
     *
     * @param width new value of width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="getLength">
    /**
     * Get the value of length
     *
     * @return the value of length
     */
    public int getLength()
    {
        return length;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setLength">
    /**
     * Set the value of length
     *
     * @param length new value of length
     */
    public void setLength(int length)
    {
        this.length = length;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString()
    {
        return "MaterialModel{" + "ID=" + ID + ", name=" + name + ", description=" + description + ", helptext=" + helptext + ", length=" + length + ", width=" + width + ", height=" + height + ", quantity=" + quantity + ", price=" + price + ", unit=" + unit + '}';
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="hashCode">
    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 41 * hash + this.ID;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + Objects.hashCode(this.helptext);
        hash = 41 * hash + this.length;
        hash = 41 * hash + this.width;
        hash = 41 * hash + this.height;
        hash = 41 * hash + this.quantity;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.unit);
        return hash;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="equals">
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final MaterialModel other = (MaterialModel) obj;
        if (this.ID != other.ID)
        {
            return false;
        }
        if (this.length != other.length)
        {
            return false;
        }
        if (this.width != other.width)
        {
            return false;
        }
        if (this.height != other.height)
        {
            return false;
        }
        if (this.quantity != other.quantity)
        {
            return false;
        }
        if (this.price != other.price)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.description, other.description))
        {
            return false;
        }
        if (!Objects.equals(this.helptext, other.helptext))
        {
            return false;
        }
        if (!Objects.equals(this.unit, other.unit))
        {
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    
}
