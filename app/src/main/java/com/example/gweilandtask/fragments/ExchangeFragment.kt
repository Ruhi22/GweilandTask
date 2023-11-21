package com.example.gweilandtask.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gweilandtask.R
import com.example.gweilandtask.adapter.CurrencyUpdateListAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExchangeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExchangeFragment : Fragment(), AdapterView.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var rv_currency_update_list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var root: View =  inflater.inflate(R.layout.fragment_exchange, container, false)
        rv_currency_update_list = root.findViewById(R.id.rv_currency_update_list)

        val arrayList_for_recyclerView: ArrayList<String> = ArrayList<String>(5)
        arrayList_for_recyclerView.add("ETH")
        arrayList_for_recyclerView.add("BNB")
        arrayList_for_recyclerView.add("ADA")
        arrayList_for_recyclerView.add("XRP")
        arrayList_for_recyclerView.add("SOL")



        rv_currency_update_list.setHasFixedSize(true)
        rv_currency_update_list.setLayoutManager(LinearLayoutManager(activity))
        var myRecyclerViewAdapter = CurrencyUpdateListAdapter(arrayList_for_recyclerView, this)
        rv_currency_update_list.adapter = myRecyclerViewAdapter

        return root


    }

    /*override fun onItemClick(position: Int?) {
        Toast.makeText(context, "$position clicked", Toast.LENGTH_SHORT).show()
    }*/

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(context, "$position clicked", Toast.LENGTH_SHORT).show()
        //Toast.makeText(view?.context, "Job $position clicked", Toast.LENGTH_SHORT).show()
        /*val openJobProfileActivity = Intent(context, JobProfileActivity::class.java)
        openJobProfileActivity.putExtra("jobClickedPosition", position.toString())
        openJobProfileActivity.putExtra("backStackFragment", "Jobs")
        startActivity(openJobProfileActivity)*/
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExchangeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExchangeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}