package androidx.webkit.internal;

import androidx.annotation.NonNull;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebResourceRequestAdapter {
    private final WebResourceRequestBoundaryInterface mBoundaryInterface;

    public WebResourceRequestAdapter(@NonNull WebResourceRequestBoundaryInterface webResourceRequestBoundaryInterface) {
        this.mBoundaryInterface = webResourceRequestBoundaryInterface;
    }

    public boolean isRedirect() {
        return this.mBoundaryInterface.isRedirect();
    }
}
