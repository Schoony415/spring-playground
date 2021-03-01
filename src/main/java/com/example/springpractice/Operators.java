package com.example.springpractice;

public enum Operators {
    add("+"),
    subtract("-"),
    multiply("*"),
    divide("/"),
    modulo("%"),
    exponential("^"),
    log("log")
    ;
    private String mysymbol;
    private Operators(String setstr){
        this.mysymbol=setstr;
    }
    public String toString(){ return mysymbol; }
    public float Evaluate (float num1, float num2){
        switch (this){
            case add: return num1+num2;
            case subtract: return num1-num2;
            case multiply: return num1*num2;
            case divide:
                try{ return num1/num2;}
                catch(ArithmeticException e){return 0.0f;}
            case modulo:
                try{ return num1%num2;}
                catch(ArithmeticException e){return 0.0f;}
            case exponential: return (float)Math.pow(num1,num2);
            case log:
                try{ return (float)(Math.log(num1)/Math.log(num2));}
                catch(ArithmeticException e){return 0.0f;}
            default: return 0.0f;//should never be reached
        }
    }

}//end of enum
