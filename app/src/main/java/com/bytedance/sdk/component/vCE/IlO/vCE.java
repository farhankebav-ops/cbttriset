package com.bytedance.sdk.component.vCE.IlO;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface vCE extends IInterface {
    int IlO(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException;

    int IlO(Uri uri, String str, String[] strArr) throws RemoteException;

    String IlO(Uri uri) throws RemoteException;

    String IlO(Uri uri, ContentValues contentValues) throws RemoteException;

    Map IlO(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class IlO extends Binder implements vCE {
        public IlO() {
            attachInterface(this, "com.bytedance.sdk.component.log.impl.IListenerEventManager");
        }

        public static vCE IlO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof vCE)) ? new C0063IlO(iBinder) : (vCE) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                Map mapIlO = IlO(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.createStringArray(), parcel.readString(), parcel.createStringArray(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeMap(mapIlO);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                String strIlO = IlO(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(strIlO);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                String strIlO2 = IlO(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ContentValues) ContentValues.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(strIlO2);
                return true;
            }
            if (i2 == 4) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                int iIlO = IlO(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                parcel2.writeInt(iIlO);
                return true;
            }
            if (i2 != 5) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i8);
                }
                parcel2.writeString("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
            int iIlO2 = IlO(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ContentValues) ContentValues.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
            parcel2.writeNoException();
            parcel2.writeInt(iIlO2);
            return true;
        }

        public static vCE IlO() {
            return C0063IlO.IlO;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.component.vCE.IlO.vCE$IlO$IlO, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static class C0063IlO implements vCE {
            public static vCE IlO;
            private IBinder MY;

            public C0063IlO(IBinder iBinder) {
                this.MY = iBinder;
            }

            @Override // com.bytedance.sdk.component.vCE.IlO.vCE
            public Map IlO(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException {
                Map hashMap;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr2);
                    parcelObtain.writeString(str2);
                    if (this.MY.transact(1, parcelObtain, parcelObtain2, 0) || IlO.IlO() == null) {
                        parcelObtain2.readException();
                        hashMap = parcelObtain2.readHashMap(getClass().getClassLoader());
                    } else {
                        hashMap = IlO.IlO().IlO(uri, strArr, str, strArr2, str2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return hashMap;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.MY;
            }

            @Override // com.bytedance.sdk.component.vCE.IlO.vCE
            public String IlO(Uri uri) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.MY.transact(2, parcelObtain, parcelObtain2, 0) && IlO.IlO() != null) {
                        string = IlO.IlO().IlO(uri);
                    } else {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.vCE.IlO.vCE
            public String IlO(Uri uri, ContentValues contentValues) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        parcelObtain.writeInt(1);
                        contentValues.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.MY.transact(3, parcelObtain, parcelObtain2, 0) && IlO.IlO() != null) {
                        string = IlO.IlO().IlO(uri, contentValues);
                    } else {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.vCE.IlO.vCE
            public int IlO(Uri uri, String str, String[] strArr) throws RemoteException {
                int iIlO;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    if (!this.MY.transact(4, parcelObtain, parcelObtain2, 0) && IlO.IlO() != null) {
                        iIlO = IlO.IlO().IlO(uri, str, strArr);
                    } else {
                        parcelObtain2.readException();
                        iIlO = parcelObtain2.readInt();
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iIlO;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.vCE.IlO.vCE
            public int IlO(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException {
                int iIlO;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        parcelObtain.writeInt(1);
                        contentValues.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    if (!this.MY.transact(5, parcelObtain, parcelObtain2, 0) && IlO.IlO() != null) {
                        iIlO = IlO.IlO().IlO(uri, contentValues, str, strArr);
                    } else {
                        parcelObtain2.readException();
                        iIlO = parcelObtain2.readInt();
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iIlO;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }
    }
}
