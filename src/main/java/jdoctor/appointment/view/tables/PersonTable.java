package jdoctor.appointment.view.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import jdoctor.appointment.model.Person;
import jdoctor.appointment.util.GuiUtils;


public class PersonTable extends AbstractTableModel {
    private String columns[] = {"Nome", "Email", "Telfone", "CPF"};
    private ArrayList<Person> persons;
    private ArrayList<Person> allPersons;
    private final int COLUMN_NAME = 0;
    private final int COLUMN_EMAIL = 1;
    private final int COLUMN_PHONE = 2;
    private final int COLUMN_DOC_CPF = 3;

    public PersonTable(ArrayList<Person> persons) {
        allPersons = new ArrayList<>(persons);
        this.persons = allPersons;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Person getRow(Integer rowIndex) {
        return this.persons.get(rowIndex);
    }
    
    public void filter(String name) {
        persons = new ArrayList<>();
        
        for (Person p : allPersons) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                persons.add(p);
            }
        }
        
        fireTableDataChanged();
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return (persons.size());
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
            case COLUMN_EMAIL:
                return String.class;
            case COLUMN_PHONE:
                return String.class;
            case COLUMN_DOC_CPF:
                return String.class;
        }
        
        return null;
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case COLUMN_NAME:
                return persons.get(rowIndex).getName();
            case COLUMN_EMAIL:
                return persons.get(rowIndex).getEmail();
            case COLUMN_PHONE:
                return persons.get(rowIndex).getPhoneNumber();
            case COLUMN_DOC_CPF:
                return persons.get(rowIndex).getDocCPF();
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
