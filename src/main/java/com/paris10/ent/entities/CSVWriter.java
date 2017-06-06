package com.paris10.ent.entities;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Youssef on 05/06/2017.
 */
public class CSVWriter {


        //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ":";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private String csvFile;

    public CSVWriter(){

    }

    public CSVWriter(String csvFile) {
        this.csvFile = csvFile;
    }

    //CSV file header
  //  private static final String FILE_HEADER = "id,firstName,lastName,gender,age";


    public static void writeCsvFile(String fileName,String codeFonction) {

        FileWriter fileWriter = null;

        try{
            String url = "jdbc:mysql://localhost:3306/ENT?autoReconnect=true&useSSL=false";
            Connection connection = DriverManager.getConnection(url,"root","root");
            Statement st = connection.createStatement();
            fileWriter = new FileWriter(fileName);
            ResultSet rs;
            String nom_semestre,nom_matiere,description_matiere,nb_ects,nb_heures,nom_enseignant;

            switch(codeFonction){
                case "1":
                    System.out.println("Premiere requête");
                    rs = st.executeQuery("SELECT nom_semestre FROM semestre");
                    System.out.println("YES requête 1");
                    while (rs.next()) {
                        nom_semestre= rs.getString("nom_semestre");
                        fileWriter.append(nom_semestre);
                        fileWriter.append(NEW_LINE_SEPARATOR);
                    }
                    System.out.println("CSV file was created successfully !!!");
                    break;
                case "2":
                    String nom_ue,nom_promo;
                    rs = st.executeQuery("SELECT nom_ue, semestre.nom_semestre, promotion.nom_promo from ue,semestre,promotion WHERE ue.id_semestre=semestre.id_semestre and ue.id_promotion=promotion.id_promotion");
                    while (rs.next()) {
                        nom_ue=rs.getString("nom_ue");
                        nom_semestre= rs.getString("nom_semestre");
                        nom_promo=rs.getString("nom_promo");
                        fileWriter.append(nom_ue);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(nom_semestre);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(nom_promo);
                        fileWriter.append(NEW_LINE_SEPARATOR);
                    }
                    break;
                case "3":
                    rs = st.executeQuery("SELECT nom_matiere, description_matiere, nb_ects, nb_heures, ue.nom_ue, enseignant.nom_enseignant from matiere,ue,enseignant WHERE matiere.id_ue=ue.id_ue and matiere.id_enseignant=enseignant.enseignant_id_user");
                    while (rs.next()) {
                        nom_matiere=rs.getString("nom_matiere");
                        description_matiere= rs.getString("description_matiere");
                        nb_ects=rs.getString("nb_ects");
                        nb_heures=rs.getString("nb_heures");
                        nom_ue=rs.getString("nom_ue");
                        nom_enseignant=rs.getString("nom_enseignant");
                        fileWriter.append(nom_matiere);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(description_matiere);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(nb_ects);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(nb_heures);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(nom_ue);
                        fileWriter.append(COMMA_DELIMITER);
                        fileWriter.append(nom_enseignant);
                        fileWriter.append(NEW_LINE_SEPARATOR);
                    }
            }
            System.out.println("CSV file was created successfully !!!");
        }
        catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                }
                catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                 }

        }
    }
}