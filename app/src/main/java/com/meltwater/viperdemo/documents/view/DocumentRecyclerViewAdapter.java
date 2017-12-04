package com.meltwater.viperdemo.documents.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meltwater.viperdemo.R;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;
import com.meltwater.viperdemo.documents.view.DocumentListFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DocumentUIModel} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class DocumentRecyclerViewAdapter extends RecyclerView.Adapter<DocumentRecyclerViewAdapter.ViewHolder> {

    private final List<DocumentUIModel> mValues;
    private final OnListFragmentInteractionListener mListener;

    public DocumentRecyclerViewAdapter(List<DocumentUIModel> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_document, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mUrl.setText(mValues.get(position).getDisplayUrl());
        holder.mTitle.setText(mValues.get(position).getDisplayTitle());
        holder.mMatchSentence.setText(mValues.get(position).getDisplayMatchSentence());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mUrl;
        public final TextView mTitle;
        public final TextView mMatchSentence;

        public DocumentUIModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mUrl = (TextView) view.findViewById(R.id.url);
            mTitle = (TextView) view.findViewById(R.id.title);
            mMatchSentence = (TextView) view.findViewById(R.id.matchSentence);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitle.getText() + "'";
        }
    }
}
