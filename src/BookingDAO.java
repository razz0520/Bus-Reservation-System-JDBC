import java.sql.*;

public class BookingDAO {
    public boolean isAvailable(int busId, Date date) throws SQLException{
        String query="SELECT capacity - (SELECT count(*) FROM passenger WHERE bus_id=? AND date_booked=?) FROM bus WHERE bus_no=?";

        // Automatic resource management
        try(Connection con=DbConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query)){

                pst.setInt(1,busId);
                pst.setDate(2,date);
                pst.setInt(3, busId);

                try(ResultSet rs= pst.executeQuery()){
                    if(rs.next()) {
                        int remainingSeats = rs.getInt(1);
                        return remainingSeats > 0;
                    }
                }
            } catch (SQLException e){
            System.out.println("Error checking availability: "+e.getMessage());
        }
        return false;
    }
    public int getRemainingSeats(int busId, Date date) throws SQLException {
        String query = "SELECT b.capacity - (SELECT COUNT(*) FROM passenger WHERE bus_id = ? AND date_booked = ?) " +
                "FROM bus b WHERE b.bus_no = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, busId);
            pst.setDate(2, date);
            pst.setInt(3, busId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return 0;
    }

    public void finalizeBooking(passenger p) throws SQLException{
        String query = "INSERT INTO passenger(name, age, date_booked, amount, bus_id, starting_point, destination) VALUES(?,?,?,?,?,?,?)";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,p.name);
        pst.setInt(2,p.age);
        pst.setDate(3,p.dateBooked);
        pst.setDouble(4, p.amount);
        pst.setInt(5,p.busId);
        pst.setString(6,p.start);
        pst.setString(7,p.dest);
        pst.executeUpdate();
    }
}
