package model;

public class DailyElectrictyRecord implements Comparable<DailyElectrictyRecord>{
	// Date	Israeli_Lines_MWs	Gaza_Power_Plant_MWs	Egyptian_Lines_MWs	Total_daily_Supply_available_in_MWs	Overall_demand_in_MWs	Power_Cuts_hours_day_400mg	Temp
	// 1/1/2017,120,45,0,165,450,8,11
	// 1/2/2017,120,45,0,165,450,8,11
	
	private String date;//1/18/2017
	private int year;//2017
	private int month;//1
	private int day;//18
	private double Israeli_Lines_MWs;
	private double Gaza_Power_Plant_MWs;
	private int Egyptian_Lines_MWs;
	private double Total_daily_Supply_available_in_MWs;
	private double Overall_demand_in_MWs;
	private double Power_Cuts_hours_day_400mg;
	private double Temp;
	private String csvRecord;
	
	public DailyElectrictyRecord(String date, double israeli_Lines_MWs, double gaza_Power_Plant_MWs, int egyptian_Lines_MWs,
        double total_daily_Supply_available_in_MWs, double overall_demand_in_MWs,
        double power_Cuts_hours_day_400mg, double temp) {
		this.date = date;
			
		// Extracting year, month, and day from the date
		String[] dateParts = date.split("-");
		this.month = Integer.parseInt(dateParts[1]);
		this.day = Integer.parseInt(dateParts[2]);
		this.year = Integer.parseInt(dateParts[0]);
		
		this.Israeli_Lines_MWs = israeli_Lines_MWs;
		this.Gaza_Power_Plant_MWs = gaza_Power_Plant_MWs;
		this.Egyptian_Lines_MWs = egyptian_Lines_MWs;
		this.Total_daily_Supply_available_in_MWs = total_daily_Supply_available_in_MWs;
		this.Overall_demand_in_MWs = overall_demand_in_MWs;
		this.Power_Cuts_hours_day_400mg = power_Cuts_hours_day_400mg;
		
		setCsvRecord(month+"/"+day+"/"+year+","
				+israeli_Lines_MWs+","
				+gaza_Power_Plant_MWs+","
				+egyptian_Lines_MWs+","
				+total_daily_Supply_available_in_MWs+","
				+overall_demand_in_MWs+","
				+power_Cuts_hours_day_400mg+","
				+temp+"\n");
	}
	   
	/*
	 * GEtters & Setters
	 */
	public double getIsraeli_Lines_MWs() {
		return Israeli_Lines_MWs;
	}
	public void setIsraeli_Lines_MWs(double israeli_Lines_MWs) {
		Israeli_Lines_MWs = israeli_Lines_MWs;
	}
	public double getGaza_Power_Plant_MWs() {
		return Gaza_Power_Plant_MWs;
	}
	public void setGaza_Power_Plant_MWs(double gaza_Power_Plant_MWs) {
		Gaza_Power_Plant_MWs = gaza_Power_Plant_MWs;
	}
	public int getEgyptian_Lines_MWs() {
		return Egyptian_Lines_MWs;
	}
	public void setEgyptian_Lines_MWs(int egyptian_Lines_MWs) {
		Egyptian_Lines_MWs = egyptian_Lines_MWs;
	}
	public double getTotal_daily_Supply_available_in_MWs() {
		return Total_daily_Supply_available_in_MWs;
	}
	public void setTotal_daily_Supply_available_in_MWs(double total_daily_Supply_available_in_MWs) {
		Total_daily_Supply_available_in_MWs = total_daily_Supply_available_in_MWs;
	}
	public double getOverall_demand_in_MWs() {
		return Overall_demand_in_MWs;
	}
	public void setOverall_demand_in_MWs(double overall_demand_in_MWs) {
		Overall_demand_in_MWs = overall_demand_in_MWs;
	}
	public double getPower_Cuts_hours_day_400mg() {
		return Power_Cuts_hours_day_400mg;
	}
	public void setPower_Cuts_hours_day_400mg(double power_Cuts_hours_day_400mg) {
		Power_Cuts_hours_day_400mg = power_Cuts_hours_day_400mg;
	}
	
	@Override
	public String toString() {
	    return "Date => " + date + "\n"+
	           " Israeli Lines MWs=> " + Israeli_Lines_MWs + "\n"+
	           " Gaza Power Plant MWs => " + Gaza_Power_Plant_MWs + "\n"+
	           " Egyptian Lines MWs => " + Egyptian_Lines_MWs + "\n"+
	           " Total Daily Supply Available MWs => " + Total_daily_Supply_available_in_MWs + "\n"+
	           " Overall Demand MWs => " + Overall_demand_in_MWs + "\n"+
	           " Power Cuts Hours (400mg) => " + Power_Cuts_hours_day_400mg;
	}

	@Override
	public int compareTo(DailyElectrictyRecord o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}

	public double getTemp() {
		return Temp;
	}

	public void setTemp(double temp) {
		Temp = temp;
	}

	public String getCsvRecord() {
		return csvRecord;
	}

	public void setCsvRecord(String csvRecord) {
		this.csvRecord = csvRecord;
	}
}