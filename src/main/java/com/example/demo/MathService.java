package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;

@RestController
@RequestMapping("/math")
public class MathService {
    @GetMapping("/")
    public String mathHome(){
        return ("<html><body><p>" +
                "All numbers calculated as floats" +
                "<br>Current operators: add,subtract,multiply,divide,modulo,exponential" +
                "<br>calculator?" +
                "<br>&nbsp;&nbsp;&nbsp;operator=*&numbers=*,*,*" +
                "<br>&nbsp;&nbsp;&nbsp;operator=*&x=*&y=*" +
                "<br>&nbsp;&nbsp;&nbsp;numbers=*,*" +
                "<br><br>/pi" +
                "<br>/volume/*/*/*" +
                "</p></body></html>");
    }
    @RequestMapping("/pi")
    public String RequestPi(){
        return ""+Math.PI;
        //return "3.141592653589793";
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
            // */
            /* //trying to make it take any number of args like x y z
            if(args.containsKey("operator")){
                tempnums=new float[args.size()-1];
                for(int i = 1, i<args.size(); i++)
                    //tempnums[i-1]=Float.parseFloat(args.);
            }// */

        }

        //creating the calculator
        if(args.containsKey("operator")){
            //i shouldn't need this switch state, i should be able to turn the string directly into the enum
            //valueof does replace the switch statement, but if something goes wrong idk what'll happen
            //without a default case, any wrong spelling gets to error page
            mycalc = new Calculator(Operators.valueOf(args.get("operator").toLowerCase()),tempnums);
            /*
            switch (args.get("operator").toLowerCase()){
                case "add": mycalc = new Calculator(Operators.add, tempnums);break;
                case "subtract": mycalc = new Calculator(Operators.subtract, tempnums);break;
                case "multiply": mycalc = new Calculator(Operators.multiply, tempnums);break;
                case "divide": mycalc = new Calculator(Operators.divide, tempnums);break;
                case "modulo": mycalc = new Calculator(Operators.modulo, tempnums);break;
                case "exponential": mycalc = new Calculator(Operators.exponential,tempnums);break;
                default: mycalc=new Calculator(tempnums);break;
            }//*/
        }else{
            mycalc= new Calculator(tempnums);
        }

        //return (""+args.toString()+":"+mycalc.toString());
        return ("<html><body> All numbers calculated as float <br>" +
                "<table border=1><tr><td>Inputs</td><td nowrap> " +
                args.toString()+" </td></tr><tr><td>Outputs</td><td nowrap> " +
                mycalc.toString()+" </td></tr></table></body></html>"
                );
        //return String.format("<table><tr> %s </tr><tr> %s </tr></table>",args.toString(),mycalc.toString());
    }//end of calculator method

    @GetMapping("/volume/{x}/{y}/{z}")
    public String cubicVolume(@PathVariable String x,@PathVariable String y,@PathVariable String z){
        //The volume of a 6x7x8 rectangle is 336
        return ("The volume of a "+x+"x"+y+"x"+z+" rectangle is " +
                (int)(Float.parseFloat(x)*Float.parseFloat(y)*Float.parseFloat(z))
                );
    }

}
