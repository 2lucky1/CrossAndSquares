package com.muntian;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[][] inputData = new int[12][4];
        char c = 13;
//        System.out.println(String.valueOf((char)c));
        int d = Character.digit(c, 10);
//        System.out.println(d);


        int[][] initialData = readDataFromFile("InputData.txt");
        System.out.println(Arrays.deepToString(initialData));


    }

    public boolean checkOfCondition(int[][] arr) {
        if (arr[0][3] + arr[1][2] + arr[3][1] + arr[4][0] == 10) {
            if (arr[2][3] + arr[3][2] + arr[6][1] + arr[7][0] == 10) {
                if (arr[3][3] + arr[4][2] + arr[7][1] + arr[8][0] == 10) {
                    if (arr[4][3] + arr[5][2] + arr[8][1] + arr[9][0] == 10) {
                        if (arr[7][3] + arr[8][2] + arr[10][1] + arr[11][0] == 10) {

                            if (arr[0][1] + arr[1][0] <= 10) {
                                if (arr[2][2] + arr[6][0] <= 10) {
                                    if(arr[5][3] + arr[9][1] <= 10){
                                        if(arr[10][3] + arr[11][2] <= 10){

                                            if(arr[0][2] + arr[2][1] + arr[3][0] <= 10){
                                                if(arr[6][3] + arr[7][2] + arr[10][0] <= 10){
                                                    if(arr[8][3] + arr[9][2] + arr[11][0] <= 10){
                                                        if(arr[1][3] + arr[4][1] + arr[5][0] <= 10){
                                                            return true;
                                                        }else {
                                                            return false;
                                                        }
                                                    }else {
                                                        return false;
                                                    }
                                                }else {
                                                    return false;
                                                }
                                            }else {
                                                return false;
                                            }
                                        }else {
                                            return false;
                                        }
                                    }else {
                                        return false;
                                    }
                                }else {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }


    public static int[][] readDataFromFile(String fileName) {

        int[][] inputData = new int[12][4];
        try (Reader reader = new FileReader(fileName)) {

            BufferedReader bufferedReader = new BufferedReader(reader);

            int symbol = bufferedReader.read();

            for (int i = 0; i < inputData.length; i++) {
                for (int j = 0; j < inputData[i].length; j++) {
                    if (Character.isDigit(symbol)) {
                        inputData[i][j] = Character.digit(symbol, 10);
                    }
                    symbol = bufferedReader.read();
                    while (!Character.isDigit(symbol) && symbol != -1) {
                        symbol = bufferedReader.read();
                    }
                }
            }
            return inputData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeResultToFile(List<String> result) {
        try (Writer writer = new FileWriter("result.txt")) {
            for (String line : result) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
