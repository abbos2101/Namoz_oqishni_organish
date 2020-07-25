package abbos2101.namozoqishniorganish.ui.activity

import abbos2101.example.terrabayt.ui.base.BaseActivity
import abbos2101.namozoqishniorganish.databinding.ActivityMainBinding
import android.view.LayoutInflater

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun create() {
        supportActionBar?.show()
    }

    override fun setViewBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(inflater)
}