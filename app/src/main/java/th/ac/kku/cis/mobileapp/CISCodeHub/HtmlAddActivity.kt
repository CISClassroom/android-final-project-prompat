package th.ac.kku.cis.mobileapp.CISCodeHub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_html_add.*
import th.ac.kku.cis.mobileapp.CISCodeHub.Model.Course

class HtmlAddActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html_add)

        save_add_html.setOnClickListener {
            saveData()
        }
    }


    private fun saveData(){

        val topic   = editText_topic_html.text.toString().trim()
        val subtopic = editText_sub_html.text.toString().trim()
        val article = editText_content_html.text.toString().trim()

        if (topic.isEmpty()){
            Toast.makeText(this,"Please enter your topic",Toast.LENGTH_LONG).show()
            return
        }
        if (subtopic.isEmpty()){
            Toast.makeText(this,"Please enter your Subtopic",Toast.LENGTH_LONG).show()
            return
        }
        if (article.isEmpty()){
            Toast.makeText(this,"Please enter your content",Toast.LENGTH_LONG).show()
            return
        }

        val myDataBase = FirebaseDatabase.getInstance().getReference("html")
        val id = myDataBase.push().key
        val course = Course(topic,subtopic,article)
        if (id != null) {
            myDataBase.child(id).setValue(course).addOnCompleteListener{
                Toast.makeText(this,"Saved :) ",Toast.LENGTH_LONG).show()
            }
        }
    }

}
