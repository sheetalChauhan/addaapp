package bi.demo.addaapplication.view

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bi.demo.addaapplication.R
import bi.demo.addaapplication.databinding.ActivityMainBinding
import bi.demo.addaapplication.model.UserResponseDto
import bi.demo.addaapplication.viewmodel.UserViewmodel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val productListModel: UserViewmodel by viewModel()
    var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding!!.recylerview!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        productListModel.getUserList()
        productListModel.listOfProducts.observe(this, Observer(function = fun(productList: UserResponseDto?) {
            productList?.let {

                var productListAdapter: UserAdapter = UserAdapter(this,productList!!.list)
                binding!!.recylerview.adapter = productListAdapter

            }
        }))
    }
}