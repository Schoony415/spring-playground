package com.example.demo;

public class Calculator {
    //this is old enum, I made it it's own file
    /*public enum Operators{
        add,subtract,multiply,divide,modulo,exponential
    }//*/
    private float[] numbers;
    private Operators operator=Operators.add;//default should help in problem cases
    private float evaluated;
    public Calculator(Operators op, float[] num){
        //System.out.println("constructor, argsin:"+op+num.toString());
        this.operator=op;
        //doing a deep copy
        this.numbers=new float[num.length];
        for(int i =0; i<num.length;i++)
            this.numbers[i]=num[i];
        this.Evaluate();
    }
    public Calculator(float[] num){
        this(Operators.add,num);
    }
    //this was replaced by tostring in enum
    /*private String opString(Operators op){
        switch (op){
            case add: return "+";
            case subtract: return "-";
            case multiply: return "*";
            case divide: return "/";
            case modulo: return "%";
            case exponential: return "^";
            default: return "_";
        }
    }*/
    private void Evaluate(){//todo handle /0 errors
        switch (operator){
            case add:
                for(int i = 0; i<numbers.length-1;i++)
                    evaluated+=numbers[i];
                evaluated+=numbers[numbers.length-1];
                break;
            case subtract:
                for(int i = 0; i<numbers.length-1;i++)
                    evaluated-=numbers[i];
                evaluated-=numbers[numbers.length-1];
                break;
            case multiply:
                evaluated=numbers[0];
                for(int i = 1; i<numbers.length-1;i++)
                    evaluated=evaluated*numbers[i];
                evaluated=evaluated*numbers[numbers.length-1];
                break;
            case divide:
                evaluated=numbers[0];
                for(int i = 1; i<numbers.length-1;i++)
                    evaluated=evaluated/numbers[i];
                evaluated=evaluated/numbers[numbers.length-1];
                break;
            case modulo:
                evaluated=numbers[0];
                for(int i = 1; i<numbers.length-1;i++)
                    evaluated=evaluated%numbers[i];
                evaluated=evaluated%numbers[numbers.length-1];
                break;
            case exponential:
                evaluated=numbers[0];
                for(int i = 1; i<numbers.length-1;i++)
                    evaluated=(float)Math.pow(evaluated,numbers[i]);
                evaluated=(float)Math.pow(evaluated,numbers[numbers.length-1]);
                break;
        }
        //System.out.println("evaluated: "+evaluated);
    }
    public String toString(){
        String tempstr="";
        //should work out for multiple numbers
        for(int i = 0; i<numbers.length-1;i++)
            //tempstr+=(""+numbers[i]+opString(this.operator));//using old method
            tempstr+=(""+numbers[i]+this.operator);//using new enum tostring
        tempstr+=(""+numbers[numbers.length-1]);
        tempstr+=(" = "+evaluated);
        //System.out.println("toString:"+tempstr);
        return tempstr;
    }


}//end of file
