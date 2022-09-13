package database.connection;

import database.queryBuilder.QueryBuilder;
import database.queryBuilder.builder.DeleteQuery;
import database.queryBuilder.builder.InsertQuery;
import database.queryBuilder.builder.SelectQuery;
import database.queryBuilder.builder.UpdateQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractRepository<T> {
    protected HashMap<String, String> _fields;
    protected String _tableName;
    protected String _primaryKey;
    private QueryBuilder queryBuilder;
    private Connector connector;

    public AbstractRepository(String tableName, String primaryKey, String[] fields) {
        this._tableName = tableName;
        this._primaryKey = primaryKey;
        this._fields = new HashMap<>();

        this.queryBuilder = new QueryBuilder(this._tableName, this._primaryKey, fields);
        this.connector = new Connector();
    }

    public Connection getConnection() {
        return this.connector.getConnection();
    }

    public AbstractRepository<T> setConnector(String urlConnection, String user, String password) {
        this.connector = new Connector(urlConnection, user, password);

        return this;
    }
    protected abstract AbstractRepository<T> prepareData(T obj);

    public ResultSet fetchAll() {
        try {
            String query = this.queryBuilder.getSelectQueryBuilder().getQuery();
            PreparedStatement ps = this.getConnection().prepareStatement(query);

            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getById(String id) {
        SelectQuery query = this.queryBuilder.getSelectQueryBuilder();
        query.setCondition(this._primaryKey, "=", id);

        try {
            PreparedStatement ps = this.getConnection().prepareStatement(query.getQuery());
            ps.setMaxRows(1);

            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(T obj) {
        this.prepareData(obj);

        try {
            String query = this.queryBuilder
                    .getInsertQueryBuilder()
                    .setInsertValue(this._fields)
                    .getQuery();

            PreparedStatement ps = this.getConnection().prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(List<T> listObject) {
        try {
            InsertQuery query = this.queryBuilder.getInsertQueryBuilder();

            for (T obj: listObject) {
                this.prepareData(obj);
                query.setInsertValue(this._fields);
            }

            PreparedStatement ps = this.getConnection().prepareStatement(query.getQuery());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String id) {
        try {
            DeleteQuery query = this.queryBuilder.getDeleteQueryBuilder();

            query.setCondition(this._primaryKey, "=", id);

            PreparedStatement ps = this.getConnection().prepareStatement(query.getQuery());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(T obj) {
        this.prepareData(obj);

        try {
            UpdateQuery query = this.queryBuilder
                    .getUpdateQueryBuilder()
                    .setUpdateValue(this._fields);

            query.setCondition(this._primaryKey, "=", this._fields.get(this._primaryKey));

            PreparedStatement ps = this.getConnection().prepareStatement(query.getQuery());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
