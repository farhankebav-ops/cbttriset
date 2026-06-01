package com.vungle.ads.internal.model;

import androidx.camera.core.processing.util.a;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdAsset {
    private final String adIdentifier;
    private long contentLength;
    private long fileSize;
    private final boolean isRequired;
    private final String localPath;
    private final Integer percentage;
    private Long rangeEnd;
    private long rangeStart;
    private final String serverPath;
    private Status status;
    private final Object waitLock;
    private final AtomicBoolean waitingForDownload;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Status {
        NEW,
        DOWNLOAD_RUNNING,
        DOWNLOAD_FAILED,
        DOWNLOAD_SUCCESS,
        PROCESSED
    }

    public AdAsset(String adIdentifier, String serverPath, String localPath, boolean z2, Integer num) {
        k.e(adIdentifier, "adIdentifier");
        k.e(serverPath, "serverPath");
        k.e(localPath, "localPath");
        this.adIdentifier = adIdentifier;
        this.serverPath = serverPath;
        this.localPath = localPath;
        this.isRequired = z2;
        this.percentage = num;
        this.status = Status.NEW;
        this.waitLock = new Object();
        this.waitingForDownload = new AtomicBoolean(false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !AdAsset.class.equals(obj.getClass())) {
            return false;
        }
        AdAsset adAsset = (AdAsset) obj;
        if (this.status == adAsset.status && this.fileSize == adAsset.fileSize && this.isRequired == adAsset.isRequired && k.a(this.adIdentifier, adAsset.adIdentifier) && k.a(this.serverPath, adAsset.serverPath) && this.contentLength == adAsset.contentLength && k.a(this.percentage, adAsset.percentage)) {
            return k.a(this.localPath, adAsset.localPath);
        }
        return false;
    }

    public final String getAdIdentifier() {
        return this.adIdentifier;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final Integer getPercentage() {
        return this.percentage;
    }

    public final Long getRangeEnd() {
        return this.rangeEnd;
    }

    public final long getRangeStart() {
        return this.rangeStart;
    }

    public final String getServerPath() {
        return this.serverPath;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = (this.status.hashCode() + a.b(a.b(this.adIdentifier.hashCode() * 31, 31, this.serverPath), 31, this.localPath)) * 31;
        long j = this.fileSize;
        int i2 = (((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (this.isRequired ? 1231 : 1237)) * 31;
        long j3 = this.contentLength;
        int i8 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        Integer num = this.percentage;
        return i8 + (num != null ? num.hashCode() : 0);
    }

    public final boolean isHtmlTemplate() {
        return k.a(this.adIdentifier, AdPayload.KEY_VM);
    }

    public final boolean isMainVideo() {
        return k.a(this.adIdentifier, Constants.KEY_MAIN_VIDEO);
    }

    public final boolean isPrivacyIcon() {
        return k.a(this.adIdentifier, "VUNGLE_PRIVACY_ICON_URL");
    }

    public final boolean isRequired() {
        return this.isRequired;
    }

    public final boolean isWaitingForDownload() {
        return this.waitingForDownload.get();
    }

    public final void notifyDownloadEnough() {
        if (this.waitingForDownload.getAndSet(false)) {
            synchronized (this.waitLock) {
                this.waitLock.notifyAll();
            }
        }
    }

    public final void setContentLength(long j) {
        this.contentLength = j;
    }

    public final void setFileSize(long j) {
        this.fileSize = j;
    }

    public final void setRangeEnd(Long l) {
        this.rangeEnd = l;
    }

    public final void setRangeStart(long j) {
        this.rangeStart = j;
    }

    public final void setStatus(Status status) {
        k.e(status, "<set-?>");
        this.status = status;
    }

    public String toString() {
        return "AdAsset(adIdentifier=" + this.adIdentifier + ", serverPath=" + this.serverPath + ", localPath=" + this.localPath + ", status=" + this.status + ", fileSize=" + this.fileSize + ", contentLength=" + this.contentLength + ", isRequired=" + this.isRequired + ", percentage=" + this.percentage + ')';
    }

    public final void waitForDownload() {
        Object objM;
        this.waitingForDownload.set(true);
        synchronized (this.waitLock) {
            try {
                this.waitLock.wait();
                objM = x.f13520a;
            } finally {
            }
            Throwable thA = q5.k.a(objM);
            if (thA != null) {
                Logger.Companion.e("AdAsset", "Interrupted while waiting for file download: " + this, thA);
            }
        }
    }

    public /* synthetic */ AdAsset(String str, String str2, String str3, boolean z2, Integer num, int i2, f fVar) {
        this(str, str2, str3, z2, (i2 & 16) != 0 ? null : num);
    }
}
