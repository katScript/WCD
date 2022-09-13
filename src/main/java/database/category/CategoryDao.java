package database.category;

import database.dao.DaoInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao implements DaoInterface<Category> {

    private CategoryRepository categoryRepository;

    public CategoryDao() {
        this.categoryRepository = new CategoryRepository();
    }

    @Override
    public Optional<Category> get(long id) {
        ResultSet rs = this.categoryRepository.getById(Long.toString(id));

        try {
            Category category = null;

            if (rs.next()) {
                category = new Category(
                        rs.getInt("id"),
                        rs.getString("cat_name"),
                        rs.getString("cat_description")
                );
            }

            return Optional.ofNullable(category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> getAll() throws SQLException {
        ResultSet rs = this.categoryRepository.fetchAll();
        List<Category> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new Category(
                rs.getInt("id"),
                rs.getString("cat_name"),
                rs.getString("cat_description")
            ));
        }

        return list;
    }

    @Override
    public void save(Category category) {
        if (category.getId() == null)
            this.categoryRepository.insert(category);
        else
            this.categoryRepository.update(category);
    }

    @Override
    public void delete(Category category) {
        this.categoryRepository.delete(Integer.toString(category.getId()));
    }
}
