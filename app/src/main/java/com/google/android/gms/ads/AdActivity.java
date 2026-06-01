package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class AdActivity extends Activity {

    @NonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";

    @Nullable
    private zzbvi zza;

    private final void zza() {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            try {
                zzbviVar.zzs();
            } catch (RemoteException e) {
                zzo.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i2, int i8, @NonNull Intent intent) {
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzm(i2, i8, intent);
            }
        } catch (Exception e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i2, i8, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                if (!zzbviVar.zzg()) {
                    return;
                }
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbvi zzbviVar2 = this.zza;
            if (zzbviVar2 != null) {
                zzbviVar2.zze();
            }
        } catch (RemoteException e4) {
            zzo.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzn(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zzo.zzd("AdActivity onCreate");
        zzbvi zzbviVarZzh = zzbb.zzb().zzh(this);
        this.zza = zzbviVarZzh;
        if (zzbviVarZzh == null) {
            zzo.zzl("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzbviVarZzh.zzh(bundle);
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        zzo.zzd("AdActivity onDestroy");
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzq();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        zzo.zzd("AdActivity onPause");
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzl();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzH(i2, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        zzo.zzd("AdActivity onRestart");
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzi();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        zzo.zzd("AdActivity onResume");
        super.onResume();
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzk();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzo(bundle);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        zzo.zzd("AdActivity onStart");
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzj();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        zzo.zzd("AdActivity onStop");
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzp();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzf();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i2) {
        super.setContentView(i2);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view) {
        super.setContentView(view);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view, @NonNull ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
