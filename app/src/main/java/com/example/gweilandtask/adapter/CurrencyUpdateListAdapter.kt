package com.example.gweilandtask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gweilandtask.R

class CurrencyUpdateListAdapter(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<CurrencyUpdateListAdapter.ViewHolder>() {

    lateinit var listItem: ArrayList<String>

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_currencyTitle: TextView
        val cv_currencyCard: CardView

        init {
            // Define click listener for the ViewHolder's View
            tv_currencyTitle = view.findViewById(R.id.tv_currencyTitle)
            cv_currencyCard = view.findViewById(R.id.cv_currencyCard)

            //cv_currencyCard.setOnClickListener(this)

            /*cv_jobCard.setOnClickListener {v: View ->
                val position: Int = adapterPosition
                Toast.makeText(view.context, "$position clicked", Toast.LENGTH_SHORT).show()
                val openJobProfileActivity = Intent(view.context, JobProfileActivity::class.java)
                openJobProfileActivity.putExtra("jobClickedPosition", position.toString())
                openJobProfileActivity.putExtra("backStackFragment", "Jobs")
                view.context.startActivity(openJobProfileActivity)
            }*/

        }

        /*override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position!= RecyclerView.NO_POSITION) {
                listener.onItemClick(null, v, position, itemId!!)
            }
        }*/

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.currency_update_list_card, viewGroup, false)
        this.listItem = dataSet

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tv_currencyTitle.text = dataSet[position]
    }

    // Replace the contents of a view (invoked by the layout manager)
    /*override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //val job = dataSet[position]
        viewHolder.tv_currencyTitle.text = dataSet[position]

    }*/

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
}