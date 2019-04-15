/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.databaseAccessObjects.mappers;

/**
 *
 * @author Camilla
 */

public class OrderMapper {
    private static OrderMapper orderMapper;
    
    private OrderMapper() {

    }

    public static OrderMapper getInstance() {
        if (orderMapper == null) {
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }
}