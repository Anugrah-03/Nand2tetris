
import java.io.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;

public class AssemblerAnugrahNambiar_Q1_21016 {
	public void parser1(){
    	try{
            File file = new File("C://Users//anugr//Desktop//Assembler//Max.asm");
            Scanner sc = new Scanner(file);
            PrintWriter pw1 = new PrintWriter(new FileOutputStream("21016_no_whitespaceAdd.asm") );
            
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
        AssemblerAnugrahNambiar_Q1_21016 m=new  AssemblerAnugrahNambiar_Q1_21016();
        m.parser1();
       HashMap<String,String> Lab = new HashMap<String,String>();
        HashMap<String, String> jump;
        HashMap<String, String> comp;
        HashMap<String, String> dest;
        dest = new HashMap<String, String>();
        dest.put("", "000");
        dest.put("M", "001");
        dest.put("D", "010");
        dest.put("MD", "011");
        dest.put("A", "100");
        dest.put("AM", "101");
        dest.put("AD", "110");
        dest.put("AMD", "111");
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
        jump = new HashMap<String, String>();
        jump.put("", "000");
        jump.put("JGT", "001");
        jump.put("JEQ", "010");
        jump.put("JGE", "011");
        jump.put("JLT", "100");
        jump.put("JNE", "101");
        jump.put("JLE", "110");
        jump.put("JMP", "111");

        try {
            int x = 0;
            File f = new File("21016_no_whitespaceAdd.asm");
            Scanner sc = new Scanner(f);
            int l = 0;
            ArrayList<String> arr = new ArrayList<String>();
            int count = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                l++;
                if (line.charAt(0) == '(') {
                    String lt = (line.replace("(", "").replace(")", "").trim());
                    Lab.put(lt, Integer.toString(l-1+x));
                    x=x-1;
                }
            }
            sc.close();
            String destString = "";
            String compString = "";
            String jumpString = "";
            File f1 = new File("21016_no_whitespaceAdd.asm");
            PrintWriter pw1 = new PrintWriter(new FileOutputStream("21016_Max.hack"));
            Scanner sc1 = new Scanner(f1);
            while (sc1.hasNextLine()) {
                String line = sc1.nextLine();
                if (line.charAt(0) == '@') {
                    String sca = (line.replace("@", "").trim());
                    if (Character.isDigit(sca.charAt(0))) {
                        arr.add(sca);
                        count = count + 1;
                        String ainstruction = Integer.toBinaryString(Integer.parseInt(sca.trim()));
                        String w = "0".repeat(16 - ainstruction.length()) + ainstruction;
                        pw1.println(w);
                        pw1.flush();
                    }else if (Lab.containsKey(sca)) {
                        String value = Lab.get(sca);
                        String ainstruction = Integer.toBinaryString(Integer.parseInt(value.trim()));
                        String astring = "0".repeat(16 - ainstruction.length()) + ainstruction;
                        pw1.println(astring);
                        pw1.flush();
                    }

                } else if (line.charAt(0) != '@' && line.charAt(0) != '(') {
                    if (line.contains(";")) {
                        String[] list = new String[2];
                        list = line.split(";");
                        jumpString = list[1];
                        if (line.contains("=")) {
                            String[] list1 = new String[2];
                            list1 = list[0].split("=");
                            destString = list1[0];
                            compString = list1[1];
                        } else {
                            compString = list[0];
                            destString = "";
                        }
                    } else {
                        String[] list2 = new String[2];
                        list2 = line.split("=");
                        compString = list2[1];
                        destString = list2[0];
                        jumpString = "";
                    }
                    pw1.println("111"+ comp.get(compString.trim())+ dest.get(destString.trim()) + jump.get(jumpString.trim()));
                    pw1.flush();
                }
            
            }
            pw1.close();
            sc1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}