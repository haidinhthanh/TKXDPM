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

import java.util.List;

public interface PaginationDataProvider<T> {
    int getTotalRowCount();
    List<T> getRows(int startIndex, int endIndex);
}
