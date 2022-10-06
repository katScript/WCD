package database.queryBuilder.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsertQuery extends AbstractBuilder {
    private String insertQuery;
    private List<String> insertValue;

    public InsertQuery(String tableName, String primaryKey, String[] fields) {
        super(tableName, primaryKey, fields);
        this.insertValue = new ArrayList<>();
    }

    @Override
    public InsertQuery init() {
        this._dataField.clear();
        this.insertQuery = "INSERT INTO ? ";

        this._dataField.add(this._tableName);

        return this;
    }

    @Override
    public String getQuery() {
        return this.insertQuery + String.join(",", this.insertValue) + ";";
    }

    public InsertQuery setInsertValue(HashMap<String, Object> fields) {
        this.insertQuery += " (" + this.setField(fields) + ") VALUES ";
        List<String> data = new ArrayList<>();

        for (String key : fields.keySet()) {
            data.add("?");
            this._dataField.add(fields.get(key));
        }

        this.insertValue.add("(" + String.join(", ", data) + ")");
        return this;
    }

    private String setField(HashMap<String, Object> fields) {
        List<String> fieldName = new ArrayList<>();

        for (String key : fields.keySet()) {
            fieldName.add("?");
            this._dataField.add(key);
        }

        return String.join(", ", fieldName);
    }
}
