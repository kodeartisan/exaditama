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
import com.exaditama.testapp.model.DataVertical;

import butterknife.BindView;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class VerticalAdapter extends BaseAdapter<DataVertical> {

    public VerticalAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.adapter_vertical, parent, false);

        return new VerticalViewHolder(view);
    }

    public class VerticalViewHolder extends BaseViewHolder {

        @BindView(R.id.imageMain)
        protected ImageView mImageMain;

        @BindView(R.id.titleMain)
        protected TextView mTitleMain;

        public VerticalViewHolder(View itemView) {
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
