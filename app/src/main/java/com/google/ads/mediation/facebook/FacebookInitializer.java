package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class FacebookInitializer implements AudienceNetworkAds.InitListener {
    private static FacebookInitializer instance;
    private boolean isInitializing = false;
    private boolean isInitialized = false;
    private final ArrayList<Listener> listeners = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Listener {
        void onInitializeError(AdError adError);

        void onInitializeSuccess();
    }

    private FacebookInitializer() {
    }

    public static FacebookInitializer getInstance() {
        if (instance == null) {
            instance = new FacebookInitializer();
        }
        return instance;
    }

    public void initialize(Context context, String str, Listener listener) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        getInstance().initialize(context, arrayList, listener);
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        int i2 = 0;
        this.isInitializing = false;
        this.isInitialized = initResult.isSuccess();
        ArrayList<Listener> arrayList = this.listeners;
        int size = arrayList.size();
        while (i2 < size) {
            Listener listener = arrayList.get(i2);
            i2++;
            Listener listener2 = listener;
            if (initResult.isSuccess()) {
                listener2.onInitializeSuccess();
            } else {
                listener2.onInitializeError(new AdError(104, initResult.getMessage(), "com.google.ads.mediation.facebook"));
            }
        }
        this.listeners.clear();
    }

    public void initialize(Context context, ArrayList<String> arrayList, Listener listener) {
        if (this.isInitializing) {
            this.listeners.add(listener);
        } else {
            if (this.isInitialized) {
                listener.onInitializeSuccess();
                return;
            }
            this.isInitializing = true;
            getInstance().listeners.add(listener);
            AudienceNetworkAds.buildInitSettings(context).withMediationService("GOOGLE:6.20.0.2").withPlacementIds(arrayList).withInitListener(this).initialize();
        }
    }
}
