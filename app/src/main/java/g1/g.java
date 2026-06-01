package g1;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends AbsSavedState {
    public static final Parcelable.Creator<g> CREATOR = new f(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11570d;
    public final boolean e;

    public g(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f11567a = parcel.readInt();
        this.f11568b = parcel.readInt();
        this.f11569c = parcel.readInt() == 1;
        this.f11570d = parcel.readInt() == 1;
        this.e = parcel.readInt() == 1;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f11567a);
        parcel.writeInt(this.f11568b);
        parcel.writeInt(this.f11569c ? 1 : 0);
        parcel.writeInt(this.f11570d ? 1 : 0);
        parcel.writeInt(this.e ? 1 : 0);
    }

    public g(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
        super(parcelable);
        this.f11567a = bottomSheetBehavior.N;
        this.f11568b = bottomSheetBehavior.e;
        this.f11569c = bottomSheetBehavior.f5273b;
        this.f11570d = bottomSheetBehavior.I;
        this.e = bottomSheetBehavior.J;
    }
}
