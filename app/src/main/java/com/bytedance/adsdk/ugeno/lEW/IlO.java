package com.bytedance.adsdk.ugeno.lEW;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO implements Parcelable {
    private final Parcelable MY;
    public static final IlO IlO = new IlO() { // from class: com.bytedance.adsdk.ugeno.lEW.IlO.1
    };
    public static final Parcelable.Creator<IlO> CREATOR = new Parcelable.ClassLoaderCreator<IlO>() { // from class: com.bytedance.adsdk.ugeno.lEW.IlO.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public IlO createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public IlO createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return IlO.IlO;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public IlO[] newArray(int i2) {
            return new IlO[i2];
        }
    };

    public final Parcelable IlO() {
        return this.MY;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.MY, i2);
    }

    private IlO() {
        this.MY = null;
    }

    public IlO(Parcelable parcelable) {
        if (parcelable != null) {
            this.MY = parcelable == IlO ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public IlO(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.MY = parcelable == null ? IlO : parcelable;
    }
}
