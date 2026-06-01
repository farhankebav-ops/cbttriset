package q1;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends AbsSavedState {
    public static final Parcelable.Creator<b> CREATOR = new g1.f(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13383a;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f13383a = parcel.readInt() == 1;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f13383a ? 1 : 0);
    }
}
