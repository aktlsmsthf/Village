package ver0.village;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import ver0.village.utils.BaseActivity;

public class BorrowDetailActivity extends BaseActivity {

    Button urgentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_detail);
    }
}
