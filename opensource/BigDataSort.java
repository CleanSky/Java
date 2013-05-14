package com.bisn.opensource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * 大数据排序，理论上支持个100亿条没问题
 */

public class BigDataSort {

	public final static String SMALL_FILE_PATH = "D:\\temp\\BigData\\";
	public final static int BIG_NUM_LINE = 1000000;
	public final static String ORING_FILE_PATH = "D:\\temp\\BigData\\bigData.txt";
	public final static int SMALL_FILE_LINE = 100000; // 1M for 1 small file
	private File tempFiles[];

	public BigDataSort() throws IOException {
		createBigsortNums();
		beSmallFileAndSort();
		unitFileToSort();
	}

	private void createBigsortNums() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				ORING_FILE_PATH));
		Random random = new Random();
		for (int i = 0; i < BIG_NUM_LINE; i++) {
			writer.write(String.valueOf(random.nextInt(100000000)));
			writer.newLine();// add a new line . in order to show easy by file
		}
		writer.close();
	}

	private void beSmallFileAndSort() throws IOException {
		BufferedReader bigDataFile = new BufferedReader(new FileReader(
				ORING_FILE_PATH));
		List<Integer> smallLine = null;
		tempFiles = new File[BIG_NUM_LINE / SMALL_FILE_LINE];
		for (int i = 0; i < tempFiles.length; i++) {
			tempFiles[i] = new File(SMALL_FILE_PATH + "sortTempFile" + i
					+ ".temp");
			BufferedWriter smallWtite = new BufferedWriter(new FileWriter(
					tempFiles[i]));
			smallLine = new ArrayList<Integer>();
			for (int j = 0; j < SMALL_FILE_LINE; j++)
				smallLine.add(Integer.parseInt(bigDataFile.readLine()));
			Collections.sort(smallLine);
			for (Object num : smallLine.toArray())
				smallWtite.write(num + "\n");
			smallWtite.close();
		}
	}

	private void unitFileToSort() throws IOException {
		File tempFile = null;
		for (int i = 1; i < tempFiles.length; i++) {
			tempFile = sortBySmallFile(tempFiles[0], tempFiles[i]);
			tempFiles[0].delete();
			tempFiles[0] = tempFile;
		}
		tempFile.renameTo(new File(ORING_FILE_PATH + "sortResult.txt"));
	}

	public static File sortBySmallFile(File fromFile, File toFile)
			throws IOException {
		BufferedReader fromRd = new BufferedReader(new FileReader(fromFile));
		BufferedReader toTempRd = new BufferedReader(new FileReader(toFile));
		File newSortFile = new File(SMALL_FILE_PATH + fromFile.getName()
				+ ".temp");
		BufferedWriter newSortFileWt = new BufferedWriter(new FileWriter(
				newSortFile));
		int index = -1;
		int toPoint = -1;
		while (fromRd.ready()) {
			index = Integer.parseInt(fromRd.readLine());
			if (index < toPoint) {
				newSortFileWt.write(String.valueOf(index));
				newSortFileWt.newLine();
				continue;
			} else {
				if (toPoint != -1) {
					newSortFileWt.write(String.valueOf(toPoint));
					newSortFileWt.newLine();
				}
			}
			while (toTempRd.ready()) {
				toPoint = Integer.parseInt(toTempRd.readLine());
				if (toPoint < index) {
					newSortFileWt.write(String.valueOf(toPoint));
					newSortFileWt.newLine();
				} else {
					newSortFileWt.write(String.valueOf(index));
					newSortFileWt.newLine();
					break;
				}
			}

		}
		newSortFileWt.write(String.valueOf(index > toPoint ? index : toPoint));
		newSortFileWt.newLine();
		newSortFileWt.close();
		fromRd.close();
		toTempRd.close();
		toFile.delete();
		return newSortFile;
	}

	public static void main(String[] args) throws IOException {
		BigDataSort bigDataSort = new BigDataSort();
	}
}
