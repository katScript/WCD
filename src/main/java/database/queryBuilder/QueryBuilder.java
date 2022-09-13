package database.queryBuilder;

import database.queryBuilder.builder.DeleteQuery;
import database.queryBuilder.builder.InsertQuery;
import database.queryBuilder.builder.SelectQuery;
import database.queryBuilder.builder.UpdateQuery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QueryBuilder {
    protected String _tableName;
    protected String _primaryKey;

    protected String[] _fields;

    protected InsertQuery insertQueryBuilder;
    protected SelectQuery selectQueryBuilder;
    protected UpdateQuery updateQueryBuilder;
    protected DeleteQuery deleteQueryBuilder;

    public QueryBuilder(String tableName, String primaryKey, String[] fields) {
        this._tableName = tableName;
        this._primaryKey = primaryKey;
        this._fields = fields;

        this.insertQueryBuilder = new InsertQuery(this._tableName, this._primaryKey, this._fields);
        this.selectQueryBuilder = new SelectQuery(this._tableName, this._primaryKey, this._fields);
        this.updateQueryBuilder = new UpdateQuery(this._tableName, this._primaryKey, this._fields);
        this.deleteQueryBuilder = new DeleteQuery(this._tableName, this._primaryKey, this._fields);
    }

    public InsertQuery getInsertQueryBuilder() {
        return this.insertQueryBuilder.init();
    }

    public SelectQuery getSelectQueryBuilder() {
        return this.selectQueryBuilder.init();
    }

    public UpdateQuery getUpdateQueryBuilder() {
        return this.updateQueryBuilder.init();
    }

    public DeleteQuery getDeleteQueryBuilder() {
        return this.deleteQueryBuilder.init();
    }
}
