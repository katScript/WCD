package database.queryBuilder.builder;

import database.queryBuilder.builder.condition.ConditionBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class UpdateQuery extends AbstractBuilder {
    private String updateQuery;
    private ConditionBuilder updateCondition;

    public UpdateQuery(String tableName, String primaryKey, String[] fields) {
        super(tableName, primaryKey, fields);

        this.updateCondition = new ConditionBuilder();
    }

    @Override
    public UpdateQuery init() {
        this.updateQuery = "UPDATE " + this._tableName + " SET ";
        return this;
    }

    @Override
    public String getQuery() {
        return this.updateQuery + " " + String.join(",", this.updateQuery) + ";";
    }

    public UpdateQuery setUpdateValue(HashMap<String, String> fields) {
        List<String> data = new ArrayList<>();

        for (String key : fields.keySet()) {
            if (key.equals(this._primaryKey))
                continue;

            String value = String.valueOf(fields.get(key));
            data.add(key +  " = '" + value + "'");
        }

        this.updateQuery += String.join(", ", data);
        return this;
    }

    public ConditionBuilder setCondition(String col, String con, String val) {
        return this.updateCondition.init(col, con, val);
    }
}
