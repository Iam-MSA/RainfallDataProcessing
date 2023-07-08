package rainfall;
 
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The RainfallDataCreator class is responsible for creating a set of rainfall data
 * and storing it in a file using java.io.DataOutputStream.
 */
public class RainfallDataCreator {
    private String fileName;
    private String stationName;
    private String district;
    private int[] rainfallData;

    /**
     * Constructs a RainfallDataCreator object with the specified parameters.
     *
     * @param fileName      the name of the file to store the rainfall data
     * @param stationName   the name of the weather station
     * @param district      the district where the weather station is located
     * @param rainfallData  an array of integer values representing the rainfall data
     */
    public RainfallDataCreator(String fileName, String stationName, String district, int[] rainfallData) {
        this.fileName = fileName;
        this.stationName = stationName;
        this.district = district;
        this.rainfallData = rainfallData;
    }

    /**
     * Creates the rainfall data file and stores the data using java.io.DataOutputStream.
     * The data includes the station name, district, and the rainfall readings.
     */
    public void createRainfallData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeUTF(stationName); // Write station name as UTF string
            dos.writeUTF(district); // Write district as UTF string
            
            dos.writeInt(rainfallData.length); // Write the length of the data array
            
            for (int rainfall : rainfallData) {
                dos.writeInt(rainfall); // Write each rainfall data as integer
            }
            
            System.out.println("Data created Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The main method creates an instance of RainfallDataCreator and calls the
     * createRainfallData() method to create the rainfall data file.
     *
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin"; // File location
        String stationName = "Durian Tunggal"; // Station name
        String district = "Alor Gajah"; // District
        int[] rainfallData = {0, 0, 0, 26, 3, 1}; // Rainfall data of Alor Gajah in 6 days
        
        // Creating an instance and calling the method
        RainfallDataCreator dataCreator = new RainfallDataCreator(fileName, stationName, district, rainfallData);
        dataCreator.createRainfallData();
    }
}
