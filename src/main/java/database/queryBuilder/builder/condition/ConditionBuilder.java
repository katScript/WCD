package database.queryBuilder.builder.condition;

import java.util.ArrayList;
import java.util.List;

public class ConditionBuilder {
    protected String condition = "";
    protected List<String> order = new ArrayList<>();

    public ConditionBuilder init(String col, String con, String val) {
        this.condition = "WHERE " + col + " " + con + " '" + val + "' ";

        return this;
    }

    protected ConditionBuilder addCondition(String col, String con, String val, String cat) {
        this.condition += cat + " " + col + " " + con + " '" + val + "' ";

        return this;
    }

    public ConditionBuilder and(String col, String con, String val) {
        return this.addCondition(col, con, val, "AND");
    }

    public ConditionBuilder or(String col, String con, String val) {
        return this.addCondition(col, con, val, "OR");
    }

    public ConditionBuilder order(String col) {
        this.order.add(col);

        return this;
    }

    public ConditionBuilder order(String col, String order) {
        this.order.add(col + " " + order);

        return this;
    }

    public String getCondition() {
        if (this.order.size() > 0)
            this.condition += " ORDER BY " + String.join(", ", this.order);

        return this.condition;
    }
}
