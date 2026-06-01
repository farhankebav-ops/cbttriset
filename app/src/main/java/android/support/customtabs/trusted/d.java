package android.support.customtabs.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f3240a;

    @Override // android.support.customtabs.trusted.f
    public final Bundle areNotificationsEnabled(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.w6);
            a.a.e(parcelObtain, bundle, 0);
            this.f3240a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) a.a.d(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3240a;
    }

    @Override // android.support.customtabs.trusted.f
    public final void cancelNotification(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.w6);
            a.a.e(parcelObtain, bundle, 0);
            this.f3240a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.w6);
            parcelObtain.writeString(str);
            a.a.e(parcelObtain, bundle, 0);
            parcelObtain.writeStrongBinder(iBinder);
            this.f3240a.transact(9, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) a.a.d(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle getActiveNotifications() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.w6);
            this.f3240a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) a.a.d(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle getSmallIconBitmap() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.w6);
            this.f3240a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) a.a.d(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final int getSmallIconId() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.w6);
            this.f3240a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle notifyNotificationWithChannel(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f.w6);
            a.a.e(parcelObtain, bundle, 0);
            this.f3240a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) a.a.d(parcelObtain2);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
