import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class DataBase {
    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/electro";
    private String username = "root";
    private String password = "root";

    DataBase(){
        conn = Connect();
    }

    private Connection Connect() {
        try{
            Class.forName(driver);
            Properties connInfo = new Properties();
            connInfo.setProperty("user", username);
            connInfo.setProperty("password", password);
            connInfo.setProperty("useUnicode","true");
            connInfo.setProperty("characterEncoding","cp1251");
            return DriverManager.getConnection(url, connInfo);
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Chip> getAllChips(){
        ArrayList<Chip> data = new ArrayList<>();

        try{
            ResultSet rs = conn != null ? conn.createStatement().executeQuery(
                    "SELECT * FROM tests") : null;
            while (rs != null && rs.next()){
                data.add(new Chip(
                    rs.getString("chip_name"),  rs.getString("sensor_type"),
                    rs.getString("product_type"),  rs.getString("integrated_circuit_type"),
                    rs.getString("initial_settings"),  rs.getString("preliminary_tests"),
                    rs.getString("calibration"),  rs.getString("verification_tests"),
                    rs.getString("allan_variance_and_noise"),  rs.getString("ready"),
                    rs.getString("zero_offset"), rs.getString("coefficient_of_transformation"),
                    rs.getString("nonlinearity_of_calibration_characteristic"),
                    rs.getString("conversion_factor_change"), rs.getString("zero_offset_change"),
                    rs.getString("measurement_error")));
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        return data;
    }

    public ArrayList<Chip> getChipsByParams(String query){
        ArrayList<Chip> data = new ArrayList<>();

        try{
            ResultSet rs = conn != null ? conn.createStatement().executeQuery(query) : null;
            while (rs != null && rs.next()){
                data.add(new Chip(
                        rs.getString("chip_name"),  rs.getString("sensor_type"),
                        rs.getString("product_type"),  rs.getString("integrated_circuit_type"),
                        rs.getString("initial_settings"),  rs.getString("preliminary_tests"),
                        rs.getString("calibration"),  rs.getString("verification_tests"),
                        rs.getString("allan_variance_and_noise"),  rs.getString("ready"),
                        rs.getString("zero_offset"), rs.getString("coefficient_of_transformation"),
                        rs.getString("nonlinearity_of_calibration_characteristic"),
                        rs.getString("conversion_factor_change"), rs.getString("zero_offset_change"),
                        rs.getString("measurement_error")));
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        return data;
    }

    public Chip getChipByName(String chipName){
        Chip chip = null;

        try{
            ResultSet rs = conn != null ? conn.createStatement().executeQuery(
                    "SELECT * FROM tests where chip_name = \""+chipName+"\"") : null;
            while (rs != null && rs.next()) {
                chip = new Chip(
                        rs.getString("chip_name"), rs.getString("sensor_type"),
                        rs.getString("product_type"), rs.getString("integrated_circuit_type"),
                        rs.getString("initial_settings"), rs.getString("preliminary_tests"),
                        rs.getString("calibration"), rs.getString("verification_tests"),
                        rs.getString("allan_variance_and_noise"), rs.getString("ready"),
                        rs.getString("zero_offset"), rs.getString("coefficient_of_transformation"),
                        rs.getString("nonlinearity_of_calibration_characteristic"),
                        rs.getString("conversion_factor_change"), rs.getString("zero_offset_change"),
                        rs.getString("measurement_error"));
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        return chip;
    }

    public int addChip(Chip chip){
        try {
            if (conn != null){
                conn.createStatement().executeUpdate("INSERT INTO tests VALUES (\""+
                chip.getChip_name()+"\", \""+chip.getSensor_type()+"\", \""+chip.getProduct_type()+"\", \""+
                chip.getIntegrated_circuit_type()+"\", \""+chip.getInitial_settings()+"\", \""+
                chip.getPreliminary_tests()+"\", \""+chip.getCalibration()+"\", \""+chip.getVerification_tests()+"\", \""+
                chip.getAllan_variance_and_noise()+"\", \""+chip.getReady()+"\", \""+chip.getZero_offset()+"\", \""+
                chip.getCoefficient_of_transformation()+"\", \""+chip.getNonlinearity_of_calibration_characteristic()+"\", \""+
                chip.getConversion_factor_change()+ "\", \""+chip.getZero_offset_change()+"\", \""+chip.getMeasurement_error()+"\")");
            }
        }catch (Exception ignored){
            System.out.println(ignored);
            return 1;
        }
        return 0;
    }

    public int editChip(Chip chip){
        try {
            if (conn != null){
                conn.createStatement().executeUpdate("UPDATE tests SET sensor_type='"+
                        chip.getSensor_type()+"', product_type='"+chip.getProduct_type()+"', integrated_circuit_type='"+
                        chip.getIntegrated_circuit_type()+"', initial_settings='"+chip.getInitial_settings()+
                        "', preliminary_tests='"+chip.getPreliminary_tests()+"', calibration='"+chip.getCalibration()+
                        "', verification_tests='"+chip.getVerification_tests()+"', allan_variance_and_noise='"+
                        chip.getAllan_variance_and_noise()+"', ready='"+chip.getReady()+"', zero_offset='"+
                        chip.getZero_offset()+"', coefficient_of_transformation='"+chip.getCoefficient_of_transformation()+
                        "', nonlinearity_of_calibration_characteristic='"+chip.getNonlinearity_of_calibration_characteristic()+
                        "', conversion_factor_change='"+chip.getConversion_factor_change()+
                        "', zero_offset_change='"+chip.getZero_offset_change()+"', measurement_error='"+
                        chip.getMeasurement_error()+"' WHERE chip_name ='"+chip.getChip_name()+"'");
            }
        }catch (Exception ignored){
            System.out.println(ignored);
            return 1;
        }
        return 0;
    }

    public int deleteChipByName(String chipName){
        try {
            if (conn != null){
                conn.createStatement().executeUpdate("DELETE FROM tests WHERE chip_name = \"" + chipName+"\"");
            }
        }catch (Exception ignored){
            System.out.println(ignored);
            return 1;
        }
        return 0;
    }
}
