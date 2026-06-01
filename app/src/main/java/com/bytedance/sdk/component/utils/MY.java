package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static IlO IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        ExecutorService getAsyncStartActivityThreadPool();

        boolean isEnableAsyncStartActivity();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.MY$MY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0060MY {
        void IlO();

        void IlO(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean EO(Context context, Intent intent, InterfaceC0060MY interfaceC0060MY) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (interfaceC0060MY == null) {
                    return true;
                }
                interfaceC0060MY.IlO();
                return true;
            } catch (Throwable th) {
                if (interfaceC0060MY != null) {
                    interfaceC0060MY.IlO(th);
                }
            }
        }
        return false;
    }

    public static void IlO(IlO ilO) {
        IlO = ilO;
    }

    public static boolean IlO(Context context, Intent intent, InterfaceC0060MY interfaceC0060MY) {
        return IlO(context, intent, interfaceC0060MY, false);
    }

    public static boolean IlO(final Context context, final Intent intent, final InterfaceC0060MY interfaceC0060MY, boolean z2) {
        IlO ilO;
        ExecutorService asyncStartActivityThreadPool;
        if (z2 && (ilO = IlO) != null && ilO.isEnableAsyncStartActivity() && (asyncStartActivityThreadPool = IlO.getAsyncStartActivityThreadPool()) != null) {
            asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.lEW.lEW("startAct") { // from class: com.bytedance.sdk.component.utils.MY.1
                @Override // java.lang.Runnable
                public void run() {
                    MY.EO(context, intent, interfaceC0060MY);
                }
            });
            return true;
        }
        return EO(context, intent, interfaceC0060MY);
    }

    public static Activity IlO(View view) {
        View viewFindViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (viewFindViewById = rootView.findViewById(R.id.content)) == null || (context = viewFindViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}
