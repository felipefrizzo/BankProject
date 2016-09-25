package br.univel.reports.customers;

import br.univel.model.account.Account;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.util.List;

/**
 * Created by felipefrizzo on 25/09/16.
 */
public class CustomerReport {
    private InputStream pathReport;

    public CustomerReport() {
        this.pathReport = this.getClass().getResourceAsStream("/br/univel/reports/customers/CustomerReport.jrxml");
        System.out.println(this.pathReport);
    }

    public void printReport(List<Account> banking) {
        try {
            JasperReport report = JasperCompileManager.compileReport(getPathReport());
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(banking));
            JasperExportManager.exportReportToPdfFile(print, "customer_report.pdf");

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.show();
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public InputStream getPathReport() {
        return pathReport;
    }
}
