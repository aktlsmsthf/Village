package ver0.village.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


import ver0.village.BorrowUploadActivity;
import ver0.village.R;

public class UploadDialog {

    private Context context;
    TextView borrowUpload;
    TextView lendUpload;

    public UploadDialog(Context context) {
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction() {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_upload);

        dlg.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.dialog_upload));

        borrowUpload = dlg.findViewById(R.id.borrowUpload);
        lendUpload = dlg.findViewById(R.id.lendUpload);

        borrowUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BorrowUploadActivity.class);
                context.startActivity(intent);
            }
        });

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

    }
}
