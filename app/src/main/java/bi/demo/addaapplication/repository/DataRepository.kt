package bi.demo.addaapplication.repository

import bi.demo.addaapplication.NetWorkApi
import bi.demo.addaapplication.model.UserResponseDto
import retrofit2.Call
import retrofit2.Response

class DataRepository(val netWorkApi: NetWorkApi) {

    fun getProducts(onProductData: onUserDataListener) {
        netWorkApi.getUserList().enqueue(object : retrofit2.Callback<List<UserResponseDto>> {
            override fun onResponse(call: Call<List<UserResponseDto>>, response: Response<List<UserResponseDto>>) {
                onProductData.onSuccess((response.body() as UserResponseDto))
            }

            override fun onFailure(call: Call<List<UserResponseDto>>, t: Throwable) {
                onProductData.onFailure()
            }
        })
    }

    interface onUserDataListener {
        fun onSuccess(data: UserResponseDto)
        fun onFailure()
    }
}
