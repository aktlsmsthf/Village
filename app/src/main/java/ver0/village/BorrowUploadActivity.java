package ver0.village;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ver0.village.utils.BaseActivity;

public class BorrowUploadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_upload);

        setPrevBtn();
        setScreenTitleText("빌리기 글 작성");
    }
}
