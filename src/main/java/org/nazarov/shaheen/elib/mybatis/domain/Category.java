package org.nazarov.shaheen.elib.mybatis.domain;

/**
 * Created by Shahin on 5/17/2017.
 */
public class Category {

    private int id;
    private String name;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
