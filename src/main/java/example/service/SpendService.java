package example.service;

import example.data.Category;
import example.db.AccountRepository;
import example.db.SpendRepository;
import example.db.impl.PostgresAccountRepository;
import example.db.impl.PostgresSpendRepository;
import example.entity.AccountEntity;
import example.entity.SpendEntity;

import javax.swing.*;
import java.util.Arrays;

public class SpendService {

    private SpendRepository spendRepository = new PostgresSpendRepository();
    private AccountRepository accountRepository = new PostgresAccountRepository();

    public void doSpend(AccountEntity account) {
        int index = JOptionPane.showOptionDialog(
                null,
                "Категория",
                "Выберите категорию траты",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Arrays.stream(Category.values()).map(Category::getDescription).toArray(String[]::new),
                Category.BAR.getDescription()
        );

        Category selected = Category.values()[index];
        int spendValue = Integer.parseInt(
                JOptionPane.showInputDialog("Введите размер траты")
        );
        String desc = JOptionPane.showInputDialog("Введите описание траты");

        if (isSpendAcceptedForGivenUser(account, spendValue)) {
            SpendEntity spend = new SpendEntity()
                    .setAccountId(account.getId())
                    .setCategory(selected)
                    .setSpend(spendValue)
                    .setDescription(desc);

            spendRepository.addSpend(spend);
            account.setValue(account.getValue() - spendValue);
            accountRepository.updateAccount(account);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Невозможно совершить списание",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void showAllSpends(AccountEntity account) {
        Object[][] rows = spendRepository.getAllForAccount(account).stream()
                .map(spend -> new Object[]{spend.getCategory().getDescription(), spend.getSpend(), spend.getDescription()})
                .toArray(Object[][]::new);

        Object[] headers = {"Категория", "Размер траты", "Описание траты"};
        JTable table = new JTable(rows, headers);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }

    private boolean isSpendAcceptedForGivenUser(AccountEntity givenUser, int spend) {
        if (spend <= 0 || givenUser.getValue() < spend) {
            return false;
        }
        return true;
    }
}
