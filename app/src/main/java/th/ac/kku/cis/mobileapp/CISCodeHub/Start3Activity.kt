package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start3.*

class Start3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start3)

        btn_next1.setOnClickListener{ startActivity(Intent(this@Start3Activity, MainActivity::class.java))}
    }
}
