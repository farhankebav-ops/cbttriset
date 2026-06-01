package com.ironsource.environment;

import android.app.Activity;
import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ContextProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ContextProvider f8476d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f8477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f8478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f8479c = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private ContextProvider() {
    }

    public static ContextProvider getInstance() {
        if (f8476d == null) {
            synchronized (ContextProvider.class) {
                try {
                    if (f8476d == null) {
                        f8476d = new ContextProvider();
                    }
                } finally {
                }
            }
        }
        return f8476d;
    }

    public Context getActiveContext() {
        Activity activity = this.f8477a;
        return activity != null ? activity : this.f8478b;
    }

    public Context getApplicationContext() {
        Activity activity;
        Context context = this.f8478b;
        return (context != null || (activity = this.f8477a) == null) ? context : activity.getApplicationContext();
    }

    public Activity getCurrentActiveActivity() {
        return this.f8477a;
    }

    public void onPause(Activity activity) {
        if (activity != null) {
            Iterator<a> it = this.f8479c.values().iterator();
            while (it.hasNext()) {
                it.next().onPause(activity);
            }
        }
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            this.f8477a = activity;
            Iterator<a> it = this.f8479c.values().iterator();
            while (it.hasNext()) {
                it.next().onResume(this.f8477a);
            }
        }
    }

    public void registerLifeCycleListener(a aVar) {
        this.f8479c.put(aVar.getClass().getSimpleName(), aVar);
    }

    public void updateActivity(Activity activity) {
        if (activity != null) {
            this.f8477a = activity;
        }
    }

    public void updateAppContext(Context context) {
        if (context != null) {
            this.f8478b = context;
        }
    }
}
