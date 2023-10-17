package ru.otus.lesson14;

public class Main {
	public static void main(String[] args) {
		int answer = 0;
		String[][] testWrongArray = {
				{"a", "b", "c", "d"},
				{"1", "2", "3", "4"},
				{"a", "1", "b", "2"},
				{"c", "3", "d", "4"}
		};
		String[][] testNormalArray = {
				{"1", "2", "3", "4"},
				{"1", "2", "3", "4"},
				{"1", "2", "3", "4"},
				{"1", "2", "3", "4"}
		};
		try {
			answer = sumArray(testWrongArray);
			System.out.println(answer);
		} catch (AppArraySizeException ex) {
			System.out.println("Некорректная длина массива");
		} catch (AppArrayDataException ex) {
			System.out.println("В массив переданы некорректные данные");
		}
	}

	public static int sumArray(String[][] arr) {
		int sum = 0;
		if (arr.length != 4) {
			throw new AppArraySizeException();
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length != 4) {
				throw new AppArraySizeException();
			}
			for (int j = 0; j < arr[i].length; j++) {
				try {
					sum += Integer.parseInt(arr[i][j]);
				} catch (NumberFormatException ex) {
					throw new AppArrayDataException();
				}
			}
		}
		return sum;
	}
}
