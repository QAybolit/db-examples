package example.db;

import example.entity.AccountEntity;
import example.entity.SpendEntity;

import java.util.List;

public interface SpendRepository {

     List<SpendEntity> getAllForAccount(AccountEntity account);

     void addSpend(SpendEntity spend);
}
