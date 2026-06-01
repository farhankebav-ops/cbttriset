package com.vungle.ads.internal.network;

import androidx.annotation.VisibleForTesting;
import androidx.camera.core.impl.utils.futures.d;
import com.vungle.ads.TpatError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.ErrorInfo;
import com.vungle.ads.internal.network.TpatRequest;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import g7.b;
import g7.c;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.k;
import l6.t;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TpatSender {
    public static final Companion Companion = new Companion(null);
    private static final String FAILED_TPATS = "FAILED_TPATS";
    private static final String TAG = "TpatSender";
    private final Executor jobExecutor;
    private final SignalManager signalManager;
    private final FilePreferences tpatFilePreferences;
    private final Object tpatLock;
    private final VungleApiClient vungleApiClient;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public TpatSender(VungleApiClient vungleApiClient, Executor ioExecutor, Executor jobExecutor, PathProvider pathProvider, SignalManager signalManager) {
        k.e(vungleApiClient, "vungleApiClient");
        k.e(ioExecutor, "ioExecutor");
        k.e(jobExecutor, "jobExecutor");
        k.e(pathProvider, "pathProvider");
        this.vungleApiClient = vungleApiClient;
        this.jobExecutor = jobExecutor;
        this.signalManager = signalManager;
        this.tpatFilePreferences = FilePreferences.Companion.get(ioExecutor, pathProvider, FilePreferences.TPAT_FAILED_FILENAME);
        this.tpatLock = new Object();
    }

    private final Map<String, FailedTpat> getStoredTpats() {
        Object objM;
        String string = this.tpatFilePreferences.getString(FAILED_TPATS);
        if (string != null) {
            try {
                b bVar = c.f11597d;
                i7.f fVar = bVar.f11599b;
                int i2 = t.f12828c;
                t tVarZ = n7.b.z(b0.b(String.class));
                t tVarZ2 = n7.b.z(b0.b(FailedTpat.class));
                c0 c0Var = b0.f12719a;
                e eVarA = b0.a(Map.class);
                List listAsList = Arrays.asList(tVarZ, tVarZ2);
                c0Var.getClass();
                f0 f0VarB = c0.b(eVarA, listAsList);
                c0Var.getClass();
                objM = (Map) bVar.a(q.q0(fVar, new f0(f0VarB.f12723a, f0VarB.f12724b, f0VarB.f12725c | 2)), string);
            } catch (Throwable th) {
                objM = q.M(th);
            }
            Throwable thA = q5.k.a(objM);
            if (thA != null) {
                Logger.Companion.e(TAG, "Failed to decode stored tpats: " + thA);
            }
            if (q5.k.a(objM) != null) {
                objM = new LinkedHashMap();
            }
            Map<String, FailedTpat> map = (Map) objM;
            if (map != null) {
                return map;
            }
        }
        return new LinkedHashMap();
    }

    private final boolean isPriorityTpat(String str) {
        return k.a(str, Constants.CHECKPOINT_0) || k.a(str, Constants.CLICK_URL) || k.a(str, "impression") || k.a(str, Constants.LOAD_AD);
    }

    private final void logTpatError(TpatRequest tpatRequest, String str, ErrorInfo errorInfo, Sdk.SDKError.Reason reason) {
        StringBuilder sb = new StringBuilder("tpat key: ");
        sb.append(tpatRequest.getTpatKey());
        sb.append(", error: ");
        sb.append(errorInfo.getDescription());
        sb.append(", errorIsTerminal: ");
        sb.append(errorInfo.getErrorIsTerminal());
        String strR = a1.a.r(sb, " url: ", str);
        Logger.Companion.e(TAG, strR);
        new TpatError(reason, strR).setLogEntry$vungle_ads_release(tpatRequest.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
    }

    private final ErrorInfo performPriorityRetry(TpatRequest tpatRequest, String str) {
        String str2;
        ErrorInfo errorInfoPingTPAT;
        Boolean priorityRetry = tpatRequest.getPriorityRetry();
        int i2 = 0;
        boolean z2 = ConfigManager.INSTANCE.retryPriorityTPATs() && (priorityRetry != null ? priorityRetry.booleanValue() : isPriorityTpat(tpatRequest.getTpatKey()));
        while (true) {
            str2 = str;
            errorInfoPingTPAT = this.vungleApiClient.pingTPAT(str2, tpatRequest.getHeaders(), tpatRequest.getBody(), tpatRequest.getMethod(), tpatRequest.getLogEntry());
            if (!z2 || errorInfoPingTPAT == null || !errorInfoPingTPAT.isRetryCode() || (i2 = i2 + 1) >= tpatRequest.getPriorityRetryCount()) {
                break;
            }
            str = str2;
        }
        if (errorInfoPingTPAT != null) {
            logTpatError(tpatRequest, str2, errorInfoPingTPAT, i2 >= tpatRequest.getPriorityRetryCount() ? Sdk.SDKError.Reason.TPAT_RETRY_FAILED : Sdk.SDKError.Reason.TPAT_ERROR);
        }
        return errorInfoPingTPAT;
    }

    private final void saveStoredTpats(Map<String, FailedTpat> map) {
        Object objM;
        try {
            FilePreferences filePreferences = this.tpatFilePreferences;
            b bVar = c.f11597d;
            i7.f fVar = bVar.f11599b;
            int i2 = t.f12828c;
            t tVarZ = n7.b.z(b0.b(String.class));
            t tVarZ2 = n7.b.z(b0.b(FailedTpat.class));
            c0 c0Var = b0.f12719a;
            e eVarA = b0.a(Map.class);
            List listAsList = Arrays.asList(tVarZ, tVarZ2);
            c0Var.getClass();
            f0 f0VarB = c0.b(eVarA, listAsList);
            c0Var.getClass();
            filePreferences.put(FAILED_TPATS, bVar.b(q.q0(fVar, new f0(f0VarB.f12723a, f0VarB.f12724b, f0VarB.f12725c | 2)), map)).apply();
            objM = x.f13520a;
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (q5.k.a(objM) != null) {
            Logger.Companion.e(TAG, "Failed to encode the about to storing tpats: " + map);
        }
    }

    public static /* synthetic */ void sendTpat$default(TpatSender tpatSender, TpatRequest tpatRequest, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        tpatSender.sendTpat(tpatRequest, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendTpat$lambda-1, reason: not valid java name */
    public static final void m3329sendTpat$lambda1(TpatSender this$0, TpatRequest request, String urlWithSessionId, boolean z2) {
        FailedTpat failedTpat;
        k.e(this$0, "this$0");
        k.e(request, "$request");
        k.e(urlWithSessionId, "$urlWithSessionId");
        ErrorInfo errorInfoPerformPriorityRetry = this$0.performPriorityRetry(request, urlWithSessionId);
        if (request.getRegularRetry()) {
            if (errorInfoPerformPriorityRetry == null || !errorInfoPerformPriorityRetry.getErrorIsTerminal()) {
                if (errorInfoPerformPriorityRetry != null || z2) {
                    synchronized (this$0.tpatLock) {
                        try {
                            Map<String, FailedTpat> storedTpats = this$0.getStoredTpats();
                            FailedTpat failedTpat2 = storedTpats.get(request.getUrl());
                            int retryAttempt = failedTpat2 != null ? failedTpat2.getRetryAttempt() : 0;
                            if (errorInfoPerformPriorityRetry == null && retryAttempt > 0) {
                                storedTpats.remove(request.getUrl());
                                this$0.saveStoredTpats(storedTpats);
                            } else if (errorInfoPerformPriorityRetry != null && retryAttempt >= request.getRegularRetryCount()) {
                                storedTpats.remove(request.getUrl());
                                this$0.saveStoredTpats(storedTpats);
                                this$0.logTpatError(request, urlWithSessionId, errorInfoPerformPriorityRetry, Sdk.SDKError.Reason.TPAT_RETRY_FAILED);
                            } else if (errorInfoPerformPriorityRetry != null) {
                                FailedTpat failedTpat3 = storedTpats.get(request.getUrl());
                                if (failedTpat3 == null || (failedTpat = FailedTpat.copy$default(failedTpat3, null, null, null, retryAttempt + 1, 0, null, 55, null)) == null) {
                                    failedTpat = new FailedTpat(request.getMethod(), request.getHeaders(), request.getBody(), 1, request.getRegularRetryCount(), request.getTpatKey());
                                }
                                storedTpats.put(request.getUrl(), failedTpat);
                                this$0.saveStoredTpats(storedTpats);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public final Executor getJobExecutor() {
        return this.jobExecutor;
    }

    public final SignalManager getSignalManager() {
        return this.signalManager;
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    @VisibleForTesting
    public final String injectSessionIdToUrl(String url) {
        k.e(url, "url");
        SignalManager signalManager = this.signalManager;
        String uuid = signalManager != null ? signalManager.getUuid() : null;
        if (uuid == null) {
            uuid = "";
        }
        if (uuid.length() <= 0) {
            return url;
        }
        String strQuote = Pattern.quote(Constants.SESSION_ID);
        k.d(strQuote, "quote(Constants.SESSION_ID)");
        Pattern patternCompile = Pattern.compile(strQuote);
        k.d(patternCompile, "compile(...)");
        String strReplaceAll = patternCompile.matcher(url).replaceAll(uuid);
        k.d(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final void resendStoredTpats$vungle_ads_release() {
        for (Map.Entry<String, FailedTpat> entry : getStoredTpats().entrySet()) {
            String key = entry.getKey();
            FailedTpat value = entry.getValue();
            sendTpat(new TpatRequest.Builder(key).regularRetry(true).priorityRetry(false).headers(value.getHeaders()).body(value.getBody()).regularRetryCount(value.getRetryCount()).method(value.getMethod()).tpatKey(value.getTpatKey()).build(), true);
        }
    }

    public final void sendTpat(TpatRequest request, boolean z2) {
        k.e(request, "request");
        this.jobExecutor.execute(new d(this, request, injectSessionIdToUrl(request.getUrl()), z2, 5));
    }

    public /* synthetic */ TpatSender(VungleApiClient vungleApiClient, Executor executor, Executor executor2, PathProvider pathProvider, SignalManager signalManager, int i2, f fVar) {
        this(vungleApiClient, executor, executor2, pathProvider, (i2 & 16) != 0 ? null : signalManager);
    }
}
