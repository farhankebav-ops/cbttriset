package sg.bigo.ads.api.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f15477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<WeakReference<InterfaceC0278a>> f15478b;

    /* JADX INFO: renamed from: sg.bigo.ads.api.core.a$a, reason: collision with other inner class name */
    public interface InterfaceC0278a {
        void a();

        void b();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f15481a = new a(0);
    }

    private a() {
        this.f15478b = new ArrayList();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator<WeakReference<InterfaceC0278a>> it = this.f15478b.iterator();
        while (it.hasNext()) {
            it.next().get();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Iterator<WeakReference<InterfaceC0278a>> it = this.f15478b.iterator();
        while (it.hasNext()) {
            it.next().get();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Iterator<WeakReference<InterfaceC0278a>> it = this.f15478b.iterator();
        while (it.hasNext()) {
            InterfaceC0278a interfaceC0278a = it.next().get();
            if (interfaceC0278a != null) {
                interfaceC0278a.b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f15477a = new WeakReference<>(activity);
        Iterator<WeakReference<InterfaceC0278a>> it = this.f15478b.iterator();
        while (it.hasNext()) {
            InterfaceC0278a interfaceC0278a = it.next().get();
            if (interfaceC0278a != null) {
                interfaceC0278a.a();
            }
        }
    }

    public /* synthetic */ a(byte b8) {
        this();
    }

    public static a a() {
        return b.f15481a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
