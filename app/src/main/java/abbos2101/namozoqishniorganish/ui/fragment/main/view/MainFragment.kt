package abbos2101.namozoqishniorganish.ui.fragment.main.view

import abbos2101.mvvmdemo.common.getViewModel
import abbos2101.mvvmdemo.common.lazyFast
import abbos2101.mvvmdemo.common.toJsonString
import abbos2101.namozoqishniorganish.R
import abbos2101.namozoqishniorganish.databinding.FragmentMainBinding
import abbos2101.namozoqishniorganish.ui.base.fragment.BaseFragmentFull
import abbos2101.namozoqishniorganish.ui.fragment.main.presenter.MainPresenter
import abbos2101.namozoqishniorganish.ui.fragment.main.viewmodel.MainViewModel
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class MainFragment : BaseFragmentFull<FragmentMainBinding, MainPresenter, MainViewModel>() {
    private val adapter by lazyFast {
        MainAdapter(
            presenter
        )
    }

    override fun create() {
        init()
        initViewModel()
    }

    private fun init() {
        (activity as AppCompatActivity).supportActionBar?.title =
            "${activity?.resources?.getString(R.string.app_name)}"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding.rv.adapter = adapter
        presenter.loadList()
    }

    private fun initViewModel() {
        viewModel.getList().observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                viewModel.setListValue(null)
            }
        })
        viewModel.getCategory().observe(this, Observer {
            if (it != null) {
                val action =
                    MainFragmentDirections.actionMainFragmentToCategoryFragment()
                action.message = "${it.toJsonString()}"
                findNavController().navigate(action)
                viewModel.setCategoryValue(null)
            }
        })
    }

    override fun setViewBinding(inflater: LayoutInflater) = FragmentMainBinding.inflate(inflater)
    override fun setPresenter() =
        MainPresenter(
            viewModel
        )

    override fun setViewModel() = activity?.getViewModel(MainViewModel::class.java)!!
}