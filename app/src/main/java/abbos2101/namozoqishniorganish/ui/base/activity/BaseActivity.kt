package abbos2101.example.terrabayt.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB

    abstract fun create()
    abstract fun setViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setViewBinding(layoutInflater)
        setContentView(binding.root)
        create()
    }

    fun logSnackbar(text: String) {
        Snackbar.make(this.window.decorView.rootView, text, Snackbar.LENGTH_LONG).show()
    }

    fun logToast(text: String) {
        Toast.makeText(this, "$text", Toast.LENGTH_SHORT).show()
    }

    fun logLog(text: String, tag: String = "myTAG") {
        Log.d("myTAG", "$text")
    }
}