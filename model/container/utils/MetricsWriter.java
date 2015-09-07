/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.container.utils;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import model.container.MetricsContainer;
import model.container.QualityMetricContainer;
import model.container.TestCoverageContainer;

/**
 *
 * @author Arturo
 */
public class MetricsWriter {
    
    private final HashMap<String, MetricsContainer> metricsContainer;
    
    public MetricsWriter(HashMap<String, MetricsContainer> metricsContainer){
        this.metricsContainer = metricsContainer;
    }
    
    public void saveMetricsCsvFile(String filePath) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"));   
        
        MetricsContainer maxValueContainer = getMaxValueContainer();
        //Commented due to generate the files without headers
        /*writer.write("Class Name, "
                + "Test Coverage, "
                + "Branch Coverage, "
                + "CC Cobertura, "
                //+ "CC Vizz, "
                + "LOC, "
                + "NOM, "
                + "ILCOM, "
                + "LOD, "                
                + "DIT, "
                + "CBO, "
                + "Full Name"+"\n");*/
        
        for(MetricsContainer container : metricsContainer.values()){
            writer.write(container.getClassName()+",");
            writer.write(container.getTestCoverageContainer().getTestCoverage()+",");
            writer.write(container.getTestCoverageContainer().getBranchCoverage()+",");
            writer.write(container.getTestCoverageContainer().getMcCabeCyclomaticComplexity()+",");
            writer.write(container.getQualityMetricsContainer().getLinesOfCode()+",");
            writer.write(container.getQualityMetricsContainer().getNumberOfLocalMethods()+",");
            writer.write(container.getQualityMetricsContainer().getLackOfCohesionInMethods()+",");
            writer.write(container.getQualityMetricsContainer().getLackOfDocumentation()+",");            
            writer.write(container.getQualityMetricsContainer().getDepthOfInheritanceTree()+",");
            writer.write(container.getQualityMetricsContainer().getCouplingBetweenObjects()+",");
            
            
            //standardized data
            writer.write(container.getTestCoverageContainer().getTestCoverage()/maxValueContainer.getTestCoverageContainer().getTestCoverage()+",");
            writer.write(container.getTestCoverageContainer().getBranchCoverage()/maxValueContainer.getTestCoverageContainer().getBranchCoverage()+",");
            writer.write(container.getTestCoverageContainer().getMcCabeCyclomaticComplexity()/maxValueContainer.getTestCoverageContainer().getMcCabeCyclomaticComplexity()+",");
            writer.write(((double)container.getQualityMetricsContainer().getLinesOfCode()/(double)maxValueContainer.getQualityMetricsContainer().getLinesOfCode())+",");
            writer.write(((double)container.getQualityMetricsContainer().getNumberOfLocalMethods()/(double)maxValueContainer.getQualityMetricsContainer().getNumberOfLocalMethods())+",");
            writer.write(((double)container.getQualityMetricsContainer().getLackOfCohesionInMethods()/(double)maxValueContainer.getQualityMetricsContainer().getLackOfCohesionInMethods())+",");
            writer.write(container.getQualityMetricsContainer().getLackOfDocumentation()/maxValueContainer.getQualityMetricsContainer().getLackOfDocumentation()+",");            
            writer.write(((double)container.getQualityMetricsContainer().getDepthOfInheritanceTree()/(double)maxValueContainer.getQualityMetricsContainer().getDepthOfInheritanceTree())+",");
            writer.write(((double)container.getQualityMetricsContainer().getCouplingBetweenObjects()/(double)maxValueContainer.getQualityMetricsContainer().getCouplingBetweenObjects())+",");
            //fullqualifiedname
            writer.write(container.getTestCoverageContainer().getFullQualifiedName()+"\n");
        }
        writer.close();
    }
    
    public static void saveMetricsHtmlFile(){
        
    }

    private MetricsContainer getMaxValueContainer() {
        
        Double maxTestCoverage = 0.0d;
        Double maxBranchCoverage = 0.0d;
        Double maxCyclomaticComplexity = 0.0d;
        int maxLinesOfCode = 0;
        int maxNumberOfLocalMethods = 0;
        int maxDepthOfInheritanceTree = 0;
        int maxCouplingBetweenObjects = 0;
        int maxLackOfCohesionInMethods = 0;
        Double maxLackOfDocumentation = 0.0d;
        
        MetricsContainer maxValueContainer = new MetricsContainer();
        TestCoverageContainer maxTestContainer = new TestCoverageContainer();
        QualityMetricContainer maxQualityContainer = new QualityMetricContainer();
        
        for(MetricsContainer container : metricsContainer.values()){
            if(maxTestCoverage < container.getTestCoverageContainer().getTestCoverage()){
                maxTestCoverage = container.getTestCoverageContainer().getTestCoverage();
            }
            if(maxBranchCoverage < container.getTestCoverageContainer().getBranchCoverage()){
                maxBranchCoverage = container.getTestCoverageContainer().getBranchCoverage();
            }
            if(maxCyclomaticComplexity < container.getTestCoverageContainer().getMcCabeCyclomaticComplexity()){
                maxCyclomaticComplexity = container.getTestCoverageContainer().getMcCabeCyclomaticComplexity();
            }
            //System.out.println(container.getClassName());
            if(maxLinesOfCode < container.getQualityMetricsContainer().getLinesOfCode()){
                maxLinesOfCode = container.getQualityMetricsContainer().getLinesOfCode();
            }
            if(maxNumberOfLocalMethods < container.getQualityMetricsContainer().getNumberOfLocalMethods()){
                maxNumberOfLocalMethods = container.getQualityMetricsContainer().getNumberOfLocalMethods();
            }
            if(maxDepthOfInheritanceTree < container.getQualityMetricsContainer().getDepthOfInheritanceTree()){
                maxDepthOfInheritanceTree = container.getQualityMetricsContainer().getDepthOfInheritanceTree();
            }
            if(maxCouplingBetweenObjects < container.getQualityMetricsContainer().getCouplingBetweenObjects()){
                maxCouplingBetweenObjects = container.getQualityMetricsContainer().getCouplingBetweenObjects();
            }
            if(maxLackOfCohesionInMethods < container.getQualityMetricsContainer().getLackOfCohesionInMethods()){
                maxLackOfCohesionInMethods = container.getQualityMetricsContainer().getLackOfCohesionInMethods();
            }
            if(maxLackOfDocumentation < container.getQualityMetricsContainer().getLackOfDocumentation()){
                maxLackOfDocumentation = container.getQualityMetricsContainer().getLackOfDocumentation();
            }            
        }//end for
       
        maxTestContainer.setTestCoverage(maxTestCoverage);
        maxTestContainer.setBranchCoverage(maxBranchCoverage);
        maxTestContainer.setMcCabeCyclomaticComplexity(maxCyclomaticComplexity);
        maxQualityContainer.setCouplingBetweenObjects(maxCouplingBetweenObjects);
        maxQualityContainer.setDepthOfInheritanceTree(maxDepthOfInheritanceTree);
        maxQualityContainer.setLackOfCohesionInMethods(maxLackOfCohesionInMethods);
        maxQualityContainer.setLackOfDocumentation(maxLackOfDocumentation);
        maxQualityContainer.setLinesOfCode(maxLinesOfCode);
        maxQualityContainer.setNumberOfLocalMethods(maxNumberOfLocalMethods);
        maxValueContainer.setQualityMetricsContainer(maxQualityContainer);
        maxValueContainer.setTestCoverageContainer(maxTestContainer);
        return maxValueContainer;
        
    }
}
