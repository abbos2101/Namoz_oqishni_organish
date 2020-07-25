package abbos2101.namozoqishniorganish.ui.fragment.supcategory.viewmodel

import abbos2101.example.terrabayt.ui.base.BaseViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SubCategoryViewModel : BaseViewModel() {
    private val _list: MutableLiveData<ArrayList<String>?> = MutableLiveData()
    private val _position: MutableLiveData<Int?> = MutableLiveData()

    fun getList(): LiveData<ArrayList<String>?> = _list
    fun setListValue(value: ArrayList<String>?) {
        _list.value = value
    }

    fun getPosition(): LiveData<Int?> = _position
    fun setPositionValue(value: Int?) {
        _position.value = value
    }
}