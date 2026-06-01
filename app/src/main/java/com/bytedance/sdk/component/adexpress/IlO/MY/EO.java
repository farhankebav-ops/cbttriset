package com.bytedance.sdk.component.adexpress.IlO.MY;

import a1.a;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.IlO.EO.IlO;
import com.bytedance.sdk.component.utils.lMM;
import com.ironsource.G5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EO {
    public void EO(List<IlO.C0049IlO> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<IlO.C0049IlO> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(IlO(), com.bytedance.sdk.component.utils.Cc.IlO(it.next().IlO()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public abstract File IlO();

    public boolean IlO(Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO = map.get(it.next());
            if (ilO != null && !IlO(ilO.vCE())) {
                return false;
            }
        }
        return true;
    }

    public List<IlO.C0049IlO> MY(com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO, com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<IlO.C0049IlO> arrayList3 = new ArrayList<>();
        if (ilO2 == null || ilO2.vCE().isEmpty()) {
            arrayList2.addAll(ilO.vCE());
        } else if (ilO.vCE().isEmpty()) {
            arrayList.addAll(ilO2.vCE());
        } else {
            for (IlO.C0049IlO c0049IlO : ilO.vCE()) {
                if (!ilO2.vCE().contains(c0049IlO) && c0049IlO != null && c0049IlO.IlO() != null && c0049IlO.MY() != null) {
                    arrayList2.add(c0049IlO);
                }
            }
            for (IlO.C0049IlO c0049IlO2 : ilO2.vCE()) {
                if (!ilO.vCE().contains(c0049IlO2)) {
                    arrayList.add(c0049IlO2);
                }
            }
        }
        if (IlO(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public boolean IlO(List<IlO.C0049IlO> list) {
        if (list == null || list.size() <= 0 || IlO() == null) {
            return false;
        }
        for (IlO.C0049IlO c0049IlO : list) {
            String strIlO = com.bytedance.sdk.component.utils.Cc.IlO(c0049IlO.IlO());
            if (TextUtils.isEmpty(strIlO)) {
                return false;
            }
            File file = new File(IlO(), strIlO);
            String strIlO2 = com.bytedance.sdk.component.utils.Cc.IlO(file);
            if (!file.exists() || !file.isFile() || c0049IlO.MY() == null || !c0049IlO.MY().equals(strIlO2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean EO(com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO, com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO2) {
        if (ilO != null) {
            try {
                if (!TextUtils.isEmpty(ilO.EO())) {
                    if (ilO2 == null) {
                        return false;
                    }
                    String strBc = ilO.Bc();
                    String strBc2 = ilO2.Bc();
                    if ((!TextUtils.isEmpty(strBc2) && !strBc2.equals(strBc)) || IlO(ilO.EO(), ilO2.EO())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO = ilO.IlO();
                    Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO2 = ilO2.IlO();
                    if (mapIlO.isEmpty()) {
                        return !mapIlO2.isEmpty();
                    }
                    if (mapIlO2.isEmpty()) {
                        return false;
                    }
                    return IlO(mapIlO, mapIlO2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    public boolean IlO(IlO.MY my) {
        if (my == null || IlO() == null) {
            return false;
        }
        List<Pair<String, String>> listMY = my.MY();
        if (listMY == null || listMY.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listMY.iterator();
        while (it.hasNext()) {
            File file = new File(IlO(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public void MY(List<IlO.C0049IlO> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<IlO.C0049IlO> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(IlO(), com.bytedance.sdk.component.utils.Cc.IlO(it.next().IlO()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public List<IlO.C0049IlO> IlO(com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO, com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO2) {
        Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO = ilO.IlO();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<IlO.C0049IlO> arrayList3 = new ArrayList<>();
        if (mapIlO.size() == 0) {
            if (ilO2 != null && ilO2.IlO().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO2 = ilO2.IlO();
                Iterator<String> it = mapIlO2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO3 = mapIlO2.get(it.next());
                    if (ilO3 != null) {
                        arrayList.addAll(ilO3.vCE());
                    }
                }
            }
        } else if (ilO2 != null && ilO2.IlO().size() != 0) {
            Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO3 = ilO2.IlO();
            for (String str : mapIlO.keySet()) {
                com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO4 = mapIlO.get(str);
                com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO5 = mapIlO3.get(str);
                if (ilO5 == null && ilO4 != null) {
                    arrayList2.addAll(ilO4.vCE());
                } else if (ilO4 == null && ilO5 != null) {
                    arrayList.addAll(ilO5.vCE());
                } else if (ilO4 != null) {
                    for (IlO.C0049IlO c0049IlO : ilO4.vCE()) {
                        if (c0049IlO != null && !ilO5.vCE().contains(c0049IlO) && c0049IlO.MY() != null && c0049IlO.IlO() != null) {
                            arrayList2.add(c0049IlO);
                        }
                    }
                    for (IlO.C0049IlO c0049IlO2 : ilO5.vCE()) {
                        if (c0049IlO2 != null && !ilO4.vCE().contains(c0049IlO2)) {
                            arrayList.add(c0049IlO2);
                        }
                    }
                }
            }
        } else if (mapIlO.size() != 0) {
            Iterator<String> it2 = mapIlO.keySet().iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO6 = mapIlO.get(it2.next());
                if (ilO6 != null) {
                    arrayList2.addAll(ilO6.vCE());
                }
            }
        }
        if (IlO(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public static void MY(File file, com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO, String str) {
        if (ilO == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (ilO.vCE() != null) {
            Iterator<IlO.C0049IlO> it = ilO.vCE().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.Cc.IlO(it.next().IlO())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private boolean IlO(List<IlO.C0049IlO> list, List<IlO.C0049IlO> list2) {
        for (IlO.C0049IlO c0049IlO : list) {
            String strIlO = c0049IlO.IlO();
            String strIlO2 = com.bytedance.sdk.component.utils.Cc.IlO(strIlO);
            File file = new File(IlO(), strIlO2);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.Bc.MY.IlO ilOVCE = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().vCE();
            ilOVCE.MY(strIlO);
            ilOVCE.IlO(IlO().getAbsolutePath(), strIlO2);
            com.bytedance.sdk.component.Bc.MY myIlO = ilOVCE.IlO();
            list2.add(c0049IlO);
            if (myIlO == null || !myIlO.vCE() || myIlO.Cc() == null || !myIlO.Cc().exists()) {
                EO(list2);
                return false;
            }
        }
        return true;
    }

    public boolean IlO(String str) {
        File file = new File(IlO().getAbsoluteFile(), a.C(com.bytedance.sdk.component.utils.Cc.IlO(str), ".zip"));
        com.bytedance.sdk.component.Bc.MY.IlO ilOVCE = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().vCE();
        ilOVCE.MY(str);
        ilOVCE.IlO(file.getParent(), file.getName());
        com.bytedance.sdk.component.Bc.MY myIlO = ilOVCE.IlO();
        if (myIlO.vCE() && myIlO.Cc() != null && myIlO.Cc().exists()) {
            File fileCc = myIlO.Cc();
            try {
                lMM.IlO(fileCc.getAbsolutePath(), file.getParent());
                if (!fileCc.exists()) {
                    return true;
                }
                fileCc.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void IlO(int i2) {
        if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().tV() != null) {
            com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().tV().IlO(i2);
        }
    }

    public static void IlO(File file, com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO, String str) {
        FileOutputStream fileOutputStream;
        if (ilO == null) {
            return;
        }
        String strNV = ilO.NV();
        if (TextUtils.isEmpty(strNV)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file3);
                try {
                    fileOutputStream.write(strNV.getBytes(G5.N));
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file3.renameTo(file2);
                    fileOutputStream.close();
                } catch (Throwable unused) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable unused3) {
            fileOutputStream = null;
        }
    }

    private static boolean IlO(Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> map, Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO = map.get(str);
            if (ilO == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO2 = map2.get(str);
            if (ilO2 == null) {
                return false;
            }
            if (IlO(ilO.EO(), ilO2.EO())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean IlO(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r7.length
            int r1 = r6.length
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = r1
        L12:
            if (r2 >= r0) goto L42
            r3 = r7[r2]
            int r3 = r3.length()
            r4 = r6[r2]
            int r4 = r4.length()
            int r3 = r3 - r4
            r4 = 1
            if (r3 != 0) goto L3f
            r3 = r7[r2]
            r5 = r6[r2]
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L2f
            return r4
        L2f:
            if (r3 >= 0) goto L32
            return r1
        L32:
            int r3 = r0 + (-1)
            if (r2 != r3) goto L3c
            int r7 = r7.length
            int r6 = r6.length
            if (r7 <= r6) goto L3b
            return r4
        L3b:
            return r1
        L3c:
            int r2 = r2 + 1
            goto L12
        L3f:
            if (r3 <= 0) goto L42
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.IlO.MY.EO.IlO(java.lang.String, java.lang.String):boolean");
    }

    @Deprecated
    public static boolean IlO(com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO, String str) {
        if (ilO == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(ilO.EO())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return IlO(ilO.EO(), str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
