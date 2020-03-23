package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? =null
    private val TAG: String = "Admin Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        mAuth = FirebaseAuth.getInstance()
        btn_add_python.setOnClickListener{ startActivity(Intent(this@AdminActivity, PythonAddActivity::class.java))}
        btn_add_html.setOnClickListener{ startActivity(Intent(this@AdminActivity, HtmlAddActivity::class.java))}
        btn_add_ja.setOnClickListener{ startActivity(Intent(this@AdminActivity, JavaAddActivity::class.java))}
        btn_add_kotlin.setOnClickListener{ startActivity(Intent(this@AdminActivity, KotlinAddActivity::class.java))}
        btn_signOut_admin.setOnClickListener(){
            mAuth!!.signOut()
            Toast.makeText(this,"Signed Out", Toast.LENGTH_LONG).show()
            Log.d(TAG,"Signed Out")
            startActivity(Intent(this@AdminActivity, MainActivity::class.java))
            finish()
        }
    }
}
