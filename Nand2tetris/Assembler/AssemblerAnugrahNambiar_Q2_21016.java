import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class AssemblerAnugrahNambiar_Q2_21016 {
    public void parser(){
        try{
            File file = new File("C://Users//anugr//Desktop//Assembler//Max1.asm");
            Scanner sc = new Scanner(file);
            PrintWriter pw1 = new PrintWriter(new FileOutputStream("21016_no_whitespaceMax.asm") );
            while(sc.hasNextLine()){
                 String line = sc.nextLine();
                 if(line.length()!=0){
                    for(int i=0;i<line.length();i++){
                         if(line.charAt(i)=='/'){
                      	     break;
        
                         }else {
                      	   if(line.charAt(i)==' ') {
                      		   continue;
                      	   }else {
                      	   
                                 pw1.print(line.charAt(i));
                                 pw1.flush();
                      	   }
                      	
                         }
                    }
                    if(line.charAt(0)!='/') {
                         pw1.print("\n");
                         pw1.flush();
                    }
                 }
             }
                  pw1.close();
                  sc.close();
              }catch(Exception e){
                  System.out.println(e);
              }
    	
    	
    }
     public static void main(String[] args) {
         AssemblerAnugrahNambiar_Q2_21016 s=new AssemblerAnugrahNambiar_Q2_21016();
         s.parser();
        HashMap<String, String> symbols = new HashMap<>();

        symbols.put("SP", "0");
        symbols.put("LCL", "1");
        symbols.put("ARG", "2");
        symbols.put("THIS", "3");
        symbols.put("THAT", "4");
        symbols.put("R0", "0");
        symbols.put("R1", "1");
        symbols.put("R2", "2");
        symbols.put("R3", "3");
        symbols.put("R4", "4");
        symbols.put("R5", "5");
        symbols.put("R6", "6");
        symbols.put("R7", "7");
        symbols.put("R8", "8");
        symbols.put("R9", "9");
        symbols.put("R10", "10");
        symbols.put("R11", "11");
        symbols.put("R12", "12");
        symbols.put("R13", "13");
        symbols.put("R14", "14");
        symbols.put("R15", "15");
        symbols.put("SCREEN", "16384");
        symbols.put("KBD", "24576");

        HashMap<String, String> jump;
        HashMap<String, String> comp;
        HashMap<String, String> dest;
        jump = new HashMap<String, String>();
        jump.put("", "000");
        jump.put("JGT", "001");
        jump.put("JEQ", "010");
        jump.put("JGE", "011");
        jump.put("JLT", "100");
        jump.put("JNE", "101");
        jump.put("JLE", "110");
        jump.put("JMP", "111");

        comp = new HashMap<String, String>();
        comp.put("0", "0101010");
        comp.put("1", "0111111");
        comp.put("-1", "0111010");
        comp.put("D", "0001100");
        comp.put("A", "0110000");
        comp.put("!D", "0001101");
        comp.put("!A", "0110001");
        comp.put("-D", "0001111");
        comp.put("-A", "0110011");
        comp.put("D+1", "0011111");
        comp.put("A+1", "0110111");
        comp.put("D+A", "0000010");
        comp.put("D-A", "0010011");
        comp.put("A-D", "0000111");
        comp.put("D&A", "0000000");
        comp.put("D|A", "0010101");
        comp.put("M", "1110000");
        comp.put("!M", "1110001");
        comp.put("-M", "1110011");
        comp.put("M+1", "1110111");
        comp.put("M-1", "1110010");
        comp.put("D+M", "1000010");
        comp.put("D-M", "1010011");
        comp.put("M-D", "1000111");
        comp.put("D&M", "1000000");
        comp.put("D|M", "1010101");
        comp.put("D-1", "0001110");
        comp.put("A-1", "0110010");

        dest = new HashMap<String, String>();
        dest.put("", "000");
        dest.put("M", "001");
        dest.put("D", "010");
        dest.put("MD", "011");
        dest.put("A", "100");
        dest.put("AM", "101");
        dest.put("AD", "110");
        dest.put("AMD", "111");

        try {
            File file = new File("21016_no_whitespaceMax.asm");
            Scanner sc1 = new Scanner(file);
           
            ArrayList<String> arr = new ArrayList<String>();
            int count = 0;
            int x = 0;
            int l = 0;
            int v = 16;
            while (sc1.hasNextLine()) {
                String line1 = sc1.nextLine();

                l++;
                if (line1.charAt(0) == '(') {
                    String lab = (line1.replace("(", "").replace(")", "").trim());
                    symbols.put(lab, Integer.toString(l-1+x));
                    x=x-1;

                }
            }
            String destv = "";
            String compv = "";
            String jumpv = "";

            File file2 = new File("21016_no_whitespaceMax.asm");
            PrintWriter pw2 = new PrintWriter(new FileOutputStream("21016_Max1.hack"));
            Scanner sc2 = new Scanner(file2);

            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                
                if (line.charAt(0) == '@') {
                    

                    String command = (line.replace("@", "").trim());
                    if (symbols.containsKey(command)) {
                        String value = symbols.get(command);
                        String a_instr = Integer.toBinaryString(Integer.parseInt(value.trim()));
                        String a_str = "0".repeat(16 - a_instr.length()) + a_instr;
                        pw2.println(a_str);
                        pw2.flush();
                        
                    } else if (Character.isDigit(command.charAt(0))) {
                        
                        arr.add(command);
                        count = count + 1;
                        String a_instr = Integer.toBinaryString(Integer.parseInt(command.trim()));
                        String a_str = "0".repeat(16 - a_instr.length()) + a_instr;
                        pw2.println(a_str);
                        pw2.flush();
                    } else if (!symbols.containsKey(command) && !Arrays.asList(arr).contains(command)) {
                        if (symbols.containsValue(Integer.toString(v)))
                            v++;
                        symbols.put(command, Integer.toString(v));
                        String value = symbols.get(command);
                        String a_instr = Integer.toBinaryString(Integer.parseInt(value.trim()));
                        String a_str = "0".repeat(16 - a_instr.length()) + a_instr;
                        pw2.println(a_str);
                        pw2.flush();

                    }

                } else if (line.charAt(0) != '@' && line.charAt(0) != '(') {
                    if (line.contains(";")) {

                        String[] list1 = new String[2];

                        list1 = line.split(";");
                        jumpv = list1[1];
                      
                        if (line.contains("=")) {
                            String[] list2 = new String[2];
                            list2 = list1[0].split("=");
                            destv = list2[0];
                            compv = list2[1];

                        } else {
                            compv = list1[0];
                            destv = "";

                        }
                    } else {
                        String[] list3 = new String[2];
                        list3 = line.split("=");
                        compv = list3[1];
                        destv = list3[0];
                        jumpv = "";

                    }

                    pw2.println("111"+ comp.get(compv.trim())+ dest.get(destv.trim()) + jump.get(jumpv.trim()));
                    pw2.flush();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
