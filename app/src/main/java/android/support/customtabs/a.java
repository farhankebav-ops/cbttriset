package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f3230a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3230a;
    }

    @Override // android.support.customtabs.c
    public final void extraCallback(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            parcelObtain.writeString(str);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(3, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            parcelObtain.writeString(str);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (Bundle) n7.b.d(parcelObtain2, Bundle.CREATOR);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onActivityLayout(int i2, int i8, int i9, int i10, int i11, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i8);
            parcelObtain.writeInt(i9);
            parcelObtain.writeInt(i10);
            parcelObtain.writeInt(i11);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(10, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onActivityResized(int i2, int i8, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i8);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(8, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onMessageChannelReady(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onMinimized(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(11, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onNavigationEvent(int i2, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            parcelObtain.writeInt(i2);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(2, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onPostMessage(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            parcelObtain.writeString(str);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onRelationshipValidationResult(int i2, Uri uri, boolean z2, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            parcelObtain.writeInt(i2);
            n7.b.e(parcelObtain, uri, 0);
            parcelObtain.writeInt(z2 ? 1 : 0);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(6, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onUnminimized(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(12, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onWarmupCompleted(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f3231r6);
            n7.b.e(parcelObtain, bundle, 0);
            this.f3230a.transact(9, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
