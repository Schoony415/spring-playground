package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping("/math")
public class MathService {
    @GetMapping("/")
    public String mathHome(){
        return ("<html><body><p>" +
                "Current operators: add,subtract,multiply,divide,modulo,exponential" +
                "<br>calculate?" +
                "<br>.    operation=*&numbers=*,*,*" +
                "<br>.    operation=*&x=*&y=*" +
                "<br>.    numbers=*,*" +
                "<br><br>/pi" +
                "</p></body></html>");
    }
    @RequestMapping("/pi")
    public String RequestPi() {
        return "3.141592653589793";
    }

    @GetMapping("/calculator")
    public String ishallcalculate(@RequestParam HashMap<String,String> args){
        Calculator mycalc;

        //needed temp to arrange arguments
        float[] tempnums;
        if(args.containsKey("numbers")){
            //Arrays.stream(strings).map(Float::valueOf).toArray(Float[]::new);
            //args.get("numbers").split(",")
            String[] tempstring =  args.get("numbers").split(",");
            tempnums=new float[tempstring.length];
            for(int i = 0; i<tempstring.length;i++)
                tempnums[i]=Float.parseFloat(tempstring[i]);
        }else{
            //x and y condition
            tempnums=new float[2];
            tempnums[0] = Float.parseFloat(args.get("x"));
            tempnums[1] = Float.parseFloat(args.get("y"));
        }

        //creating the calculator
        if(args.containsKey("operator")){
            switch (args.get("operator").toLowerCase()){
                case "add": mycalc = new Calculator(Calculator.operators.add, tempnums);break;
                case "subtract": mycalc = new Calculator(Calculator.operators.subtract, tempnums);break;
                case "multiply": mycalc = new Calculator(Calculator.operators.multiply, tempnums);break;
                case "divide": mycalc = new Calculator(Calculator.operators.divide, tempnums);break;
                case "modulo": mycalc = new Calculator(Calculator.operators.modulo, tempnums);break;
                case "exponential": mycalc = new Calculator(Calculator.operators.exponential,tempnums);break;
                default: mycalc=new Calculator(tempnums);break;
            }
        }else{
            mycalc= new Calculator(tempnums);
        }

        //return (""+args.toString()+":"+mycalc.toString());
        return ("<html><body><table border=1><tr><td>Inputs</td><td nowrap> "
                +args.toString()+" </td></tr><tr><td>Outputs</td><td nowrap> "
                +mycalc.toString()+" </td></tr></table></body></html>");
        //return ("<table><tr> %s </tr><tr> %s </tr></table>",args.toString(),mycalc.toString());
    }

}