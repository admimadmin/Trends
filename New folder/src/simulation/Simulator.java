/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.sql.Connection;
import lib.MysqlService;

/**
 *
 * @author IEUser
 */
public class Simulator {

    protected MysqlService service;

    public Simulator() {
        service = new MysqlService();
    }
    
    public Connection getConnection(){
        return service.connToDatabase("simulator_shema");
    }
}
