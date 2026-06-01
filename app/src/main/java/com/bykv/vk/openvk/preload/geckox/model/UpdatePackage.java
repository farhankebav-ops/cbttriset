package com.bykv.vk.openvk.preload.geckox.model;

import a1.a;
import com.bykv.vk.openvk.preload.a.a.b;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class UpdatePackage {
    private String accessKey;

    @b(a = "channel")
    private String channel;

    @b(a = "channel_index")
    private int channelIndex;

    @b(a = "content")
    private Content content;

    @b(a = "group_name")
    private String groupName;
    private long localVersion;

    @b(a = "package_type")
    private int packageType;

    @b(a = "package_version")
    private long version;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Content {

        @b(a = "package")
        private Package fullPackage;

        @b(a = "patch")
        private Package patch;

        @b(a = "strategies")
        private Strategy strategy;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class FileType {
        public static final int COMPRESSED_FILE = 0;
        public static final int MY_ARCHIVE_FILE = 2;
        public static final int UNCOMPRESSED_FILE = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Package {

        @b(a = "id")
        long id;

        @b(a = "size")
        long length;

        @b(a = "md5")
        String md5;

        @Deprecated
        String url;

        @b(a = "url_list")
        List<String> urlList;

        public Package() {
        }

        public long getId() {
            return this.id;
        }

        public long getLength() {
            return this.length;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getUrl() {
            return this.url;
        }

        public List<String> getUrlList() {
            return this.urlList;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUrlList(List<String> list) {
            this.urlList = list;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Package{url='");
            sb.append(this.url);
            sb.append("', md5='");
            return a.r(sb, this.md5, "'}");
        }

        public Package(int i2, List<String> list, String str) {
            this.id = i2;
            this.urlList = list;
            this.md5 = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Strategy {

        @b(a = "del_if_download_failed")
        private boolean deleteIfFail;

        @b(a = "del_old_pkg_before_download")
        private boolean deleteOldPackageBeforeDownload;

        @b(a = "need_unzip")
        private boolean needUnzip;

        public Strategy(int i2) {
            this.deleteIfFail = i2 == 1;
        }

        public boolean isDeleteIfFail() {
            return this.deleteIfFail;
        }

        public boolean isDeleteOldPackageBeforeDownload() {
            return this.deleteOldPackageBeforeDownload;
        }

        public boolean isNeedUnzip() {
            return this.needUnzip;
        }

        public void setDeleteIfFail(boolean z2) {
            this.deleteIfFail = z2;
        }

        public void setDeleteOldPackageBeforeDownload(boolean z2) {
            this.deleteOldPackageBeforeDownload = z2;
        }

        public void setNeedUnzip(boolean z2) {
            this.needUnzip = z2;
        }
    }

    public UpdatePackage() {
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getChannelIndex() {
        return this.channelIndex;
    }

    public Package getFullPackage() {
        return this.content.fullPackage;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getLocalVersion() {
        return this.localVersion;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public Package getPatch() {
        return this.content.patch;
    }

    public Strategy getStrategy() {
        return this.content.strategy;
    }

    public long getVersion() {
        return this.version;
    }

    public boolean isFullUpdate() {
        return getFullPackage() != null && getFullPackage().getUrlList().size() > 0;
    }

    public boolean isPatchUpdate() {
        return getPatch() != null && getPatch().getUrlList().size() > 0;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setChannelIndex(int i2) {
        this.channelIndex = i2;
    }

    public void setFullPackage(Package r22) {
        this.content.fullPackage = r22;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setLocalVersion(long j) {
        this.localVersion = j;
    }

    public void setPatch(Package r22) {
        this.content.patch = r22;
    }

    public void setStrategy(Strategy strategy) {
        this.content.strategy = strategy;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UpdatePackage{version=");
        sb.append(this.version);
        sb.append(", channel='");
        sb.append(this.channel);
        sb.append("', content=");
        sb.append(this.content);
        sb.append(", packageType=");
        return a0.c(sb, this.packageType, '}');
    }

    public UpdatePackage(long j, String str, Package r42, Package r52) {
        this.version = j;
        this.channel = str;
        Content content = new Content();
        this.content = content;
        content.fullPackage = r42;
        this.content.patch = r52;
    }
}
