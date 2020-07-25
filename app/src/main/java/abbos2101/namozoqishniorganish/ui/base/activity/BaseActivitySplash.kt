package abbos2101.namozoqishniorganish.ui.base.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseActivitySplash<VB : ViewBinding>() :
    AppCompatActivity(), CoroutineScope {
    protected val mainJob by lazy { Job() }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + mainJob
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setViewBinding(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        create()
        launch {
            delay(setStartTime())
            finish()
            startActivity(setStartIntent())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainJob.cancel()
    }

    open fun create() {}
    abstract fun setStartIntent(): Intent
    abstract fun setStartTime(): Long
    abstract fun setViewBinding(inflater: LayoutInflater): VB
}