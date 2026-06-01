package com.bykv.vk.openvk.preload.geckox.statistic.model;

import com.bykv.vk.openvk.preload.a.a.b;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class StatisticModel {

    @b(a = "common")
    public Common common;

    @b(a = "packages")
    public List<PackageStatisticModel> packages = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class PackageStatisticModel {

        @b(a = "ac")
        public String ac;

        @b(a = "access_key")
        public String accessKey;

        @b(a = "active_check_duration")
        public Long activeCheckDuration;

        @b(a = "apply_duration")
        public Long applyDuration;

        @b(a = "channel")
        public String channel;

        @b(a = "clean_duration")
        public Long cleanDuration;

        @b(a = "clean_strategy")
        public Integer cleanStrategy;

        @b(a = "clean_type")
        public Integer cleanType;

        @b(a = "download_duration")
        public Long downloadDuration;

        @b(a = "download_fail_records")
        public List<DownloadFailRecords> downloadFailRecords;

        @b(a = "download_retry_times")
        public Integer downloadRetryTimes;

        @b(a = "download_url")
        public String downloadUrl;

        @b(a = "err_code")
        public String errCode;

        @b(a = "err_msg")
        public String errMsg;

        @b(a = "group_name")
        public String groupName;

        @b(a = "id")
        public Long id;

        @b(a = "log_id")
        public String logId;

        @b(a = "patch_id")
        public Long patchId;

        @b(a = "stats_type")
        public Integer statsType;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static class DownloadFailRecords {

            @b(a = C2300e4.i.D)
            public String domain;

            @b(a = "reason")
            public String reason;

            public DownloadFailRecords(String str, String str2) {
                this.domain = str;
                this.reason = str2;
            }
        }
    }
}
