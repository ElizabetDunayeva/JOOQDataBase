import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NomenclaturaDAO implements DAO<Nomenclatura> {

    final Connection connection;

    public NomenclaturaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Nomenclatura get(int id) {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT Name FROM Nomanclatures WHERE Cod_ID = " + id)) {
                while (rs.next()) {
                    return new Nomenclatura (rs.getInt("Cod_ID"),rs.getString("Name"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new IllegalStateException("Record with id " + id + "not found");
    }

    @Override
    public List<Nomenclatura> getAll() {
        final List<Nomenclatura> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT Name, Cod_ID FROM Nomenclatures")) {
                while (rs.next()) {
                    result.add(new Nomenclatura (rs.getInt("Cod_ID"),rs.getString("Name")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public void save(Nomenclatura entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Nomanclatures(Cod_ID,Name) VALUES(?,?)")) {
            preparedStatement.setInt(1, entity.getCod_Id());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void delete(Nomenclatura entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Nomenclatures WHERE Cod_ID = ?")) {
            preparedStatement.setInt(1, entity.getCod_Id());
            if (preparedStatement.executeUpdate() == 0) {
                throw new IllegalStateException("Record with id = " + entity.getCod_Id() + " not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
