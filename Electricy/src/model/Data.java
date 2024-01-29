package model;

public class Data {
	private static AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> records;
	
	/*
	 * Central data class to make changes in one place
	 */
	
	public static void setData(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> recordss) {
		records = recordss;
	}
	
	public static AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> getData(){
		return records;
	}
}