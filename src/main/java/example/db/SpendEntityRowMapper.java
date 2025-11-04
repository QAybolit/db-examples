package example.db;

import example.data.Category;
import example.entity.SpendEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpendEntityRowMapper implements RowMapper<SpendEntity> {

    @Override
    public SpendEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SpendEntity()
                .setId(rs.getInt("id"))
                .setAccountId(rs.getInt("account_id"))
                .setCategory(Category.valueOf(rs.getString("spend_category")))
                .setSpend(rs.getInt("spend"))
                .setDescription(rs.getString("description"));
    }
}
