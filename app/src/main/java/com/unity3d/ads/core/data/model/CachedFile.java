package com.unity3d.ads.core.data.model;

import androidx.camera.core.processing.util.a;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.File;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CachedFile {
    private final long contentLength;
    private final String extension;
    private final File file;
    private final String name;
    private final String objectId;
    private final int priority;
    private final String protocol;
    private final String url;

    public CachedFile(String objectId, String url, String name, File file, String str, long j, String protocol, int i2) {
        k.e(objectId, "objectId");
        k.e(url, "url");
        k.e(name, "name");
        k.e(protocol, "protocol");
        this.objectId = objectId;
        this.url = url;
        this.name = name;
        this.file = file;
        this.extension = str;
        this.contentLength = j;
        this.protocol = protocol;
        this.priority = i2;
    }

    public static /* synthetic */ CachedFile copy$default(CachedFile cachedFile, String str, String str2, String str3, File file, String str4, long j, String str5, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = cachedFile.objectId;
        }
        if ((i8 & 2) != 0) {
            str2 = cachedFile.url;
        }
        if ((i8 & 4) != 0) {
            str3 = cachedFile.name;
        }
        if ((i8 & 8) != 0) {
            file = cachedFile.file;
        }
        if ((i8 & 16) != 0) {
            str4 = cachedFile.extension;
        }
        if ((i8 & 32) != 0) {
            j = cachedFile.contentLength;
        }
        if ((i8 & 64) != 0) {
            str5 = cachedFile.protocol;
        }
        if ((i8 & 128) != 0) {
            i2 = cachedFile.priority;
        }
        long j3 = j;
        File file2 = file;
        String str6 = str4;
        String str7 = str3;
        return cachedFile.copy(str, str2, str7, file2, str6, j3, str5, i2);
    }

    public final String component1() {
        return this.objectId;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.name;
    }

    public final File component4() {
        return this.file;
    }

    public final String component5() {
        return this.extension;
    }

    public final long component6() {
        return this.contentLength;
    }

    public final String component7() {
        return this.protocol;
    }

    public final int component8() {
        return this.priority;
    }

    public final CachedFile copy(String objectId, String url, String name, File file, String str, long j, String protocol, int i2) {
        k.e(objectId, "objectId");
        k.e(url, "url");
        k.e(name, "name");
        k.e(protocol, "protocol");
        return new CachedFile(objectId, url, name, file, str, j, protocol, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedFile)) {
            return false;
        }
        CachedFile cachedFile = (CachedFile) obj;
        return k.a(this.objectId, cachedFile.objectId) && k.a(this.url, cachedFile.url) && k.a(this.name, cachedFile.name) && k.a(this.file, cachedFile.file) && k.a(this.extension, cachedFile.extension) && this.contentLength == cachedFile.contentLength && k.a(this.protocol, cachedFile.protocol) && this.priority == cachedFile.priority;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final String getExtension() {
        return this.extension;
    }

    public final File getFile() {
        return this.file;
    }

    public final String getName() {
        return this.name;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iB = a.b(a.b(this.objectId.hashCode() * 31, 31, this.url), 31, this.name);
        File file = this.file;
        int iHashCode = (iB + (file == null ? 0 : file.hashCode())) * 31;
        String str = this.extension;
        int iHashCode2 = str != null ? str.hashCode() : 0;
        long j = this.contentLength;
        return a.b((((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31, 31, this.protocol) + this.priority;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CachedFile(objectId=");
        sb.append(this.objectId);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", file=");
        sb.append(this.file);
        sb.append(", extension=");
        sb.append(this.extension);
        sb.append(", contentLength=");
        sb.append(this.contentLength);
        sb.append(", protocol=");
        sb.append(this.protocol);
        sb.append(", priority=");
        return a0.c(sb, this.priority, ')');
    }

    public /* synthetic */ CachedFile(String str, String str2, String str3, File file, String str4, long j, String str5, int i2, int i8, f fVar) {
        this(str, str2, str3, (i8 & 8) != 0 ? null : file, (i8 & 16) != 0 ? "" : str4, (i8 & 32) != 0 ? -1L : j, (i8 & 64) != 0 ? "" : str5, (i8 & 128) != 0 ? Integer.MAX_VALUE : i2);
    }
}
