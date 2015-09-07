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
public class TestCoverageContainer {
    
    private String fullQualifiedName;
    private String className;
    private Double testCoverage;
    private Double branchCoverage;
    private Double mcCabeCyclomaticComplexity;

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the testCoverage
     */
    public Double getTestCoverage() {
        return testCoverage;
    }

    /**
     * @param testCoverage the testCoverage to set
     */
    public void setTestCoverage(Double testCoverage) {
        this.testCoverage = testCoverage;
    }

    /**
     * @return the branchCoverage
     */
    public Double getBranchCoverage() {
        return branchCoverage;
    }

    /**
     * @param branchCoverage the branchCoverage to set
     */
    public void setBranchCoverage(Double branchCoverage) {
        this.branchCoverage = branchCoverage;
    }

    /**
     * @return the mcCabeCyclomaticComplexity
     */
    public Double getMcCabeCyclomaticComplexity() {
        return mcCabeCyclomaticComplexity;
    }

    /**
     * @param mcCabeCyclomaticComplexity the mcCabeCyclomaticComplexity to set
     */
    public void setMcCabeCyclomaticComplexity(Double mcCabeCyclomaticComplexity) {
        this.mcCabeCyclomaticComplexity = mcCabeCyclomaticComplexity;
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
       if (!(obj instanceof TestCoverageContainer))
            return false;
        if (obj == this)
            return true;

        TestCoverageContainer container = (TestCoverageContainer) obj;
        return new EqualsBuilder().
            append(this.className, container.getClassName()).
            isEquals();
    }

    

    
}
