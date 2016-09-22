package br.univel.reports.operation;

import br.univel.model.operationbanking.OperationBanking;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.util.List;

/**
 * Created by felipefrizzo on 9/22/16.
 */
public class OperationReport {
    private InputStream pathReport;

    public OperationReport() {
        this.pathReport = this.getClass().getResourceAsStream("/br/univel/reports/operation/OperationReport.jrxml");
        System.out.println(this.pathReport);
    }

    public void printReport(List<OperationBanking> banking) {
        try {
            JasperReport report = JasperCompileManager.compileReport(getPathReport());
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(banking));
            JasperExportManager.exportReportToPdfFile(print, "operation_report.pdf");

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
