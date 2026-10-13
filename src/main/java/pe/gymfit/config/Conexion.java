/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gymfit.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import pe.gymfit.dao.DatosException;

/**
 *
 * @author medar
 */
public class Conexion {
    private final String url;
    private final String usuario;
    private final String clave;

    public Conexion() {
        this("/db.properties");
    }

    public Conexion(String recurso) {
        Properties p = new Properties();
        try (InputStream in = Conexion.class.getResourceAsStream(recurso)) {
            if (in == null) {
                throw new DatosException("Falta " + recurso + " en src/main/resources", null);
            }
            p.load(in);
        } catch (IOException e) {
            throw new DatosException("No se pudo leer " + recurso, e);
        }
        this.url = p.getProperty("db.url");
        this.usuario = p.getProperty("db.user");
        this.clave = p.getProperty("db.password");
    }

    public Connection obtener() throws SQLException {
        return DriverManager.getConnection(url, usuario, clave);
    }
}
