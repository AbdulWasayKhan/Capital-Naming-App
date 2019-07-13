package ca.yorku.eecs.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB db;


    public Game()
    {
        this.db = new CountryDB();
    }

    public String qa()
    {
        /*list of Capital names accessor already in CountryDb db. 1). Reference to the database's capital city list.*/
        List<String> capitals = db.getCapitals();
        /*Size of the list. Calling it n.*/
        int n = capitals.size();
        /*Generated a random number in[0,n). Calling the variable as index.*/
        int index = (int) (n * Math.random());
        /*Invoking get(index) on the list to get a random capital city. Calling it c*/
        String c = capitals.get(index);
        /*Get a reference to the database's data map.*/
        Map<String, Country> data = db.getData();
//        System.out.println(data.size());
        Country ref = data.get(c);
//        System.out.println(ref.toString());

        String ques;
        if(Math.random() < 0.5)
        {
            ques =  String.format("What is the capital of %s?\n%s", ref.getName(), ref.getCapital());

        }
        else
        {
            ques = String.format("%s is the capital of ?\n%s", ref.getCapital(), ref.getName());

        }
        return  ques;

    }

}
