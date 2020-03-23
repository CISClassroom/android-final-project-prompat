package th.ac.kku.cis.mobileapp.CISCodeHub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pattern2.*

class Pattern2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pattern2)

        val i = intent
        var get_topic = i.getStringExtra("send_topic")
        var get_subtopic = i.getStringExtra("send_subtopic")
        var get_article = i.getStringExtra("send_article")

        txt_show_topic.text = get_topic
        txt_show_subtopic.text = get_subtopic
        txt_show_article.text =get_article
        btn_back_menu.setOnClickListener { onBackPressed() }
    }
}
