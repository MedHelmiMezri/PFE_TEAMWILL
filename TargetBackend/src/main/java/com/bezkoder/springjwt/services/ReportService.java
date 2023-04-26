package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Project;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
 public class ReportService {

    @Autowired
    ProjectService projectrepo ;
    @Autowired
    ProjectService projectservice ;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\moham\\Desktop\\PFE";
        List<Project> projects = projectservice.getAllProjects() ;
         //load file and compile it
        File file = ResourceUtils.getFile("classpath:target.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projects);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "HELMI MEZRI");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\projects.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\projects.pdf");
        }

        return "report generated in path : " + path;
    }
}
