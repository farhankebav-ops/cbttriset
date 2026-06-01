package androidx.core.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.provider.FontProvider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static FontProvider.ContentQueryWrapper a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT < 24 ? new FontProvider.ContentQueryWrapperApi16Impl(context, uri) : new FontProvider.ContentQueryWrapperApi24Impl(context, uri);
    }
}
