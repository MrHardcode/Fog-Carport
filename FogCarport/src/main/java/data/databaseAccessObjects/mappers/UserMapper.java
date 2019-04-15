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

public class UserMapper {
    private static UserMapper userMapper;
    
    private UserMapper() {

    }

    public static UserMapper getInstance() {
        if (userMapper == null) {
            userMapper = new UserMapper();
        }
        return userMapper;
    }
}