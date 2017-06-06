package com.paris10.ent.entities;

import javax.persistence.Entity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Youssef on 04/06/2017.
 */
public class CSVReader {

    private String csvFile;

    public CSVReader(){}

    public CSVReader(String csvFile) {
        this.csvFile = csvFile;
    }
    public void ajoutSemestre(String[]record){

        try{
            String url = "jdbc:mysql://localhost:3306/ENT?autoReconnect=true&useSSL=false";
            Connection connection = DriverManager.getConnection(url,"root","root");
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO semestre(nom_semestre) VALUES ('"+record[0]+"')");
        }
        catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    public void ajouterUE(String[]record){
        try{
            String url = "jdbc:mysql://localhost:3306/ENT?autoReconnect=true&useSSL=false";
            Connection connection = DriverManager.getConnection(url,"root","root");
            Statement st = connection.createStatement();
            int semestre=0,promotion=0;


            System.out.println("Premiere requête");
            ResultSet rs = st.executeQuery("SELECT id_semestre FROM semestre WHERE nom_semestre='"+record[1]+"'");
            System.out.println("YES requête 1");
            while (rs.next()) {
                semestre= rs.getInt("id_semestre");
            }

            System.out.println("semestre id " + semestre);
            ResultSet rs2 = st.executeQuery("SELECT id_promotion FROM promotion WHERE nom_promo='"+record[2]+"'");
            while (rs2.next()) {
                promotion = rs2.getInt("id_promotion");
            }
            System.out.println("promotion id " +promotion);
          //  st.executeUpdate("INSERT INTO ue(nom_ue,id_semestre,id_promotion) VALUES ('"+record[0]+"','"+semestre+"','"+promotion+"')");

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO ue(nom_ue,id_semestre,id_promotion) VALUES (?,?,?)");
            pstmt.setString(1, record[0] );
            pstmt.setInt(2, semestre);
            pstmt.setInt(3, promotion);
            pstmt.executeUpdate();


        }
        catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void ajouterMatiere(String[]record){
        try{
            String url = "jdbc:mysql://localhost:3306/ENT?autoReconnect=true&useSSL=false";
            Connection connection = DriverManager.getConnection(url,"root","root");
            Statement st = connection.createStatement();
            int ue=0,enseignant=0;


            System.out.println("Premiere requête");
            ResultSet rs = st.executeQuery("SELECT id_ue FROM ue WHERE nom_ue='"+record[4]+"'");
            System.out.println("YES requête 1");
            while (rs.next()) {
                ue= rs.getInt("id_ue");
            }

            System.out.println("ue id " + enseignant);
            ResultSet rs2 = st.executeQuery("SELECT enseignant.enseignant_id_user FROM enseignant WHERE nom_enseignant='"+record[5]+"'");
            while (rs2.next()) {
                enseignant = rs2.getInt("enseignant_id_user");
            }
            System.out.println("enseignant id " +enseignant);
            //  st.executeUpdate("INSERT INTO ue(nom_ue,id_semestre,id_promotion) VALUES ('"+record[0]+"','"+semestre+"','"+promotion+"')");

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO matiere(nom_matiere,description_matiere,nb_ects,nb_heures,id_ue,id_enseignant) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, record[0] );
            pstmt.setString(2, record[1] );
            pstmt.setString(3, record[2] );
            pstmt.setString(4, record[3] );
            pstmt.setInt(5, ue);
            pstmt.setInt(6, enseignant);
            pstmt.executeUpdate();


        }
        catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void readCSV(String csvFile,String codeFonction) {

        //String csvFile = "/Users/mkyong/csv/country.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ":";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] record = line.split(cvsSplitBy);

//                System.out.println("UE ajouté = " + record[0] +"  "+record[1] );
                System.out.println("code Fonction : "+codeFonction);
                switch (codeFonction) {
                    case "1":  ajoutSemestre(record);
                        break;
                    case "2":  ajouterUE(record);
                        break;
                    case "3":  ajouterMatiere(record);
                        break;
                    default:
                        break;
                }
               // ajoutSemestre(record);

               // ajouterUE(record);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}