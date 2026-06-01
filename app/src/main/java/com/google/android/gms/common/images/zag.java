package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    public zag(Uri uri, int i2) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i2;
    }

    public abstract void zaa(@Nullable Drawable drawable, boolean z2, boolean z7, boolean z8);

    public final void zab(Context context, zam zamVar, boolean z2) {
        int i2 = this.zab;
        zaa(i2 != 0 ? context.getResources().getDrawable(i2) : null, z2, false, false);
    }

    public final void zac(Context context, Bitmap bitmap, boolean z2) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
