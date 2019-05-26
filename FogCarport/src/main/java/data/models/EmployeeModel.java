/*
 *  
 */
package data.models;

/**
 * Model of the Employee data
 * @author 
 */
public class EmployeeModel
{
    private int id;
    private String email;
    private String role;
    private int id_role;
    
    public EmployeeModel()
    {
    }

    //<editor-fold defaultstate="collapsed" desc="getId_role">
    /**
     * Get the value of id_role
     *
     * @return the value of id_role
     */
    public int getId_role()
    {
        return id_role;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setId_role">
    /**
     * Set the value of id_role
     *
     * @param id_role new value of id_role
     */
    public void setId_role(int id_role)
    {
        this.id_role = id_role;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getRole">
    /**
     * Get the value of role
     *
     * @return the value of role
     */
    public String getRole()
    {
        return role;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setRole">
    /**
     * Set the value of role
     *
     * @param role new value of role
     */
    public void setRole(String role)
    {
        this.role = role;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getEmail">
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getEmail()
    {
        return email;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setEmail">
    /**
     * Set the value of name
     *
     * @param email new value of name
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getId">
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setId">
    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    //</editor-fold>

}
