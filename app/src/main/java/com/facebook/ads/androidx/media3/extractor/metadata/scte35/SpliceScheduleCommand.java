package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.instagram.common.viewpoint.core.C0810Hx;
import com.instagram.common.viewpoint.core.C0812Hz;
import com.instagram.common.viewpoint.core.C4J;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new C0810Hx();
    public final List<C0812Hz> A00;

    public SpliceScheduleCommand(Parcel parcel) {
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i8 = 0; i8 < i2; i8++) {
            arrayList.add(C0812Hz.A00(parcel));
        }
        this.A00 = Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, C0810Hx c0810Hx) {
        this(parcel);
    }

    public SpliceScheduleCommand(List<C0812Hz> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand A00(C4J c4j) {
        int iA0I = c4j.A0I();
        ArrayList arrayList = new ArrayList(iA0I);
        for (int i2 = 0; i2 < iA0I; i2++) {
            arrayList.add(C0812Hz.A02(c4j));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int size = this.A00.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            this.A00.get(i8).A04(parcel);
        }
    }
}
