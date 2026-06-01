package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Binder implements c {
    static final int TRANSACTION_extraCallback = 3;
    static final int TRANSACTION_extraCallbackWithResult = 7;
    static final int TRANSACTION_onActivityLayout = 10;
    static final int TRANSACTION_onActivityResized = 8;
    static final int TRANSACTION_onMessageChannelReady = 4;
    static final int TRANSACTION_onMinimized = 11;
    static final int TRANSACTION_onNavigationEvent = 2;
    static final int TRANSACTION_onPostMessage = 5;
    static final int TRANSACTION_onRelationshipValidationResult = 6;
    static final int TRANSACTION_onUnminimized = 12;
    static final int TRANSACTION_onWarmupCompleted = 9;

    public b() {
        attachInterface(this, c.f3231r6);
    }

    public static c asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c.f3231r6);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
            return (c) iInterfaceQueryLocalInterface;
        }
        a aVar = new a();
        aVar.f3230a = iBinder;
        return aVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        String str = c.f3231r6;
        if (i2 >= 1 && i2 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i2 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i2) {
            case 2:
                onNavigationEvent(parcel.readInt(), (Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            case 3:
                extraCallback(parcel.readString(), (Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            case 4:
                onMessageChannelReady((Bundle) n7.b.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                onPostMessage(parcel.readString(), (Bundle) n7.b.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 6:
                onRelationshipValidationResult(parcel.readInt(), (Uri) n7.b.d(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            case 7:
                Bundle bundleExtraCallbackWithResult = extraCallbackWithResult(parcel.readString(), (Bundle) n7.b.d(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                n7.b.e(parcel2, bundleExtraCallbackWithResult, 1);
                return true;
            case 8:
                onActivityResized(parcel.readInt(), parcel.readInt(), (Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            case 9:
                onWarmupCompleted((Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            case 10:
                onActivityLayout(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            case 11:
                onMinimized((Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            case 12:
                onUnminimized((Bundle) n7.b.d(parcel, Bundle.CREATOR));
                return true;
            default:
                return super.onTransact(i2, parcel, parcel2, i8);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
