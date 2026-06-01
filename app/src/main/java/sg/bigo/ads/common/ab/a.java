package sg.bigo.ads.common.ab;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.utils.t;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    @NonNull
    public static boolean a(View view, @NonNull Rect rect) {
        if (view == null || !u.d(view)) {
            t.a();
            return false;
        }
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            return false;
        }
        return view.getGlobalVisibleRect(rect);
    }
}
