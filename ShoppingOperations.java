import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingOperations {
    private Connection connection;

    public ShoppingOperations() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    // Add Item
    public void addItem(Item item) {
        String query = "INSERT INTO shopping_list (name, quantity) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getQuantity());
            stmt.executeUpdate();
            System.out.println("Item added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get All Items
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM shopping_list";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                items.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getBoolean("is_purchased"),
                        rs.getString("added_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Update Item
    public void updateItem(int id, String newName, int newQuantity) {
        String query = "UPDATE shopping_list SET name = ?, quantity = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setInt(2, newQuantity);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Item updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Item
    public void deleteItem(int id) {
        String query = "DELETE FROM shopping_list WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Item deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mark as Purchased
    public void markAsPurchased(int id) {
        String query = "UPDATE shopping_list SET is_purchased = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Item marked as purchased!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
