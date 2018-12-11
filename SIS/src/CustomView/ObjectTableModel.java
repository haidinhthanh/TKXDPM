/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomView;

/**
 *
 * @author haidt
 */
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;

public abstract class ObjectTableModel<T> extends AbstractTableModel {
    private List<T> objectRows = new ArrayList<>();

    public List<T> getObjectRows() {
        return objectRows;
    }

    public void setObjectRows(List<T> objectRows) {
        this.objectRows = objectRows;
    }

    @Override
    public int getRowCount() {
        return objectRows.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T t = objectRows.get(rowIndex);
        return getValueAt(t, columnIndex);
    }

    @Override
    public void fireTableChanged(TableModelEvent e) {
        super.fireTableChanged(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract Object getValueAt(T t, int columnIndex);    
}
