package sg.bigo.ads.controller.form;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.ad.c;
import sg.bigo.ads.common.form.a;
import sg.bigo.ads.common.form.render.b;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.controller.landing.d;

/* JADX INFO: loaded from: classes6.dex */
public class AdFormActivity extends Activity implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private c<?, ?> f16645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16648d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f16649f;
    private sg.bigo.ads.common.form.c g;

    @NonNull
    public static Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) AdFormActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if ((currentFocus instanceof EditText) && !u.a(currentFocus, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                currentFocus.clearFocus();
                try {
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                } catch (Throwable unused) {
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f16648d) {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0178 A[Catch: all -> 0x0049, TryCatch #1 {all -> 0x0049, blocks: (B:3:0x001f, B:5:0x0045, B:9:0x004d, B:11:0x0068, B:12:0x006b, B:14:0x0073, B:15:0x007b, B:17:0x0085, B:19:0x0089, B:23:0x00a4, B:25:0x00aa, B:76:0x017a, B:26:0x00b1, B:28:0x00b7, B:29:0x00be, B:31:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00d8, B:37:0x00de, B:38:0x00e5, B:40:0x00eb, B:41:0x00f2, B:43:0x00f8, B:44:0x00ff, B:46:0x0107, B:47:0x010b, B:49:0x0113, B:50:0x0117, B:52:0x011d, B:53:0x0123, B:55:0x0129, B:56:0x012f, B:58:0x0135, B:59:0x013b, B:61:0x0143, B:62:0x0146, B:64:0x014c, B:65:0x0152, B:67:0x0158, B:69:0x015f, B:71:0x0167, B:72:0x016a, B:74:0x0172, B:75:0x0178), top: B:91:0x001f }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(@androidx.annotation.Nullable android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.form.AdFormActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    @CallSuper
    public void onDestroy() {
        sg.bigo.ads.common.form.c cVar;
        b bVar;
        super.onDestroy();
        try {
            if (this.f16645a != null && (cVar = this.g) != null && (bVar = cVar.f15647a) != null) {
                Map<String, Object> mapA = a.a(bVar.f15672b, bVar.f15673c.b(), bVar.f15673c.a());
                boolean z2 = this.f16648d;
                if (!z2) {
                    a.a(this.f16647c, mapA);
                } else if (z2) {
                    a.a(this.f16647c, 3);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // sg.bigo.ads.common.form.render.b.a
    public final void a() {
        this.f16648d = true;
        c<?, ?> cVar = this.f16645a;
        if (cVar != null) {
            cVar.j = true;
        }
    }

    @Override // sg.bigo.ads.common.form.render.b.a
    public final void a(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        d.a(this, str, this.f16645a);
    }
}
