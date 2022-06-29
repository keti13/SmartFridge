package ge.gtu.smartfridgewebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {
    @Autowired private FoodService service;

    @GetMapping("/foods")
    public String showFoodList(Model model){
        List<Food> listFoods = (List<Food>) service.listAll();
        model.addAttribute("listFoods", listFoods);

        return "foods";
    }

    @GetMapping("/foods/delete/{id}")
    public String deleteFood(@PathVariable("id") int id) throws Exception {
        service.delete(id);
        return "redirect:/foods";
    }
}
