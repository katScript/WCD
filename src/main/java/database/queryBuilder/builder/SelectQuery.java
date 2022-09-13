package database.queryBuilder.builder;

import database.queryBuilder.builder.condition.ConditionBuilder;

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
        this.selectQuery = "SELECT " + String.join(", ", this._fields) + " FROM " + this._tableName;

        return this;
    }

    @Override
    public String getQuery() {
        return this.selectQuery + " " + this.selectCondition.getCondition() + ";";
    }

    public ConditionBuilder setCondition(String col, String con, String val) {
        return this.selectCondition.init(col, con, val);
    }
}
