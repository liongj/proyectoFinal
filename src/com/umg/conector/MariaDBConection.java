package com.umg.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MariaDBConection {
	 private static final String URL = "jdbc:mariadb://localhost:3306/producto/envios?permitMysqlScheme";

	    private static final String USUARIO = "root";

	    private static final String CONTRASEÑA = "47211815";

	    

	    public static Connection getConnection() {

	        Connection conn = null;

	        try {

	            Class.forName("org.mariadb.jdbc.Driver");

	            conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);

	            return conn;

	        } catch (SQLException e) {

	            System.out.println("Error al conectar a la base de datos: " + e.getMessage());

	            return null;

	        } catch (ClassNotFoundException e) {

	            System.out.println("No se encontró el controlador JDBC" + e.toString());

	            return null;

	        }

	    }
	    
	    public boolean Agregara (Negocio a) {
	    	
	    	try {
	    		String query = "INSERT INTO productos(cliente,direccion_de_pedido,estado_de_pedido) VALUES(?,?,?)";
	    	
	    		PreparedStatement sta = getConnection ().prepareStatement(query);
	    		
	    		sta.setString(1,a.getCliente());
	    		sta.setString(2,a.getDireccion_de_pedido());
	    		sta.setString(3,a.getEstado_de_pedido());
	    		
	    		sta.executeUpdate();
	    		
	    		return true;
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		return false;
	    	}finally {
	    		try {
	    			if(getConnection()!=null) {
	    				getConnection().close();
	    			}
	    		}catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	    public boolean Eliminar(Negocio o) {
	    	
	    	try {
	    		String query = "DELETE FROM 'producto'Where 'Id'=? ";
	    	
	    		PreparedStatement sta = getConnection ().prepareStatement(query);
	    		
	    		sta.setInt(1, o.getIdproducto());
	    		
	    		sta.executeUpdate();
	    		
	    		return true;
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		return false;
	    	}finally {
	    		try {
	    			if(getConnection()!=null) {
	    				getConnection().close();
	    			}
	    		}catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
   public boolean Editar(Negocio u) {
	    	
	    	try {
	    		String query = "UPDATE'productos'SET'cliente'=?,'direccion_de_pedido'=?,'estado_de_pedido'=? WHERE'productos'.'Id'=? ";
	    	
	    		PreparedStatement sta = getConnection ().prepareStatement(query);
	    		
	    		sta.setString(1,u.cliente);
	    		sta.setString(2,u.direccion_de_pedido);
	    		sta.setString(3,u.estado_de_pedido);
	    		sta.setInt(4, u.Idproducto);
	    		
	    		sta.executeUpdate();
	    		
	    		return true;
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    		return false;
	    	}finally {
	    		try {
	    			if(getConnection()!=null) {
	    				getConnection().close();
	    			}
	    		}catch(SQLException e) {
	    			e.printStackTrace();
	    		}}
   }
   
   
   public boolean Buscara(Negocio l) {
	   
   	     ResultSet rs = null;
   
   	try {
   		String query = "SELECT * FROM 'productos'WHERE 'Id'=?";
   		PreparedStatement sta = getConnection ().prepareStatement(query);
   		
   		sta.setInt(1, l.getIdproducto());
   		
   		rs= sta.executeQuery();
   		
   		if(rs.next()) {
   			l.setCliente(rs.getString("cliente"));
   			l.setDireccion_de_pedido(rs.getString("direccion_de_producto"));
   			l.setEstado_de_pedido(rs.getString("estado_de_pedido"));
   		}
   		return true;
   		
   	}catch(SQLException e) {
   		e.printStackTrace();
   		return false;
   	}finally {
   		try {
   			if(getConnection()!=null) {
   				getConnection().close();
   			}
   		}catch(SQLException e) {
   			e.printStackTrace();
   		}
   	}
   }
}
