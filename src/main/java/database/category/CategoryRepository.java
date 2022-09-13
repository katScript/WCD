package database.category;


import database.connection.AbstractRepository;
import database.queryBuilder.builder.UpdateQuery;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepository extends AbstractRepository<Category> {

    public CategoryRepository() {
        super("tblcategory", "id",
                new String[] {"id", "cat_name", "cat_description"}
        );
    }

    @Override
    protected AbstractRepository prepareData(Category obj) {
        if (obj.getId() != null) {
            this._fields.put(this._primaryKey, String.valueOf(obj.getId()));
        } else {
            this._fields.remove(this._primaryKey);
        }

        this._fields.put("cat_name", obj.getName());
        this._fields.put("cat_description", obj.getDescription());

        return this;
    }
}
