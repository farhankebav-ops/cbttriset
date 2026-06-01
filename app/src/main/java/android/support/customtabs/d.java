package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f3232a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3232a;
    }

    @Override // android.support.customtabs.f
    public final Bundle extraCommand(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeString(str);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (Bundle) q.f(parcelObtain2, Bundle.CREATOR);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean isEngagementSignalsApiAvailable(c cVar, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(13, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean mayLaunchUrl(c cVar, Uri uri, Bundle bundle, List list) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            q.F0(parcelObtain, uri, 0);
            q.F0(parcelObtain, bundle, 0);
            if (list == null) {
                parcelObtain.writeInt(-1);
            } else {
                int size = list.size();
                parcelObtain.writeInt(size);
                for (int i2 = 0; i2 < size; i2++) {
                    q.F0(parcelObtain, (Parcelable) list.get(i2), 0);
                }
            }
            this.f3232a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean newSession(c cVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            this.f3232a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean newSessionWithExtras(c cVar, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(10, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final int postMessage(c cVar, String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            parcelObtain.writeString(str);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(8, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean receiveFile(c cVar, Uri uri, int i2, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            q.F0(parcelObtain, uri, 0);
            parcelObtain.writeInt(i2);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean requestPostMessageChannel(c cVar, Uri uri) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            q.F0(parcelObtain, uri, 0);
            this.f3232a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean requestPostMessageChannelWithExtras(c cVar, Uri uri, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            q.F0(parcelObtain, uri, 0);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean setEngagementSignalsCallback(c cVar, IBinder iBinder, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            parcelObtain.writeStrongBinder(iBinder);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(14, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean updateVisuals(c cVar, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean validateRelationship(c cVar, int i2, Uri uri, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeStrongInterface(cVar);
            parcelObtain.writeInt(i2);
            q.F0(parcelObtain, uri, 0);
            q.F0(parcelObtain, bundle, 0);
            this.f3232a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean warmup(long j) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.f3233s6);
            parcelObtain.writeLong(j);
            this.f3232a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
