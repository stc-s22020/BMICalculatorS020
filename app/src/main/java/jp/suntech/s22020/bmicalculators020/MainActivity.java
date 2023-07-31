package jp.suntech.s22020.bmicalculators020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloListener listener = new HelloListener();

        Button btColc = findViewById(R.id.btcolc);
        btColc.setOnClickListener(listener);

        Button btclear = findViewById(R.id.clear);
        btclear.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
        EditText age = findViewById(R.id.et_Age);
        EditText height = findViewById(R.id.et_height);
        EditText weight = findViewById(R.id.et_weight);
        TextView result1 = findViewById(R.id.result1);
        TextView result2 = findViewById(R.id.result2);
        TextView result3 = findViewById(R.id.result3);
        TextView result4 = findViewById(R.id.result4);
        TextView result5 = findViewById(R.id.result5);

        String age_st = age.getText().toString();
        String height_st = height.getText().toString();
        String weight_st = weight.getText().toString();

            double age_d = Double.parseDouble(age_st);
           double weight_d = Double.parseDouble(weight_st);
            double height_d = Double.parseDouble(height_st);
            int id = v.getId();
            String hanntei ;
            double tekisei;
            ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();

            double height_dou = height_d/100;
            double BMI = weight_d/(height_dou*height_dou);
            tekisei = height_dou*height_dou*22;
            if(BMI >=40){
                hanntei="肥満（4度）";
            } else if (BMI>=35) {
                hanntei="肥満（3度）";
            } else if (BMI>=30) {
                hanntei="肥満（2度）";
            } else if (BMI >=25) {
                hanntei="肥満（1度）";
            } else if (BMI>=18.5) {
                hanntei="普通体重";
            }else{
                hanntei="低体重";
            }

            if(id == R.id.btcolc){
               result1.setText("あなたの肥満度は");
               result2.setText(hanntei);
               result3.setText("あなたの適正体重は");
               result4.setText(String.format("%.1f",tekisei));
               result5.setText("kg");
              if(age_d <16)
                dialogFragment.show(getSupportFragmentManager(), "ConfirmDialogFragment");
            }
            if(id == R.id.clear){
                age.setText("");
                height.setText("");
                weight.setText("");
                result1.setText("");
                result2.setText("");
                result3.setText("");
                result4.setText("");
                result5.setText("");

            }
        }
    }
}