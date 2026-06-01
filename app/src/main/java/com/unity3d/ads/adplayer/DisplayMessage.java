package com.unity3d.ads.adplayer;

import android.webkit.WebView;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class DisplayMessage {
    private final String opportunityId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DisplayDestroyed extends DisplayMessage {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayDestroyed(String opportunityId) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DisplayError extends DisplayMessage {
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayError(String opportunityId, String reason) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
            k.e(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DisplayFinishRequest extends DisplayMessage {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayFinishRequest(String opportunityId) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DisplayReady extends DisplayMessage {
        private final Map<String, Object> showOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayReady(String opportunityId, Map<String, ? extends Object> map) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
            this.showOptions = map;
        }

        public final Map<String, Object> getShowOptions() {
            return this.showOptions;
        }

        public /* synthetic */ DisplayReady(String str, Map map, int i2, f fVar) {
            this(str, (i2 & 2) != 0 ? null : map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class FocusChanged extends DisplayMessage {
        private final boolean isFocused;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FocusChanged(String opportunityId, boolean z2) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
            this.isFocused = z2;
        }

        public final boolean isFocused() {
            return this.isFocused;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SetOrientation extends DisplayMessage {
        private final int orientation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetOrientation(String opportunityId, int i2) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
            this.orientation = i2;
        }

        public final int getOrientation() {
            return this.orientation;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class VisibilityChanged extends DisplayMessage {
        private final boolean isVisible;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VisibilityChanged(String opportunityId, boolean z2) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
            this.isVisible = z2;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class WebViewInstanceRequest extends DisplayMessage {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewInstanceRequest(String opportunityId) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class WebViewInstanceResponse extends DisplayMessage {
        private final WebView webView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewInstanceResponse(String opportunityId, WebView webView) {
            super(opportunityId, null);
            k.e(opportunityId, "opportunityId");
            k.e(webView, "webView");
            this.webView = webView;
        }

        public final WebView getWebView() {
            return this.webView;
        }
    }

    public /* synthetic */ DisplayMessage(String str, f fVar) {
        this(str);
    }

    public final String getOpportunityId() {
        return this.opportunityId;
    }

    private DisplayMessage(String str) {
        this.opportunityId = str;
    }
}
