package database.queryBuilder.builder;

import database.queryBuilder.builder.condition.ConditionBuilder;

import java.util.Set;

public class DeleteQuery extends AbstractBuilder {
    private String deleteQuery;
    private ConditionBuilder deleteCondition;

    public DeleteQuery(String tableName, String primaryKey, String[] fields) {
        super(tableName, primaryKey, fields);

        this.deleteCondition = new ConditionBuilder();
    }

    @Override
    public DeleteQuery init() {
        this.deleteQuery = "DELETE FROM " + this._tableName + " ";
        return this;
    }

    @Override
    public String getQuery() {
        return this.deleteQuery + this.deleteCondition.getCondition() + ";";
    }

    public ConditionBuilder setCondition(String col, String con, String val) {
        return this.deleteCondition.init(col, con, val);
    }
}
