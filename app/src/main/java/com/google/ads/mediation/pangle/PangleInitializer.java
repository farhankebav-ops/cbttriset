package com.google.ads.mediation.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PangleInitializer implements PAGSdk.PAGInitCallback {
    private static PangleInitializer instance;
    private final ArrayList<Listener> initListeners;
    private boolean isInitialized;
    private boolean isInitializing;
    private final PangleFactory pangleFactory;
    private final PangleSdkWrapper pangleSdkWrapper;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Listener {
        void onInitializeError(@NonNull AdError adError);

        void onInitializeSuccess();
    }

    private PangleInitializer() {
        this.isInitializing = false;
        this.isInitialized = false;
        this.initListeners = new ArrayList<>();
        this.pangleSdkWrapper = new PangleSdkWrapper();
        this.pangleFactory = new PangleFactory();
    }

    @NonNull
    public static PangleInitializer getInstance() {
        if (instance == null) {
            instance = new PangleInitializer();
        }
        return instance;
    }

    @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
    public void fail(int i2, @NonNull String str) {
        int i8 = 0;
        this.isInitializing = false;
        this.isInitialized = false;
        AdError adErrorCreateSdkError = PangleConstants.createSdkError(i2, str);
        ArrayList<Listener> arrayList = this.initListeners;
        int size = arrayList.size();
        while (i8 < size) {
            Listener listener = arrayList.get(i8);
            i8++;
            listener.onInitializeError(adErrorCreateSdkError);
        }
        this.initListeners.clear();
    }

    public void initialize(@NonNull Context context, @NonNull String str, @NonNull Listener listener) {
        if (TextUtils.isEmpty(str)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to initialize Pangle SDK. Missing or invalid App ID.");
            Log.w(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            listener.onInitializeError(adErrorCreateAdapterError);
        } else {
            if (this.isInitializing) {
                this.initListeners.add(listener);
                return;
            }
            if (this.isInitialized) {
                listener.onInitializeSuccess();
                return;
            }
            this.isInitializing = true;
            this.initListeners.add(listener);
            this.pangleSdkWrapper.init(context, this.pangleFactory.createPAGConfigBuilder().appId(str).setAdxId(PangleConstants.ADX_ID).setGDPRConsent(PangleMediationAdapter.getGDPRConsent()).setUserData("[{\"name\":\"mediation\",\"value\":\"google\"},{\"name\":\"adapter_version\",\"value\":\"7.2.0.6.0\"}]").build(), this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
    public void success() {
        int i2 = 0;
        this.isInitializing = false;
        this.isInitialized = true;
        ArrayList<Listener> arrayList = this.initListeners;
        int size = arrayList.size();
        while (i2 < size) {
            Listener listener = arrayList.get(i2);
            i2++;
            listener.onInitializeSuccess();
        }
        this.initListeners.clear();
    }

    @VisibleForTesting
    public PangleInitializer(PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.isInitializing = false;
        this.isInitialized = false;
        this.initListeners = new ArrayList<>();
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }
}
