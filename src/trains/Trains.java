package trains;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.Month;

public class Trains {
    
    //ajouter gare
    public static void ajouterGare(int code, String nomGare,String nomVile,Connection c)throws Exception{
        PreparedStatement requete = c.prepareStatement("INSERT INTO gare VALUES(?,?,?)");
        requete.setInt(1, code);requete.setString(2, nomGare);requete.setString(3, nomVile);
        requete.executeUpdate();
    }
    //ajouter voyage
    public static void ajouterVoyage(int codev, int codegaredep, int codegarearr,Timestamp tempsarrprevue,Timestamp tempsarreffec,Connection c)throws Exception{
        PreparedStatement requete = c.prepareStatement("INSERT INTO voyage VALUES(?,?,?,?,?)");
        requete.setInt(1, codev);requete.setInt(2, codegaredep);requete.setInt(3, codegarearr);
        requete.setTimestamp(4, tempsarrprevue);requete.setTimestamp(5, tempsarreffec);
        requete.executeUpdate();
        
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/dbtrains";
            String user = "postgres";
            String password = "wissal";
            Connection c = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie");
            
            //tester les fonctions d'ajout 23:07:00 
            java.sql.Timestamp t = java.sql.Timestamp.valueOf("2019-10-23 23:07:00");
            java.sql.Timestamp tt = java.sql.Timestamp.valueOf("2019-10-23 23:41:00");
            //Timestamp t = new Timestamp(2019.10.23.23.07.00);
            //ajouterGare(101, "agdal", "rabat");
           // ajouterGare(202, "OASIS", "Casablanca");
           // ajouterGare(303, "Casaport", "casablanca");
            
            //ajouterVoyage(48, 303, 202,t,tt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}
