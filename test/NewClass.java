/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quang Huy
 */
public class NewClass {

    private String ConvertFrom10toBase(int input, int baseOut) {
        String total = "";
        int remainder;
        while (input > 0) {
            remainder = input % baseOut;
            if (remainder >= 0 && remainder <= 9) {
                total = remainder + total + "";

            } else {
                total = checkElement2(remainder) + total;
            }
            input = input / baseOut;
        }
        return total;
    }

    private String checkElement2(int remainder) {
        String element = null;
        switch (remainder) {
            case 10:
                element = "A";
                break;
            case 11:
                element = "B";
                break;
            case 12:
                element = "C";
                break;
            case 13:
                element = "D";
                break;
            case 14:
                element = "E";
                break;
            case 15:
                element = "F";
                break;
        }
        return element;
    }

    public static void main(String[] args) {
        NewClass n = new NewClass();
        System.out.println(n.ConvertFrom10toBase(67, 16));
    }
}
