import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO implements DAO<Invoice>{

    final Connection connection;

    public InvoiceDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Invoice get(int id) {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT Date_Of, Organization_ID FROM Invoices WHERE Number = " + id)) {
                while (rs.next()) {
                    return new Invoice (rs.getInt("Number"),rs.getDate("Date_of").toLocalDate(),rs.getInt("Organization_ID"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Record with id " + id + "not found");
    }

    @Override
    public List<Invoice> getAll() {
        final List<Invoice> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT Number,Date_Of, Organization_ID FROM Invoices")) {
                while (rs.next()) {
                    result.add(new Invoice (rs.getInt("Number"),rs.getDate("Date_of").toLocalDate(),rs.getInt("Organization_ID")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public void save(Invoice entity) {

        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Invoices(Number,Date_Of,Organization_ID) VALUES(?,?,?)")) {
            preparedStatement.setInt(1, entity.getNumber());
            preparedStatement.setDate(2, Date.valueOf(entity.getDate_Of()));
            preparedStatement.setInt(3, entity.getOrganization_ID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void delete(Invoice entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Invoices WHERE Number = ?")) {
            preparedStatement.setInt(1, entity.getNumber());
            if (preparedStatement.executeUpdate() == 0) {
                throw new IllegalStateException("Record with id = " + entity.getNumber() + " not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
