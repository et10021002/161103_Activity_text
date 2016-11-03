package tw.com.a4040e009.a161103_activity_text;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText ethomework,etexam,etnote,ettext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    private void findviews(){
        ethomework = (EditText)findViewById(R.id.ethomework);
        etexam = (EditText)findViewById(R.id.etexam);
        etnote = (EditText)findViewById(R.id.etnote);
        ettext = (EditText)findViewById(R.id.ettext);
    }

    private boolean isValid(EditText editText) {
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();
        if (!text.matches(pattern)) {
            editText.setError("0 ~ 100");
            return false;
        } else {
            return true;
        }
    }

    public void onSubmit(View view){
        // use "&" not "&&" because even the first isValid() return false,
        // the second isValid() will still be called
        boolean isValid =
                isValid(ethomework) & isValid(etexam) & isValid(etnote)& isValid(ettext);
        if (!isValid) {
            return;
        }
        int homework = Integer.parseInt(ethomework.getText().toString());
        int exam = Integer.parseInt(etexam.getText().toString());
        int note = Integer.parseInt(etnote.getText().toString());
        int text = Integer.parseInt(ettext.getText().toString());
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("homework", homework);
        bundle.putInt("exam", exam);
        bundle.putInt("note", note);
        bundle.putInt("text", text);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
