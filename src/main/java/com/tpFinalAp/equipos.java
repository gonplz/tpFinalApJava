package com.tpFinalAp;

import java.sql.*;


public class equipos {
    public String nombre;
    public int titulares;
    public int suplentes;
    public String directorTecnico;
    public int puntos;
    public int partidosJugados;

    public equipos(){}

    public equipos (String nombre, int titulares, int suplentes, String directorTecnico, int puntos, int partidosJugados ){
        this.nombre = nombre;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.directorTecnico = directorTecnico;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

    public String ConsultarTodosLosEquipos()  {
        ResultSet rs;
        String resultado = "";
        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/equipo","root","");
            Statement stmt=con.createStatement();

            rs = stmt.executeQuery ("SELECT * FROM Equipo");
            while(rs.next()){
                resultado += (rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt (3) + " " +
                        rs.getInt (4) + " " + rs.getString(5) + " " + rs.getInt(6) + " " +
                        rs.getInt(7) + " |\n ");

            }
            con.close();


        } catch(Exception e){System.out.println(e);}

        return resultado;
    }

    public String ConsultarUnEquipo(int idEquipo)  {
        ResultSet rs;
        String resultado = "";
        String consulta = "SELECT * FROM Equipo WHERE idEquipo = ?";
        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/equipo","root","");

            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, idEquipo);
            rs = ps.executeQuery();
            while(rs.next())
                resultado = (rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt (3) + " " +
                        rs.getInt (4) + " " + rs.getString(5) + " " + rs.getInt(6) + " " +
                        rs.getInt(7) + "\n");

            con.close();

        } catch(Exception e){System.out.println(e);}

        return resultado;
    }
}