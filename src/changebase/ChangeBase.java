/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebase;

import java.util.Scanner;

/**
 *
 * @author Quang Huy
 */
public class ChangeBase {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Convert cv = new Convert();
        int baseIn, baseOut;
        String str;
        boolean loop = true;

        do {
            System.out.println("\n====================================");
            System.out.println("Enter input number base "
                    + "(2. Binary, 10. Demacial, 16 Hexadecimal): ");
            baseIn = getBase(); //nhập base input

            System.out.println("Input value: ");
            str = input.nextLine(); // nhập giá trị

            
            if (checkBaseIn(baseIn, str) || cv.checkValuein(baseIn, str)) { // kiểm tra xem giá trị nhập có đúng không, nếu không thì nhâp lại
                System.err.println("Your value does not suitable or too big. Input again");
                continue; //  khối lệnh phía sau từ khóa continue sẽ không được thực thi. 
                // và bắt đầu chu kì mới của vòng lặp
            }

            System.out.println("Enter output number base "
                    + "(2. Binary, 10. Demacial, 16 Hexadecimal): ");
            baseOut = getBase(); //nhập base output

            System.out.println("===== RESULT =====");
            cv.convert(baseIn, baseOut, str); // thực hiện chuyển đổi và in ra kết quả
            loop = ask(); // hỏi người dùng muốn nhập tiếp không?

        } while (loop);

    }

    /**
     * hỏi người dùng muốn nhập tiếp không?
     *
     * @return: điều kiện của vòng lạp while
     */
    public static boolean ask() { //hỏi người dùng
        String choice;
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        OUTER:
        do {
            System.out.println("Do you want to continue: \n 1.Yes\t2.No");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    loop = true;
                    break OUTER;
                case "2":
                    loop = false;
                    break OUTER;
                default:
                    System.out.println("Please input 1 or 2");
            }
        } while (true);
        return loop;
    }

    

    public static boolean checkBaseIn(int baseIn, String str) {
        String[] checkString = str.split("");
        switch (baseIn) {
            case 2:
                for (String check : checkString) {
                    if (!check.matches("[0-1]")) {
                        return true;
                    }
                }
            case 16:
                for (String check : checkString) {
                    if (!check.matches("[0-9A-F]")) {
                        return true;
                    }
                }
            case 10:

                for (String check : checkString) {
                    if (!check.matches("[0-9]")) {
                        return true;
                    }
                }
        }
        return false;
    }

    public static int getBase() {
        Scanner input = new Scanner(System.in);
        int n = 0;
        boolean loop = true;
        do {
            try {
                n = input.nextInt();
                if (n != 2 && n != 10 && n != 16) {
                    throw new Exception();
                } else {
                    loop = false;
                }
            } catch (Exception e) {
                System.err.println("Invalid data. \nPlease input again");
                input.nextLine();

            }
        } while (loop);
        return n;
    }
}
