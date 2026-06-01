package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends Binder implements f {
    static final int TRANSACTION_areNotificationsEnabled = 6;
    static final int TRANSACTION_cancelNotification = 3;
    static final int TRANSACTION_extraCommand = 9;
    static final int TRANSACTION_getActiveNotifications = 5;
    static final int TRANSACTION_getSmallIconBitmap = 7;
    static final int TRANSACTION_getSmallIconId = 4;
    static final int TRANSACTION_notifyNotificationWithChannel = 2;

    public static f asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f.w6);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof f)) {
            return (f) iInterfaceQueryLocalInterface;
        }
        d dVar = new d();
        dVar.f3240a = iBinder;
        return dVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        String str = f.w6;
        if (i2 >= 1 && i2 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i2 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i2) {
            case 2:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundleNotifyNotificationWithChannel = notifyNotificationWithChannel((Bundle) a.a.d(parcel));
                parcel2.writeNoException();
                a.a.e(parcel2, bundleNotifyNotificationWithChannel, 1);
                return true;
            case 3:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                cancelNotification((Bundle) a.a.d(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                int smallIconId = getSmallIconId();
                parcel2.writeNoException();
                parcel2.writeInt(smallIconId);
                return true;
            case 5:
                Bundle activeNotifications = getActiveNotifications();
                parcel2.writeNoException();
                a.a.e(parcel2, activeNotifications, 1);
                return true;
            case 6:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundleAreNotificationsEnabled = areNotificationsEnabled((Bundle) a.a.d(parcel));
                parcel2.writeNoException();
                a.a.e(parcel2, bundleAreNotificationsEnabled, 1);
                return true;
            case 7:
                Bundle smallIconBitmap = getSmallIconBitmap();
                parcel2.writeNoException();
                a.a.e(parcel2, smallIconBitmap, 1);
                return true;
            case 8:
            default:
                return super.onTransact(i2, parcel, parcel2, i8);
            case 9:
                String string = parcel.readString();
                Parcelable.Creator creator4 = Bundle.CREATOR;
                Bundle bundleExtraCommand = extraCommand(string, (Bundle) a.a.d(parcel), parcel.readStrongBinder());
                parcel2.writeNoException();
                a.a.e(parcel2, bundleExtraCommand, 1);
                return true;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
