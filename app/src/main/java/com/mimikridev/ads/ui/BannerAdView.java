package com.mimikridev.ads.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.mimikridev.ads.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class BannerAdView extends LinearLayout {
    private AttributeSet attrs;
    private Context mContext;
    private int styleAttr;
    private View view;

    public BannerAdView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.view = this;
        View.inflate(this.mContext, R.layout.view_banner_ad, this);
    }

    public BannerAdView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.attrs = attributeSet;
        initView();
    }

    public BannerAdView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
        this.attrs = attributeSet;
        this.styleAttr = i2;
        initView();
    }

    public BannerAdView(Context context, AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2, i8);
    }
}
