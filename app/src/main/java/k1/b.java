package k1;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends View.BaseSavedState {

    @NonNull
    public static final Parcelable.Creator<b> CREATOR = new f(13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12596a;

    public final String toString() {
        StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" CheckedState=");
        int i2 = this.f12596a;
        return a1.a.r(sb, i2 != 1 ? i2 != 2 ? "unchecked" : "indeterminate" : "checked", "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeValue(Integer.valueOf(this.f12596a));
    }
}
