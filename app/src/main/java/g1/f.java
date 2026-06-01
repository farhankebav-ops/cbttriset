package g1;

import android.os.Parcel;
import android.os.Parcelable;
import z1.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11566a;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f11566a) {
            case 0:
                return new g(parcel, classLoader);
            case 1:
                return new h1.c(parcel, classLoader);
            case 2:
                return new q1.b(parcel, classLoader);
            case 3:
                return new x1.c(parcel, classLoader);
            default:
                return new a0(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f11566a) {
            case 0:
                return new g[i2];
            case 1:
                return new h1.c[i2];
            case 2:
                return new q1.b[i2];
            case 3:
                return new x1.c[i2];
            default:
                return new a0[i2];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f11566a) {
            case 0:
                return new g(parcel, (ClassLoader) null);
            case 1:
                return new h1.c(parcel, null);
            case 2:
                return new q1.b(parcel, null);
            case 3:
                return new x1.c(parcel, (ClassLoader) null);
            default:
                return new a0(parcel, null);
        }
    }
}
