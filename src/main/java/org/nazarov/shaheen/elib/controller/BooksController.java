package org.nazarov.shaheen.elib.controller;

import org.nazarov.shaheen.elib.model.CategoryModel;
import org.nazarov.shaheen.elib.mybatis.domain.Book;
import org.nazarov.shaheen.elib.mybatis.domain.Category;
import org.nazarov.shaheen.elib.mybatis.mapper.BookMapper;
import org.nazarov.shaheen.elib.mybatis.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Shahin on 5/21/2017.
 */
@Controller
public class BooksController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(value={"/books"}, method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books" , bookMapper.listWithLimit(12));
        modelAndView.addObject("reccomenadations" , bookMapper.listView(4));
        modelAndView.setViewName("books");
        return modelAndView;
    }

    @RequestMapping(value={"/books/{id}"}, method = RequestMethod.GET)
    public ModelAndView bookAbout(@PathVariable(value = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookMapper.getBook(id);
        modelAndView.addObject("book" , book);
        modelAndView.setViewName("books");
        return modelAndView;
    }

}
