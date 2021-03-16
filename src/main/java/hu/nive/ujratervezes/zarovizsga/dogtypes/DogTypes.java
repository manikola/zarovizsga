package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country){
        String country1 = country.toUpperCase();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `name` FROM `dog_types` WHERE `country` = ?;")) {
            stmt.setString(1, country1);


            return getListByPreparedStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalArgumentException("Error by select", se);
        }
    }
    private List<String> getListByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            List<String> dogNames = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                dogNames.add(name.toLowerCase());

            }
            return dogNames;


        } catch (SQLException se) {
            throw new IllegalStateException("Error by select", se);

        }
    }

}
//A DogTypes osztályba dolgozz, mely egy DataSource-ot kap konstruktorba. A DogTypesTest hívja meg, ott van a DataSource
// deklarálva. Nyugodtan írd át a benne lévő értékeket.
//
//Legyen egy List<String> getDogsByCountry(String country) metódusa, mely adatbázisból visszaadja az adott országhoz
// tartozó kutyafajtákat! A teszteset a V1__dogs.sql állományt futtatja le Flyway-jel. Létrehoz egy dog_types táblát,
// amiből a lényeges a name és a country oszlop. Adatokat is beszúrja. Ha lassú, akkor csak azokat a sorokat hagyd benne,
// amiben szerepel a HUNGARY szó!
//
//Vigyázz, a metódus kisbetűsen kapja az ország nevét, de az adatbázisban csupa nagybetűsen szerepel. Vigyázz, a kutyák
// fajtái nagybetűkkel vannak, de kisbetűkkel kell visszaadni. (Konvertálásokat végezheted Javaban vagy SQL-ben is.)
//
//Név szerint sorbarendezve add vissza őket!