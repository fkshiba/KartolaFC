package com.example.vntfesh.kartolafc.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.vntfesh.kartolafc.R
import com.example.vntfesh.kartolafc.model.domain.Highlight
import com.squareup.picasso.Picasso

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 */
class HighlightRecyclerViewAdapter(private val context: Context, private val highlightList: List<Highlight>) : RecyclerView.Adapter<HighlightRecyclerViewAdapter.ViewHolder>() {

    private var inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.fragment_highlight, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val highlight = highlightList[position];
        if(highlight == null || highlight.athlete == null){
            return;
        }

        holder.nicknameView.text = highlight.athlete.nickname;
        holder.positionView.text = highlight.position;
        holder.numberOfDraftView.text = highlight.numberOfDraft.toString();
        holder.ratingBar.rating = (highlight.numberOfDraft / highlight.athlete.editorialPrice % 3).toFloat();
        Picasso.with(context).load(highlight.teamShield).into(holder.imageView);

//        holder.mView.setOnClickListener {
//        }
    }

    override fun getItemCount(): Int {
        return highlightList.size
    }

    inner class ViewHolder(val viewInstance: View) : RecyclerView.ViewHolder(viewInstance) {
        val imageView: ImageView
        val nicknameView: TextView
        val positionView: TextView
        val numberOfDraftView: TextView
        val ratingBar: RatingBar
        var item: Highlight? = null

        init {
            imageView = viewInstance.findViewById(R.id.photo) as ImageView
            nicknameView = viewInstance.findViewById(R.id.nickname) as TextView
            positionView = viewInstance.findViewById(R.id.position) as TextView
            numberOfDraftView = viewInstance.findViewById(R.id.numberOfDraft) as TextView
            ratingBar = viewInstance.findViewById(R.id.rating) as RatingBar
        }

    }
}
