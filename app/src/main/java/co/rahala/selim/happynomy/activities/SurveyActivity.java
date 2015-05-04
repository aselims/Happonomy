package co.rahala.selim.happynomy.activities;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.List;

import co.rahala.selim.happynomy.R;
import co.rahala.selim.happynomy.model.Survey;
import co.rahala.selim.happynomy.utility.Data;


public class SurveyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        final ListView surveyList = (ListView) findViewById(R.id.survey_list);
        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();

        surveyList.setAdapter(new SurveyAdapter(this, Data.SURVEYS, settings));

        surveyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Survey s = (Survey) surveyList.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(), s.getQuestion(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class SurveyAdapter extends BaseFlipAdapter<Survey> {

        private final int PAGES = 3;

        public SurveyAdapter(Context context, List<Survey> items, FlipSettings settings) {
            super(context, items, settings);
        }

        @Override
        public View getPage(int i, View view, ViewGroup viewGroup, Survey survey, Survey survey2) {
            final SurveyHolder holder;
            if (view == null) {
                holder = new SurveyHolder();
                view = getLayoutInflater().inflate(R.layout.row, viewGroup, false);
                holder.image1 = (ImageView) view.findViewById(R.id.iv_icon1);
                holder.image2 = (ImageView) view.findViewById(R.id.iv_icon2);
                holder.info = getLayoutInflater().inflate(R.layout.question_info, viewGroup, false);
                holder.question = (TextView) holder.info.findViewById(R.id.question1);

                view.setTag(holder);
            }
            else{
                holder = (SurveyHolder) view.getTag();
            }

            switch (i){
                case 1:
                    holder.image1.setImageResource(survey.getImage());
                    if (survey2 != null)
                        holder.image2.setImageResource(survey2.getImage());
                    break;
                default:
                    fillHoder(holder, i == 0 ? survey : survey2);
                    holder.info.setTag(holder);
                    return holder.info;
            }
            return view;
        }


        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHoder(SurveyHolder holder, Survey survey) {
            if (survey == null) {
                return;
            }
            holder.question.setText(survey.getQuestion());
        }

        class SurveyHolder {
            ImageView image1;
            ImageView image2;
            View info;
            TextView question;
            ImageView answer1;
            ImageView answer2;
            ImageView answer3;

        }
    }


}



