package bi.demo.addaapplication

import bi.demo.addaapplication.repository.DataRepository
import bi.demo.addaapplication.viewmodel.UserViewmodel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    single { DataRepository(get()) }

    single { createWebService() }

    viewModel { UserViewmodel(get()) }

}

fun createWebService(): NetWorkApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("http://gorest.co.in/public-api/")
        .build()

    return retrofit.create(NetWorkApi::class.java)
}