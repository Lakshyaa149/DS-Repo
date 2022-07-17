import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RecipesAndIngredients {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, ArrayList<Integer>> mapOfIngredientsToRecipe=new HashMap<>();
        int recipeToIngredientsCount[]=new int[recipes.length];
        for(int i=0;i<ingredients.size();i++){
            for(String ingredient:ingredients.get(i)){

                if(mapOfIngredientsToRecipe.containsKey(ingredient)){
                    ArrayList<Integer> al=mapOfIngredientsToRecipe.get(ingredient);
                    al.add(i);
                    mapOfIngredientsToRecipe.put(ingredient,al);
                }
                else{
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(i);
                    mapOfIngredientsToRecipe.put(ingredient,list);
                }
            }
            recipeToIngredientsCount[i]=ingredients.get(i).size();
        }

        Queue<String> queue=new LinkedList<>();
        queue.addAll(Arrays.asList(supplies));
        ArrayList<String> result=new ArrayList<>();

        while (!queue.isEmpty()){
           String supply=queue.poll();
            if(!mapOfIngredientsToRecipe.containsKey(supply)){
                continue;
            }
            for(Integer recipe:mapOfIngredientsToRecipe.get(supply)){
                recipeToIngredientsCount[recipe]--;
                if(recipeToIngredientsCount[recipe]==0){
                    queue.add(recipes[recipe]);
                    result.add(recipes[recipe]);
                }
            }
        }

        return  result;
    }
}
