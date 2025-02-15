package Week2;

public class Calculate {
    private double memory;

    public Calculate() {
        this.memory = 0;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }
    
    
    
    public double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+" -> memory = a + b;
            case "-" -> memory = a - b;
            case "*" -> memory = a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Error: Division by zero");
                }
                memory = a / b;
            }
            case "^" -> memory = Math.pow(a, b);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return memory;
    }
    
    public String bmiCaculate(double weight , double height){
        double bmiResult =weight / (height * height )  ;
        setMemory(bmiResult);
        if(bmiResult < 19){
            return "Under-standard";
        } else if (bmiResult >= 19 && bmiResult < 25){
            return "Standard";
        } else if (bmiResult >= 25 && bmiResult < 30){
            return "Overweight";
        } else if (bmiResult >= 30 && bmiResult < 40){
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
       
    }
}