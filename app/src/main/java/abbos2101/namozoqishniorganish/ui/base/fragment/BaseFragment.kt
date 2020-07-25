package abbos2101.namozoqishniorganish.ui.base.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected lateinit var binding: VB

    abstract fun create()
    abstract fun setViewBinding(inflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setViewBinding(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        create()
    }

    fun logSnackbar(text: String) {
        Snackbar.make(activity?.window?.decorView?.rootView!!, text, Snackbar.LENGTH_LONG).show()
    }

    fun logToast(text: String) {
        Toast.makeText(activity, "$text", Toast.LENGTH_SHORT).show()
    }

    fun logLog(text: String, tag: String = "myTAG") {
        Log.d("myTAG", "$text")
    }
}