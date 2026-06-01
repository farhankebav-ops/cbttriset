package com.instagram.common.viewpoint.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.exoplayer.scheduler.Requirements;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0646Bm implements Parcelable.Creator<Requirements> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Requirements createFromParcel(Parcel parcel) {
        return new Requirements(parcel.readInt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final Requirements[] newArray(int i2) {
        return new Requirements[i2];
    }
}
