package example.entity;

import example.data.Category;

public class SpendEntity {

    private int id;
    private int accountId;
    private Category category;
    private int spend;

    public int getId() {
        return id;
    }

    public SpendEntity setId(int id) {
        this.id = id;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public SpendEntity setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public SpendEntity setCategory(Category category) {
        this.category = category;
        return this;
    }

    public int getSpend() {
        return spend;
    }

    public SpendEntity setSpend(int spend) {
        this.spend = spend;
        return this;
    }
}
