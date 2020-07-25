package abbos2101.namozoqishniorganish.ui.activity

import abbos2101.namozoqishniorganish.databinding.ActivitySplashBinding
import abbos2101.namozoqishniorganish.ui.base.activity.BaseActivitySplash
import android.content.Intent
import android.view.LayoutInflater

class SplashActivity : BaseActivitySplash<ActivitySplashBinding>() {
    override fun setStartIntent() = Intent(this, MainActivity::class.java)
    override fun setStartTime(): Long = 2000
    override fun setViewBinding(inflater: LayoutInflater) = ActivitySplashBinding.inflate(inflater)
}