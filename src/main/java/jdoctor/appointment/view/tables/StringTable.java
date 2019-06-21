package jdoctor.appointment.view.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import jdoctor.appointment.util.GuiUtils;


public class StringTable extends AbstractTableModel {
    private String columns[] = {"Nome"};
    private ArrayList<ArrayList<String>> objects;
    private ArrayList<ArrayList<String>> allObjects;
    private final int COLUMN_NAME = 0;

    public StringTable(ArrayList<ArrayList<String>> objects) {
        this.objects = objects;
        this.allObjects = objects;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public void filter(String name) {
        objects = new ArrayList<ArrayList<String>>();
        
        for (ArrayList<String> vec : allObjects) {
            if (vec.get(1).contains(name)) {
                objects.add(vec);
            }
        }
        
        fireTableDataChanged();
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return (objects.size());
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
            case COLUMN_NAME:
                return String.class;
        }
        
        return null;
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case COLUMN_NAME:
                return objects.get(rowIndex).get(1);
        }
        return null;
    }
    
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        fireTableDataChanged();
    }
}
