import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codehafeez.flavoursex1.R
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.app_title)
    }
}