package com.bykv.vk.openvk.preload.geckox.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.model.ComponentModel;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import java.io.File;
import java.io.FileFilter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class c extends com.bykv.vk.openvk.preload.b.d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.b f4980d;
    private Map<String, Map<String, Object>> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, List<CheckRequestBodyModel.TargetChannel>> f4981f;
    private com.bykv.vk.openvk.preload.geckox.e.a g;
    private String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.buffer.a.a f4982i = new com.bykv.vk.openvk.preload.geckox.buffer.a.a();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends RuntimeException {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.geckox.d.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0023c extends RuntimeException {
        public C0023c(String str, Throwable th) {
            super(str, th);
        }
    }

    private static void b(List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> list) {
        if (list == null) {
            return;
        }
        Iterator<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> it = list.iterator();
        while (it.hasNext()) {
            try {
                ((com.bykv.vk.openvk.preload.geckox.g.a) it.next().second).a();
            } catch (Exception e) {
                GeckoLogger.e("gecko-debug-tag", "releaseLock:", e);
            }
        }
    }

    private List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> c(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UpdatePackage updatePackage : list) {
            try {
                File file = new File(new File(this.f4980d.n(), updatePackage.getAccessKey()), updatePackage.getChannel());
                if (file.isFile()) {
                    com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
                }
                if (!file.mkdirs() && !file.isDirectory()) {
                    GeckoLogger.d("gecko-debug-tag", "can not create channel dir：", file.getAbsolutePath());
                    throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                }
                com.bykv.vk.openvk.preload.geckox.g.a aVarA = com.bykv.vk.openvk.preload.geckox.g.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                if (aVarA != null) {
                    arrayList.add(new Pair(updatePackage.getChannel(), aVarA));
                    arrayList2.add(updatePackage);
                } else {
                    com.bykv.vk.openvk.preload.geckox.e.a aVar = this.g;
                    updatePackage.getChannel();
                }
            } catch (Exception e) {
                GeckoLogger.e("gecko-debug-tag", "filterChannel:", e);
                updatePackage.getChannel();
                com.bykv.vk.openvk.preload.geckox.e.a aVar2 = this.g;
            }
        }
        list.clear();
        list.addAll(arrayList2);
        return arrayList;
    }

    @Override // com.bykv.vk.openvk.preload.b.d
    public final void a(Object... objArr) {
        super.a(objArr);
        this.f4980d = (com.bykv.vk.openvk.preload.geckox.b) objArr[0];
        this.e = (Map) objArr[1];
        this.f4981f = (Map) objArr[2];
        this.g = (com.bykv.vk.openvk.preload.geckox.e.a) objArr[3];
        this.h = (String) objArr[4];
    }

    private String b(Map<String, List<Pair<String, Long>>> map) {
        List<CheckRequestBodyModel.TargetChannel> list;
        CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
        Context contextA = this.f4980d.a();
        checkRequestBodyModel.setCommon(new Common(this.f4980d.k(), this.f4980d.o(), this.f4980d.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(contextA), com.bykv.vk.openvk.preload.geckox.utils.e.a(contextA), this.f4980d.l(), this.f4980d.m()));
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<Pair<String, Long>>> entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Pair<String, Long> pair : entry.getValue()) {
                CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                localChannel.localVersion = (Long) pair.second;
                map3.put(pair.first, localChannel);
            }
            map2.put(entry.getKey(), map3);
        }
        try {
            com.bykv.vk.openvk.preload.a.d dVarB = com.bykv.vk.openvk.preload.geckox.c.b.a().b();
            this.f4982i.f4951a = dVarB.a(map2);
            checkRequestBodyModel.setLocal(map2);
            HashMap map4 = new HashMap();
            for (String str : this.f4980d.e()) {
                CheckRequestBodyModel.Group group = new CheckRequestBodyModel.Group();
                group.groupName = this.h;
                Map<String, List<CheckRequestBodyModel.TargetChannel>> map5 = this.f4981f;
                if (map5 != null && !map5.isEmpty() && (list = this.f4981f.get(str)) != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    group.targetChannels = arrayList;
                    arrayList.addAll(list);
                }
                map4.put(str, group);
            }
            this.f4982i.f4952b = dVarB.a(map4);
            checkRequestBodyModel.setDeployments(map4);
            Map<String, Map<String, Object>> map6 = this.e;
            if (map6 != null) {
                this.f4982i.f4953c = dVarB.a(map6);
                checkRequestBodyModel.setCustom(this.e);
            }
            return dVarB.a(checkRequestBodyModel);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bykv.vk.openvk.preload.b.d
    public Object a(com.bykv.vk.openvk.preload.b.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Exception {
        List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> listC;
        int i2;
        char c7 = 2;
        int i8 = 0;
        char c8 = 1;
        GeckoLogger.d("gecko-debug-tag", "start get server channel version[v3]... local channel version:", map);
        Map<String, List<UpdatePackage>> mapA = a(map);
        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f4980d, this.f4982i);
        Iterator<Map.Entry<String, List<UpdatePackage>>> it = mapA.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<UpdatePackage> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                UpdatePackage next = it2.next();
                long localVersion = next.getLocalVersion();
                long version = next.getVersion();
                if (version < localVersion) {
                    String channel = next.getChannel();
                    Long lValueOf = Long.valueOf(localVersion);
                    Long lValueOf2 = Long.valueOf(version);
                    Object[] objArr = new Object[5];
                    objArr[i8] = channel;
                    objArr[c8] = "rollback：";
                    objArr[c7] = lValueOf;
                    objArr[3] = "->";
                    objArr[4] = lValueOf2;
                    GeckoLogger.d("gecko-debug-tag", objArr);
                    File[] fileArrListFiles = new File(this.f4980d.n(), next.getAccessKey() + File.separator + next.getChannel()).listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return file.isDirectory();
                        }
                    });
                    if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                        i8 = i8;
                        c7 = 2;
                        c8 = 1;
                    } else {
                        int length = fileArrListFiles.length;
                        int i9 = i8;
                        while (i9 < length) {
                            File file = fileArrListFiles[i9];
                            try {
                                long j = Long.parseLong(file.getName());
                                if (j > version) {
                                    i2 = i8;
                                    final File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                                    file.renameTo(file2);
                                    com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.bykv.vk.openvk.preload.geckox.utils.b.a(file2);
                                        }
                                    });
                                } else {
                                    i2 = i8;
                                    if (j == version) {
                                        it2.remove();
                                    }
                                }
                            } catch (Exception unused) {
                                i2 = i8;
                            }
                            i9++;
                            i8 = i2;
                            c7 = 2;
                            c8 = 1;
                        }
                    }
                }
            }
        }
        int i10 = i8;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, List<UpdatePackage>>> it3 = mapA.entrySet().iterator();
        while (it3.hasNext()) {
            arrayList.addAll(it3.next().getValue());
        }
        Object objA = null;
        try {
            listC = c(arrayList);
        } catch (Throwable th) {
            th = th;
            listC = null;
        }
        try {
            objA = bVar.a(arrayList);
            b(listC);
            Object[] objArr2 = new Object[1];
            objArr2[i10] = "all channel update finished";
            GeckoLogger.d("gecko-debug-tag", objArr2);
        } catch (Throwable th2) {
            th = th2;
            try {
                GeckoLogger.e("gecko-debug-tag", "filterChannel:", th);
                b(listC);
                Object[] objArr3 = new Object[1];
                objArr3[i10] = "all channel update finished";
                GeckoLogger.d("gecko-debug-tag", objArr3);
            } catch (Throwable th3) {
                b(listC);
                Object[] objArr4 = new Object[1];
                objArr4[i10] = "all channel update finished";
                GeckoLogger.d("gecko-debug-tag", objArr4);
                throw th3;
            }
        }
        a(arrayList);
        return objA;
    }

    private void a(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return;
        }
        for (UpdatePackage updatePackage : list) {
            com.bykv.vk.openvk.preload.geckox.a.c.a(new File(new File(this.f4980d.n(), updatePackage.getAccessKey()), updatePackage.getChannel()).getAbsolutePath());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<String, List<UpdatePackage>> a(Map<String, List<Pair<String, Long>>> map) throws Exception {
        String strB = b(map);
        String str = "https://" + this.f4980d.j() + "/gecko/server/v3/package";
        try {
            this.f4982i.f4955f = com.bykv.vk.openvk.preload.geckox.utils.e.a(this.f4980d.a());
            Response responseDoPost = this.f4980d.i().doPost(str, strB);
            com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar = this.f4982i;
            aVar.g = responseDoPost.code;
            aVar.f4954d = responseDoPost.msg;
            Map<String, String> map2 = responseDoPost.headers;
            String str2 = "";
            if (map2 != null && !map2.isEmpty()) {
                String str3 = map2.get("x-tt-logid");
                if (TextUtils.isEmpty(str3)) {
                    str3 = map2.get("X-Tt-Logid");
                    if (TextUtils.isEmpty(str3)) {
                        String str4 = map2.get("X-TT-LOGID");
                        if (!TextUtils.isEmpty(str4)) {
                            str2 = str4;
                        }
                    } else {
                        str2 = str3;
                    }
                } else {
                    str2 = str3;
                }
            }
            aVar.e = str2;
            if (responseDoPost.code == 200) {
                String str5 = responseDoPost.body;
                GeckoLogger.d("gecko-debug-tag", "response:", str5);
                try {
                    com.bykv.vk.openvk.preload.geckox.model.Response response = (com.bykv.vk.openvk.preload.geckox.model.Response) (str5 == null ? null : com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(new StringReader(str5), new com.bykv.vk.openvk.preload.a.c.a<com.bykv.vk.openvk.preload.geckox.model.Response<ComponentModel>>() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.3
                    }.b()));
                    int i2 = response.status;
                    if (i2 != 0) {
                        if (i2 == 2000) {
                            com.bykv.vk.openvk.preload.geckox.a.a.a(this.f4980d);
                            return new HashMap();
                        }
                        String str6 = "check update error，unknow status code，response.status：" + response.status;
                        com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar2 = this.f4982i;
                        aVar2.f4954d = str6;
                        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f4980d, aVar2);
                        throw new a(str6);
                    }
                    if (response.data != 0) {
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.f4980d.a(), ((ComponentModel) response.data).getUniversalStrategies(), this.f4980d.n(), this.g);
                        Map<String, List<UpdatePackage>> packages = ((ComponentModel) response.data).getPackages();
                        if (packages != null && !packages.isEmpty()) {
                            for (String str7 : this.f4980d.e()) {
                                List<UpdatePackage> list = packages.get(str7);
                                if (list != null && !list.isEmpty()) {
                                    for (UpdatePackage updatePackage : list) {
                                        updatePackage.setAccessKey(str7);
                                        updatePackage.setLocalVersion(a(map.get(str7), updatePackage.getChannel()));
                                    }
                                }
                            }
                            return packages;
                        }
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.f4980d);
                        return new HashMap();
                    }
                    com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar3 = this.f4982i;
                    aVar3.f4954d = "check update error：response.data==null";
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f4980d, aVar3);
                    throw new a("check update error：response.data==null");
                } catch (Throwable th) {
                    this.f4982i.f4954d = "json parse failed：" + th.getMessage();
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f4980d, this.f4982i);
                    StringBuilder sbY = a1.a.y("json parse failed：", str5, " caused by:");
                    sbY.append(th.getMessage());
                    throw new b(sbY.toString(), th);
                }
            }
            throw new NetworkErrorException("net work get failed, code: " + responseDoPost.code + ", url:" + str);
        } catch (Exception e) {
            com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f4980d, this.f4982i);
            throw new C0023c(a1.a.j(e, a1.a.y("request failed：url:", str, ", caused by:")), e);
        }
    }

    private static long a(List<Pair<String, Long>> list, String str) {
        for (Pair<String, Long> pair : list) {
            if (((String) pair.first).equals(str)) {
                return ((Long) pair.second).longValue();
            }
        }
        return 0L;
    }
}
