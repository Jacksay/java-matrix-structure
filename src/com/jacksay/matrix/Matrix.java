package com.jacksay.matrix;

import java.util.*;

/**
 * Data structure as matrix.
 *
 * @author Stéphane Bouvry <stephane.bouvry@unicaen.fr>
 */
public class Matrix<E, F> implements Iterable<F> {

    public static final boolean DIAGONAL = true;
    public static final boolean FREE = false;
    private static final boolean DEFAULT_DIAGONAL = DIAGONAL;
    // Instance internal datas
    private Map<E, Map<E, F>> datas;
    private boolean isDiagonal = DEFAULT_DIAGONAL;
    private int numRow;
    private int numCol;

    public Matrix(Collection<E> rowsCols, F defaultValue) {
        this((E[]) rowsCols.toArray(), defaultValue);
    }

    public Matrix(E[] rowsCols) {
        this(rowsCols, null);
    }

    public Matrix(E[] rowsCols, F defaultValue) {
        this(rowsCols, DEFAULT_DIAGONAL, defaultValue);
    }

    public Matrix(E[] rowsCols, boolean isDiagonal) {
        this(rowsCols, isDiagonal, null);
    }

    public Matrix(Collection<E> rowsCols, boolean isDiagonal, F defaultValue) {
        this((E[]) rowsCols.toArray(), isDiagonal, defaultValue);
    }

    public Matrix(E[] rowsCols, boolean isDiagonal, F defaultValue) {
        this(rowsCols, rowsCols, null, isDiagonal, defaultValue);
    }

    public Matrix(E[] rowsCols, F[][] values, boolean isDiagonal, F defaultValue) {
        this(rowsCols, rowsCols, values, isDiagonal, defaultValue);
    }

    public Matrix(E[] cols, E[] rows, F[][] values, boolean isDiagonal,
            F defaultValue) {
        datas = new TreeMap<>();
        this.isDiagonal = isDiagonal;
        numRow = rows.length;
        numCol = cols.length;
        for (int i = 0; i < rows.length; i++) {
            Map line = new TreeMap<>();
            for (int j = 0; j < cols.length; j++) {
                F value = (values == null) ? defaultValue : values[i][j];
                line.put(cols[j], value);
            }
            datas.put(rows[i], line);
        }
    }
    
    public Set<E> getColumns() {
        return datas.keySet();
    }
    
    public Set<E> getLines() {
        return datas.values().iterator().next().keySet();
    }

    protected Map<E, F> getLine(E index) {
        return datas.get(index);
    }

    /**
     * Insert value in cell(x,y).
     *
     * @param x E Position X
     * @param y E Position Y
     * @param value F Value insert
     */
    public void setValue(E x, E y, F value) {
        datas.get(x).put(y, value);
        if (isDiagonal) {
            datas.get(y).put(x, value);
        }
    }
    
    /**
     * Get value from cell(x,y).
     *
     * @param x E Position X
     * @param y E Position Y
     * @param value F Value insert
     */
    public F getValue(E x, E y) {
        return datas.get(x).get(y);
    }

    /**
     * Return list of value from column col.
     *
     * @param col Column key
     * @return List<F>
     */
    public List<F> getColumnValues(E col) {
        List<F> out = new ArrayList<>();
        for (Map<E, F> map : datas.values()) {
            out.add(map.get(col));
        }
        return out;
    }

    /**
     * Return list of value from line line.
     *
     * @param line Column key
     * @return List<F> List of values
     */
    public List<F> getLineValues(E line) {
        return new ArrayList(datas.get(line).values());
    }

    @Override
    public String toString() {
        String out = "";
        String head = "   \t";
        for (E col : datas.keySet()) {
            head += "| " + col + "\t";
            String line = col + "\t";
            for (E row : datas.get(col).keySet()) {
                line += "| " + getValue(col, row) + "\t";
            }
            out += line;
            out += "\n";
        }
        return head + "\n" + out;
    }

    @Override
    public Iterator<F> iterator() {
        return new MatrixIterator(this);
    }

    private class MatrixIterator implements Iterator<F> {

        private Iterator<Map<E, F>> colsIterator;
        private Iterator<F> rowsIterator;

        public MatrixIterator(Matrix<E, F> matrix) {
            colsIterator = matrix.datas.values().iterator();
            rowsIterator = colsIterator.next().values().iterator();
        }

        @Override
        public boolean hasNext() {
            return colsIterator.hasNext() || rowsIterator.hasNext();
        }

        @Override
        public F next() {
            if (!rowsIterator.hasNext()) {
                rowsIterator = colsIterator.next().values().iterator();
            }
            return rowsIterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
