package com.bykv.vk.openvk.preload.geckox.statistic;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.e;
import com.ironsource.C2605va;
import com.ironsource.Q6;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static void a(com.bykv.vk.openvk.preload.geckox.b bVar, com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar) {
        IStatisticMonitor iStatisticMonitorQ = bVar.q();
        if (iStatisticMonitorQ != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("params_for_special", "gecko");
                jSONObject.put("device_id", bVar.r());
                jSONObject.put(Q6.F, 0);
                jSONObject.put("app_version", bVar.o());
                jSONObject.put("api_version", "v3");
                jSONObject.put(C2605va.f10440b, bVar.k());
                jSONObject.put("x_tt_logid", aVar.e);
                jSONObject.put("http_status", aVar.g);
                jSONObject.put("err_msg", aVar.f4954d);
                if (TextUtils.isEmpty(aVar.e)) {
                    jSONObject.put("deployments_info", aVar.f4952b);
                    jSONObject.put("local_info", aVar.f4951a);
                    jSONObject.put("custom_info", aVar.f4953c);
                } else {
                    jSONObject.put("deployments_info", "");
                    jSONObject.put("local_info", "");
                    jSONObject.put("custom_info", "");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(Build.VERSION.SDK_INT);
                jSONObject.put("os_version", sb.toString());
                jSONObject.put("device_platform", "android");
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put("ac", aVar.f4955f);
                iStatisticMonitorQ.upload("geckosdk_query_pkgs", jSONObject);
            } catch (Throwable th) {
                GeckoLogger.w("gecko-debug-tag", "UploadStatistic.upload:", th);
            }
        }
    }

    private static List<StatisticModel.PackageStatisticModel.DownloadFailRecords> b(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private static Integer a(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return Integer.valueOf(list.size());
    }

    private static void a(com.bykv.vk.openvk.preload.geckox.statistic.model.a aVar, List<StatisticModel.PackageStatisticModel> list) {
        if (aVar.f5042z && aVar.A) {
            StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel);
            packageStatisticModel.statsType = 0;
            packageStatisticModel.accessKey = aVar.f5026a;
            packageStatisticModel.groupName = aVar.f5027b;
            packageStatisticModel.channel = aVar.f5028c;
            packageStatisticModel.ac = aVar.f5032n;
            packageStatisticModel.id = aVar.p;
            packageStatisticModel.downloadRetryTimes = a(aVar.f5038u);
            packageStatisticModel.downloadUrl = aVar.f5037t;
            packageStatisticModel.downloadFailRecords = b(aVar.f5038u);
            packageStatisticModel.downloadDuration = Long.valueOf(aVar.f5040w - aVar.f5039v);
            if (aVar.B) {
                StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                list.add(packageStatisticModel2);
                packageStatisticModel2.accessKey = aVar.f5026a;
                packageStatisticModel2.groupName = aVar.f5027b;
                packageStatisticModel2.statsType = 2;
                packageStatisticModel2.id = aVar.p;
                packageStatisticModel2.channel = aVar.f5028c;
                packageStatisticModel2.activeCheckDuration = Long.valueOf(aVar.f5041x - aVar.f5040w);
                packageStatisticModel2.applyDuration = Long.valueOf(aVar.y - aVar.f5041x);
                return;
            }
            StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel3);
            packageStatisticModel3.statsType = 3;
            packageStatisticModel3.accessKey = aVar.f5026a;
            packageStatisticModel3.groupName = aVar.f5027b;
            packageStatisticModel3.errCode = "500";
            packageStatisticModel3.id = aVar.p;
            packageStatisticModel3.channel = aVar.f5028c;
            packageStatisticModel3.errMsg = aVar.D;
            return;
        }
        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
        list.add(packageStatisticModel4);
        packageStatisticModel4.statsType = 1;
        packageStatisticModel4.accessKey = aVar.f5026a;
        packageStatisticModel4.groupName = aVar.f5027b;
        packageStatisticModel4.channel = aVar.f5028c;
        packageStatisticModel4.ac = aVar.f5032n;
        packageStatisticModel4.id = aVar.p;
        packageStatisticModel4.downloadRetryTimes = a(aVar.f5038u);
        packageStatisticModel4.downloadUrl = aVar.f5037t;
        packageStatisticModel4.downloadFailRecords = b(aVar.f5038u);
        if (!aVar.f5042z) {
            packageStatisticModel4.errCode = "300";
            List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list2 = aVar.f5038u;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            packageStatisticModel4.errMsg = aVar.f5038u.get(0).reason;
            return;
        }
        if (aVar.A) {
            return;
        }
        packageStatisticModel4.errCode = "450";
        packageStatisticModel4.errMsg = aVar.C;
    }

    public static void a(final com.bykv.vk.openvk.preload.geckox.b bVar, a aVar) {
        StatisticModel statisticModel;
        ArrayList arrayList = new ArrayList();
        for (com.bykv.vk.openvk.preload.geckox.statistic.model.a aVar2 : aVar.a()) {
            if (aVar2.f5029d != null || aVar2.f5030f != 0) {
                if (aVar2.h && aVar2.f5031i) {
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel);
                    packageStatisticModel.statsType = 100;
                    packageStatisticModel.groupName = aVar2.f5027b;
                    packageStatisticModel.accessKey = aVar2.f5026a;
                    packageStatisticModel.channel = aVar2.f5028c;
                    packageStatisticModel.ac = aVar2.f5032n;
                    packageStatisticModel.id = aVar2.p;
                    packageStatisticModel.patchId = aVar2.f5033o;
                    packageStatisticModel.downloadRetryTimes = a(aVar2.e);
                    packageStatisticModel.downloadUrl = aVar2.f5029d;
                    packageStatisticModel.downloadFailRecords = b(aVar2.e);
                    packageStatisticModel.downloadDuration = Long.valueOf(aVar2.g - aVar2.f5030f);
                    if (!aVar2.j) {
                        StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel2);
                        packageStatisticModel2.statsType = 100;
                        packageStatisticModel2.channel = aVar2.f5028c;
                        packageStatisticModel2.errCode = "403";
                        packageStatisticModel2.errMsg = aVar2.f5035r;
                        packageStatisticModel2.ac = aVar2.f5032n;
                        packageStatisticModel2.patchId = aVar2.f5033o;
                        packageStatisticModel2.id = aVar2.p;
                        packageStatisticModel2.downloadRetryTimes = a(aVar2.e);
                        packageStatisticModel2.downloadUrl = aVar2.f5029d;
                        packageStatisticModel2.downloadFailRecords = b(aVar2.e);
                    } else if (aVar2.k) {
                        StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel3);
                        packageStatisticModel3.accessKey = aVar2.f5026a;
                        packageStatisticModel3.groupName = aVar2.f5027b;
                        packageStatisticModel3.statsType = 102;
                        packageStatisticModel3.patchId = aVar2.f5033o;
                        packageStatisticModel3.id = aVar2.p;
                        packageStatisticModel3.channel = aVar2.f5028c;
                        packageStatisticModel3.activeCheckDuration = Long.valueOf(aVar2.l - aVar2.g);
                        packageStatisticModel3.applyDuration = Long.valueOf(aVar2.m - aVar2.l);
                    } else {
                        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel4);
                        packageStatisticModel4.accessKey = aVar2.f5026a;
                        packageStatisticModel4.groupName = aVar2.f5027b;
                        packageStatisticModel4.statsType = 103;
                        packageStatisticModel4.errCode = "501";
                        packageStatisticModel4.channel = aVar2.f5028c;
                        packageStatisticModel4.patchId = aVar2.f5033o;
                        packageStatisticModel4.id = aVar2.p;
                        packageStatisticModel4.errMsg = aVar2.f5036s;
                        a(aVar2, arrayList);
                    }
                } else {
                    StatisticModel.PackageStatisticModel packageStatisticModel5 = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel5);
                    packageStatisticModel5.statsType = 101;
                    packageStatisticModel5.accessKey = aVar2.f5026a;
                    packageStatisticModel5.groupName = aVar2.f5027b;
                    packageStatisticModel5.channel = aVar2.f5028c;
                    packageStatisticModel5.ac = aVar2.f5032n;
                    packageStatisticModel5.patchId = aVar2.f5033o;
                    packageStatisticModel5.id = aVar2.p;
                    packageStatisticModel5.downloadRetryTimes = a(aVar2.e);
                    packageStatisticModel5.downloadUrl = aVar2.f5029d;
                    packageStatisticModel5.downloadFailRecords = b(aVar2.e);
                    if (!aVar2.h) {
                        packageStatisticModel5.errCode = "301";
                        List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list = aVar2.e;
                        if (list != null && !list.isEmpty()) {
                            packageStatisticModel5.errMsg = aVar2.e.get(0).reason;
                        }
                    } else if (!aVar2.f5031i) {
                        packageStatisticModel5.errCode = "402";
                        packageStatisticModel5.errMsg = aVar2.f5034q;
                    }
                    a(aVar2, arrayList);
                }
            }
            a(aVar2, arrayList);
        }
        Context contextA = bVar.a();
        arrayList.addAll(com.bykv.vk.openvk.preload.geckox.a.a.a(contextA));
        if (arrayList.isEmpty()) {
            statisticModel = null;
        } else {
            Common common = new Common(bVar.k(), bVar.o(), bVar.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(contextA), e.a(contextA), bVar.l(), bVar.m());
            statisticModel = new StatisticModel();
            statisticModel.common = common;
            statisticModel.packages = arrayList;
            String string = UUID.randomUUID().toString();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((StatisticModel.PackageStatisticModel) obj).logId = string;
            }
        }
        StatisticModel statisticModel2 = statisticModel;
        if (statisticModel2 == null || statisticModel2.packages == null) {
            return;
        }
        IStatisticMonitor iStatisticMonitorQ = bVar.q();
        if (iStatisticMonitorQ != null) {
            try {
                for (StatisticModel.PackageStatisticModel packageStatisticModel6 : statisticModel2.packages) {
                    Common common2 = statisticModel2.common;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("params_for_special", "gecko");
                    jSONObject.put("region", common2.region);
                    jSONObject.put("err_code", packageStatisticModel6.errCode);
                    jSONObject.put("err_msg", packageStatisticModel6.errMsg);
                    jSONObject.put("sdk_version", common2.sdkVersion);
                    jSONObject.put("access_key", packageStatisticModel6.accessKey);
                    jSONObject.put("stats_type", packageStatisticModel6.statsType);
                    jSONObject.put("device_id", common2.deviceId);
                    Long l = packageStatisticModel6.patchId;
                    jSONObject.put("patch_id", l == null ? 0L : l.longValue());
                    jSONObject.put("group_name", packageStatisticModel6.groupName);
                    jSONObject.put(Q6.F, common2.os);
                    jSONObject.put("app_version", common2.appVersion);
                    jSONObject.put("device_model", common2.deviceModel);
                    jSONObject.put("channel", packageStatisticModel6.channel);
                    Long l8 = packageStatisticModel6.id;
                    jSONObject.put("id", l8 == null ? 0L : l8.longValue());
                    jSONObject.put("ac", common2.ac);
                    Integer num = packageStatisticModel6.downloadRetryTimes;
                    jSONObject.put("download_retry_times", num == null ? 0 : num.intValue());
                    String str = packageStatisticModel6.downloadUrl;
                    Object obj2 = "";
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("download_url", str);
                    jSONObject.put("download_duration", packageStatisticModel6.downloadDuration);
                    List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list2 = packageStatisticModel6.downloadFailRecords;
                    if (list2 != null) {
                        obj2 = list2;
                    }
                    jSONObject.put("download_fail_records", obj2);
                    jSONObject.put("log_id", packageStatisticModel6.logId);
                    Long l9 = packageStatisticModel6.activeCheckDuration;
                    jSONObject.put("active_check_duration", l9 == null ? 0L : l9.longValue());
                    Long l10 = packageStatisticModel6.applyDuration;
                    jSONObject.put("apply_duration", l10 == null ? 0L : l10.longValue());
                    iStatisticMonitorQ.upload("geckosdk_update_stats", jSONObject);
                }
            } catch (Throwable th) {
                GeckoLogger.w("gecko-debug-tag", "UploadStatistic.upload:", th);
            }
        }
        if (bVar.c()) {
            try {
                final String strA = com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(statisticModel2);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                final String str2 = "https://" + bVar.j() + "/gecko/server/packages/stats";
                com.bykv.vk.openvk.preload.geckox.b.g().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.statistic.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (int i8 = 0; i8 < 3; i8++) {
                            try {
                                Response responseDoPost = bVar.i().doPost(str2, strA);
                                if (responseDoPost.code != 200) {
                                    throw new NetworkErrorException("net work get failed, code: " + responseDoPost.code + ", url:" + str2);
                                }
                                if (new JSONObject(responseDoPost.body).getInt("status") == 0) {
                                    return;
                                }
                            } catch (Exception e) {
                                GeckoLogger.w("gecko-debug-tag", "upload statistic:", e);
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }
}
