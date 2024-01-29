package model;

import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
    
	/*
	 * This is to print the tree level by level
	 */
	public static StringBuilder printTreeLevels(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> yearsTree, String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);

        StringBuilder str = new StringBuilder();
        str.append("Years Tree Levels:\n");
        str.append(getAVLLevelOrderString(yearsTree, false)).append("\n");
        str.append("\n===========================\n");

        Node<AVLTree<AVLTree<DailyElectrictyRecord>>> yearNode = yearsTree.search(year);

        if (yearNode != null) {
            str.append("Months Tree Levels for Year ").append(year).append(":\n");
            str.append(getAVLLevelOrderString(yearNode.getData(), true)).append("\n");
            str.append("\n===========================\n");

            Node<AVLTree<DailyElectrictyRecord>> monthNode = yearNode.getData().search(month);
            if (monthNode != null) {
                str.append("Days Tree Levels for ").append(Month.of(month)).append(" in Year ").append(year).append(":\n");
                str.append(getAVLLevelOrderString(monthNode.getData(), false));
            }
        }
        return str;
    }
	
	/*
	 * This is to print the keys level by level 
	 * using a queue 
	 */
    private static <T> String getAVLLevelOrderString(AVLTree<T> yearsTree, boolean month) {
        if (yearsTree.getRoot() == null)
            return "";
        StringBuilder result = new StringBuilder();
        Queue<Node<T>> queue = new LinkedList<>();//fifo
        queue.add(yearsTree.getRoot());

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                Node<T> current = queue.poll();
                if (month)
                    result.append("|- "+Month.of(current.getKey())).append("     ");
                else
                    result.append("|- "+current.getKey()).append("     ");

                if (current.getLeft() != null)
                    queue.add(current.getLeft());
                if (current.getRight() != null)
                    queue.add(current.getRight());

                levelSize--;
            }
            result.append("\n");
        }
        return result.toString();
    }
    
    /*
     * This is to print the information 
     * about the trees
     * like the roots and the heights of the trees
     * and teh heights of specific date
     */
    public static StringBuilder printTreeHeights(AVLTree<AVLTree<AVLTree<DailyElectrictyRecord>>> yearsTree, String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);

        StringBuilder str = new StringBuilder();

        Node<AVLTree<AVLTree<DailyElectrictyRecord>>> yearRoot = yearsTree.getRoot();
        int yearHeight = yearRoot.getData().getRoot().getHeight();
        str.append("Root of the years tree is |- ").append( yearRoot.getKey()).append(" -| and the height = ").append(yearHeight).append("\n");

        Node<AVLTree<DailyElectrictyRecord>> monthTree = null;
        int monthHeight = 0;

        if (yearRoot != null) {
            monthTree = yearRoot.getData().getRoot();
            monthHeight = monthTree.getData().getRoot().getHeight();
        }
        str.append("Root of the months tree is |- ").append(Month.of(monthTree.getKey())).append(" -| and height = ").append(monthHeight).append("\n");

        Node<DailyElectrictyRecord> dayTree = null;
        int dayHeight = 0;
        if (monthTree != null) {
            dayTree = monthTree.getData().getRoot();
            dayHeight = dayTree.getHeight();
        }
        str.append("Root of days tree is |- ").append(dayTree.getKey()).append(" -| and height = ").append(dayHeight).append("\n");

        str.append("================================\n");
        str.append("Height of year ").append(year).append(" = ").append(yearHeight).append("\n");
        str.append("Height of month ").append(Month.of(month)).append(" = ").append(monthHeight).append("\n");
        str.append("Height of day ").append(day).append(" = ").append(dayHeight).append("\n");

        return str;
    }
}