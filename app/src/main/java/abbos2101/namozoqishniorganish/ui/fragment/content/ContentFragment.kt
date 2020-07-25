package abbos2101.namozoqishniorganish.ui.fragment.content

import abbos2101.mvvmdemo.common.fromJsonObject
import abbos2101.mvvmdemo.common.lazyFast
import abbos2101.mvvmdemo.common.setVisible
import abbos2101.namozoqishniorganish.databinding.FragmentContentBinding
import abbos2101.namozoqishniorganish.module.jsonSubItems
import abbos2101.namozoqishniorganish.ui.base.fragment.BaseFragment
import android.view.LayoutInflater
import android.webkit.WebViewClient

class ContentFragment :
    BaseFragment<FragmentContentBinding>() {

    private val message by lazyFast { arguments?.getString("message") ?: "" }
    var pageId = 0

    private val model: jsonSubItems? by lazyFast {
        if (message != "") message.fromJsonObject(
            jsonSubItems::class.java
        ) else null
    }

    override fun create() {
        init()
        setEvent()
    }

    private fun init() {
        if (model != null) {
            pageId = arguments?.getInt("position") ?: 0
            if (model?.items?.size == 1) binding.llBottom.setVisible(false)
            loadWebViewByPageId(pageId)
        }
    }

    private fun setEvent() {
        binding.imgLeft.setOnClickListener {
            if (pageId != 0)
                pageId--
            loadWebViewByPageId(pageId)
        }
        binding.imgRight.setOnClickListener {
            if (pageId < model!!.items.size - 1)
                pageId++
            loadWebViewByPageId(pageId)
        }
    }

    private fun loadWebViewByPageId(position: Int) {
        binding.wb.webViewClient = WebViewClient()
        binding.wb.settings.allowFileAccess = true
        binding.wb.settings.allowContentAccess = true
        binding.wb.settings.javaScriptEnabled = true

        binding.wb.loadDataWithBaseURL(null, model!!.items[position], "text/html", "utf-8", null)
        binding.tv.text = "${pageId + 1}/${model!!.items.size}"
    }

    override fun setViewBinding(inflater: LayoutInflater) = FragmentContentBinding.inflate(inflater)
}