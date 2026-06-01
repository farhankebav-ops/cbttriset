package sg.bigo.ads.common.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<WeakReference<b>> f15595b;

    /* JADX INFO: renamed from: sg.bigo.ads.common.d.a$a, reason: collision with other inner class name */
    public static class C0282a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f15600a = new a(0);
    }

    private a() {
        this.f15594a = false;
        this.f15595b = new ArrayList();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z2;
        Iterator<WeakReference<b>> it = this.f15595b.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar != null) {
                String action = intent.getAction();
                boolean z7 = false;
                if ((bVar instanceof c) && !TextUtils.isEmpty(action) && "android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    bVar.a(context, intent);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    String action2 = intent.getAction();
                    if ((bVar instanceof e) && q.b((CharSequence) action2)) {
                        action2.getClass();
                        switch (action2) {
                            case "android.intent.action.SCREEN_OFF":
                            case "android.intent.action.SCREEN_ON":
                            case "android.intent.action.ACTION_POWER_CONNECTED":
                                bVar.a(context, intent);
                                z7 = true;
                                break;
                        }
                    }
                    z2 = z7;
                }
                if (!z2) {
                    String action3 = intent.getAction();
                    if ((bVar instanceof d) && !TextUtils.isEmpty(action3) && "android.intent.action.CONFIGURATION_CHANGED".equals(action3)) {
                        bVar.a(context, intent);
                    }
                }
            }
        }
    }

    public /* synthetic */ a(byte b8) {
        this();
    }

    public static a a() {
        return C0282a.f15600a;
    }

    public final void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f15594a = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            applicationContext.registerReceiver(this, intentFilter);
        }
    }

    public final void a(Context context, final b bVar) {
        if (!this.f15594a) {
            a(context);
        }
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.common.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = a.this.f15595b.iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) ((WeakReference) it.next()).get();
                    if (bVar2 != null && bVar2 == bVar) {
                        return;
                    }
                }
                a.this.f15595b.add(new WeakReference(bVar));
            }
        }, 1L);
    }

    public final void a(final b bVar) {
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.common.d.a.2
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = a.this.f15595b.iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) ((WeakReference) it.next()).get();
                    b bVar3 = bVar;
                    if (bVar3 != null && bVar2 == bVar3) {
                        it.remove();
                        return;
                    }
                }
            }
        });
    }
}
