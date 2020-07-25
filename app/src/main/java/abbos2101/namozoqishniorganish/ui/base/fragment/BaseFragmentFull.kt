package abbos2101.namozoqishniorganish.ui.base.fragment

import abbos2101.example.terrabayt.ui.base.BasePresenter
import abbos2101.example.terrabayt.ui.base.BaseViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragmentFull<VB : ViewBinding, P : BasePresenter, VM : BaseViewModel> :
    Fragment() {
    protected lateinit var binding: VB
    protected lateinit var presenter: P
    protected lateinit var viewModel: VM

    abstract fun create()
    abstract fun setViewBinding(inflater: LayoutInflater): VB
    abstract fun setViewModel(): VM
    abstract fun setPresenter(): P

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setViewBinding(layoutInflater)
        viewModel = setViewModel()
        presenter = setPresenter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        create()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            activity?.onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    fun <T : ViewModel> getViewModel(type: Class<T>) =
        ViewModelProviders.of(this).get(type)

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