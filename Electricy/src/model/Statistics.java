package model;

public class Statistics {
	/*
	 * Returns the Minimum total Daily Supply in a given Day over the years and months
	 */
    public static double minimumTotalDailySupply(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> tree, String daystr) {
        int day = Integer.parseInt(daystr);
    	double minSupply = Double.MAX_VALUE;

        Node<AVLTree<AVLTree<DailyElectrictyRecord>>> yearNode = tree.getRoot();
        while (yearNode != null) {
            AVLTree<AVLTree<DailyElectrictyRecord>> monthTree = yearNode.getData();

            Node<AVLTree<DailyElectrictyRecord>> monthNode = monthTree.search(day);
            if (monthNode != null) {
                AVLTree<DailyElectrictyRecord> dayTree = monthNode.getData();

                Node<DailyElectrictyRecord> dayNode = dayTree.getRoot();
                while (dayNode != null) {
                    DailyElectrictyRecord record = dayNode.getData();
                    double totalDailySupply = record.getTotal_daily_Supply_available_in_MWs();
                    minSupply = Math.min(minSupply, totalDailySupply);

                    dayNode = dayNode.getRight();
                }
            }

            yearNode = yearNode.getRight();
        }

        return minSupply;
    }
    
    /*
     * Returns the maxiummu Value of Overall demand in a given month over all the years and teh days
     */
    public static double maximumOverallDemand(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> tree, String monthstr) {
    	int month = Integer.parseInt(monthstr);
    	
    	double maxDemand = Double.MIN_VALUE;

        Node<AVLTree<AVLTree<DailyElectrictyRecord>>> yearNode = tree.getRoot();
        while (yearNode != null) {
            AVLTree<AVLTree<DailyElectrictyRecord>> monthTree = yearNode.getData();

            Node<AVLTree<DailyElectrictyRecord>> monthNode = monthTree.search(month);
            if (monthNode != null) {
                AVLTree<DailyElectrictyRecord> dayTree = monthNode.getData();

                Node<DailyElectrictyRecord> dayNode = dayTree.getRoot();
                while (dayNode != null) {
                    DailyElectrictyRecord record = dayNode.getData();
                    double overallDemand = record.getOverall_demand_in_MWs();
                    maxDemand = Math.max(maxDemand, overallDemand);

                    dayNode = dayNode.getRight();
                }
            }
            yearNode = yearNode.getRight();
        }
        return maxDemand;
    }

    
    /*
     * Returns the valuse of the average power cuts in a given year 
     * for all months and days
     */
    public static double averagePowerCutsHoursDay(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> tree, String yearstr) {
        int year = Integer.parseInt(yearstr);
        double totalPowerCuts = 0;
        int totalRecords = 0;

        Node<AVLTree<AVLTree<DailyElectrictyRecord>>> yearNode = tree.search(year);
        if (yearNode != null) {
            AVLTree<AVLTree<DailyElectrictyRecord>> monthTree = yearNode.getData();

            Node<AVLTree<DailyElectrictyRecord>> monthNode = monthTree.getRoot();
            while (monthNode != null) {
                AVLTree<DailyElectrictyRecord> dayTree = monthNode.getData();

                Node<DailyElectrictyRecord> dayNode = dayTree.getRoot();
                while (dayNode != null) {
                    DailyElectrictyRecord record = dayNode.getData();
                    double powerCuts = record.getPower_Cuts_hours_day_400mg();
                    totalPowerCuts += powerCuts;
                    totalRecords++;

                    dayNode = dayNode.getRight();
                }

                monthNode = monthNode.getRight();
            }
        }

        return (totalRecords > 0) ? (totalPowerCuts / totalRecords) : 0;
    }

    /*
     * Taqkes the tree and retursn a string 
     * this string contains the total of all attributes accross all the records
     * 
     */
    public static StringBuilder totalStatistics(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> tree) {
        double totalIsraeliLines = 0;
        double totalGazaPowerPlant = 0;
        int totalEgyptianLines = 0;
        double totalDailySupply = 0;
        double totalOverallDemand = 0;
        double totalPowerCuts = 0;
        double totalTemp = 0;

        Node<AVLTree<AVLTree<DailyElectrictyRecord>>> yearNode = tree.getRoot();
        while (yearNode != null) {
            AVLTree<AVLTree<DailyElectrictyRecord>> monthTree = yearNode.getData();
            
            Node<AVLTree<DailyElectrictyRecord>> monthNode = monthTree.getRoot();
            while (monthNode != null) {
                AVLTree<DailyElectrictyRecord> dayTree = monthNode.getData();
                
                Node<DailyElectrictyRecord> dayNode = dayTree.getRoot();
                while (dayNode != null) {
                    DailyElectrictyRecord record = dayNode.getData();
                    totalIsraeliLines += record.getIsraeli_Lines_MWs();
                    totalGazaPowerPlant += record.getGaza_Power_Plant_MWs();
                    totalEgyptianLines += record.getEgyptian_Lines_MWs();
                    totalDailySupply += record.getTotal_daily_Supply_available_in_MWs();
                    totalOverallDemand += record.getOverall_demand_in_MWs();
                    totalPowerCuts += record.getPower_Cuts_hours_day_400mg();
                    totalTemp += record.getTemp();

                    dayNode = dayNode.getRight();
                }
                monthNode = monthNode.getRight();
            }
            yearNode = yearNode.getRight();
        }

        StringBuilder result = new StringBuilder();
        result.append("Total Statistics\n");
        result.append("Israeli_Lines_MWs    =>    ").append(totalIsraeliLines).append("\n");
        result.append("Gaza_Power_Plant_MWs    =>    ").append(totalGazaPowerPlant).append("\n");
        result.append("Egyptian_Lines_MWs    =>    ").append(totalEgyptianLines).append("\n");
        result.append("Total_daily_Supply_available_in_MWs    =>    ").append(totalDailySupply).append("\n");
        result.append("Overall_demand_in_MWs    =>    ").append(totalOverallDemand).append("\n");
        result.append("Power_Cuts_hours_day_400mg    =>    ").append(totalPowerCuts).append("\n");
        result.append("Temp    =>    ").append(totalTemp).append("\n");

        return result;
    }
}