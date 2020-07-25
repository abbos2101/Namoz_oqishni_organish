package abbos2101.namozoqishniorganish.ui.fragment.supcategory.view

import abbos2101.mvvmdemo.common.fromJsonObject
import abbos2101.mvvmdemo.common.getViewModel
import abbos2101.mvvmdemo.common.lazyFast
import abbos2101.namozoqishniorganish.databinding.FragmentSubCategoryBinding
import abbos2101.namozoqishniorganish.module.jsonSubItems
import abbos2101.namozoqishniorganish.ui.base.fragment.BaseFragmentFull
import abbos2101.namozoqishniorganish.ui.fragment.supcategory.presenter.SubCategoryPresenter
import abbos2101.namozoqishniorganish.ui.fragment.supcategory.viewmodel.SubCategoryViewModel
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class SubCategoryFragment :
    BaseFragmentFull<FragmentSubCategoryBinding, SubCategoryPresenter, SubCategoryViewModel>() {
    private val message by lazyFast { arguments?.getString("message") ?: "" }
    private val model: jsonSubItems? by lazyFast {
        if (message != "") message.fromJsonObject(
            jsonSubItems::class.java
        ) else null
    }
    private val adapter by lazyFast {
        SubCategoryAdapter(
            presenter
        )
    }

    override fun create() {
        init()
        layoutInflater
        initViewModel()
    }

    private fun init() {
        if (model != null) {
            binding.rv.adapter = adapter
            (activity as AppCompatActivity).supportActionBar?.title = model?.name
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            presenter.loadItems(model?.items ?: arrayListOf())
        }
    }

    private fun initViewModel() {
        viewModel.getList().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                viewModel.setListValue(null)
            }
        })
        viewModel.getPosition().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                val action = SubCategoryFragmentDirections.actionSubCategoryFragmentToContentFragment()
                    .setMessage("$message")
                    .setPosition(it)
                findNavController().navigate(action)
                viewModel.setPositionValue(null)
            }
        })
    }

    override fun setViewBinding(inflater: LayoutInflater) =
        FragmentSubCategoryBinding.inflate(inflater)

    override fun setPresenter() =
        SubCategoryPresenter(
            viewModel
        )
    override fun setViewModel() = activity?.getViewModel(SubCategoryViewModel::class.java)!!
}