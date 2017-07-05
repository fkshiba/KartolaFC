package com.example.vntfesh.kartolafc.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.example.vntfesh.kartolafc.R
import com.example.vntfesh.kartolafc.model.api.CartolaService
import com.example.vntfesh.kartolafc.model.api.RestApi
import com.example.vntfesh.kartolafc.model.domain.Highlight
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HighlightFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTextView: TextView

    private var highlightList:MutableList<Highlight> = mutableListOf();
    private var cartolaService: CartolaService = RestApi().cartolaService;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_highlight_list, container, false)
        recyclerView = view.findViewById(R.id.recylerView) as RecyclerView;
        progressBar = view.findViewById(R.id.progressBar) as ProgressBar;
        errorTextView = view.findViewById(R.id.errorTextView) as TextView;
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
        recyclerView.adapter = HighlightRecyclerViewAdapter(context, highlightList);

        cartolaService.getHighlightList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { data ->
                            highlightList.addAll(data);
                            recyclerView.adapter.notifyDataSetChanged();
                            recyclerView.visibility = View.VISIBLE;
                        },
                        { error ->
                            errorTextView.text = Html.fromHtml("<b>An error occurred:</b> ${error.toString()}");
                            errorTextView.visibility = View.VISIBLE;
                            progressBar.visibility = View.GONE;
                        },
                        {
                            progressBar.visibility = View.GONE;
                        }
                )
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
