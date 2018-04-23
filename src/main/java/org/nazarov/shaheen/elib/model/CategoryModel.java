package org.nazarov.shaheen.elib.model;

import org.nazarov.shaheen.elib.mybatis.domain.Category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shahin on 5/18/2017.
 */
public class CategoryModel {

    private int id;
    private String name;
    private Set<Category> categories;

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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public static List<CategoryModel> convertCategoryModel(List<Category> categories){
        List<CategoryModel> categoryModels = new ArrayList<>();
        for(Category category : categories){
            if(category.getCategoryId() == 0){
                CategoryModel categoryModel = new CategoryModel();
                Set<Category> categories1 = new HashSet<>();
                categoryModel.setId(category.getId());
                categoryModel.setName(category.getName());
                for (Category category2 : categories){
                    if(category2.getCategoryId() == category.getId()){
                        categories1.add(category2);
                    }
                }
                categoryModel.setCategories(categories1);
                categoryModels.add(categoryModel);
            }
        }
        return categoryModels;
    }
}
