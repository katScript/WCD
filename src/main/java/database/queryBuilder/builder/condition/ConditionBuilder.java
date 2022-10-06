package database.queryBuilder.builder.condition;

import java.util.ArrayList;
import java.util.List;

public class ConditionBuilder {
    protected String condition = "";
    protected List<String> order = new ArrayList<>();

    protected List<Object> _data = new ArrayList<>();

    public ConditionBuilder init(String col, String con, Object val) {
        this._data.clear();
        this.condition = "WHERE ? ? ? ";
        this._data.add(col);
        this._data.add(con);
        this._data.add(val);

        return this;
    }

    protected ConditionBuilder addCondition(String col, String con, Object val, String cat) {
        this.condition += cat + " ? ? ? ";
        this._data.add(col);
        this._data.add(con);
        this._data.add(val);

        return this;
    }

    public ConditionBuilder and(String col, String con, Object val) {
        return this.addCondition(col, con, val, "AND");
    }

    public ConditionBuilder or(String col, String con, Object val) {
        return this.addCondition(col, con, val, "OR");
    }

    public ConditionBuilder order(String col) {
        this.order.add("?");
        this._data.add(col);

        return this;
    }

    public ConditionBuilder order(String col, String order) {
        this.order.add("? " + order);
        this._data.add(col);
        this._data.add(order);

        return this;
    }

    public String getCondition() {
        if (this.order.size() > 0)
            this.condition += " ORDER BY " + String.join(", ", this.order);

        return this.condition;
    }

    public List<Object> getDataField() {
        return this._data;
    }
}
