/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebase;

import static java.lang.Math.pow;

/**
 *
 * @author Quang Huy
 */
public class Convert {

    enum Base16 { // enum là tập hợp các hằng số
        //Khởi tạo giá trị đặc biệt cho hằng số enum
        A(10), B(11), C(12), D(13), E(14), F(15);
        private final int value; // định nghĩa giá trị đặc biệt

        private Base16(int value) {  // constructor 
            this.value = value;
        }
    }

    /**
     *
     * @param baseIn
     * @param baseOut
     * @param str
     */
    public void convert(int baseIn, int baseOut, String str) {
        switch (baseIn) {
            case 2, 16 -> {
                int demacial = ConvertFromBaseInTo10(str, baseIn); // chuyen ve co so 10 
                if (baseOut == 16 || baseOut == 2) {
                    System.out.println(ConvertFrom10toBaseOut(demacial, baseOut));
                } else {
                    System.out.println(demacial);
                }
            }
            case 10 -> {
                long input = Long.valueOf(str); // chuyen String str ve so
                System.out.println(ConvertFrom10toBaseOut(input, baseOut));
            }
        }
    }

    /**
     * chúng ta chia số cần chuyển cho hệ cơ số và lấy phần dư, rối tiếp tục
     * chia phần nguyên lấy phần dư, sau đó sắp xếp thứ tự phần dư theo thứ tự
     * ngược từ dưới lên.
     *
     * @param input
     * @param baseOut
     * @return phép chia cho 2 thì chỉ dư 0 và 1 còn chia cho 16 thì từ 0 -> 15
     */
    private String ConvertFrom10toBaseOut(long input, int baseOut) {
        String total = "";
        long remainder;
        while (input > 0) {
            remainder = input % baseOut; // lấy phần dư 17 -> 2 
            if (remainder >= 0 && remainder <= 9) {
                total = remainder + total + ""; //  10001111
            } else {
                total = changeToABCDEF(remainder) + total;
            }
            input = input / baseOut; // chia lấy phần nguyên
        }
        return total;
    }

    private String changeToABCDEF(long remainder) {
        String element = null;
        Base16[] bs = Base16.values(); // tạo mảng các tất cả phần tử trong Enum A B C D E F
        for (int i = 0; i < bs.length; i++) {
            if (bs[i].value == remainder) {
                element = bs[i].toString();
            }
        }
        return element; // trả về chữ cái tương ứng với giá trị
    }

    /**
     * ta lấy các chữ số trong phần nguyên của số cần chuyển nhân lần lượt với
     * hệ cơ số đầu vào, mũ 0,1,2,3,…tăng dần từ phải qua trái.
     *
     * @param str
     * @param baseIn
     * @return
     */
    private int ConvertFromBaseInTo10(String str, int baseIn) {
        int total = 0;
        int y;
        String[] x = str.split(""); // 1001110  
        for (int i = x.length - 1; i >= 0; i--) { //6
            y = checkElement(x[x.length - 1 - i]); //x[0]
            total += y * pow(baseIn, i); //1* 2^6 + 
        }
        return total;
    }

    public boolean checkValuein(int baseIn, String str) {
        String[] x = str.split("");
        int max = 2147483647;
        switch (baseIn) {
            case 10: 
                try {
                int value = Integer.valueOf(str);
            } catch (NumberFormatException e) {
                return true;
            }
            case 2:
            case 16:
                int total = 0;
                int y;
                for (int i = str.length() - 1; i >= 0; i--) {
                    y = checkElement(x[x.length - 1 - i]); //x[0]
                    total += y * pow(baseIn, i); //1* 2^6 + 
                    if (total >= max) {
                        return true;
                    }
                }
        }
        return false;
    }

    private int checkElement(String Element) {
        int parseInt = 0;
        try {
            parseInt = Integer.valueOf(Element);
        } catch (NumberFormatException e) {
            Base16[] bs = Base16.values();
            for (int i = 0; i < bs.length; i++) {
                if (Element.equals(bs[i].toString())) {
                    parseInt = bs[i].value;
                }
            }
        }
        return parseInt;
    }
}
