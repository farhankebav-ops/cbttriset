package b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new f(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4114a;

    public final void b(int i2, Bundle bundle) {
        b bVar = this.f4114a;
        if (bVar != null) {
            try {
                bVar.a(i2, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            try {
                if (this.f4114a == null) {
                    this.f4114a = new c(this);
                }
                parcel.writeStrongBinder(this.f4114a.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i2, Bundle bundle) {
    }
}
