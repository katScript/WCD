package database.queryBuilder.builder;

import database.queryBuilder.builder.condition.ConditionBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SelectQuery extends AbstractBuilder {
    private String selectQuery;
    private ConditionBuilder selectCondition;

    public SelectQuery(String tableName, String primaryKey, String[] fields) {
        super(tableName, primaryKey, fields);

        this.selectCondition = new ConditionBuilder();
    }

    public SelectQuery setFields(String[] fields) {
        this._fields = fields;
        return this;
    }

    @Override
    public SelectQuery init() {
        this._dataField.clear();
        this.selectQuery = "SELECT " + this.setField() + " FROM ?";
        this._dataField.add(this._tableName);

        return this;
    }

    @Override
    public String getQuery() {
        this._dataField.addAll(this.selectCondition.getDataField());

        return this.selectQuery + " " + this.selectCondition.getCondition() + ";";
    }

    public ConditionBuilder setCondition(String col, String con, Object val) {
        return this.selectCondition.init(col, con, val);
    }

    private String setField() {
        List<String> listField = new ArrayList<>();
        for (String f: this._fields) {
            listField.add("?");
            this._dataField.add(f);
        }

        return String.join(", ", listField);
    }
}
