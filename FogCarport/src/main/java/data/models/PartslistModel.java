/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Camilla
 */
public class PartslistModel {
    private ArrayList<MaterialModel> billOfMaterials;
    private int totalprice = 0;

    public PartslistModel() {
        billOfMaterials = new ArrayList<>();
    }

    public ArrayList<MaterialModel> getBillOfMaterials() {
        return billOfMaterials;
    }
    
    public void addMaterial(MaterialModel material){
        this.getBillOfMaterials().add(material);
        this.totalprice += material.getPrice();
    }
    
    public void addPartslist (PartslistModel partslist){
        billOfMaterials.addAll(partslist.getBillOfMaterials());
        this.totalprice += partslist.getTotalprice();
    }

    public int getTotalprice()
    {
        return totalprice;
    }

    public void setTotalprice(int totalprice)
    {
        this.totalprice = totalprice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.billOfMaterials);
        hash = 79 * hash + this.totalprice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PartslistModel other = (PartslistModel) obj;
        if (this.totalprice != other.totalprice) {
            return false;
        }
        if (!Objects.equals(this.billOfMaterials, other.billOfMaterials)) {
            return false;
        }
        return true;
    }
    
    

}
