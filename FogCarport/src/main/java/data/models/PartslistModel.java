
package data.models;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author 
 */
public class PartslistModel
{

    private ArrayList<MaterialModel> billOfMaterials;
    private int totalprice = 0;
    
    int rafterCount = 0;
    int lathRowCount = 0;
    int tileCount = 0;
    int topTileCount = 0;
    private ArrayList postPosSideOne = new ArrayList();
    private ArrayList postPosSideTwo = new ArrayList();
    private ArrayList postPosRear = new ArrayList();

    public PartslistModel()
    {
        billOfMaterials = new ArrayList<>();
    }

    public ArrayList<MaterialModel> getBillOfMaterials()
    {
        return billOfMaterials;
    }

    public void addMaterial(MaterialModel material)
    {
        this.getBillOfMaterials().add(material);
        this.totalprice += material.getPrice();
    }

    public void addPartslist(PartslistModel partslist)
    {
        /*Updating SVG stuff*/
        rafterCount = partslist.getRafterCount();
        lathRowCount = partslist.getLathRowCount();
        tileCount = partslist.getTileCount();
        topTileCount = partslist.getTopTileCount();
        postPosSideOne = partslist.getPostPosSideOne();
        postPosSideTwo = partslist.getPostPosSideTwo();
        postPosRear = partslist.getPostPosRear();
        /*Updating materials*/
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

    public int getRafterCount() {
        return rafterCount;
    }

    public void setRafterCount(int rafterCount) {
        this.rafterCount = rafterCount;
    }

    public int getLathRowCount() {
        return lathRowCount;
    }

    public void setLathRowCount(int lathRowCount) {
        this.lathRowCount = lathRowCount;
    }

    public int getTileCount() {
        return tileCount;
    }

    public void setTileCount(int tileCount) {
        this.tileCount = tileCount;
    }

    public int getTopTileCount() {
        return topTileCount;
    }

    public void setTopTileCount(int topTileCount) {
        this.topTileCount = topTileCount;
    }

    public ArrayList getPostPosSideOne()
    {
        return postPosSideOne;
    }

    public void setPostPosSideOne(ArrayList postPosSideOne)
    {
        this.postPosSideOne = postPosSideOne;
    }

    public ArrayList getPostPosSideTwo()
    {
        return postPosSideTwo;
    }

    public void setPostPosSideTwo(ArrayList postPosSideTwo)
    {
        this.postPosSideTwo = postPosSideTwo;
    }

    public ArrayList getPostPosRear()
    {
        return postPosRear;
    }

    public void setPostPosRear(ArrayList postPosRear)
    {
        this.postPosRear = postPosRear;
    }
    
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.billOfMaterials);
        hash = 79 * hash + this.totalprice;
        return hash;
    }

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
        final PartslistModel other = (PartslistModel) obj;
        if (this.totalprice != other.totalprice)
        {
            return false;
        }
        if (!Objects.equals(this.billOfMaterials, other.billOfMaterials))
        {
            return false;
        }
        return true;
    }

}
