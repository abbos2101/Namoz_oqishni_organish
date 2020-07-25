package abbos2101.example.terrabayt.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter : CoroutineScope {
    val mainJob by lazy { Job() }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + mainJob

}