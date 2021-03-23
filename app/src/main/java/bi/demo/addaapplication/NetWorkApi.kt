package bi.demo.addaapplication


import bi.demo.addaapplication.model.UserResponseDto
import retrofit2.Call
import retrofit2.http.GET

interface NetWorkApi{

    @GET("users")
    fun getUserList(): Call<List<UserResponseDto>>

}