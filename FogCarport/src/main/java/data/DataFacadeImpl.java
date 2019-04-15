/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.models.MaterialModel;
import data.models.OrderModel;

/**
 *
 * @author Camilla
 */
public class DataFacadeImpl implements DataFacade{

    @Override
    public MaterialModel getMaterial() {
        // skal udviddes 
        return new MaterialModel();
    }

    @Override
    public OrderModel getOrder() {
        // skal udviddes 
        return new OrderModel();
    }
    
}
