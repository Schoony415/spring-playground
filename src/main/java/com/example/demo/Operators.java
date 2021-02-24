package com.example.demo;

public enum Operators {
    add("+"),
    subtract("-"),
    multiply("*"),
    divide("/"),
    modulo("%"),
    exponential("^")
    ;
    private String mysymbol;
    private Operators(String setstr){
        this.mysymbol=setstr;
    }
    public String toString(){
        return mysymbol;
    }
}//end of enum
