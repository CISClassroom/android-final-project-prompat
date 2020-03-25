package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start1.*

class Start1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start1)

        btn_next1.setOnClickListener{ startActivity(Intent(this@Start1Activity, Start2Activity::class.java))}
        btn_skip.setOnClickListener{ startActivity(Intent(this@Start1Activity, MainActivity::class.java))}
    }
}
