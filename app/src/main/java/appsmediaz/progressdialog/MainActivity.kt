package appsmediaz.progressdialog

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.progressdialog.ProgressDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btShowProgressBar.setOnClickListener(View.OnClickListener {
            progressDialog = ProgressDialog.show(this, "Loading...", true);
        })
    }
}
