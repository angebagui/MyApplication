package com.example.android.myapplication.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.myapplication.R;
import com.example.android.myapplication.ormlite.entity.Dummy;

import java.util.List;

/**
 * Created by angebagui on 23/07/2015.
 */
public class DummyAdapterRecyclerView extends RecyclerView.Adapter<DummyAdapterRecyclerView.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<Dummy> mValues;


    public DummyAdapterRecyclerView(FragmentActivity context, List<Dummy> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dummy_list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mBoundDummy = mValues.get(position);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public Dummy getValueAt(int position) {
        return mValues.get(position);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public Dummy mBoundDummy;

        public final View mView;
        public final ImageView mImageView;
        public final TextView contentTextView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.avatar);
            contentTextView = (TextView) view.findViewById(R.id.content);
        }
    }
}
