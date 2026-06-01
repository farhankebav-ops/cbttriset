package com.instagram.common.viewpoint.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0803Hq implements Parcelable.Creator<SmtaMetadataEntry> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final SmtaMetadataEntry createFromParcel(Parcel parcel) {
        return new SmtaMetadataEntry(parcel, (C0803Hq) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final SmtaMetadataEntry[] newArray(int i2) {
        return new SmtaMetadataEntry[i2];
    }
}
