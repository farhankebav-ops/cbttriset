package com.vungle.ads.internal.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ThreadUtil {
    public static final ThreadUtil INSTANCE = new ThreadUtil();
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
    private static Executor uiExecutor;

    private ThreadUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runOnUiThread$lambda-0, reason: not valid java name */
    public static final void m3380runOnUiThread$lambda0(e6.a tmp0) {
        k.e(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runOnUiThread$lambda-1, reason: not valid java name */
    public static final void m3381runOnUiThread$lambda1(e6.a tmp0) {
        k.e(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final Executor getUiExecutor$vungle_ads_release() {
        return uiExecutor;
    }

    public final boolean isMainThread() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        return mainLooper.isCurrentThread();
    }

    public final void runOnUiThread(final e6.a block) {
        k.e(block, "block");
        if (isMainThread()) {
            block.invoke();
            return;
        }
        Executor executor = uiExecutor;
        if (executor != null) {
            final int i2 = 0;
            executor.execute(new Runnable() { // from class: com.vungle.ads.internal.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            ThreadUtil.m3380runOnUiThread$lambda0(block);
                            break;
                        default:
                            ThreadUtil.m3381runOnUiThread$lambda1(block);
                            break;
                    }
                }
            });
        } else {
            final int i8 = 1;
            UI_HANDLER.post(new Runnable() { // from class: com.vungle.ads.internal.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i8) {
                        case 0:
                            ThreadUtil.m3380runOnUiThread$lambda0(block);
                            break;
                        default:
                            ThreadUtil.m3381runOnUiThread$lambda1(block);
                            break;
                    }
                }
            });
        }
    }

    public final void setUiExecutor$vungle_ads_release(Executor executor) {
        uiExecutor = executor;
    }

    @VisibleForTesting
    public static /* synthetic */ void getUiExecutor$vungle_ads_release$annotations() {
    }
}
