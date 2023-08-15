package com.codehafeez.cropimage
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yalantis.ucrop.UCrop
import java.io.File
class MainActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            openImagePicker()
        }
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            val imageUri = data?.data
            imageUri?.let { startCropActivity(it) }
        } else if (requestCode == UCrop.REQUEST_CROP && resultCode == Activity.RESULT_OK) {
            val resultUri: Uri? = UCrop.getOutput(data!!)
        } else if (resultCode == UCrop.RESULT_ERROR) {
            val cropError: Throwable? = UCrop.getError(data!!)
        }
    }

    private fun startCropActivity(sourceUri: Uri) {
        val destinationUri: Uri = Uri.fromFile(createTempFile()) // Destination URI for the cropped image
        val maxWidth = 800 // Maximum width of the cropped image
        val maxHeight = 800 // Maximum height of the cropped image

        UCrop.of(sourceUri, destinationUri)
            .withAspectRatio(1f, 1f) // Set the aspect ratio (optional)
            .withMaxResultSize(maxWidth, maxHeight) // Set the maximum result size (optional)
            .start(this)
    }

    private fun createTempFile(): File {
        val tempFileName = "temp_cropped_image.jpg"
        val tempDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File(tempDir, tempFileName)
    }
}
