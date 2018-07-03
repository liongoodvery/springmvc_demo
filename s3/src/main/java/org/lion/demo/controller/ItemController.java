package org.lion.demo.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.lion.demo.pojo.Items;
import org.lion.demo.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ItemController {
    Logger logger = Logger.getLogger(ItemController.class.getName());

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/itemList.action")
    public ModelAndView getAllItems() {
        ModelAndView modelAndView = new ModelAndView();
        List<Items> itemList = itemsService.getItemList();
        modelAndView.addObject("itemList", itemList);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    @RequestMapping("/itemEdit.action")
    public ModelAndView toEdit(Integer id,
                               HttpServletRequest request, HttpServletResponse response
            , HttpSession session, Model model) {
        Items item = itemsService.getItem(Integer.valueOf(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item", item);
        modelAndView.setViewName("editItem");
        return modelAndView;
    }

    @RequestMapping("/updateitem.action")
    public ModelAndView update(Items items) {
//        itemsService.update(items);
        logger.log(Level.INFO, ToStringBuilder.reflectionToString(items));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
