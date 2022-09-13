package database.queryBuilder.builder;

import database.queryBuilder.builder.api.QueryBuilderInterface;

import java.util.Set;

abstract class AbstractBuilder implements QueryBuilderInterface {
    protected String _tableName;
    protected String _primaryKey;
    protected String[] _fields;

    public AbstractBuilder(String tableName, String primaryKey, String[] fields) {
        this._tableName = tableName;
        this._primaryKey = primaryKey;
        this._fields = fields;
    }
}
