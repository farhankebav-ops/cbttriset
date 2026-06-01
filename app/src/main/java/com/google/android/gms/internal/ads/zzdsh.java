package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdsh extends FrameLayout {
    private final com.google.android.gms.ads.internal.util.zzat zza;

    public zzdsh(Context context, @NonNull View view, @NonNull com.google.android.gms.ads.internal.util.zzat zzatVar) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zza = zzatVar;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.zza(motionEvent);
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            KeyEvent.Callback childAt = getChildAt(i2);
            if (childAt instanceof zzcgy) {
                arrayList.add((zzcgy) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((zzcgy) arrayList.get(i8)).destroy();
        }
    }
}
