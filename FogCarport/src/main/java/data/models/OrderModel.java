package data.models;

/**
 *
 * @author
 */ 
public class OrderModel
{

    /*
    Fields
     */
    private int height;
    private int length;
    private int width;
    private int id;
    private int id_customer;
    private int id_employee;
    private String build_adress;
    private int build_zipcode;
    private int incline;
    private String status;
    private int roof_tiles_id;
    private int shed_width;
    private int shed_length;
    private int shed_walls_id;
    private int shed_floor_id;
    private double price;

    public OrderModel()
    {
    }

    public OrderModel(int height, int length, int width)
    {
        this.length = length;
        this.width = width;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    /**
     * Get the value of shed_floor_id
     *
     * @return the value of shed_floor_id
     */
    public int getShed_floor_id()
    {
        return shed_floor_id;
    }

    /**
     * Set the value of shed_floor_id
     *
     * @param shed_floor_id new value of shed_floor_id
     */
    public void setShed_floor_id(int shed_floor_id)
    {
        this.shed_floor_id = shed_floor_id;
    }

    /**
     * Get the value of shed_walls_id
     *
     * @return the value of shed_walls_id
     */
    public int getShed_walls_id()
    {
        return shed_walls_id;
    }

    /**
     * Set the value of shed_walls_id
     *
     * @param shed_walls_id new value of shed_walls_id
     */
    public void setShed_walls_id(int shed_walls_id)
    {
        this.shed_walls_id = shed_walls_id;
    }

    /**
     * Get the value of shed_length
     *
     * @return the value of shed_length
     */
    public int getShed_length()
    {
        return shed_length;
    }

    /**
     * Set the value of shed_length
     *
     * @param shed_length new value of shed_length
     */
    public void setShed_length(int shed_length)
    {
        this.shed_length = shed_length;
    }

    /**
     * Get the value of shed_width
     *
     * @return the value of shed_width
     */
    public int getShed_width()
    {
        return shed_width;
    }

    /**
     * Set the value of shed_width
     *
     * @param shed_width new value of shed_width
     */
    public void setShed_width(int shed_width)
    {
        this.shed_width = shed_width;
    }

    /**
     * Get the value of roof_tiles_id
     *
     * @return the value of roof_tiles_id
     */
    public int getRoof_tiles_id()
    {
        return roof_tiles_id;
    }

    /**
     * Set the value of roof_tiles_id
     *
     * @param roof_tiles_id new value of roof_tiles_id
     */
    public void setRoof_tiles_id(int roof_tiles_id)
    {
        this.roof_tiles_id = roof_tiles_id;
    }

    /**
     * Get the value of height
     *
     * @return the value of height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Set the value of height
     *
     * @param height new value of height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * Get the value of length
     *
     * @return the value of length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Set the value of length
     *
     * @param length new value of length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * Get the value of width
     *
     * @return the value of width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Set the value of width
     *
     * @param width new value of width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Get the value of incline
     *
     * @return the value of incline
     */
    public int getIncline()
    {
        return incline;
    }

    /**
     * Set the value of incline
     *
     * @param incline new value of incline
     */
    public void setIncline(int incline)
    {
        this.incline = incline;
    }

    /**
     * Get the value of build_zipcode
     *
     * @return the value of build_zipcode
     */
    public int getBuild_zipcode()
    {
        return build_zipcode;
    }

    /**
     * Set the value of build_zipcode
     *
     * @param build_zipcode new value of build_zipcode
     */
    public void setBuild_zipcode(int build_zipcode)
    {
        this.build_zipcode = build_zipcode;
    }

    /**
     * Get the value of build_adress
     *
     * @return the value of build_adress
     */
    public String getBuild_adress()
    {
        return build_adress;
    }

    /**
     * Set the value of build_adress
     *
     * @param build_adress new value of build_adress
     */
    public void setBuild_adress(String build_adress)
    {
        this.build_adress = build_adress;
    }

    /**
     * Get the value of id_employee
     *
     * @return the value of id_employee
     */
    public int getId_employee()
    {
        return id_employee;
    }

    /**
     * Set the value of id_employee
     *
     * @param id_employee new value of id_employee
     */
    public void setId_employee(int id_employee)
    {
        this.id_employee = id_employee;
    }

    /**
     * Get the value of id_customer
     *
     * @return the value of id_customer
     */
    public int getId_customer()
    {
        return id_customer;
    }

    /**
     * Set the value of id_customer
     *
     * @param id_customer new value of id_customer
     */
    public void setId_customer(int id_customer)
    {
        this.id_customer = id_customer;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    // </editor-fold>
}
