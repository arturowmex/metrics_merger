/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.container;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author Arturo
 */
public class QualityMetricContainer {
    
    private String className;
    private String fullQualifiedName;
    private int linesOfCode;
    private int numberOfLocalMethods;
    private int mcCabeCyclomaticComplexity;
    private int depthOfInheritanceTree;
    private int couplingBetweenObjects;
    private int lackOfCohesionInMethods;
    private double lackOfDocumentation;

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param ClassName the className to set
     */
    public void setClassName(String ClassName) {
        this.className = ClassName;
    }

    /**
     * @return the linesOfCode
     */
    public int getLinesOfCode() {
        return linesOfCode;
    }

    /**
     * @param linesOfCode the linesOfCode to set
     */
    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    /**
     * @return the numberOfLocalMethods
     */
    public int getNumberOfLocalMethods() {
        return numberOfLocalMethods;
    }

    /**
     * @param numberOfLocalMethods the numberOfLocalMethods to set
     */
    public void setNumberOfLocalMethods(int numberOfLocalMethods) {
        this.numberOfLocalMethods = numberOfLocalMethods;
    }

    /**
     * @return the mcCabeCyclomaticComplexity
     */
    public int getMcCabeCyclomaticComplexity() {
        return mcCabeCyclomaticComplexity;
    }

    /**
     * @param mcCabeCyclomaticComplexity the mcCabeCyclomaticComplexity to set
     */
    public void setMcCabeCyclomaticComplexity(int mcCabeCyclomaticComplexity) {
        this.mcCabeCyclomaticComplexity = mcCabeCyclomaticComplexity;
    }

    /**
     * @return the depthOfInheritanceTree
     */
    public int getDepthOfInheritanceTree() {
        return depthOfInheritanceTree;
    }

    /**
     * @param depthOfInheritanceTree the depthOfInheritanceTree to set
     */
    public void setDepthOfInheritanceTree(int depthOfInheritanceTree) {
        this.depthOfInheritanceTree = depthOfInheritanceTree;
    }

    /**
     * @return the couplingBetweenObjects
     */
    public int getCouplingBetweenObjects() {
        return couplingBetweenObjects;
    }

    /**
     * @param couplingBetweenObjects the couplingBetweenObjects to set
     */
    public void setCouplingBetweenObjects(int couplingBetweenObjects) {
        this.couplingBetweenObjects = couplingBetweenObjects;
    }

    /**
     * @return the lackOfCohesionInMethods
     */
    public int getLackOfCohesionInMethods() {
        return lackOfCohesionInMethods;
    }

    /**
     * @param lackOfCohesionInMethods the lackOfCohesionInMethods to set
     */
    public void setLackOfCohesionInMethods(int lackOfCohesionInMethods) {
        this.lackOfCohesionInMethods = lackOfCohesionInMethods;
    }

    /**
     * @return the lackOfDocumentation
     */
    public double getLackOfDocumentation() {
        return lackOfDocumentation;
    }

    /**
     * @param lackOfDocumentation the lackOfDocumentation to set
     */
    public void setLackOfDocumentation(double lackOfDocumentation) {
        this.lackOfDocumentation = lackOfDocumentation;
    }

    /**
     * @return the fullQualifiedName
     */
    public String getFullQualifiedName() {
        return fullQualifiedName;
    }

    /**
     * @param fullQualifiedName the fullQualifiedName to set
     */
    public void setFullQualifiedName(String fullQualifiedName) {
        this.fullQualifiedName = fullQualifiedName;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
            append(this.className).            
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof QualityMetricContainer))
            return false;
        if (obj == this)
            return true;

        QualityMetricContainer container = (QualityMetricContainer) obj;
        return new EqualsBuilder().
            append(this.className, container.getFullQualifiedName()).
            isEquals();
    }
}
