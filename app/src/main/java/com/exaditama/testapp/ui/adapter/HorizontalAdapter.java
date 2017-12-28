package com.exaditama.testapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.exaditama.testapp.Constants;
import com.exaditama.testapp.R;
import com.exaditama.testapp.base.BaseAdapter;
import com.exaditama.testapp.model.DataHorizontal;

import butterknife.BindView;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class HorizontalAdapter extends BaseAdapter<DataHorizontal> {

    public HorizontalAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.adapter_horizontal, parent, false);

        return new HorizontalViewHolder(view);
    }

    public class HorizontalViewHolder extends BaseViewHolder {

        @BindView(R.id.imageMain)
        protected ImageView mImageMain;

        @BindView(R.id.titleMain)
        protected TextView mTitleMain;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void fillView(int position) {
            Glide.with(mContext).load(Constants.IMAGE_URL + mData.get(position).getImageUrl())
                    .into(mImageMain);

            mTitleMain.setText(mData.get(position).getTitle());

        }
    }
}
