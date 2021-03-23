package bi.demo.addaapplication.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import bi.demo.addaapplication.R
import bi.demo.addaapplication.databinding.UserLayoutBinding
import bi.demo.addaapplication.model.UserData
import java.util.ArrayList

class UserAdapter(private val mActivity: Activity, private var userList: ArrayList<UserData>?) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    private val mInflator: LayoutInflater

    init {
        mInflator = LayoutInflater.from(mActivity)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(mActivity)
        val view: View = inflater.inflate(R.layout.user_layout, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding!!.tvName.text=userList!!.get(position).name
        holder.binding!!.tvEmail.text=userList!!.get(position).email
        holder.binding!!.tvGender.text=userList!!.get(position).gender
        holder.binding!!.tvStatus.text=userList!!.get(position).status
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }





    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var binding:UserLayoutBinding?


        init {
            binding = DataBindingUtil.bind<UserLayoutBinding>(itemView)
        }


    }

}
