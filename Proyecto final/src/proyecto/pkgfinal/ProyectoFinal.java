/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author demen
 */
public class ProyectoFinal{
    public String origen;
    public int Destino;
    public int transporte;
    public int procedencia;
   
    public ProyectoFinal(String origen, int Destino, int transporte, int procedencia){
        this.origen=origen;
        this.Destino=Destino;
        this.transporte=transporte;
        this.procedencia=procedencia;
           
    }
    
   ProyectoFinal(){}
  private File archivo;
   
 
    
    ProyectoFinal(String path){
        this.archivo=new File(path);
    }

   public List< ProyectoFinal> crearListado() throws FileNotFoundException{
         List< ProyectoFinal> listadoFinal = new ArrayList<>();
        try (Scanner scanner = new Scanner(this.archivo);) {
            while (scanner.hasNextLine()) {
                List<String> record=getRecordFromLine(scanner.nextLine());
                 ProyectoFinal dato=new  ProyectoFinal();
                dato.origen=record.get(5);
                dato.Destino=Integer.parseInt(record.get(2));
                dato.transporte=Integer.parseInt(record.get(7));
                dato.procedencia=Integer.parseInt(record.get(6));
                listadoFinal.add(dato);
            }
        }
        return listadoFinal;
        
    }
    
      private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
    
}


