package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.MediaContent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MediaView extends FrameLayout {
    public MediaView(@NonNull Context context) {
        super(context);
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2, i8);
    }

    public void setImageScaleType(@NonNull ImageView.ScaleType scaleType) {
    }

    public void setMediaContent(@NonNull MediaContent mediaContent) {
    }
}
