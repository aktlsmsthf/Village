package ver0.village.utils;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ver0.village.R;

public class BaseActivity extends AppCompatActivity{

    ImageView prevBtn;
    TextView screenTitleText;

    public void setPrevBtn(){
        prevBtn = findViewById(R.id.prevbtn);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void setScreenTitleText(String s){
        screenTitleText = findViewById(R.id.screenTitleText);
        screenTitleText.setText(s);
    }
}
