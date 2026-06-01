package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import androidx.camera.core.processing.util.a;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zaz extends RemoteCreator {
    private static final zaz zaa = new zaz();

    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i2, int i8) throws RemoteCreator.RemoteCreatorException {
        zaz zazVar = zaa;
        try {
            zax zaxVar = new zax(1, i2, i8, null);
            return (View) ObjectWrapper.unwrap(((zam) zazVar.getRemoteCreatorInstance(context)).zae(ObjectWrapper.wrap(context), zaxVar));
        } catch (Exception e) {
            throw new RemoteCreator.RemoteCreatorException(a.i("Could not get button with size ", i2, " and color ", i8), e);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof zam ? (zam) iInterfaceQueryLocalInterface : new zam(iBinder);
    }
}
