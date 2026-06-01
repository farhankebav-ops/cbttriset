package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.k;
import android.support.customtabs.l;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {
    private k mBinder = new k() { // from class: androidx.browser.customtabs.PostMessageService.1
        {
            attachInterface(this, l.f3237u6);
        }

        @Override // android.support.customtabs.l
        public void onMessageChannelReady(@NonNull android.support.customtabs.c cVar, @Nullable Bundle bundle) throws RemoteException {
            cVar.onMessageChannelReady(bundle);
        }

        @Override // android.support.customtabs.l
        public void onPostMessage(@NonNull android.support.customtabs.c cVar, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            cVar.onPostMessage(str, bundle);
        }
    };

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}
