package Week5.lab3;

public class LargerNumber {
    private String num1;
    private String num2;

    public LargerNumber() {

    }

    public LargerNumber(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String addLarge(String num1 , String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        int[] arr = new int[maxLength + 1];
        int size = 0;
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            arr[size] = sum % 10;
            size++;
            carry = sum / 10;
            i--;
            j--;
        }
        String result = "";
        for (int k = size - 1; k >= 0; k--) {
            result += arr[k];
        }

        return result;
    }

    public String multiLargeNumber() {
        String result = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {
            int digit2 = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder tempResult = new StringBuilder();


            for (int k = 0; k < num2.length() - 1 - i; k++) {
                tempResult.append("0");
            }

            for (int j = num1.length() - 1; j >= 0; j--) {
                int digit1 = num1.charAt(j) - '0';
                int product = digit1 * digit2 + carry;
                tempResult.append(product % 10);
                carry = product / 10;
            }

            if (carry > 0) {
                tempResult.append(carry);
            }

            result = addLarge(result, tempResult.reverse().toString());
        }

        return result;
    }
}


