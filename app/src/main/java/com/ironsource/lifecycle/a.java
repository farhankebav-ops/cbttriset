package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class a extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8931b = "com.ironsource.lifecycle.IronsourceLifecycleFragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0189a f8932a;

    /* JADX INFO: renamed from: com.ironsource.lifecycle.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0189a {
        void a(Activity activity);

        void b(Activity activity);

        void onResume(Activity activity);
    }

    public static a a(Activity activity) {
        return (a) activity.getFragmentManager().findFragmentByTag(f8931b);
    }

    public static void b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null || fragmentManager.findFragmentByTag(f8931b) != null) {
            return;
        }
        fragmentManager.beginTransaction().add(new a(), f8931b).commit();
        fragmentManager.executePendingTransactions();
    }

    private void c(InterfaceC0189a interfaceC0189a) {
        if (interfaceC0189a != null) {
            interfaceC0189a.a(getActivity());
        }
    }

    public void d(InterfaceC0189a interfaceC0189a) {
        this.f8932a = interfaceC0189a;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f8932a);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f8932a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        b(this.f8932a);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.f8932a);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    private void a(InterfaceC0189a interfaceC0189a) {
        if (interfaceC0189a != null) {
            interfaceC0189a.b(getActivity());
        }
    }

    private void b(InterfaceC0189a interfaceC0189a) {
        if (interfaceC0189a != null) {
            interfaceC0189a.onResume(getActivity());
        }
    }
}
