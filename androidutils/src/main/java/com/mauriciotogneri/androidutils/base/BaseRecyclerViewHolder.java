package com.mauriciotogneri.androidutils.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

import com.mauriciotogneri.androidutils.uibinder.UiBinder;

import androidx.recyclerview.widget.RecyclerView;

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements OnClickListener, OnLongClickListener
{
    private final OnViewHolderClicked onViewHolderClicked;

    protected BaseRecyclerViewHolder(View view, OnViewHolderClicked onViewHolderClicked)
    {
        super(view);

        if (onViewHolderClicked != null)
        {
            this.onViewHolderClicked = onViewHolderClicked;
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }
        else
        {
            this.onViewHolderClicked = null;
        }

        UiBinder uiBinder = new UiBinder();
        uiBinder.bind(view, this);
    }

    protected BaseRecyclerViewHolder(View view)
    {
        this(view, null);
    }

    @Override
    public void onClick(View view)
    {
        if (onViewHolderClicked != null)
        {
            onViewHolderClicked.onViewHolderClick(getLayoutPosition());
        }
    }

    @Override
    public boolean onLongClick(View v)
    {
        if (onViewHolderClicked != null)
        {
            onViewHolderClicked.onViewHolderLongClick(getLayoutPosition());

            return true;
        }
        else
        {
            return false;
        }
    }

    public interface OnViewHolderClicked
    {
        void onViewHolderClick(int position);

        void onViewHolderLongClick(int position);
    }
}