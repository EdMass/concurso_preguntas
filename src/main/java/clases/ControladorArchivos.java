
package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ListModel;

public class ControladorArchivos {
    
    ArrayList<String> preguntas;
    ArrayList<String> repuestas;
    String usuario = System.getProperty("user.name");
    String carpeta = "C:\\Users\\"+usuario+"\\Documents\\AndoPreguntando\\";
    
    
    public void CreateCarpeta(){
        File carp = new File(carpeta);
        
        if(!carp.exists())
        {     
            carp.mkdir();
        }
    }    
    
    
    public ArrayList<String> Preguntas(){
        try{
            CreateCarpeta();
            File archivo = new File(carpeta+"Preguntas.txt");
            
            if(archivo.exists()){
            } else {
                archivo.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(archivo));                         
            String linea;
            preguntas = new ArrayList<>();
            int i = 1;
            while((linea = br.readLine())!= null)
            {
                preguntas.add(linea);
                i++;
            }
            br.close(); 
            
            return preguntas;
            
        }catch(IOException ex){
            
        }
        
        return preguntas;
    } 
    
    
    public void AddPregunta(ArrayList<String> pregunta){
        try{
            CreateCarpeta();
            File archivo = new File(carpeta+"Preguntas.txt");
            
            if(archivo.exists()){
            } else {
                archivo.createNewFile();
            }
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));     
            
            for(int i=0; i<pregunta.size(); i++){
                String prg = pregunta.get(i);
                bw.write(prg); 
                bw.newLine();
                bw.flush();
            }
            bw.close();
            
        }catch(IOException ex){
            
        }

    }
    
    
    public boolean existPregunta(){
        preguntas = Preguntas();
        
        return preguntas.isEmpty();
    }
    
    
    public ArrayList<String> Repuestas(){
        try{
            CreateCarpeta();
            File archivo = new File(carpeta+"Repuestas.txt");
            
            if(archivo.exists()){
            } else {
                archivo.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(archivo));                         
            String linea;
            repuestas = new ArrayList<>();
            int i = 1;
            while((linea = br.readLine())!= null){
                repuestas.add(linea);
                i++;
            }
            
            br.close(); 
            
            return repuestas;
            
        }catch(IOException ex){
            
        }
        
        return repuestas;
    }
    
    
    public void AddRepuesta(ArrayList<String> respuestas){

        try{
            CreateCarpeta();
            File archivo = new File(carpeta+"Repuestas.txt");
            
            if(archivo.exists()){
            } else {
                archivo.createNewFile();
            }
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            
            for(int i=0; i<respuestas.size(); i++){ 
                String prs = respuestas.get(i);
                bw.write(prs);
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }catch(IOException ex){
            
        }

    }
    
}
