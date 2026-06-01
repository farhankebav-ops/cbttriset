package z1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a0 extends AbsSavedState {
    public static final Parcelable.Creator<a0> CREATOR = new g1.f(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f17896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17897b;

    public a0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f17896a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f17897b = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f17896a) + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        TextUtils.writeToParcel(this.f17896a, parcel, i2);
        parcel.writeInt(this.f17897b ? 1 : 0);
    }
}
