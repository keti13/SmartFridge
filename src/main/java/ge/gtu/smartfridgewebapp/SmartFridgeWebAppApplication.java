package ge.gtu.smartfridgewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@SpringBootApplication
public class SmartFridgeWebAppApplication {

    public static ArrayList<String> getFoodNames() {
        ArrayList<String> names = null;
//status
        try {
            Connection conn = null;
            String url = "jdbc:mysql://127.0.0.1:3306/SmartFridge";
            String name = "root";
            String pass = "keti13";
            conn = DriverManager.getConnection(url, name, pass);
            Statement statement = conn.createStatement();
            names = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select food.name from Food");
            while (resultSet.next()) {
                String productName = resultSet.getString("name");
                names.add(productName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return names;
    }


    public static ArrayList<String> getRecipe(){
        ArrayList<String> recipes = new ArrayList<>();
        recipes.add("Pancakes-Whisk the eggs and milk together to combine. Add in the flour, and beat until the butter is smooth and lump free. Add in any option add-ins you like here" +
                "Heat a nonstick pan over low-medium heat with cooking oil spray. Wipe over excess; pour about 1/3 cup of butter per pancake. " +
                "Cook pancakes for 1 to 2 minutes, or until bubbles appear on the surface and the bases are golden brown. " +
                "Flip and cook until golden; transfer to a warmed plate; repeat with remaining batter " +
                "(spraying/greasing pan between ever second or third pancake if needed)." +
                "Serve immediately with yoghurt, ice cream, whipped cream, maple syrup, berries, or any other toppings you like.");
        recipes.add("Vegetable Salad-Toss together the cucumber, tomato, onion, pepper, radish, jicama, and lettuce in a large salad bowl." +
                " Whisk together the garlic, lemon juice, olive oil, pomegranate juice, salt, pepper, dill, basil, " +
                "and water in a small bowl. Drizzle dressing over the salad just before serving.");
        return recipes;
    }

    public static void main(String[] args) {
        SpringApplication.run(SmartFridgeWebAppApplication.class, args);

        ArrayList<String> foodNames = getFoodNames();
        ArrayList<String> recipe = getRecipe();
        int numOfIngredients = 0;
        String recipeName = "";
        for(int i = 0; i < recipe.size(); i++){
            for(int j = 0; j < foodNames.size(); j++){
                if(recipe.get(i).contains(foodNames.get(j))){
                    numOfIngredients++;
                }
            }
            if(numOfIngredients >= 3){
                String[] split = new String[]{};
                split = recipe.get(i).split("-", 2);
                recipeName += split[0] + ",";
                numOfIngredients = 0;
            }
        }
        System.out.println("You can make " + recipeName + " using the ingredients you have");
    }
}
