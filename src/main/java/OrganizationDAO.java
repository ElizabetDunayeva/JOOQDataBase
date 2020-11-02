
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationDAO implements DAO<Organization>{

    final Connection connection;

    public OrganizationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Organization get(int id) {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT Name, Account FROM Organizations WHERE INN = " + id)) {
                while (rs.next()) {
                    return new Organization (rs.getInt("INN"), rs.getInt("Account"),rs.getString("Name"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Record with id " + id + "not found");
    }

    @Override
    public List<Organization> getAll() {
        final List<Organization> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT Name, Account,INN FROM Organizations")) {
                while (rs.next()) {
                    result.add(new Organization (rs.getInt("INN"), rs.getInt("Account"),rs.getString("Name")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public void save(Organization entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Organizations(Name,INN,Account) VALUES(?,?,?)")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getINN());
            preparedStatement.setInt(3, entity.getAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void delete(Organization entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Organizations WHERE INN = ?")) {
            preparedStatement.setInt(1, entity.getINN());
            if (preparedStatement.executeUpdate() == 0) {
                throw new IllegalStateException("Record with id = " + entity.getINN() + " not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * выбрать первые 10 поставщиков по количеству поставленного товара
     * @return
     */

    public List<Organization> getByAmountTen() {
        final List<Organization> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("\n" +
                    "SELECT * from Organizations O\n" +
                    " RIGHT JOIN (SELECT C.Organization_ID,SUM(D.AMOUNT)AS S\n" +
                    "from POSITIONS D LEFT JOIN INVOICES C ON\n" +
                    "  (D.Number_Invoice = C.NUMBER)\n" +
                    "GROUP BY C.Organization_ID\n" +
                    ")NEW\n" +
                    "on O.INN = NEW.Organization_ID\n" +
                    "ORDER BY NEW.S DESC\n" +
                    "LIMIT 10"
            )) {
                while (rs.next()) {
                    result.add(new Organization (rs.getInt("INN"), rs.getInt("Account"),rs.getString("Name")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    /**
     * Выбрать поставщиков с суммой поставляемого товара выше указанного количества
     * @param limit сумма поставленного товара являющейся минимальной
     * @return
     */
    public List<Organization> getWithBigSum(int limit){
        final List<Organization> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * from Organizations O\n" +
                    "RIGHT JOIN \n" +
                    "      (SELECT C.Organization_ID,SUM(D.AMOUNT*D.PRICE)AS S\n" +
                    "       from POSITIONS D \n" +
                    "\t   LEFT JOIN INVOICES C ON\n" +
                    "           (D.Number_Invoice = C.NUMBER)\n" +
                    "       GROUP BY C.Organization_ID\n" +
                    "       HAVING SUM(D.AMOUNT*D.PRICE) > "+" 400\n" +
                    "      )NEW\n" +
                    "   on O.INN = NEW.Organization_ID\n" +
                    "ORDER BY NEW.S DESC"
            )) {
                while (rs.next()) {
                    result.add(new Organization (rs.getInt("INN"), rs.getInt("Account"),rs.getString("Name")));
                }
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     return result;
    }

    public List<Organization> getWithDateLimits(int limit){
        final List<Organization> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * from Organizations O\n" +
                    "RIGHT JOIN \n" +
                    "      (SELECT C.Organization_ID,SUM(D.AMOUNT*D.PRICE)AS S\n" +
                    "       from POSITIONS D \n" +
                    "\t   LEFT JOIN INVOICES C ON\n" +
                    "           (D.Number_Invoice = C.NUMBER)\n" +
                    "       GROUP BY C.Organization_ID\n" +
                    "       HAVING SUM(D.AMOUNT*D.PRICE) > "+" 400\n" +
                    "      )NEW\n" +
                    "   on O.INN = NEW.Organization_ID\n" +
                    "ORDER BY NEW.S DESC"
            )) {
                while (rs.next()) {
                    result.add(new Organization (rs.getInt("INN"), rs.getInt("Account"),rs.getString("Name")));
                }
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Рассчитать среднюю цену полученного товара за период
     * @param limit1 начало периода
     * @param limit2 конец периода
     * @return
     */
    public int GetAVGPriceForPeriod(LocalDate limit1, LocalDate limit2){


        java.sql.Date sqlDate1 = java.sql.Date.valueOf( limit1 );
        java.sql.Date sqlDate2 = java.sql.Date.valueOf( limit2 );
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT ROUND(AVG(PRICE),1) AS PRICE\n" +
                    "from POSITIONS P\n" +
                    "LEFT JOIN INVOICES I ON(I.Number = P.Number_Invoice)\n" +
                    "WHERE I.Date_Of >= DATE'"+sqlDate1 +"' AND I.Date_Of <= DATE'"+sqlDate2+"'"
            )) {
                while (rs.next()) {

                    return rs.getInt(1);

                }
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        throw new IllegalStateException("Record with id not found");
    }


    public void GetProductsByTime(LocalDate limit1, LocalDate limit2){

        java.sql.Date sqlDate1 = java.sql.Date.valueOf( limit1 );
        java.sql.Date sqlDate2 = java.sql.Date.valueOf( limit2 );
        List<Organization> organizations = this.getAll();

        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT O.Name,O.INN,N.Name,N.COD_ID\n" +
                    "from ORGANIZATIONS O\n" +
                    "LEFT JOIN INVOICES I\n" +
                    "  ON(I.organization_id = O.inn),NOMENCLATURES N\n" +
                    "WHERE I.DATE_OF >=DATE'"+sqlDate1+"'AND I.DATE_OF<=DATE'"+sqlDate2+"'\n" +
                    "ORDER BY O.INN\n"
            )) {
                while (rs.next()) {

                    System.out.println("Name of Organization: " +rs.getString(1));
                    System.out.println("INN of Organization: " +rs.getInt("INN"));
                    System.out.println("Name of Product: " +rs.getString(3));
                    System.out.println("Cod of Product: " +rs.getInt("Cod_ID"));



                }
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //throw new IllegalStateException("Record with id not found");
    }

    public void GetInformation3(int productId,LocalDate limit1, LocalDate limit2){

        java.sql.Date sqlDate1 = java.sql.Date.valueOf( limit1 );
        java.sql.Date sqlDate2 = java.sql.Date.valueOf( limit2 );
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT I.Date_Of, sum(P.AMOUNT)AS A,sum(P.AMOUNT *P.PRICE)AS B\n" +
                    "FROM INVOICES I\n" +
                    "LEFT JOIN POSITIONS P\n" +
                    "ON (I.number=P.number_invoice)\n" +
                    "GROUP BY I.Date_of,P.Nomenclature_ID\n" +
                    "HAVING P.Nomenclature_ID = 1 ANd  I.DATE_OF<=DATE'"+sqlDate2+"' and I.Date_Of>= DATE'"+sqlDate1 +"'"
            )) {
                System.out.println("Product_ID :"+productId);
                while (rs.next()) {

                    System.out.println("Date: " +rs.getDate(1));
                    System.out.println("COUNT: " +rs.getInt("A"));
                    System.out.println("SUM: " +rs.getString("B"));

                }
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //throw new IllegalStateException("Record with id not found");




    }

}


