package com.ironsource.adqualitysdk.sdk.i;

import com.ironsource.adqualitysdk.sdk.i.cq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class db extends da {
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static String m1900(List<Object> list) {
        if (list.get(0) instanceof Class) {
            return hu.m2386().m2388().m2439((Class) da.m1896(list, 0, Class.class), (String) da.m1896(list, 1, String.class));
        }
        Object objM1896 = da.m1896(list, 0, (Class<Object>) Object.class);
        if (list.get(1) instanceof List) {
            return hu.m2386().m2388().m2436(objM1896, new JSONArray((Collection) da.m1896(list, 1, List.class)));
        }
        if (list.get(1) instanceof JSONArray) {
            return hu.m2386().m2388().m2436(objM1896, (JSONArray) da.m1896(list, 1, JSONArray.class));
        }
        return hu.m2386().m2388().m2435(objM1896, (String) da.m1896(list, 1, String.class));
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Object m1901(List<Object> list) {
        Object objM1896;
        Class<?> cls;
        hm hmVar;
        Object objM18962;
        hm hmVar2;
        Object objM18963;
        int size = list.size();
        Object objM18964 = null;
        Class<?> cls2 = null;
        if (size != 2) {
            if (size == 3) {
                if (list.get(0) instanceof Class) {
                    cls = (Class) da.m1896(list, 0, Class.class);
                    if (list.get(1) instanceof hm) {
                        hmVar2 = (hm) da.m1896(list, 1, hm.class);
                        objM18963 = da.m1896(list, 2, (Class<Object>) Object.class);
                    } else {
                        objM1896 = da.m1896(list, 1, (Class<Object>) Object.class);
                        hmVar = (hm) da.m1896(list, 2, hm.class);
                    }
                } else {
                    objM18964 = da.m1896(list, 0, (Class<Object>) Object.class);
                    cls = objM18964.getClass();
                    hmVar2 = (hm) da.m1896(list, 1, hm.class);
                    objM18963 = da.m1896(list, 2, (Class<Object>) Object.class);
                }
                Class<?> cls3 = cls;
                objM18962 = objM18963;
                hmVar = hmVar2;
                objM1896 = objM18964;
                cls2 = cls3;
            } else if (size != 4) {
                hmVar = null;
                objM18962 = null;
                objM1896 = null;
            } else {
                cls2 = (Class) da.m1896(list, 0, Class.class);
                Object objM18965 = da.m1896(list, 1, (Class<Object>) Object.class);
                hm hmVar3 = (hm) da.m1896(list, 2, hm.class);
                objM18962 = da.m1896(list, 3, (Class<Object>) Object.class);
                hmVar = hmVar3;
                objM1896 = objM18965;
            }
            hu.m2386().m2388();
            return hy.m2431(cls2, objM1896, hmVar, objM18962);
        }
        if (list.get(0) instanceof Class) {
            cls = (Class) da.m1896(list, 0, Class.class);
            objM1896 = null;
        } else {
            Object objM18966 = da.m1896(list, 0, (Class<Object>) Object.class);
            if (objM18966 != null) {
                objM1896 = objM18966;
                cls = objM18966.getClass();
            } else {
                objM1896 = objM18966;
                cls = null;
            }
        }
        hmVar = (hm) da.m1896(list, 1, hm.class);
        cls2 = cls;
        objM18962 = null;
        hu.m2386().m2388();
        return hy.m2431(cls2, objM1896, hmVar, objM18962);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static List<Object> m1902(List<Object> list) {
        Object objM1896;
        hm hmVar;
        Class<?> cls;
        int size = list.size();
        Class<?> cls2 = null;
        cls2 = null;
        Object objM18962 = null;
        if (size == 2) {
            if (list.get(0) instanceof Class) {
                cls2 = (Class) da.m1896(list, 0, Class.class);
                objM1896 = null;
            } else {
                objM1896 = da.m1896(list, 0, (Class<Object>) Object.class);
                if (objM1896 != null) {
                    cls2 = objM1896.getClass();
                }
            }
            hmVar = (hm) da.m1896(list, 1, hm.class);
        } else if (size != 3) {
            hmVar = null;
            objM1896 = null;
        } else {
            if (list.get(0) instanceof Class) {
                cls = (Class) da.m1896(list, 0, Class.class);
                if (list.get(1) instanceof hm) {
                    hmVar = (hm) da.m1896(list, 1, hm.class);
                } else {
                    objM18962 = da.m1896(list, 1, (Class<Object>) Object.class);
                    hmVar = (hm) da.m1896(list, 2, hm.class);
                }
            } else {
                objM18962 = da.m1896(list, 0, (Class<Object>) Object.class);
                cls = objM18962.getClass();
                hmVar = (hm) da.m1896(list, 1, hm.class);
            }
            Object obj = objM18962;
            cls2 = cls;
            objM1896 = obj;
        }
        hu.m2386().m2388();
        return hy.m2422(cls2, objM1896, hmVar);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static cq.b m1903(List<Object> list) {
        return new cq.b((List) da.m1896(list, 0, List.class), ((Integer) da.m1896(list, 1, Integer.class)).intValue());
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final List<hs> m1904(final ds dsVar, final cp cpVar, List<Object> list) {
        Object objM1896 = da.m1896(list, 0, (Class<Object>) Object.class);
        final cq cqVar = (cq) da.m1896(list, 1, cq.class);
        final List<Object> listM1898 = da.m1898(list, 2);
        if (cqVar == null) {
            return null;
        }
        return hu.m2386().m2388().m2440(objM1896, cqVar.m1782(new ia() { // from class: com.ironsource.adqualitysdk.sdk.i.db.3
            @Override // com.ironsource.adqualitysdk.sdk.i.ia
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            public final boolean mo1908(hs hsVar) {
                return cqVar.m1781().m1639(hsVar, dsVar, cpVar, listM1898);
            }
        }));
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Object m1907(ds dsVar, cp cpVar, List<Object> list) {
        hs hsVarM1906 = m1906(dsVar, cpVar, list);
        if (hsVarM1906 != null) {
            return hsVarM1906.mo2359();
        }
        return null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final <T> hs<T> m1906(final ds dsVar, final cp cpVar, List<Object> list) {
        Object objM1896 = da.m1896(list, 0, (Class<Object>) Object.class);
        final cq cqVar = (cq) da.m1896(list, 1, cq.class);
        final List<Object> listM1898 = da.m1898(list, 2);
        if (cqVar == null) {
            return null;
        }
        return hu.m2386().m2388().m2438(objM1896, cqVar.m1782(new ia() { // from class: com.ironsource.adqualitysdk.sdk.i.db.4
            @Override // com.ironsource.adqualitysdk.sdk.i.ia
            /* JADX INFO: renamed from: ﾇ */
            public final boolean mo1908(hs hsVar) {
                return cqVar.m1781().m1639(hsVar, dsVar, cpVar, listM1898);
            }
        }));
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final List<Object> m1905(ds dsVar, cp cpVar, List<Object> list) {
        ArrayList arrayList = new ArrayList();
        for (hs hsVar : m1904(dsVar, cpVar, list)) {
            if (hsVar != null) {
                arrayList.add(hsVar.mo2359());
            }
        }
        return arrayList;
    }
}
