package jdoctor.appointment.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;


public class Report {
    
public void gerarRelatorio(boolean visualizar, String nomeRelatorio, HashMap<String, Object> parametros, Connection conexao) throws JRException, FileNotFoundException, Exception {

        InputStream arquivo = getClass().getResourceAsStream("/reports/"+nomeRelatorio+".jasper");

        if (arquivo == null)
          throw new Exception("Relatório não encontrado");
                  
        JasperPrint print = 
                JasperFillManager.fillReport(arquivo, null, conexao);
        
        
        if (visualizar){
            JasperViewer viewer = new JasperViewer(print,false);
             viewer.setVisible(true);
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            viewer.setTitle("Relatório...");
        }
        else{
            JRPdfExporter exporter =  
                    new JRPdfExporter(DefaultJasperReportsContext.getInstance());//
            exporter.setExporterInput( new SimpleExporterInput(print));
            exporter.setExporterOutput(
                    new SimpleOutputStreamExporterOutput(
                            new FileOutputStream(nomeRelatorio+".pdf")));
            SimplePdfReportConfiguration configuracao =
                    new SimplePdfReportConfiguration();
            exporter.setConfiguration(configuracao);
            
            
            exporter.exportReport();
            System.out.println("Exportando relatorio...");
        }
        System.out.println("Feito...");
  
    }    
}
