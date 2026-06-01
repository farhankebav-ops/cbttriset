package com.mimikridev.ads.initialization;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.ironsource.C2300e4;
import com.mimikridev.ads.helper.AudienceNetworkInitializeHelper;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayConfiguration;
import com.unity3d.mediation.LevelPlayInitError;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class InitializeAd {
    private static final String TAG = "AdNetwork";
    Activity activity;
    private String adStatus = "";
    private String adNetwork = "";
    private String backupAdNetwork = "";
    private String adMobAppId = "";
    private String startappAppId = "0";
    private String unityGameId = "";
    private String appLovinSdkKey = "";
    private String mopubBannerId = "";
    private String ironSourceAppKey = "";
    private String wortiseAppId = "";
    private String pangleAppId = "";
    private boolean debug = true;

    /* JADX INFO: renamed from: com.mimikridev.ads.initialization.InitializeAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 implements LevelPlayInitListener {
        final /* synthetic */ LevelPlayInitRequest val$initRequest;

        public AnonymousClass1(LevelPlayInitRequest levelPlayInitRequest) {
            this.val$initRequest = levelPlayInitRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInitFailed$0(LevelPlayInitRequest levelPlayInitRequest) {
            Log.d(InitializeAd.TAG, "[IronSource] Retrying initialization...");
            LevelPlay.init(InitializeAd.this.activity, levelPlayInitRequest, this);
        }

        @Override // com.unity3d.mediation.LevelPlayInitListener
        public void onInitFailed(@NonNull LevelPlayInitError levelPlayInitError) {
            Log.e(InitializeAd.TAG, "[IronSource] Init failed: " + levelPlayInitError.getErrorMessage());
            new Handler(Looper.getMainLooper()).postDelayed(new a(this, this.val$initRequest, 0), 5000L);
        }

        @Override // com.unity3d.mediation.LevelPlayInitListener
        public void onInitSuccess(@NonNull LevelPlayConfiguration levelPlayConfiguration) {
            Log.d(InitializeAd.TAG, "[IronSource] Init success, ready to load ads");
        }
    }

    /* JADX INFO: renamed from: com.mimikridev.ads.initialization.InitializeAd$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass3 implements LevelPlayInitListener {
        final /* synthetic */ LevelPlayInitRequest val$initRequest;

        public AnonymousClass3(LevelPlayInitRequest levelPlayInitRequest) {
            this.val$initRequest = levelPlayInitRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInitFailed$0(LevelPlayInitRequest levelPlayInitRequest) {
            Log.d(InitializeAd.TAG, "[IronSource] Retrying initialization...");
            LevelPlay.init(InitializeAd.this.activity, levelPlayInitRequest, this);
        }

        @Override // com.unity3d.mediation.LevelPlayInitListener
        public void onInitFailed(@NonNull LevelPlayInitError levelPlayInitError) {
            Log.e(InitializeAd.TAG, "[IronSource] Init failed: " + levelPlayInitError.getErrorMessage());
            new Handler(Looper.getMainLooper()).postDelayed(new a(this, this.val$initRequest, 1), 5000L);
        }

        @Override // com.unity3d.mediation.LevelPlayInitListener
        public void onInitSuccess(@NonNull LevelPlayConfiguration levelPlayConfiguration) {
            Log.d(InitializeAd.TAG, "[IronSource] Init success, ready to load ads");
        }
    }

    public InitializeAd(Activity activity) {
        this.activity = activity;
    }

    private void initAds() {
        if (this.adStatus.equals("1")) {
            String str = this.adNetwork;
            str.getClass();
            switch (str) {
                case "pangle":
                    PAGSdk.init(this.activity, new PAGConfig.Builder().appId(this.pangleAppId).debugLog(true).supportMultiProcess(false).build(), new PAGSdk.PAGInitCallback() { // from class: com.mimikridev.ads.initialization.InitializeAd.2
                        @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                        public void fail(int i2, String str2) {
                            Log.i(InitializeAd.TAG, "pangle init fail: " + i2 + " : " + str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                        public void success() {
                            Log.i(InitializeAd.TAG, "pangle init success: " + InitializeAd.this.pangleAppId + " : " + PAGSdk.isInitSuccess());
                        }
                    });
                    break;
                case "ironsource":
                    LevelPlayInitRequest levelPlayInitRequestBuild = new LevelPlayInitRequest.Builder(this.ironSourceAppKey).build();
                    LevelPlay.init(this.activity, levelPlayInitRequestBuild, new AnonymousClass1(levelPlayInitRequestBuild));
                    Log.d(TAG, "[IronSource] Initialize complete");
                    break;
                case "admob":
                case "facebook":
                    AudienceNetworkInitializeHelper.initializeAd(this.activity, this.debug);
                    break;
            }
            Log.d(TAG, C2300e4.i.f8403d + this.adNetwork + "] is selected as Primary Ads");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initBackupAds() {
        /*
            r4 = this;
            java.lang.String r0 = r4.adStatus
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L9c
            java.lang.String r0 = r4.backupAdNetwork
            int r1 = r0.hashCode()
            java.lang.String r2 = "AdNetwork"
            switch(r1) {
                case -995541405: goto L59;
                case -927389981: goto L36;
                case 3387192: goto L2f;
                case 92668925: goto L1f;
                case 497130182: goto L16;
                default: goto L15;
            }
        L15:
            goto L84
        L16:
            java.lang.String r1 = "facebook"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            goto L27
        L1f:
            java.lang.String r1 = "admob"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
        L27:
            android.app.Activity r0 = r4.activity
            boolean r1 = r4.debug
            com.mimikridev.ads.helper.AudienceNetworkInitializeHelper.initializeAd(r0, r1)
            goto L84
        L2f:
            java.lang.String r1 = "none"
            boolean r0 = r0.equals(r1)
            goto L84
        L36:
            java.lang.String r1 = "ironsource"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            com.unity3d.mediation.LevelPlayInitRequest$Builder r0 = new com.unity3d.mediation.LevelPlayInitRequest$Builder
            java.lang.String r1 = r4.ironSourceAppKey
            r0.<init>(r1)
            com.unity3d.mediation.LevelPlayInitRequest r0 = r0.build()
            com.mimikridev.ads.initialization.InitializeAd$3 r1 = new com.mimikridev.ads.initialization.InitializeAd$3
            r1.<init>(r0)
            android.app.Activity r3 = r4.activity
            com.unity3d.mediation.LevelPlay.init(r3, r0, r1)
            java.lang.String r0 = "[IronSource] Initialize complete"
            android.util.Log.d(r2, r0)
            goto L84
        L59:
            java.lang.String r1 = "pangle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder r0 = new com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder
            r0.<init>()
            java.lang.String r1 = r4.pangleAppId
            com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder r0 = r0.appId(r1)
            r1 = 1
            com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder r0 = r0.debugLog(r1)
            r1 = 0
            com.bytedance.sdk.openadsdk.api.init.PAGConfig$Builder r0 = r0.supportMultiProcess(r1)
            com.bytedance.sdk.openadsdk.api.init.PAGConfig r0 = r0.build()
            android.app.Activity r1 = r4.activity
            com.mimikridev.ads.initialization.InitializeAd$4 r3 = new com.mimikridev.ads.initialization.InitializeAd$4
            r3.<init>()
            com.bytedance.sdk.openadsdk.api.init.PAGSdk.init(r1, r0, r3)
        L84:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "["
            r0.<init>(r1)
            java.lang.String r1 = r4.backupAdNetwork
            r0.append(r1)
            java.lang.String r1 = "] is selected as Backup Ads"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mimikridev.ads.initialization.InitializeAd.initBackupAds():void");
    }

    public InitializeAd build() {
        initAds();
        initBackupAds();
        return this;
    }

    public InitializeAd setAdMobAppId(String str) {
        this.adMobAppId = str;
        return this;
    }

    public InitializeAd setAdNetwork(String str) {
        this.adNetwork = str;
        return this;
    }

    public InitializeAd setAdStatus(String str) {
        this.adStatus = str;
        return this;
    }

    public InitializeAd setAppLovinSdkKey(String str) {
        this.appLovinSdkKey = str;
        return this;
    }

    public InitializeAd setBackupAdNetwork(String str) {
        this.backupAdNetwork = str;
        return this;
    }

    public InitializeAd setDebug(boolean z2) {
        this.debug = z2;
        return this;
    }

    public InitializeAd setIronSourceAppKey(String str) {
        this.ironSourceAppKey = str;
        return this;
    }

    public InitializeAd setMopubBannerId(String str) {
        this.mopubBannerId = str;
        return this;
    }

    public InitializeAd setPangleAppId(String str) {
        this.pangleAppId = str;
        return this;
    }

    public InitializeAd setStartappAppId(String str) {
        this.startappAppId = str;
        return this;
    }

    public InitializeAd setUnityGameId(String str) {
        this.unityGameId = str;
        return this;
    }

    public InitializeAd setWortiseAppId(String str) {
        this.wortiseAppId = str;
        return this;
    }
}
