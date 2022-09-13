package database.queryBuilder.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class InsertQuery extends AbstractBuilder {
    private String insertQuery;
    private List<String> insertValue;

    public InsertQuery(String tableName, String primaryKey, String[] fields) {
        super(tableName, primaryKey, fields);
        this.insertValue = new ArrayList<>();
    }

    @Override
    public InsertQuery init() {
        this.insertQuery = "INSERT INTO " + this._tableName;

        return this;
    }

    @Override
    public String getQuery() {
        return this.insertQuery + String.join(",", this.insertValue) + ";";
    }

    public InsertQuery setInsertValue(HashMap<String, String> fields) {
        this.insertQuery += " (" + String.join(", ", fields.keySet()) + ") VALUES ";
        List<String> data = new ArrayList<>();

        for (String key : fields.keySet()) {
            String value = String.valueOf(fields.get(key));
            data.add("'" + value + "'");
        }

        this.insertValue.add("(" + String.join(",", data) + ")");
        return this;
    }
}
