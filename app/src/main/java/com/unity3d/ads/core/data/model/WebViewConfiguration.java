package com.unity3d.ads.core.data.model;

import androidx.camera.core.processing.util.a;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebViewConfiguration {
    private final List<String> additionalFiles;
    private final String entryPoint;
    private final String type;
    private final int version;

    public WebViewConfiguration(int i2, String entryPoint, List<String> additionalFiles, String type) {
        k.e(entryPoint, "entryPoint");
        k.e(additionalFiles, "additionalFiles");
        k.e(type, "type");
        this.version = i2;
        this.entryPoint = entryPoint;
        this.additionalFiles = additionalFiles;
        this.type = type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebViewConfiguration copy$default(WebViewConfiguration webViewConfiguration, int i2, String str, List list, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = webViewConfiguration.version;
        }
        if ((i8 & 2) != 0) {
            str = webViewConfiguration.entryPoint;
        }
        if ((i8 & 4) != 0) {
            list = webViewConfiguration.additionalFiles;
        }
        if ((i8 & 8) != 0) {
            str2 = webViewConfiguration.type;
        }
        return webViewConfiguration.copy(i2, str, list, str2);
    }

    public final int component1() {
        return this.version;
    }

    public final String component2() {
        return this.entryPoint;
    }

    public final List<String> component3() {
        return this.additionalFiles;
    }

    public final String component4() {
        return this.type;
    }

    public final WebViewConfiguration copy(int i2, String entryPoint, List<String> additionalFiles, String type) {
        k.e(entryPoint, "entryPoint");
        k.e(additionalFiles, "additionalFiles");
        k.e(type, "type");
        return new WebViewConfiguration(i2, entryPoint, additionalFiles, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewConfiguration)) {
            return false;
        }
        WebViewConfiguration webViewConfiguration = (WebViewConfiguration) obj;
        return this.version == webViewConfiguration.version && k.a(this.entryPoint, webViewConfiguration.entryPoint) && k.a(this.additionalFiles, webViewConfiguration.additionalFiles) && k.a(this.type, webViewConfiguration.type);
    }

    public final List<String> getAdditionalFiles() {
        return this.additionalFiles;
    }

    public final String getEntryPoint() {
        return this.entryPoint;
    }

    public final String getType() {
        return this.type;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.type.hashCode() + ((this.additionalFiles.hashCode() + a.b(this.version * 31, 31, this.entryPoint)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WebViewConfiguration(version=");
        sb.append(this.version);
        sb.append(", entryPoint=");
        sb.append(this.entryPoint);
        sb.append(", additionalFiles=");
        sb.append(this.additionalFiles);
        sb.append(", type=");
        return a1.a.e(')', this.type, sb);
    }
}
