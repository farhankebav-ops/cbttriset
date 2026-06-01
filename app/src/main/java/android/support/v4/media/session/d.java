package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3290a;

    public d() {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.f3290a = new WeakReference(null);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i8) {
        if (i2 == 1598968902) {
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
        switch (i2) {
            case 1:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readString();
                if (parcel.readInt() != 0) {
                }
                if (this.f3290a.get() != null) {
                    throw new ClassCastException();
                }
                return true;
            case 2:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                throw new AssertionError();
            case 3:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                }
                if (this.f3290a.get() != null) {
                    throw new ClassCastException();
                }
                return true;
            case 4:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                }
                throw new AssertionError();
            case 5:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
                throw new AssertionError();
            case 6:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                }
                throw new AssertionError();
            case 7:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                }
                throw new AssertionError();
            case 8:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (parcel.readInt() != 0) {
                    ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                }
                throw new AssertionError();
            case 9:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readInt();
                if (this.f3290a.get() != null) {
                    throw new ClassCastException();
                }
                return true;
            case 10:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readInt();
                return true;
            case 11:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readInt();
                if (this.f3290a.get() != null) {
                    throw new ClassCastException();
                }
                return true;
            case 12:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readInt();
                if (this.f3290a.get() != null) {
                    throw new ClassCastException();
                }
                return true;
            case 13:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                if (this.f3290a.get() != null) {
                    throw new ClassCastException();
                }
                return true;
            default:
                return super.onTransact(i2, parcel, parcel2, i8);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
