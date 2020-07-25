package abbos2101.example.terrabayt.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivityFull<VB : ViewBinding, P : BasePresenter, VM : BaseViewModel> :
    AppCompatActivity() {
    protected lateinit var binding: VB
    protected lateinit var presenter: P
    protected lateinit var viewModel: VM

    abstract fun create()
    abstract fun setViewBinding(inflater: LayoutInflater): VB
    abstract fun setViewModel(): VM
    abstract fun setPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setViewBinding(layoutInflater)
        viewModel = setViewModel()
        presenter = setPresenter()
        setContentView(binding.root)
        create()
    }

    fun <T : ViewModel> getViewModel(type: Class<T>) =
        ViewModelProviders.of(this).get(type)

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