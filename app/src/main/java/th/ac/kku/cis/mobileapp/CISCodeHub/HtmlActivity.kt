package th.ac.kku.cis.mobileapp.CISCodeHub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import th.ac.kku.cis.mobileapp.CISCodeHub.Adapter.htmlAdapter
import th.ac.kku.cis.mobileapp.CISCodeHub.Model.Show


class HtmlActivity : AppCompatActivity() {

    private val TAG: String = "List Html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html)

    Firebase.database.reference.child("html").addValueEventListener(object : ValueEventListener{
        override fun onCancelled(p0: DatabaseError) {

        }

        override fun onDataChange(dataSnapshot: DataSnapshot) {


            val listView: ListView = findViewById(R.id.listView_html)
            val code_list = mutableListOf<Show>()
            for(postSnapshot in dataSnapshot.children){

                code_list.add(Show(postSnapshot.child("topic").getValue().toString()
                    ,postSnapshot.child("subtopic").getValue().toString()
                    ,postSnapshot.child("article").getValue().toString())
                )

            }


            listView.adapter = htmlAdapter(
                this@HtmlActivity,
                R.layout.activity_pattern,
                code_list

            )
            listView.setOnItemClickListener { parent, view, position, id ->
                val selectedItem = parent.getItemAtPosition(position) as Show

                val i = Intent(this@HtmlActivity,Pattern2Activity::class.java)
                i.putExtra("send_topic",selectedItem.topic)
                i.putExtra("send_subtopic",selectedItem.subtopic)
                i.putExtra("send_article",selectedItem.article)
                startActivity(i)

                //Toast.makeText(this@HtmlActivity, selectedItem.topic, Toast.LENGTH_SHORT).show()
            }





        }
    }


    )
    }


}
