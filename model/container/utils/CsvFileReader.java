/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.container.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.container.QualityMetricContainer;

/**
 *
 * @author Arturo
 */
public class CsvFileReader {

    private static ArrayList<String[]> parsedCsv;
        
    public static ArrayList<String[]> readFile(String pathFile) throws IOException {
        parsedCsv = new ArrayList<>();
        parseCsvFile(pathFile);
        return parsedCsv;
    }

    private static void parseCsvFile(String pathFile) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                parsedCsv.add(line.split(","));
            }
        }
    }
    
    public static ArrayList<QualityMetricContainer> parseCsvQualityMetricsFile(String pathFile) throws IOException{
        
        ArrayList<QualityMetricContainer> metricContainer = new ArrayList<>();
        ArrayList<String[]> parsedXml = readFile(pathFile);
        
        for(int i = 1; i < parsedXml.size(); i++){
            String[] parsedRow = parsedXml.get(i);
            QualityMetricContainer container = new QualityMetricContainer();
            
            //if(parsedRow[1] == null || parsedRow[11] ==null)
            //    continue;
            
            container.setFullQualifiedName(parsedRow[0]);
            container.setClassName(parsedRow[1]);
            container.setCouplingBetweenObjects(Integer.parseInt(parsedRow[3]));
            //container.setMcCabeCyclomaticComplexity(Integer.parseInt(parsedRow[4]));
            container.setDepthOfInheritanceTree(Integer.parseInt(parsedRow[6]));
            container.setLackOfCohesionInMethods(Integer.parseInt(parsedRow[7]));
            System.out.println("clase "+parsedRow[1] +" LOC "+parsedRow[11]);
            container.setLinesOfCode(Integer.parseInt(parsedRow[11]));
            container.setLackOfDocumentation(Double.parseDouble(parsedRow[12]));            
            container.setNumberOfLocalMethods(Integer.parseInt(parsedRow[16]));
            metricContainer.add(container);
        }
        
        return metricContainer;
    }
}
