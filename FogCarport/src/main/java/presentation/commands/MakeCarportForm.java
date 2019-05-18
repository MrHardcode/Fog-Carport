package presentation.commands;

import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author Runi
 */
public class MakeCarportForm extends Command
{
    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws UserException, DataException
    {
        /* Initializing required variables */

        //flat roof materials
        final int plasticTileID = 29; //plastmo ecolite (blåtonet)
        //final int feltTileID = 47; //not implemented

        //raised roof materials
        final int tileOptionOneID = 33; //B & C Dobbelt Tagsten (Sort)
        final int tileOptionTwoID = 34; //B & C Dobbelt Tagsten (Grå)
        final int tileOptionThreeID = 35; //Eternit Tagsten(Teglrød)
        final int tileOptionFourID = 36; //B & C Dobbelt Tagsten (Rød)
        final int tileOptionFiveID = 37; //B & C Dobbelt Tagsten (Blå)
        final int tileOptionSixID = 38; //B & C Dobbelt Tagsten (Sortblå)
        final int tileOptionSevenID = 39; //B & C Dobbelt Tagsten (Sunlux)

        //shed floor materials
        final int floorOptionOneID = 51; //30x250x4800mm alm. planke (Eg) (expensive)
        final int floorOptionTwoID = 53; //25x200x3200mm alm. Bræt (less expensive)

        //shed wall materials
        final int wallOptionOneID = 56; //25x200x5400mm trykimp. Bræt

        /* Initializing PartsListModels */
        PartslistModel flatRoofParts = new PartslistModel();
        PartslistModel raisedRoofParts = new PartslistModel();
        PartslistModel shedFloorParts = new PartslistModel();
        PartslistModel shedWallParts = new PartslistModel();

        /* Load materials needed from DB and add to their respective partslist */
        //flat roof
        flatRoofParts.addMaterial(logic.getMaterial(plasticTileID, "roof"));

        //raised roof
        raisedRoofParts.addMaterial(logic.getMaterial(tileOptionOneID, "roof"));
        raisedRoofParts.addMaterial(logic.getMaterial(tileOptionTwoID, "roof"));
        raisedRoofParts.addMaterial(logic.getMaterial(tileOptionThreeID, "roof"));
        raisedRoofParts.addMaterial(logic.getMaterial(tileOptionFourID, "roof"));
        raisedRoofParts.addMaterial(logic.getMaterial(tileOptionFiveID, "roof"));
        raisedRoofParts.addMaterial(logic.getMaterial(tileOptionSixID, "roof"));
        raisedRoofParts.addMaterial(logic.getMaterial(tileOptionSevenID, "roof"));
        //shed floor 
        shedFloorParts.addMaterial(logic.getMaterial(floorOptionOneID, "shed"));
        shedFloorParts.addMaterial(logic.getMaterial(floorOptionTwoID, "shed"));

        //shed wall
        shedWallParts.addMaterial(logic.getMaterial(wallOptionOneID, "shed"));

        /* Set partslistmodels on their respective request attributes */
        request.setAttribute("flatRoofParts", flatRoofParts.getBillOfMaterials());
        request.setAttribute("raisedRoofParts", raisedRoofParts.getBillOfMaterials());
        request.setAttribute("shedFloorParts", shedFloorParts.getBillOfMaterials());
        request.setAttribute("shedWallParts", shedWallParts.getBillOfMaterials());

        /* return */
        return "makeCarport";
    }

}
