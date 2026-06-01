package sg.bigo.ads.common.v;

import android.app.KeyguardManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import sg.bigo.ads.common.f.b;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f16050a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f16051b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f16052c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f16053d = 3;
    public static int e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f16054f = 5;
    public int g = f16050a;

    public static boolean b(View view) {
        WindowManager.LayoutParams layoutParams;
        if (view == null) {
            return false;
        }
        while (true) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams)) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    layoutParams = null;
                    break;
                }
                view = (View) parent;
            } else {
                layoutParams = (WindowManager.LayoutParams) layoutParams2;
                break;
            }
        }
        if (layoutParams == null) {
            return false;
        }
        int i2 = layoutParams.type;
        return i2 == 2002 || i2 == 2003 || i2 == 2006 || i2 == 2007 || i2 == 2010 || i2 == 2038;
    }

    public final int a() {
        int iC = b.c();
        this.g = iC != 1 ? iC != 2 ? f16050a : e : f16051b;
        return this.g;
    }

    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        try {
            KeyguardManager keyguardManager = (KeyguardManager) view.getContext().getSystemService("keyguard");
            if (keyguardManager != null) {
                return keyguardManager.isKeyguardLocked();
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
