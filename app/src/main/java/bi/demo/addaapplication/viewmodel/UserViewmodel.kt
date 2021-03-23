package bi.demo.addaapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bi.demo.addaapplication.model.UserResponseDto
import bi.demo.addaapplication.repository.DataRepository

class UserViewmodel(var dataRepository: DataRepository) :ViewModel() {

    var listOfProducts = MutableLiveData<UserResponseDto>()

    fun getUserList() {
        dataRepository.getProducts(object : DataRepository.onUserDataListener {
            override fun onSuccess(data:UserResponseDto) {
                listOfProducts.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }

}