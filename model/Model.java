/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import model.container.MetricsContainer;
import model.container.QualityMetricContainer;
import model.container.TestCoverageContainer;
import model.container.utils.CsvFileReader;
import model.container.utils.MetricsWriter;
import model.container.utils.XmlMetricsFileReader;
import org.xml.sax.SAXException;

/**
 *
 * @author Arturo
 */
public class Model {

    private List<QualityMetricContainer> qualityMetrics;
    private List<TestCoverageContainer> testCoverageMetrics;
    private HashMap<String, MetricsContainer> metricsContainer;
    private List<String> helperList = new ArrayList<>();
    
    public HashMap<String, MetricsContainer> mergeMetricsFile(String filePathQualityMetrics, String filePathTestCoverageMetrics) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        getQualityMetrics(filePathQualityMetrics);
        getTestCoverageMetrics(filePathTestCoverageMetrics);
        mergeMetrics();
        return metricsContainer;
    }

    private void getQualityMetrics(String filePathQualityMetrics) throws IOException {
        qualityMetrics = CsvFileReader.parseCsvQualityMetricsFile(filePathQualityMetrics);        
    }
   
    private void getTestCoverageMetrics(String filePathTestCoverageMetrics) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        testCoverageMetrics = XmlMetricsFileReader.readFile(filePathTestCoverageMetrics);
    }

    private void mergeMetrics() {
        metricsContainer = new HashMap<>();
        testCoverageMetrics.stream().map((testCoverageContainer) -> {
            MetricsContainer metricContainer = new MetricsContainer();
            //System.out.println("Setting class "+testCoverageContainer.getClassName());
            metricContainer.setClassName(testCoverageContainer.getClassName());
            metricContainer.setTestCoverageContainer(testCoverageContainer);            
            return metricContainer;
        }).forEach((metricContainer) -> {
            metricsContainer.put(metricContainer.getClassName(), metricContainer);
        });
        
        qualityMetrics.stream().forEach((qualityContainer) -> {
            if(metricsContainer.containsKey(qualityContainer.getClassName())){
                metricsContainer.get(qualityContainer.getClassName()).setQualityMetricsContainer(qualityContainer);
            }
        });
        
        Iterator it = metricsContainer.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(!metricsContainer.get((String)pair.getKey()).isHasQualityMetricsContainer()){
                helperList.add((String)pair.getKey());
            }
            
        }
        for(String className : helperList){
            
            metricsContainer.remove(className);
        }
        
    }
    
    public void saveMetricsCsvFile(String filePath) throws FileNotFoundException, IOException{
        MetricsWriter instance = new MetricsWriter(metricsContainer);
        instance.saveMetricsCsvFile(filePath); 
    }
    
    public void saveMetricsHtmlFile(String filePath){
        
    }
}
