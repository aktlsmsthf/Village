package ver0.village;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ver0.village.utils.BaseActivity;

public class BorrowDetailActivity extends BaseActivity {

    Button urgentBtn;
    TextView titleText;
    TextView priceText;
    ImageView profileImage;
    TextView nameText;
    TextView belongText;
    TextView rankText;
    TextView detailText;
    TextView contactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_detail);

        urgentBtn = findViewById(R.id.urgentBtn);
        titleText = findViewById(R.id.titleText);
        priceText = findViewById(R.id.priceText);
        profileImage = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        belongText = findViewById(R.id.belongText);
        rankText = findViewById(R.id.rankText);
        detailText = findViewById(R.id.detailText);
        contactBtn = findViewById(R.id.contactBtn);

        setPrevBtn();
        setScreenTitleText(getString(R.string.borrowTitle));

        profileImage.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            profileImage.setClipToOutline(true);
        }
    }
}
