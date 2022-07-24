package SyntaxAnalyzer;

import java.io.File;
import java.util.ArrayList;

public class SyntaxAnalyzer {



    public static void main(String[] args) {

                File f=new File("C:\\Users\\anugr\\Desktop\\10\\ArrayTest\\Main.jack");
                File ft = new File("C:\\Users\\anugr\\Desktop\\10\\Output files\\Main.xml");
                File tp = new File("C:\\Users\\anugr\\Desktop\\10\\Output files\\MainT.xml");

                CompilationEngine compilationEngine = new CompilationEngine(f,ft,tp);
                compilationEngine.compileClass();

                System.out.println("File created : " );
            }

        }

    
