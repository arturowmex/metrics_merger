import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as stats
#import csv

#fig, axes = plt.subplots(nrows=2, ncols=3, figsize=(6,6))

def regression(file_name, first_index_test, second_index_quality, order, output_file_name):
    
    COLUMN_SEPARATOR = ','
    metrics_data = pd.DataFrame.from_csv(file_name, sep=COLUMN_SEPARATOR, header=None)
    labels = ['','Test Coverage', 
                'Branch Coverage',
                'Cyclomatic Complexity', 
                'Lines of Code', 
                'Number Of Methods', 
                'Improvement Lack of Cohesion in Methods',
                'Lack of Documentation',
                'Depth of Inheritance',
                'Coupling Between Objects']
                
    x = metrics_data[first_index_test]
    y = metrics_data[second_index_quality]
    
    coeffs = np.polyfit(x, y, order)
    polynomial = np.poly1d(coeffs)
    ys = polynomial(x)
    
    
    covariance = np.cov(x,y)[0][1]
    
    pearson, p_value = stats.pearsonr(x,y)
    
    ybar = np.sum(y)/len(y)
    ssreg = np.sum((ys-ybar)**2)
    ss_err = np.sum((y-ys)**2)
    sstot = np.sum((y-ybar)**2)
    determination = ssreg/sstot
    determination2 = 1 - ss_err/sstot
    
    standard = np.std([x,y])
    
    if second_index_quality == 3:
        file_mode = 'w'
    else:
        file_mode = 'a'
        
    f = open(output_file_name, file_mode)        
    f.write(str(covariance)+","+str(pearson)+","+str(determination)+","+str(p_value)+","+str(standard)+","+str(coeffs[0])+","+str(coeffs[1])+","+labels[second_index_quality]+","+str(determination2)+"\n")    
    
    column = second_index_quality-2    
    
       
                
    plt.figure(column)
    plt.xlabel(labels[first_index_test]) 
    plt.ylabel(labels[second_index_quality])
    plt.title(labels[second_index_quality])  
    plt.plot(x, y, 'o')    
    plt.plot(x, ys)        

#file_path = 'C:\\Users\\Arturo\\Google Drive\\Dissertation\\Datos Proyecto\\Alibaba-dubbo\\Metricas\\Merge\\all projects dubbo.csv'
#file_path = 'C:\\Users\\Arturo\\Google Drive\\Dissertation\\Datos Proyecto\\Netty\\Metricas\\Merge\\all projects netty.csv'
file_path = 'C:\\Users\\Arturo\\Google Drive\\Dissertation\\Datos Proyecto\\Spring-Boot\\Metricas\\Merge\\all projects spring.csv'
output_file_path = 'C:\\Users\\Arturo\\Google Drive\\Dissertation\\Datos Proyecto\\Prueba.csv'
for x in range(3,10):
    regression(file_path,2,x,1,output_file_path)
    plt.show()
    
