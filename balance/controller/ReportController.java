package az.xeyale.balance.controller;

import az.xeyale.balance.entity.Report;
import az.xeyale.balance.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Yeni hesabat yaratmaq
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report createdReport = reportService.createReport(report);
        return ResponseEntity.ok(createdReport);
    }

    // İstifadəçiyə aid hesabatları tapmaq
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Report>> getReportsByUserId(@PathVariable Long userId) {
        List<Report> reports = reportService.getReportsByUserId(userId);
        return ResponseEntity.ok(reports);
    }
}
