package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends Binder implements i {
    static final int TRANSACTION_onGreatestScrollPercentageIncreased = 3;
    static final int TRANSACTION_onSessionEnded = 4;
    static final int TRANSACTION_onVerticalScrollEvent = 2;

    public h() {
        attachInterface(this, i.f3235t6);
    }

    public static i asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(i.f3235t6);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof i)) {
            return (i) iInterfaceQueryLocalInterface;
        }
        g gVar = new g();
        gVar.f3234a = iBinder;
        return gVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        String str = i.f3235t6;
        if (i2 >= 1 && i2 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i2 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        if (i2 == 2) {
            onVerticalScrollEvent(parcel.readInt() != 0, (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
            return true;
        }
        if (i2 == 3) {
            onGreatestScrollPercentageIncreased(parcel.readInt(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
            return true;
        }
        if (i2 != 4) {
            return super.onTransact(i2, parcel, parcel2, i8);
        }
        onSessionEnded(parcel.readInt() != 0, (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
