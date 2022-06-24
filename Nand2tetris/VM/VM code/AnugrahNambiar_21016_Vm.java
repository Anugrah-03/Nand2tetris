import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.util.Scanner;
public class AnugrahNambiar_21016_Vm{
    static int count=0;
    public static void push(String memorySegment,String vMemorySegment)throws IOException{
        FileWriter fileWriter =new FileWriter("C:\\Users\\anugr\\Desktop\\green usb\\Anugrah Nambiar\\AM.EN.U4AIE21016\\nand2tetris\\projects\\07\\StackArithmetic\\StackTest\\StackTest.asm",true);
        count=count+1;
        if (memorySegment.contains("constant")) {
            String[] constant = new String[]{"@" + vMemorySegment, "D=A", "@SP", "A=M", "M=D", "@SP", "M=M+1"};
            for (int i = 0; i < constant.length; i++) {
                System.out.println(constant[i]);
               fileWriter.write(constant[i]);
               fileWriter.write(System.lineSeparator());
            }
            }
            else if (memorySegment.contains("local")) {
                String[] local = new String[]{"@" + vMemorySegment, "D=A", "@LCL", "A=M","A=D+A", "D=M", "@SP", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < local.length; i++) {
                    fileWriter.write(local[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("temp")) {
                String[] temp = new String[]{"@" + vMemorySegment, "D=A","@5","A=D+A","D=M", "@SP", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < temp.length; i++) {
                    fileWriter.write(temp[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("argument")) {
                String[] argument = new String[]{"@" + vMemorySegment, "D=A", "@ARG","A=M", "A=D+A", "D=M", "@SP", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < argument.length; i++) {
                    fileWriter.write(argument[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("static")) {
                String[] statics = new String[]{"@" + "vm" + "." + vMemorySegment,"D=M", "@SP", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < statics.length; i++) {
                    fileWriter.write(statics[i]);
                    fileWriter.write(System.lineSeparator());
                }

            }
            else if (memorySegment.contains("pointer")) {
                    if(vMemorySegment.contains("0")){
                      String[] pointer0 = new String[]{"@3","D=M","@SP", "A=M", "M=D", "@SP", "M=M+1"};
                      for(int i=0;i<pointer0.length;i++){
                        fileWriter.write(pointer0[i]);
                        fileWriter.write(System.lineSeparator());}}
                    if(vMemorySegment.contains("1")){
                      String[] pointer1 = new String[]{"@4","D=M","@SP", "A=M", "M=D", "@SP", "M=M+1"};
                      for(int i=0;i<pointer1.length;i++){
                        fileWriter.write(pointer1[i]);
                        fileWriter.write(System.lineSeparator());}}
            }
            else if (memorySegment.contains("this")) {
                String[] thisSegment = new String[]{"@" + vMemorySegment, "D=A", "@THIS", "A=M", "A=D+A", "D=M", "@SP", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < thisSegment.length; i++) {
                    fileWriter.write(thisSegment[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("that")) {
                String[] that = new String[]{"@" + vMemorySegment, "D=A", "@THAT", "A=M", "A=D+A", "D=M", "@SP", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < that.length; i++) {
                    fileWriter.write(that[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else{
                System.out.println("Error in the VM Code!!!");
            }
            fileWriter.close();

        }
        public static void pop(String memorySegment,String vMemorySegment)throws IOException{
            count=count+1;
            FileWriter fileWriter = new FileWriter("C:\\Users\\anugr\\Desktop\\green usb\\Anugrah Nambiar\\AM.EN.U4AIE21016\\nand2tetris\\projects\\07\\StackArithmetic\\StackTest\\StackTest.asm",true);
                    if (memorySegment.contains("local")) {
                    String[] local = new String[]{"@" + vMemorySegment, "D=A", "@LCL", "M=M+D", "@SP", "A=M", "A=A-1", "D=M", "@LCL", "A=M","M=D", "@" + vMemorySegment, "D=A", "@LCL", "M=M-D", "@SP", "M=M-1"};
                    for (int i = 0; i < local.length; i++) {
                        System.out.println(local[i]);
                        fileWriter.write(local[i]);
                        fileWriter.write(System.lineSeparator());
                    }
                }
                else if (memorySegment.contains("temp")) {
                    String[] temp = new String[]{"@"+vMemorySegment, "D=A" ,"@5","D=D+A","@R13","M=D","@SP", "A=M", "A=A-1", "D=M","@R13","A=M","M=D","@SP", "M=M-1"};
                    for (int i = 0; i < temp.length; i++) {
                        fileWriter.write(temp[i]);
                        fileWriter.write(System.lineSeparator());
                    }
                }
                else if (memorySegment.contains("argument")) {
                    String[] argument = new String[]{"@" + vMemorySegment, "D=A", "@ARG", "M=M+D", "@SP", "A=M", "A=A-1", "D=M", "@ARG","A=M","M=D", "@" + vMemorySegment, "D=A", "@ARG", "M=M-D", "@SP", "M=M-1"};
                    for (int i = 0; i < argument.length; i++) {
                        fileWriter.write(argument[i]);
                        fileWriter.write(System.lineSeparator());
                    }
                }
                else if (memorySegment.contains("static")) {
                    String[] statics = new String[]{"@SP", "A=M","A=A-1", "D=M", "@" + "vm" + "." + vMemorySegment, "M=D","@SP","M=M-1"};
                    for (int i = 0; i < statics.length; i++) {
                        fileWriter.write(statics[i]);
                        fileWriter.write(System.lineSeparator());
                    }
    
                }
                else if (memorySegment.contains("pointer")) {
                        if(vMemorySegment.contains("0")){
                          String[] pointer0 = new String[]{"@SP",  "M=M-1", "A=M","D=M", "@3", "M=D"};
                          for(int i=0;i<pointer0.length;i++){
                            fileWriter.write(pointer0[i]);
                            fileWriter.write(System.lineSeparator());}}
                        if(vMemorySegment.contains("1")){
                          String[] pointer1 = new String[]{"@SP",  "M=M-1", "A=M","D=M", "@4", "M=D"};
                          for(int i=0;i<pointer1.length;i++){
                            fileWriter.write(pointer1[i]);
                            fileWriter.write(System.lineSeparator());}}
                }
                else if (memorySegment.contains("this")) {
                    String[] thisSegment = new String[]{"@" + vMemorySegment, "D=A", "@THIS", "M=M+D", "@SP", "A=M", "A=A-1", "D=M", "@THIS", "A=M","M=D", "@" + vMemorySegment, "D=A", "@THIS", "M=M-D", "@SP", "M=M-1"};
                    for (int i = 0; i < thisSegment.length; i++) {
                        fileWriter.write(thisSegment[i]);
                        fileWriter.write(System.lineSeparator());
                    }
                }
                else if (memorySegment.contains("that")) {
                    String[] that = new String[]{"@" + vMemorySegment, "D=A", "@THAT", "M=M+D", "@SP", "A=M", "A=A-1", "D=M", "@THAT","A=M", "M=D", "@" + vMemorySegment, "D=A", "@THAT", "M=M-D", "@SP", "M=M-1"};
                    for (int i = 0; i < that.length; i++) {
                        fileWriter.write(that[i]);
                        fileWriter.write(System.lineSeparator());
                    }
                }
                else{
                    System.out.println("Error in the VM Code!!!");
                }
                fileWriter.close();
        }
        public static void operation(String memorySegment)throws IOException{
            count=count+1;
            FileWriter fileWriter = new FileWriter("C:\\Users\\anugr\\Desktop\\green usb\\Anugrah Nambiar\\AM.EN.U4AIE21016\\nand2tetris\\projects\\07\\StackArithmetic\\StackTest\\StackTest.asm",true);
            if (memorySegment.contains("add")) {
                String[] add= new String[]{"@SP","A=M", "A=A-1", "D=M","A=A-1","D=M+D", "@SP", "M=M-1", "M=M-1", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < add.length; i++) {
                    System.out.println(add[i]);
                    fileWriter.write(add[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("sub")) {
                String[] sub = new String[]{"@SP","A=M", "A=A-1", "D=M", "A=A-1", "D=M-D", "@SP", "M=M-1", "M=M-1", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < sub.length; i++) {
                    fileWriter.write(sub[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("eq")) {
                String[] eq = new String[]{"@SP","A=M", "A=A-1","D=M","A=A-1","D=M-D","@SP", "M=M-1", "M=M-1","@w"+"."+count, "D;JEQ" ,  "@SP", "A=M", "M=0", "@END"+"."+count, "0;JMP","(w"+"."+count+")","@SP","A=M","M=-1","(END"+"."+count+")","@SP","M=M+1"};
                for (int i = 0; i < eq.length; i++) {
                    fileWriter.write(eq[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }

            else if (memorySegment.contains("gt")) {
                String[] gt = new String[]{"@SP","A=M", "A=A-1","D=M","A=A-1","D=M-D","@SP", "M=M-1", "M=M-1","@w"+"."+count, "D;JGT" ,  "@SP", "A=M", "M=0", "@END"+"."+count, "0;JMP","(w"+"."+count+")","@SP","A=M","M=-1","(END"+"."+count+")","@SP","M=M+1"};
                for (int i = 0; i < gt.length; i++) {
                    fileWriter.write(gt[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }

            else if (memorySegment.contains("lt"))
            {String[] lt = new String[]{"@SP","A=M", "A=A-1","D=M","A=A-1","D=M-D","@SP", "M=M-1", "M=M-1","@w"+"."+count, "D;JLT" ,  "@SP", "A=M", "M=0", "@END"+"."+count, "0;JMP","(w"+"."+count+")","@SP","A=M","M=-1","(END"+"."+count+")","@SP","M=M+1"};
                for (int i = 0; i < lt.length; i++){
                    fileWriter.write(lt[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("neg")) {
                String[] neg = new String[]{"@SP","M=M-1","A=M","D=M", "@SP", "A=M","M=-D","@SP","M=M+1"};
                for (int i = 0; i < neg.length; i++) {
                    fileWriter.write(neg[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("and")) {
                String[] and = new String[]{"@SP","A=M", "A=A-1", "D=M","A=A-1","D=D&M","@SP", "M=M-1", "M=M-1", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < and.length; i++)
                {   fileWriter.write(and[i]);
                    fileWriter.write(System.lineSeparator());}
            }
            else if (memorySegment.contains("or"))
            {
                String[] or = new String[]{"@SP","A=M", "A=A-1", "D=M","A=A-1","D=D|M","@SP", "M=M-1", "M=M-1", "A=M", "M=D", "@SP", "M=M+1"};
                for (int i = 0; i < or.length; i++) {
                    fileWriter.write(or[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else if (memorySegment.contains("not")) {
                String[] not = new String[]{"@SP", "M=M-1", "A=M", "D=M","@SP","A=M","M=!D", "@SP", "M=M+1"};
                for (int i = 0; i < not.length; i++) {
                    fileWriter.write(not[i]);
                    fileWriter.write(System.lineSeparator());
                }
            }
            else{
                System.out.println("Error in the VM Code!!!");
            }
            fileWriter.close();
        }
    
    
    public static void main(String[] args) {
        try{
        File file = new File("C:\\Users\\anugr\\Desktop\\green usb\\Anugrah Nambiar\\AM.EN.U4AIE21016\\nand2tetris\\projects\\07\\StackArithmetic\\StackTest\\StackTest.vm");
        FileWriter fileWriter = new FileWriter("C:\\Users\\anugr\\Desktop\\green usb\\Anugrah Nambiar\\AM.EN.U4AIE21016\\nand2tetris\\projects\\07\\StackArithmetic\\StackTest\\StackTest.asm");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            if(s.isEmpty()){
            continue;}
            else if((s.charAt(0)=='/')&&(s.charAt(1)=='/')){
             continue;
            }
            else{
                if(s.contains("add")||s.contains("sub")||s.contains("neg")||s.contains("eq")||s.contains("gt")||s.contains("lt")||s.contains("and")||s.contains("or")||s.contains("not") ){
                  
                        System.out.println(s);
                        operation(s);
                    
                }
                else{
                String[] parts3Divide = s.split(" ", 3);
                    String components=parts3Divide[0];
                    String memorySegment=parts3Divide[1];
                    String vmemorySegment=parts3Divide[2];
                    System.out.println(components); 
                    if(components.contains("push")){
                        System.out.println(vmemorySegment);
                        push(memorySegment,vmemorySegment);
                    }
                    else if(components.contains("pop")){
                        pop(memorySegment,vmemorySegment);
                    }
                    else{
                        System.out.println("fError in the VM Code!!!");
                        break;
                    }
                }
                }

            }
            sc.close();
        
    }
       catch(Exception e){
             System.out.println(e);
        }
       
    }
}