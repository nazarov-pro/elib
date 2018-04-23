package org.nazarov.shaheen.elib.mybatis.domain;

/**
 * Created by Shahin on 5/18/2017.
 */
public class CategoryBook {

    private int categoryId;
    private int bookId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
