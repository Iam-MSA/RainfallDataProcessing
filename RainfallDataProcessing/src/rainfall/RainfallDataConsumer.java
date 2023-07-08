package rainfall;
 
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * The RainfallDataConsumer class is responsible for consuming the rainfall data
 * from a file created by RainfallDataCreator, computing the average rainfall,
 * and displaying the data.
 */
public class RainfallDataConsumer {
    /**
     * The main method reads the rainfall data file, computes the average rainfall,
     * and displays the data and average.
     *
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin"; // Location of the data file
        
        try {
            consumeRainfallData(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the rainfall data from the specified file, computes the average rainfall,
     * and displays the data and average.
     *
     * @param fileName the name of the file containing the rainfall data
     * @throws IOException if an I/O error occurs while reading the file
     */
    private static void consumeRainfallData(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            String stationName = dis.readUTF(); // Read station name as UTF string
            String district = dis.readUTF(); // Read district as UTF string
            int numDays = dis.readInt(); // Read the number of days of rainfall data

            int[] rainfallData = new int[numDays];
            for (int i = 0; i < numDays; i++) {
                rainfallData[i] = dis.readInt(); // Read each rainfall data as Integer
            }

            System.out.println("Station Name: " + stationName);
            System.out.println("District: " + district);
            System.out.println("Rainfall Data: ");
            for (int rainfall : rainfallData) {
                System.out.println(rainfall);
            }

            int averageRainfall = computeAverageRainfall(rainfallData);
            System.out.println("Average Rainfall: " + averageRainfall);
        }
    }

    /**
     * Computes the average rainfall from the given rainfall data.
     *
     * @param rainfallData an array of rainfall data
     * @return the average rainfall
     */
    private static int computeAverageRainfall(int[] rainfallData) {
    	int sum = 0;
        for (int rainfall : rainfallData) {
            sum += rainfall;
        }
        return sum / rainfallData.length;
    }
}
