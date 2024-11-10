package az.xeyale.balance.service;

import az.xeyale.balance.entity.Report;
import az.xeyale.balance.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // Hesabat yaratmaq
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    // İstifadəçiyə aid hesabatları tapmaq
    public List<Report> getReportsByUserId(Long userId) {
        return reportRepository.findByUserId(userId);
    }
}
