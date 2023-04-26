package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/reporting")
public class ReportController {


    @Autowired
    ReportService reportservice ;
    @GetMapping("/reportjasper/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return reportservice.exportReport(format) ;
    }

}
