
import org.flywaydb.core.Flyway;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://127.0.0.1:5432/ProductSale", "postgres", "123")
                .locations("db")
                .load();
        flyway.clean();
        flyway.migrate();



        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProductSale", "postgres", "123"))
        {
            System.out.println("Connection Ok.");
            final OrganizationDAO organizationDAO = new OrganizationDAO(connection);
            final NomenclaturaDAO nomenclaturaDAO = new NomenclaturaDAO(connection);

            organizationDAO.save( new Organization(12345,123,"Организация11"));
            System.out.println("Все организации:");
            for (Organization organization : organizationDAO.getAll() ){
                System.out.println("id : " + organization.getINN() + " name: " + organization.getName());
            }
            System.out.println("Организации по количемству товара");
            for (Organization organization : organizationDAO.getByAmountTen() ){
                System.out.println("id : " + organization.getINN() + " name: " + organization.getName());
            }
            System.out.println("Организации с суммой поставленного товара выше ");
            for (Organization organization : organizationDAO.getWithBigSum(400) ){
                System.out.println("id : " + organization.getINN() + " name: " + organization.getName());
            }
            System.out.println("Средняя цена полученного товара за период с '2019-09-04' до '2019-11-04' ");

            LocalDate d1 =  LocalDate.of(2019,9,4);
            LocalDate d2 =  LocalDate.of(2019,11,4);
            System.out.println(organizationDAO.GetAVGPriceForPeriod(d1, d2));
            System.out.println("Продукты за период");
            organizationDAO.GetProductsByTime(d1,d2);
            System.out.println("Продукты и итоги за период");
            List<Nomenclatura>products = nomenclaturaDAO.getAll();
            for(Nomenclatura prod :products){
                organizationDAO.GetInformation3(prod.getCod_Id(),d1,d2);
            }



        }

        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }




        System.out.println("Hello world.");

    }

}

