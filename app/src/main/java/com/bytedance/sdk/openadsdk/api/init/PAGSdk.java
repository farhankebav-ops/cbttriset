package com.bytedance.sdk.openadsdk.api.init;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import com.bytedance.adsdk.ugeno.Bc.tV;
import com.bytedance.sdk.component.DmF.Cc;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.component.IlO;
import com.bytedance.sdk.component.lEW.NV;
import com.bytedance.sdk.component.utils.MY;
import com.bytedance.sdk.component.utils.lEW;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.Bc.MY;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.ea;
import com.bytedance.sdk.openadsdk.core.lEW.rp;
import com.bytedance.sdk.openadsdk.core.settings.DmF;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.core.wPn;
import com.bytedance.sdk.openadsdk.multipro.EO;
import com.bytedance.sdk.openadsdk.utils.AXM;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.es;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import com.bytedance.sdk.openadsdk.vAh.IlO;
import com.ironsource.C2300e4;
import com.ironsource.C2543s;
import com.ironsource.Y1;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
import r.a;
import z5.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    private static long IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface PAGInitCallback {
        void fail(int i2, String str);

        void success();
    }

    static {
        try {
            IlO.IlO(new IlO.InterfaceC0046IlO() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.1
                @Override // com.bytedance.sdk.component.IlO.InterfaceC0046IlO
                public ExecutorService getExecutorService() {
                    return mmj.Cc();
                }

                @Override // com.bytedance.sdk.component.IlO.InterfaceC0046IlO
                public HandlerThread getSafeHandlerThread(String str, int i2) {
                    return lEW.IlO(str, i2);
                }
            });
            mmj.IlO(new com.bytedance.sdk.component.lEW.lEW("tt_init_memory_data") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().IlO(false);
                    PAGInitHelper.initAPM();
                    PAGInitHelper.initMemoryData();
                }
            });
            bWL.IlO(System.currentTimeMillis());
            bWL.MY();
            vCE.setWebViewProvider(new vCE.EO() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.3
                @Override // com.bytedance.sdk.component.DmF.vCE.EO
                public WebView createWebView(Context context, AttributeSet attributeSet, int i2) {
                    if (!(context instanceof MutableContextWrapper)) {
                        context = context.getApplicationContext();
                    }
                    try {
                        return i2 == 0 ? new Cc(context, attributeSet) : new Cc(context, attributeSet, i2);
                    } catch (Exception unused) {
                        return i2 == 0 ? new Cc(context, attributeSet) : new Cc(context, attributeSet, i2);
                    }
                }
            });
        } catch (Throwable th) {
            Log.i("TTAD.PAGSdk", th.getMessage());
        }
        IlO = 0L;
    }

    private static void Cc(Context context, InitConfig initConfig) {
        if (DmF.IlO()) {
            com.bytedance.sdk.component.lEW.vCE.EO(-1);
            com.bytedance.sdk.component.lEW.Cc.IlO(new NV() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7
                @Override // com.bytedance.sdk.component.lEW.NV
                public com.bytedance.sdk.component.lEW.DmF createThreadFactory(int i2, String str) {
                    return new com.bytedance.sdk.component.lEW.DmF(i2, str) { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7.1
                        @Override // com.bytedance.sdk.component.lEW.DmF, java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            if (com.bytedance.sdk.component.lEW.DmF.sCrashHappened) {
                                return null;
                            }
                            int iTx = hp.aP().Tx();
                            if (iTx < -524288 || iTx >= 0) {
                                return super.newThread(runnable);
                            }
                            Thread thread = new Thread(this.IlO, runnable, this.MY, iTx);
                            if (thread.isDaemon()) {
                                thread.setDaemon(false);
                            }
                            int i8 = this.EO;
                            if (i8 > 10 || i8 <= 0) {
                                this.EO = 5;
                            }
                            thread.setPriority(this.EO);
                            return thread;
                        }
                    };
                }
            });
            EO.IlO(context);
            MY.EO();
            bWL.MY.set(true);
            try {
                com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().IlO(new com.bytedance.sdk.openadsdk.DmF.IlO());
            } catch (Exception e) {
                oeT.EO("TTAD.PAGSdk", e.getMessage());
            }
            EO(initConfig);
            EO(context, initConfig);
            a.f13608a = context;
            a.f13609b = null;
            a.e = 2;
            a.f13610c = initConfig.isSupportMultiProcess();
            a.f13611d = Bc.IlO().MY().vCE();
        }
    }

    private static void EO(Context context, InitConfig initConfig) {
        bWL.IlO = true;
        wPn.IlO().IlO(initConfig.getAppId()).MY(initConfig.getGdpr()).Cc(initConfig.getPA()).tV(initConfig.getAppIconId()).IlO(initConfig.getTitleBarTheme()).EO(initConfig.getAdxId());
        com.bytedance.sdk.openadsdk.core.DmF.pP();
        if (initConfig instanceof PAGConfig) {
            wPn.IlO().EO(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        try {
            if (MY(initConfig)) {
                wPn.IlO().IlO();
                es.IlO();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.utils.DmF.IlO();
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && bWL.tV() == 0) {
            PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
        }
    }

    public static void closeMultiWebViewFileLock() {
        EO.IlO();
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static void getBiddingToken(final Context context, final PAGBiddingRequest pAGBiddingRequest, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            mmj.Cc(new com.bytedance.sdk.component.lEW.lEW("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.13
                @Override // java.lang.Runnable
                public void run() {
                    cl.MY(context);
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.MY(pAGBiddingRequest));
                    com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().IlO(false);
                }
            });
        }
    }

    public static String getSDKVersion() {
        return wPn.IlO() != null ? wPn.IlO().EO() : "";
    }

    public static void init(final Context context, final PAGConfig pAGConfig, final PAGInitCallback pAGInitCallback) {
        bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.12
            @Override // java.lang.Runnable
            public void run() {
                PAGSdk.MY(context, pAGConfig, pAGInitCallback);
            }
        });
        bWL.lEW();
    }

    public static boolean isInitSuccess() {
        return bWL.tV() == 1;
    }

    public static boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4) {
        if (wPn.IlO() != null) {
            return wPn.IlO().IlO(str, i2, str2, str3, str4);
        }
        return false;
    }

    public static void setAabPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pP.IlO(str);
        tV.IlO(str);
    }

    public static void setAdRevenue(JSONObject jSONObject) {
        if (jSONObject != null && cl.tV().cl() && isInitSuccess()) {
            com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO(jSONObject);
        }
    }

    private static void setSdkDisable(boolean z2) {
        com.bytedance.sdk.openadsdk.common.Cc.IlO(z2);
    }

    private static void tV(Context context, InitConfig initConfig) {
        if (TextUtils.isEmpty(initConfig.getPackageName())) {
            pP.IlO((String) null);
            tV.IlO((String) null);
        } else {
            pP.IlO(initConfig.getPackageName());
            tV.IlO(initConfig.getPackageName());
        }
        cl.MY(context);
        if (initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.multipro.MY.IlO();
        } else {
            com.bytedance.sdk.openadsdk.multipro.MY.MY();
        }
        rp.IlO();
        com.bytedance.sdk.openadsdk.core.NV.MY.IlO(context);
    }

    private static void vCE(final Context context, final InitConfig initConfig) {
        SystemClock.elapsedRealtime();
        mmj.IlO(new com.bytedance.sdk.component.lEW.lEW("init_sync") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8
            @Override // java.lang.Runnable
            public void run() {
                bWL.IlO(initConfig.getData());
                com.bytedance.sdk.openadsdk.AXM.IlO.IlO(context, initConfig.getAppId());
                com.bytedance.sdk.openadsdk.AXM.IlO.IlO();
                com.bytedance.sdk.openadsdk.cl.EO.IlO();
                com.bytedance.sdk.openadsdk.cl.EO.MY();
                new zPa();
                com.bytedance.sdk.component.adexpress.IlO.MY.vCE.IlO(AXM.IlO() * 10);
                com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(context, initConfig.isSupportMultiProcess());
                ea.IlO().MY();
                com.bytedance.sdk.openadsdk.core.DmF.EO.IlO();
                com.bytedance.sdk.openadsdk.vAh.IlO.IlO(new IlO.InterfaceC0122IlO() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.1
                    public void onGdprChanged(int i2) {
                        PAGConfig.setGDPRConsent(i2);
                    }
                });
                hp.tV = hp.EO(context);
                com.bytedance.sdk.openadsdk.kBB.MY.Bc.MY();
                JSONObject jSONObjectWD = cl.tV().wD();
                if (jSONObjectWD != null) {
                    try {
                        b.f17987b = jSONObjectWD.optInt("splash", 10);
                        b.f17988c = jSONObjectWD.optInt(C2543s.j, 10);
                        b.f17989d = jSONObjectWD.optInt("brand", 10);
                        int iOptInt = jSONObjectWD.optInt(Y1.f7807d, 10);
                        b.e = iOptInt;
                        if (b.f17987b < 0) {
                            b.f17987b = 10;
                        }
                        if (b.f17988c < 0) {
                            b.f17988c = 10;
                        }
                        if (b.f17989d < 0) {
                            b.f17989d = 10;
                        }
                        if (iOptInt < 0) {
                            b.e = 10;
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                b.f17986a = CacheDirFactory.getICacheDir(0);
                com.bytedance.sdk.openadsdk.core.settings.vCE vceTV = cl.tV();
                if (!vceTV.uvo()) {
                    synchronized (vceTV) {
                        try {
                            if (!vceTV.uvo()) {
                                vceTV.MY();
                                vceTV.OOq();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                DeviceUtils.NV();
                PAGInitHelper.maybeAsyncInitTask(context);
                PAGSdk.getBiddingToken();
                com.bytedance.sdk.component.lEW.vCE.IlO(true);
                com.bytedance.sdk.component.lEW.vCE.IlO(new com.bytedance.sdk.openadsdk.ea.MY.IlO());
                DeviceUtils.IlO(context);
                DeviceUtils.rp(context);
                DeviceUtils.hp(context);
                com.bytedance.sdk.openadsdk.ea.IlO.IlO();
                com.bytedance.sdk.openadsdk.core.settings.tV.IlO();
                com.bytedance.sdk.openadsdk.ea.EO.tV();
                zLG.hp(context);
                com.bytedance.sdk.openadsdk.tV.EO.IlO();
                PAGSdk.EO();
                com.bytedance.sdk.openadsdk.core.DmF.EO.MY();
                com.bytedance.sdk.openadsdk.core.tV.IlO.IlO().MY();
                com.bytedance.sdk.component.lEW.EO.EO.IlO(bWL.MY());
                com.bytedance.sdk.component.utils.MY.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8.2
                    @Override // com.bytedance.sdk.component.utils.MY.IlO
                    public ExecutorService getAsyncStartActivityThreadPool() {
                        return mmj.DmF();
                    }

                    @Override // com.bytedance.sdk.component.utils.MY.IlO
                    public boolean isEnableAsyncStartActivity() {
                        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("start_activity_async", 0) == 1;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Context applicationContext;
        IlO = SystemClock.elapsedRealtime();
        cl.MY(context);
        if (pAGInitCallback != null) {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                if (!list.contains(pAGInitCallback)) {
                    list.add(pAGInitCallback);
                    if (bWL.tV() == 3) {
                        return;
                    }
                }
            }
        }
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            MY(-1, "DisableSDK is called, interrupt initialization");
            return;
        }
        if (isInitSuccess()) {
            tV();
            EO(initConfig);
            return;
        }
        if (initConfig == null) {
            MY(4000, "PAGConfig is null, please check.");
            return;
        }
        bWL.IlO(3);
        int pa = initConfig.getPA();
        if (pa < -1 || pa > 1) {
            MY(10004, com.bytedance.sdk.openadsdk.core.lEW.IlO(10004));
            return;
        }
        if (context == null) {
            MY(4000, "Context is null, please check. ");
            return;
        }
        if (!(context instanceof Application) && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        tV(context, initConfig);
        ApmHelper.initApm(context, initConfig);
        try {
            com.bytedance.sdk.openadsdk.core.DmF.IlO(new com.bytedance.sdk.openadsdk.core.hp() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.4
                @Override // com.bytedance.sdk.openadsdk.core.hp
                public void fail(int i2, String str) {
                    PAGSdk.MY(i2, str);
                }

                public void success() {
                    PAGSdk.tV();
                }
            });
            try {
                pP.IlO(cl.IlO(), "tt_ad_logo_txt");
                if (pP.tV(context, "tt_ad_logo") == 0) {
                    IlO(initConfig, pAGInitCallback);
                    return;
                }
                if (isInitSuccess()) {
                    if (pAGInitCallback != null) {
                        tV();
                        return;
                    }
                    return;
                }
                final com.bytedance.sdk.openadsdk.Cc.IlO ilO = new com.bytedance.sdk.openadsdk.Cc.IlO();
                SDKTypeConfig.setSdkTypeFactory(new ISDKTypeFactory() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.5
                    @Override // com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory
                    public IADTypeLoaderFactory createADTypeLoaderFactory(String str) {
                        return ilO;
                    }
                });
                if (!initConfig.isSupportMultiProcess()) {
                    MY(context, initConfig);
                } else {
                    com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO().IlO(new com.bytedance.sdk.openadsdk.multipro.aidl.MY() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6
                        @Override // com.bytedance.sdk.openadsdk.multipro.aidl.MY
                        public void onServiceConnected() {
                            bWL.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    PAGSdk.MY(context, initConfig);
                                }
                            });
                        }
                    });
                    com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO().EO();
                }
            } catch (Throwable unused) {
                IlO(initConfig, pAGInitCallback);
            }
        } catch (Throwable unused2) {
            MY(4000, "Internal Error, setting exception. ");
        }
    }

    public static void getBiddingToken(final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            mmj.Cc(new com.bytedance.sdk.component.lEW.lEW("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.14
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken());
                    com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().IlO(false);
                }
            });
        }
    }

    private static void IlO(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        bWL.IlO(2);
        if (pAGInitCallback != null) {
            if (initConfig instanceof PAGConfig) {
                MY(4000, "resources not found, if you use aab please call PAGConfig.setPackageName");
            } else {
                MY(4000, "resources not found, if you use aab please call TTAdConfig.setPackageName");
            }
        }
    }

    public static void getBiddingToken(final String str, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            mmj.Cc(new com.bytedance.sdk.component.lEW.lEW("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.15
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken(str));
                    com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().IlO(false);
                }
            });
        }
    }

    public static String getBiddingToken(Context context) {
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            return null;
        }
        cl.MY(context);
        return getBiddingToken();
    }

    private static void IlO(final Context context, final boolean z2, final InitConfig initConfig, final long j, final long j3) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO();
        com.bytedance.sdk.openadsdk.ea.EO.IlO("pangle_sdk_init", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean zEO = com.bytedance.sdk.openadsdk.core.DmF.MY().EO();
                    jSONObject.put("duration", j);
                    jSONObject.put("sdk_init_time", j3);
                    jSONObject.put("is_async", true);
                    jSONObject.put("is_multi_process", initConfig.isSupportMultiProcess());
                    jSONObject.put("is_debug", PAGSdk.MY(initConfig));
                    jSONObject.put("is_use_texture_view", initConfig.isUseTextureView());
                    jSONObject.put("is_activate_init", zEO);
                    jSONObject.put("minSdkVersion", zLG.EV(context));
                    jSONObject.put("targetSdkVersion", zLG.NV(context));
                    jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                    jSONObject.put("is_success", z2);
                    com.bytedance.sdk.openadsdk.core.DmF.MY().MY(false);
                } catch (Exception e) {
                    oeT.IlO("TTAD.PAGSdk", "run: ", e);
                }
                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("pangle_sdk_init").MY(jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tV() {
        bWL.IlO(1);
        try {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                try {
                    Iterator<PAGInitCallback> it = list.iterator();
                    while (it.hasNext()) {
                        PAGInitCallback next = it.next();
                        if (next != null) {
                            it.remove();
                            next.success();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.10
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return androidx.camera.core.processing.util.a.d(C2300e4.a.f8295f);
                }
            });
        } catch (Throwable th2) {
            oeT.EO(th2.getMessage(), new Object[0]);
        }
    }

    public static String getBiddingToken(Context context, String str) {
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            return null;
        }
        cl.MY(context);
        return getBiddingToken(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void EO() {
        ShortcutManager shortcutManagerB;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Context contextIlO = cl.IlO();
                if (contextIlO == null || (shortcutManagerB = androidx.core.content.pm.b.b(contextIlO.getSystemService(androidx.core.content.pm.b.d()))) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.DmF.MY().IlO(shortcutManagerB.isRequestPinShortcutSupported());
            } catch (Throwable unused) {
            }
        }
    }

    public static String getBiddingToken(String str) {
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            return null;
        }
        if (cl.IlO() == null || wPn.IlO() == null) {
            return "";
        }
        PAGBiddingRequest pAGBiddingRequest = new PAGBiddingRequest();
        pAGBiddingRequest.setSlotId(str);
        return wPn.IlO().IlO(pAGBiddingRequest);
    }

    private static void EO(InitConfig initConfig) {
        if (initConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(initConfig.getData())) {
            com.bytedance.sdk.openadsdk.core.DmF.MY().EO(initConfig.getData());
        }
        com.bytedance.sdk.openadsdk.core.DmF.MY().EO(MY(initConfig));
    }

    public static String getBiddingToken() {
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            return null;
        }
        return (cl.IlO() == null || wPn.IlO() == null) ? "" : wPn.IlO().IlO((PAGBiddingRequest) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(Context context, InitConfig initConfig) {
        long j;
        try {
        } catch (Throwable th) {
            th.getMessage();
            oeT.EO("TTAD.PAGSdk", th.getMessage());
            long jElapsedRealtime = SystemClock.elapsedRealtime() - IlO;
            MY(4000, th.getMessage());
            j = jElapsedRealtime;
        }
        if (isInitSuccess()) {
            tV();
            return;
        }
        Cc(context, initConfig);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - IlO;
        tV();
        vCE(context, initConfig);
        j = jElapsedRealtime2;
        IlO(context, isInitSuccess(), initConfig, SystemClock.elapsedRealtime() - IlO, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MY(InitConfig initConfig) {
        return ((PAGConfig) initConfig).getDebugLog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(int i2, String str) {
        bWL.IlO(2);
        try {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                try {
                    Iterator<PAGInitCallback> it = list.iterator();
                    while (it.hasNext()) {
                        PAGInitCallback next = it.next();
                        if (next != null) {
                            it.remove();
                            next.fail(i2, str);
                        }
                    }
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.11
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return androidx.camera.core.processing.util.a.d(C2300e4.a.f8295f);
                        }
                    });
                } finally {
                }
            }
        } catch (Throwable th) {
            oeT.EO(th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String MY(PAGBiddingRequest pAGBiddingRequest) {
        if (com.bytedance.sdk.openadsdk.common.Cc.IlO()) {
            return null;
        }
        return (cl.IlO() == null || wPn.IlO() == null) ? "" : wPn.IlO().IlO(pAGBiddingRequest);
    }
}
