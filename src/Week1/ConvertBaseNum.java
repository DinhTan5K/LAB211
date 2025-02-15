/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1;

/**
 *
 * @author LENOVO
 */
public class ConvertBaseNum {
    private String num;

    public ConvertBaseNum() {
    }

    public ConvertBaseNum(String num) {
        this.num = num;
    }

    public boolean isBin(){
        return num.matches("[01]+");

    }
    public boolean isHex() {
        return num.matches("[0-9A-Fa-f]+");
    }
    public boolean isDec(){
        return num.matches("\\d+");
    }


    public void menu(){
        System.out.println("1.Bin");
        System.out.println("2.Hex");
        System.out.println("3.Dec");
        System.out.print("Option: ");
    }

    public int optionBase(String num , int options){
        this.num = num;
        switch (options){
            case 1 -> {
                if(isBin()){
                    int decimal = 0;
                    int length = num.length();

                    for (int i = 0; i < length; i++) {

                        char bit = num.charAt(i);

                        int bitValue = Character.getNumericValue(bit);

                        decimal += (int) (bitValue * Math.pow(2, length - 1 - i));
                    }

                    return decimal;

                } else {
                    System.err.println("Error format BIN");
                    System.exit(0);
                }
            }
            case 2 -> {
                if(isHex()){
                    int decimal = 0;
                    int length = num.length();
                    for(int i = 0 ; i < length ; i++){
                        char bit = num.charAt(i);
                        int bitValue = Character.getNumericValue(bit);
                        decimal += (int) (bitValue * Math.pow(16,length - 1 - i));
                    }
                    return decimal;
                } else {
                    System.err.println("Error format HEX");
                    System.exit(0);
                }
            }
            case 3 ->{
                if(isDec()){
                    return Integer.parseInt(num,10);
                } else {
                    System.err.println("Error format");
                    System.exit(0);
                }
            }
            default -> {
                System.err.println("Invalid option");
                System.exit(0);
            }
            }
            return -1;
        }
        public void convertNum(int options,int optionConvert,String num){
            int numConvert  = optionBase(num,options);
            StringBuilder stringBuilder = new StringBuilder();
            switch (optionConvert){
                case 1 ->{
                    while (numConvert > 0) {
                        stringBuilder.insert(0, numConvert % 2);
                        numConvert /= 2;
                    }
                    System.out.println(stringBuilder);
                }
                case 2 ->{
                    char[] hexChars = "0123456789ABCDEF".toCharArray();
                    if (numConvert == 0) {
                        stringBuilder.append(0);
                    }
                    while (numConvert > 0) {
                        int result = numConvert % 16;
                        stringBuilder.insert(0,hexChars[result]);
                        numConvert /= 16;
                    }
                    System.out.println(stringBuilder);
                }
                case 3 ->System.out.println(numConvert);

            }
        }
    }
