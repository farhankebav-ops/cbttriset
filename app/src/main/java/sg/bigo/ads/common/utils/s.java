package sg.bigo.ads.common.utils;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public final class s {
    public static void a(Context context, ProgressBar progressBar, int i2) {
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        if (indeterminateDrawable == null) {
            progressBar.setIndeterminateDrawable(a.a(context, i2));
        } else {
            indeterminateDrawable.setTint(a.c(context, R.color.white));
            progressBar.setIndeterminateDrawable(indeterminateDrawable);
        }
    }

    public static void a(@NonNull Window window) {
        window.getDecorView().setSystemUiVisibility(5894);
    }
}
