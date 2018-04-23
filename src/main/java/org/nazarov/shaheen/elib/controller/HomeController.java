package org.nazarov.shaheen.elib.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.nazarov.shaheen.elib.model.CategoryModel;
import org.nazarov.shaheen.elib.mybatis.domain.Category;
import org.nazarov.shaheen.elib.mybatis.domain.Feedback;
import org.nazarov.shaheen.elib.mybatis.mapper.BookMapper;
import org.nazarov.shaheen.elib.mybatis.mapper.CategoryMapper;
import org.nazarov.shaheen.elib.mybatis.mapper.FeedbackMapper;
import org.nazarov.shaheen.elib.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by Shahin on 5/18/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;

    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView index(Principal principal){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories = categoryMapper.list();
        modelAndView.addObject("categories" , CategoryModel.convertCategoryModel(categories));
        if(principal != null ) modelAndView.addObject("user" ,userMapper.findUserByEmail(principal.getName()));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/contact" , method = RequestMethod.POST)
    @ResponseBody
    public String sendFeedback(@Valid Feedback feedback,@RequestParam String name, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getErrorCount());
            return "You has an error.";
        } else {
            System.out.println("nn"+feedback.getName());
            System.out.println(name);
            System.out.println(feedback.getMessage());
            feedbackMapper.save(feedback);
            return "Ok";
        }
    }


}
