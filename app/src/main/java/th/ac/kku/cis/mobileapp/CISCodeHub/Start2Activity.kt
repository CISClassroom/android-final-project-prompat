package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start2.*

class Start2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start2)

        btn_next1.setOnClickListener{ startActivity(Intent(this@Start2Activity, Start3Activity::class.java))}
        btn_skip.setOnClickListener{ startActivity(Intent(this@Start2Activity, MainActivity::class.java))}
    }
}
