/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.container;

/**
 *
 * @author Arturo
 */
public class MetricsContainer {
    
    private String className;
    private QualityMetricContainer qualityMetricsContainer;
    private TestCoverageContainer testCoverageContainer;
    private boolean hasQualityMetricsContainer = false;
    private boolean hasTestCoverageContainer = false;
    
    public boolean haveQualityMetricContainer(){
        return qualityMetricsContainer != null;
    }
    
    public boolean haveTestCoverageContainer(){
        return testCoverageContainer != null;
    }

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
     * @return the qualityMetricsContainer
     */
    public QualityMetricContainer getQualityMetricsContainer() {
        return qualityMetricsContainer;
    }

    /**
     * @param qualityMetricsContainer the qualityMetricsContainer to set
     */
    public void setQualityMetricsContainer(QualityMetricContainer qualityMetricsContainer) {
        
        this.setHasQualityMetricsContainer(qualityMetricsContainer != null);
            
        this.qualityMetricsContainer = qualityMetricsContainer;
    }

    /**
     * @return the testCoverageContainer
     */
    public TestCoverageContainer getTestCoverageContainer() {
        return testCoverageContainer;
    }

    /**
     * @param testCoverageContainer the testCoverageContainer to set
     */
    public void setTestCoverageContainer(TestCoverageContainer testCoverageContainer) {
        
        this.setHasTestCoverageContainer(testCoverageContainer != null);
        
        this.testCoverageContainer = testCoverageContainer;
    }

    /**
     * @return the hasQualityMetricsContainer
     */
    public boolean isHasQualityMetricsContainer() {
        return hasQualityMetricsContainer;
    }

    /**
     * @param hasQualityMetricsContainer the hasQualityMetricsContainer to set
     */
    public void setHasQualityMetricsContainer(boolean hasQualityMetricsContainer) {
        this.hasQualityMetricsContainer = hasQualityMetricsContainer;
    }

    /**
     * @return the hasTestCoverageContainer
     */
    public boolean isHasTestCoverageContainer() {
        return hasTestCoverageContainer;
    }

    /**
     * @param hasTestCoverageContainer the hasTestCoverageContainer to set
     */
    public void setHasTestCoverageContainer(boolean hasTestCoverageContainer) {
        this.hasTestCoverageContainer = hasTestCoverageContainer;
    }
    
    
}
