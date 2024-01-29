package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVandAVL {
	/*
	 * This class is used to make processing with the tree and the file
	 */
	public static AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> readCSVAVL(String filePath) {
	    AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> yearTree = new AVLTree<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        br.readLine(); // Skip the header line

	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] values = line.split(",");

	            String dateString = values[0];
	            int day = Integer.parseInt(dateString.split("-")[2]);
	            int year = Integer.parseInt(dateString.split("-")[0]);
	            int month = Integer.parseInt(dateString.split("-")[1]);

                DailyElectrictyRecord record = new DailyElectrictyRecord(
                        dateString,
                        
                        Double.parseDouble(values[1]), // Israeli_Lines_MWs
                        Double.parseDouble(values[2]), // Gaza_Power_Plant_MWs
                        Integer.parseInt(values[3]),   // Egyptian_Lines_MWs
                        Double.parseDouble(values[4]), // Total_daily_Supply_available_in_MWs
                        Double.parseDouble(values[5]), // Overall_demand_in_MWs
                        Double.parseDouble(values[6]), // Power_Cuts_hours_day_400mg
                        Double.parseDouble(values[7])  // Temp
                );
                
	            Node<AVLTree<AVLTree<DailyElectrictyRecord>>> monthsNode = yearTree.search(year);

	            if (monthsNode == null) {
	                // If the year node doesn't exist, create it
	                AVLTree<DailyElectrictyRecord> daysTree = new AVLTree<>();
	                daysTree.insert(day, record);

	                AVLTree<AVLTree<DailyElectrictyRecord>> monthsTree = new AVLTree<>();
	                monthsTree.insert(month, daysTree);

	                yearTree.insert(year, monthsTree);
	            } else {
	                // If the year node already exists, update its months and days
	                AVLTree<AVLTree<DailyElectrictyRecord>> monthsTree = monthsNode.getData();
	                Node<AVLTree<DailyElectrictyRecord>> daysNode = monthsTree.search(month);

	                if (daysNode == null) {
	                    // If the month node doesn't exist, create it
	                    AVLTree<DailyElectrictyRecord> daysTree = new AVLTree<>();
	                    daysTree.insert(day, record);
	                    monthsTree.insert(month, daysTree);
	                } else {
	                    // If the month node exists, add the day
	                    daysNode.getData().insert(day, record);
	                }
	            }
	        }
	    } catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
	    return yearTree;
	}
	
	public static boolean readAVLCSV(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> records, File selectedDirectory) {
	    /*
	     * Takes records and convert them to a File 
	     */
	    try {
	        File csv = new File(selectedDirectory, "electricity_records.csv");
	        try (FileWriter writer = new FileWriter(csv)) {
	            writer.write("Date,Israeli_Lines_MWs,Gaza_Power_Plant_MWs,Egyptian_Lines_MWs,"
	                    + "Total_daily_Supply_available_in_MWs,Overall_demand_in_MWs,Power_Cuts_hours_day_400mg,Temp\n");
	            iterateAndWrite(records.getRoot(), writer);
	            return true;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	private static void iterateAndWrite(Node<AVLTree<AVLTree<DailyElectrictyRecord>>> node, FileWriter writer) throws IOException {
	    if (node != null) {
	        AVLTree<AVLTree<DailyElectrictyRecord>> monthTree = node.getData();

	        Node<AVLTree<DailyElectrictyRecord>> monthNode = monthTree.getRoot();
	        while (monthNode != null) {
	            AVLTree<DailyElectrictyRecord> dayTree = monthNode.getData();

	            Node<DailyElectrictyRecord> dayNode = dayTree.getRoot();
	            while (dayNode != null) {
	                DailyElectrictyRecord record = dayNode.getData();
	                writer.write(record.getCsvRecord());

	                dayNode = dayNode.getRight();  
	            }
	            monthNode = monthNode.getRight();  
	        }

	        iterateAndWrite(node.getRight(), writer);
	        iterateAndWrite(node.getLeft(), writer);
	    }
	}
}