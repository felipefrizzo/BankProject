package br.univel.reports.balance;

import br.univel.model.operationbanking.OperationBanking;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.List;

/**
 * Created by felipefrizzo on 9/22/16.
 */
public class BalanceReport {
    private InputStream pathReport;

    public BalanceReport() {
        this.pathReport = this.getClass().getResourceAsStream("/br/univel/reports/balance/BalanceReport.jrxml");
        System.out.println(this.pathReport);
    }

    public void printReport(List<OperationBanking> banking) {
        try {
            JasperReport report = JasperCompileManager.compileReport(getPathReport());
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(banking));
            JasperExportManager.exportReportToPdfFile(print, "balance_report.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public InputStream getPathReport() {
        return pathReport;
    }
}
