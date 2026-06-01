package x1;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;
import g1.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends AbsSavedState {
    public static final Parcelable.Creator<c> CREATOR = new f(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17788a;

    public c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f17788a = parcel.readInt();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f17788a);
    }

    public c(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
        super(parcelable);
        this.f17788a = sideSheetBehavior.h;
    }
}
