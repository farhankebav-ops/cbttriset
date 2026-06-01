package com.unity3d.ironsourceads;

import com.unity3d.ironsourceads.IronSourceAds;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<IronSourceAds.AdFormat> f10860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LogLevel f10861c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<? extends IronSourceAds.AdFormat> f10863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LogLevel f10864c;

        public Builder(String appKey) {
            k.e(appKey, "appKey");
            this.f10862a = appKey;
        }

        public final InitRequest build() {
            String str = this.f10862a;
            List list = this.f10863b;
            if (list == null) {
                list = r.f13638a;
            }
            LogLevel logLevel = this.f10864c;
            if (logLevel == null) {
                logLevel = LogLevel.NONE;
            }
            return new InitRequest(str, list, logLevel, null);
        }

        public final String getAppKey() {
            return this.f10862a;
        }

        public final Builder withLegacyAdFormats(List<? extends IronSourceAds.AdFormat> legacyAdFormats) {
            k.e(legacyAdFormats, "legacyAdFormats");
            this.f10863b = legacyAdFormats;
            return this;
        }

        public final Builder withLogLevel(LogLevel logLevel) {
            k.e(logLevel, "logLevel");
            this.f10864c = logLevel;
            return this;
        }
    }

    public /* synthetic */ InitRequest(String str, List list, LogLevel logLevel, f fVar) {
        this(str, list, logLevel);
    }

    public final String getAppKey() {
        return this.f10859a;
    }

    public final List<IronSourceAds.AdFormat> getLegacyAdFormats() {
        return this.f10860b;
    }

    public final LogLevel getLogLevel() {
        return this.f10861c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InitRequest(String str, List<? extends IronSourceAds.AdFormat> list, LogLevel logLevel) {
        this.f10859a = str;
        this.f10860b = list;
        this.f10861c = logLevel;
    }
}
