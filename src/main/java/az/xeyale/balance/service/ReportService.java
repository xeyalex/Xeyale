package az.xeyale.balance.service;

import az.xeyale.balance.entity.Report;
import az.xeyale.balance.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Value("${balance.report.date-format}")
    private String dateFormat;  // application.properties-dən format alınacaq

    // Hesabat yaratmaq
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    // İstifadəçiyə aid hesabatları tapmaq
    public List<Report> getReportsByUserId(Long userId) {
        return reportRepository.findByUserId(userId);
    }

    // Tarixi müəyyən edilmiş formatla çevirib geri qaytarmaq
    public String formatReportDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return date.format(formatter);
    }
}
