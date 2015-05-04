package co.rahala.selim.happynomy.utility;

import java.util.ArrayList;
import java.util.List;

import co.rahala.selim.happynomy.R;
import co.rahala.selim.happynomy.model.Survey;

/**
 * Created by aselims on 02/05/15.
 */
public class Data {

    public static final List<Survey> SURVEYS = new ArrayList<>();

    static {



        SURVEYS.add(new Survey(R.drawable.appreciation, "Do you feel appreciated by the organisation?"));
        SURVEYS.add(new Survey(R.drawable.role, "Do you fully understand your role in the organisation?"));

        SURVEYS.add(new Survey(R.drawable.friends, "Do you have a friend at the workplace?"));
        SURVEYS.add(new Survey(R.drawable.illness, "Did you ever have to come to work when you were ill when you preferred to stay home? "));
        SURVEYS.add(new Survey(R.drawable.salary, "Do think your salary is sufficient to provide a decent life?"));
        SURVEYS.add(new Survey(R.drawable.selfdevelopment, "Do you feel appreciated by the organisation?"));

    }
}
