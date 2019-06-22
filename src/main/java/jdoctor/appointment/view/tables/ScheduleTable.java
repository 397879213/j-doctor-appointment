package jdoctor.appointment.view.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import jdoctor.appointment.util.GuiUtils;


public class ScheduleTable extends AbstractTableModel {
    private String columns[] = {"De", "Até"};
    private List<Date> dates;
    private final int COLUMN_FROM = 0;
    private final int COLUMN_TO = 1;
    private final SimpleDateFormat sdf;

    public ScheduleTable(ArrayList<Date> dates) {
        this.dates = dates;
        sdf = new SimpleDateFormat("HH:mm");
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    public void addRow() {
        try {
            dates.add(sdf.parse("00:00"));
            dates.add(sdf.parse("00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return (dates.size()/2);
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUMN_FROM:
                return String.class;
            case COLUMN_TO:
                return String.class;
        }
        
        return null;
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Date dateFrom = this.dates.get(rowIndex*2);
        Date dateTo = this.dates.get(rowIndex*2+1);

        switch (columnIndex) {
            case COLUMN_FROM:
                return sdf.format(dateFrom);
            case COLUMN_TO:
                return sdf.format(dateTo);
        }
        return null;
    }
    
    public void moveUp(int rowIndex) {
        if (rowIndex == -1) {
            GuiUtils.showErrorOkDialog("Voce deve selecionar uma linha.", null);
            return;
        }
        
        if  (rowIndex == 0) {
            GuiUtils.showErrorOkDialog("Essa ja é a primeira linha", null);
            return;
        }
        
        Date date1 = this.dates.get(rowIndex*2);
        Date date2 = this.dates.get(rowIndex*2+1);
        
        Date date11 = this.dates.get((rowIndex-1)*2);
        Date date22 = this.dates.get((rowIndex-1)*2+1);
        
        this.dates.set((rowIndex-1)*2, date1);
        this.dates.set((rowIndex-1)*2+1, date2);
        
        this.dates.set(rowIndex*2, date11);
        this.dates.set(rowIndex*2+1, date22);
        
        fireTableDataChanged();
    }
    
    public void moveDown(int rowIndex) {
        if (rowIndex == -1) {
            GuiUtils.showErrorOkDialog("Voce deve selecionar uma linha.", null);
            return;
        }
        
        if (rowIndex == getRowCount()-1) {
            GuiUtils.showErrorOkDialog("Essa ja é a ultima linha", null);
            return;
        }
        
        Date date1 = this.dates.get(rowIndex*2);
        Date date2 = this.dates.get(rowIndex*2+1);
        
        Date date11 = this.dates.get((rowIndex+1)*2);
        Date date22 = this.dates.get((rowIndex+1)*2+1);
        
        this.dates.set((rowIndex+1)*2, date1);
        this.dates.set((rowIndex+1)*2+1, date2);
        
        this.dates.set(rowIndex*2, date11);
        this.dates.set(rowIndex*2+1, date11);
        
        fireTableDataChanged();
    }
    
    public void removeRow(int rowIndex) {
        if (rowIndex == -1) {
            GuiUtils.showErrorOkDialog("Voce deve selecionar uma linha", null);
            return;
        }
        
        this.dates.remove(rowIndex*2+1);
        this.dates.remove(rowIndex*2);
        
        fireTableDataChanged();
    }
    
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        Date date = dates.get(rowIndex*2 + columnIndex);
        Date editedDate = null;
        
        try {
            editedDate = sdf.parse((String) aValue);
        } catch (ParseException e) {
            GuiUtils.showErrorOkDialog("Digite um horario valida", null);
            return;
        }
        
        switch (columnIndex) {
            case COLUMN_FROM:
                dates.set(rowIndex*2 + columnIndex, editedDate);
                break;
            case COLUMN_TO:
                if (editedDate.before(dates.get(rowIndex*2))) {
                    GuiUtils.showConfirmOkDialog("Horario Invalido: O Horario 'até' deve ser depois de 'de'", null);
                    return;
                } else {
                    dates.set(rowIndex*2 + columnIndex, editedDate);
                }
                break;
        }
        
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
