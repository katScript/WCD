package database.queryBuilder.builder;

import database.queryBuilder.builder.condition.ConditionBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateQuery extends AbstractBuilder {
    private String updateQuery;
    private ConditionBuilder updateCondition;

    public UpdateQuery(String tableName, String primaryKey, String[] fields) {
        super(tableName, primaryKey, fields);

        this.updateCondition = new ConditionBuilder();
    }

    @Override
    public UpdateQuery init() {
        this._dataField.clear();
        this.updateQuery = "UPDATE ? SET ";
        this._dataField.add(this._tableName);

        return this;
    }

    @Override
    public String getQuery() {
        this._dataField.addAll(this.updateCondition.getDataField());

        return this.updateQuery;
    }

    public UpdateQuery setUpdateValue(HashMap<String, Object> fields) {
        List<String> data = new ArrayList<>();

        for (String key : fields.keySet()) {
            if (key.equals(this._primaryKey))
                continue;

            data.add("? = ?");
            this._dataField.add(key);
            this._dataField.add(fields.get(key));
        }

        this.updateQuery += String.join(", ", data);
        return this;
    }

    public ConditionBuilder setCondition(String col, String con, Object val) {
        return this.updateCondition.init(col, con, val);
    }
}
