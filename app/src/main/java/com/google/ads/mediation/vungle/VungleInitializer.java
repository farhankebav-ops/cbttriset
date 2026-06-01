package com.google.ads.mediation.vungle;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VungleError;
import com.vungle.ads.VunglePrivacySettings;
import com.vungle.ads.VungleWrapperFramework;
import com.vungle.mediation.BuildConfig;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class VungleInitializer implements InitializationListener {
    private static final VungleInitializer instance = new VungleInitializer();
    private final AtomicBoolean isInitializing = new AtomicBoolean(false);
    private final ArrayList<VungleInitializationListener> initListeners = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface VungleInitializationListener {
        void onInitializeError(AdError adError);

        void onInitializeSuccess();
    }

    private VungleInitializer() {
        VungleAds.setIntegrationName(VungleWrapperFramework.admob, BuildConfig.ADAPTER_VERSION.replace('.', '_'));
    }

    @NonNull
    public static VungleInitializer getInstance() {
        return instance;
    }

    public void initialize(@NonNull String str, @NonNull Context context, @NonNull VungleInitializationListener vungleInitializationListener) {
        if (VungleSdkWrapper.delegate.isInitialized()) {
            vungleInitializationListener.onInitializeSuccess();
        } else {
            if (this.isInitializing.getAndSet(true)) {
                this.initListeners.add(vungleInitializationListener);
                return;
            }
            updateCoppaStatus(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment());
            VungleSdkWrapper.delegate.init(context, str, this);
            this.initListeners.add(vungleInitializationListener);
        }
    }

    @Override // com.vungle.ads.InitializationListener
    public void onError(@NonNull VungleError vungleError) {
        AdError adError = VungleMediationAdapter.getAdError(vungleError);
        ArrayList<VungleInitializationListener> arrayList = this.initListeners;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            VungleInitializationListener vungleInitializationListener = arrayList.get(i2);
            i2++;
            vungleInitializationListener.onInitializeError(adError);
        }
        this.initListeners.clear();
        this.isInitializing.set(false);
    }

    @Override // com.vungle.ads.InitializationListener
    public void onSuccess() {
        ArrayList<VungleInitializationListener> arrayList = this.initListeners;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            VungleInitializationListener vungleInitializationListener = arrayList.get(i2);
            i2++;
            vungleInitializationListener.onInitializeSuccess();
        }
        this.initListeners.clear();
        this.isInitializing.set(false);
    }

    public void updateCoppaStatus(int i2) {
        if (i2 == 0) {
            VunglePrivacySettings.setCOPPAStatus(false);
        } else {
            if (i2 != 1) {
                return;
            }
            VunglePrivacySettings.setCOPPAStatus(true);
        }
    }
}
