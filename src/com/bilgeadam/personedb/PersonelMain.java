package com.bilgeadam.personedb;

import java.sql.*;


public class PersonelMain {
    public static void main(String[] args) {

        try {
            //JDBC driver'ı tanımladık
            Class.forName("org.postgresql.Driver");

            //Connection objesi olusturuyoruz.
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");

            //Statement oluştur
            Statement st = conn.createStatement();

            //ResultSet'e sonucları at
            ResultSet rs = st.executeQuery("select no,ad,soyad,maas from personel order by no");

            while (rs.next())
            {
                System.out.print("No: " +rs.getInt("no"));
                System.out.print(" Ad: " +rs.getString("ad"));
                System.out.print(" Soyad: " +rs.getString("soyad"));
                System.out.print(" Maas: " +rs.getDouble("maas"));
                System.out.println();
            }

            //veri tabanında işler bitince kaynakları bırak

            rs.close();
            st.close();
            conn.close();

        }
        catch (ClassNotFoundException e) {
            System.err.println("Lütfen JDBC driver jar dosyasını ekleyin!");
        }
        catch (Exception e)
        {
            System.err.println("Hata: " +e.getMessage());
        }


    }
}
