package ex;

import java.util.Scanner;

public class Q6109 {

    static int inputMap[][];
    static int resultMap[][];
    static String[] outList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        outList = new String[T];

        for (int t = 1; t <= T; t++) {
            int mapSize = sc.nextInt();
            inputMap = new int[mapSize][mapSize];
            resultMap = new int[mapSize][mapSize];
            String direction = sc.next();

            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    inputMap[i][j] = sc.nextInt();
                }
            }

            if ("up".equals(direction)) {
                for (int column = 0; column < mapSize; column++) {
                    int rowIndex = 0;
                    int rowValue = -1;
                    for (int row = 0; row < mapSize; row++) {
                        if (inputMap[row][column] != 0) {
                            if (rowValue == -1) {
                                if (row == mapSize - 1) {
                                    resultMap[rowIndex++][column] = inputMap[row][column];
                                    break;
                                }
                                rowValue = inputMap[row][column];
                            } else {
                                if (rowValue == inputMap[row][column]) {
                                    resultMap[rowIndex++][column] = rowValue * 2;
                                    rowValue = -1;
                                } else {
                                    resultMap[rowIndex++][column] = rowValue;
                                    rowValue = inputMap[row][column];
                                    if (row == mapSize - 1) {
                                        resultMap[rowIndex++][column] = inputMap[row][column];
                                        break;
                                    }
                                }
                            }
                        } else if (row == mapSize - 1 && rowValue != -1) {
                            resultMap[rowIndex++][column] = rowValue;
                        }
                    }
                }
            } else if ("down".equals(direction)) {
                for (int column = 0; column < mapSize; column++) {
                    int rowIndex = mapSize - 1;
                    int rowValue = -1;
                    for (int row = mapSize - 1; row >= 0; row--) {
                        if (inputMap[row][column] != 0) {
                            if (rowValue == -1) {
                                if (row == 0) {
                                    resultMap[rowIndex--][column] = inputMap[row][column];
                                    break;
                                }
                                rowValue = inputMap[row][column];
                            } else {
                                if (rowValue == inputMap[row][column]) {
                                    resultMap[rowIndex--][column] = rowValue * 2;
                                    rowValue = -1;
                                } else {
                                    resultMap[rowIndex--][column] = rowValue;
                                    rowValue = inputMap[row][column];
                                    if (row == 0) {
                                        resultMap[rowIndex--][column] = inputMap[row][column];
                                        break;
                                    }
                                }
                            }
                        } else if (row == 0 && rowValue != -1) {
                            resultMap[rowIndex--][column] = rowValue;
                        }
                    }
                }
            } else if ("left".equals(direction)) {
                for (int row = 0; row < mapSize; row++) {
                    int columnIndex = 0;
                    int columnValue = -1;
                    for (int column = 0; column < mapSize; column++) {
                        if (inputMap[row][column] != 0) {
                            if (columnValue == -1) {
                                if (column == mapSize - 1) {
                                    resultMap[row][columnIndex] = inputMap[row][column];
                                    break;
                                }
                                columnValue = inputMap[row][column];
                            } else {
                                if (columnValue == inputMap[row][column]) {
                                    resultMap[row][columnIndex++] = columnValue * 2;
                                    columnValue = -1;
                                } else {
                                    resultMap[row][columnIndex++] = columnValue;
                                    columnValue = inputMap[row][column];
                                    if (column == mapSize - 1) {
                                        resultMap[row][columnIndex] = inputMap[row][column];
                                        break;
                                    }
                                }
                            }

                        } else if (column == mapSize - 1 && columnValue != -1) {
                            resultMap[row][columnIndex++] = columnValue;
                        }
                    }
                }
            } else if ("right".equals(direction)) {
                for (int row = 0; row < mapSize; row++) {
                    int columnIndex = mapSize - 1;
                    int columnValue = -1;
                    for (int column = mapSize - 1; column >= 0; column--) {
                        if (inputMap[row][column] != 0) {
                            if (columnValue == -1) {
                                if (column == 0) {
                                    resultMap[row][columnIndex] = inputMap[row][column];
                                    break;
                                }
                                columnValue = inputMap[row][column];
                            } else {
                                if (columnValue == inputMap[row][column]) {
                                    resultMap[row][columnIndex--] = columnValue * 2;
                                    columnValue = -1;
                                } else {
                                    resultMap[row][columnIndex--] = columnValue;
                                    columnValue = inputMap[row][column];
                                    if (column == 0) {
                                        resultMap[row][columnIndex] = inputMap[row][column];
                                        break;
                                    }
                                }
                            }
                        } else if (column == 0 && columnValue != -1) {
                            resultMap[row][columnIndex--] = columnValue;
                        }
                    }
                }
            }
            makeOutString(t, mapSize);
        }
        for (String a : outList) {
            System.out.print(a);
        }
    }


    static void makeOutString(int t, int mapSize) {
        String a = "#" + t + "\n";
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                a = a + resultMap[i][j] + " ";
            }
            a += "\n";
        }
        outList[t - 1] = a;

    }
}
