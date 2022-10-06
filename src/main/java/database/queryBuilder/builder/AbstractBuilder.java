package database.queryBuilder.builder;

import database.queryBuilder.builder.api.QueryBuilderInterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

abstract class AbstractBuilder implements QueryBuilderInterface {
    protected String _tableName;
    protected String _primaryKey;
    protected String[] _fields;
    protected List<Object> _dataField;

    public AbstractBuilder(String tableName, String primaryKey, String[] fields) {
        this._tableName = tableName;
        this._primaryKey = primaryKey;
        this._fields = fields;
    }

    public PreparedStatement prepareStatement(PreparedStatement ps) {
        try {
            for (int i = 0; i < this._dataField.size(); ++i) {
                Object data = this._dataField.get(i);
                int index = i + 1;

                if (data instanceof Integer) {
                    ps.setInt(index, (Integer) data);
                } else if (data instanceof String) {
                    ps.setString(index, (String) data);
                } else if (data instanceof Date) {
                    ps.setDate(index, (java.sql.Date) data);
                } else if (data instanceof Double) {
                    ps.setDouble(index, (Double) data);
                } else {
                    throw new Exception("Not valid data type!");
                }
            }

            return ps;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
