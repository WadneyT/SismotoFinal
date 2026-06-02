/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author User
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() throws Exception {

        Class.forName(
            "org.postgresql.Driver"
        );

        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/sismoto",
            "postgres",
            "123456"
        );
    }
}