/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.container.utils;

import model.container.TestCoverageContainer;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Arturo
 */
public class XmlMetricsFileReader {

    private static ArrayList<TestCoverageContainer> parsedFile;
    
    public static ArrayList<TestCoverageContainer> readFile(String pathFile) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        
        parsedFile = new ArrayList<>();
        parseXmlFile(pathFile);
        
        
        return parsedFile;
    }

    private static void parseXmlFile(String pathFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(pathFile);

        NodeList nodeList = doc.getElementsByTagName("class"); 
        
        TestCoverageContainer coverageContainer;
        int length = nodeList.getLength();
        for( int i=0; i<length; i++) {
            coverageContainer = new TestCoverageContainer();
            nodeList.item(i).getNodeValue();
            
            String fullQualifiedName = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
            String name = obtainClassName(fullQualifiedName);
            String lineRate = nodeList.item(i).getAttributes().getNamedItem("line-rate").getNodeValue();
            String branchRate = nodeList.item(i).getAttributes().getNamedItem("branch-rate").getNodeValue();
            String cyclomaticComplexity = nodeList.item(i).getAttributes().getNamedItem("complexity").getNodeValue();
            
            if(name.contains("$")){
                continue;
            }
            
            coverageContainer.setFullQualifiedName(fullQualifiedName);
            coverageContainer.setClassName(name);
            coverageContainer.setTestCoverage(Double.parseDouble(lineRate));
            coverageContainer.setBranchCoverage(Double.parseDouble(branchRate));
            coverageContainer.setMcCabeCyclomaticComplexity(Double.parseDouble(cyclomaticComplexity));
            
            parsedFile.add(coverageContainer);
        }
    }

    private static String obtainClassName(String fullQualifiedName) {
        return fullQualifiedName.substring(fullQualifiedName.lastIndexOf(".")+1);
    }
    
}
