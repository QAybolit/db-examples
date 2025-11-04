package example.data;

import java.util.Arrays;

public enum Category {
    SHOP("Магазины"), FUEL("АЗС"), BAR("Бары"), FLOWER("Цветы");

    private final String description;

    Category(String name) {
        this.description = name;
    }

    public String getDescription() {
        return description;
    }

    public static Category findCategory(String description) {
        return Arrays.stream(values()).filter(value -> value.getDescription().equals(description))
                .findFirst()
                .orElseThrow();
    }
}
