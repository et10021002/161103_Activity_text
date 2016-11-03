package tw.com.a4040e009.a161103_activity_text;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = (TextView) findViewById(R.id.result);
        showResults();
    }

    private void showResults() {
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int homework = bundle.getInt("homework");
        int exam = bundle.getInt("exam");
        int note = bundle.getInt("note");
        int text = bundle.getInt("text");
        int sum = homework + exam + note + text;
        double average = sum / 4.0;
        String output = "平常作業成績 = " + homework +
                "\n平常小考成績 = " + exam +
                "\n平常筆記成績 = " + note +
                "\n期中考成績 = " + text +
                "\n總分 = " + sum +
                "\n平均 = " + nf.format(average);
        result.setText(output);
    }

    public void onBack(View view){
        finish();
    }
}
