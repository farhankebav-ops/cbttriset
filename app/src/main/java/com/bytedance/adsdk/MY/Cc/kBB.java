package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.adsdk.MY.Bc;
import com.bytedance.adsdk.MY.EO.EO.Cc;
import com.bytedance.adsdk.MY.NV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class kBB {
    private static JSONArray EO(JsonReader jsonReader) {
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3324) {
                        if (iHashCode == 116753 && strNextName.equals("vid")) {
                            try {
                                jSONObject.put("vid", jsonReader.nextString());
                            } catch (JSONException unused) {
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("hd")) {
                        jSONObject.put("hd", jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x007e, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008e, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009e, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ae, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ce, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00de, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ee, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fd, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x010b, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0119, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0127, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0135, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0143, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x006a, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x006e, code lost:
    
        r21 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.adsdk.MY.Bc IlO(android.util.JsonReader r30) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.Cc.kBB.IlO(android.util.JsonReader):com.bytedance.adsdk.MY.Bc");
    }

    private static void MY(JsonReader jsonReader, Bc.IlO ilO) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 3276) {
                        if (iHashCode == 107027 && strNextName.equals("lel")) {
                            ilO.Bc = EO(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("fr")) {
                        ilO.Cc = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (strNextName.equals("el")) {
                    ilO.vCE = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
        }
    }

    private static List<NV.IlO> tV(JsonReader jsonReader) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                NV.IlO ilO = new NV.IlO();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 99) {
                        if (iHashCode != 102) {
                            if (iHashCode != 108) {
                                if (iHashCode != 115) {
                                    if (iHashCode != 3153) {
                                        if (iHashCode != 3449) {
                                            if (iHashCode == 96670 && strNextName.equals("ali")) {
                                                ilO.Bc = jsonReader.nextString();
                                            } else {
                                                jsonReader.skipValue();
                                            }
                                        } else if (strNextName.equals("le")) {
                                            ilO.MY = jsonReader.nextInt();
                                        } else {
                                            jsonReader.skipValue();
                                        }
                                    } else if (strNextName.equals("bs")) {
                                        ilO.vCE = jsonReader.nextInt();
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                } else if (strNextName.equals("s")) {
                                    ilO.Cc = jsonReader.nextInt();
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else if (strNextName.equals("l")) {
                                ilO.IlO = jsonReader.nextInt();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if (strNextName.equals("f")) {
                            ilO.tV = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("c")) {
                        ilO.EO = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                arrayList.add(ilO);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Map<String, Object> MY(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("lel")) {
                map.put("lel", EO(jsonReader));
            } else if (!strNextName.equals("lottie_back")) {
                jsonReader.skipValue();
            } else {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.getClass();
                    if (!strNextName2.equals("hd")) {
                        jsonReader.skipValue();
                    } else {
                        try {
                            jSONObject.putOpt("hd", Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException unused) {
                        }
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    private static void IlO(JsonReader jsonReader, Bc.MY my) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 107027) {
                        if (iHashCode == 3237004 && strNextName.equals("inel")) {
                            my.MY = new int[][]{new int[]{-1, -1}};
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                jsonReader.beginArray();
                                for (int i2 = 0; i2 < 2; i2++) {
                                    if (jsonReader.hasNext()) {
                                        my.MY[0][i2] = jsonReader.nextInt();
                                    }
                                }
                                jsonReader.endArray();
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("lel")) {
                        my.EO = EO(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (strNextName.equals("el")) {
                    my.IlO = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static void IlO(JsonReader jsonReader, Bc.IlO ilO) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3139) {
                    if (iHashCode != 3232) {
                        if (iHashCode != 3571) {
                            if (iHashCode != 3666) {
                                if (iHashCode == 98713 && strNextName.equals("cpf")) {
                                    MY(jsonReader, ilO);
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else if (strNextName.equals("se")) {
                                ilO.IlO = jsonReader.nextInt();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if (strNextName.equals("pc")) {
                            ilO.tV = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("ee")) {
                        ilO.EO = MY(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (strNextName.equals("be")) {
                    ilO.MY = MY(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static void IlO(JsonReader jsonReader, Bc.EO eo) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3123) {
                    if (iHashCode != 3239) {
                        if (iHashCode != 3355) {
                            if (iHashCode != 3418) {
                                if (iHashCode != 3704) {
                                    if (iHashCode != 107027) {
                                        if (iHashCode == 3237004 && strNextName.equals("inel")) {
                                            eo.Cc = new int[]{-1, -1};
                                            jsonReader.beginArray();
                                            for (int i2 = 0; i2 < 2; i2++) {
                                                if (jsonReader.hasNext()) {
                                                    eo.Cc[i2] = jsonReader.nextInt();
                                                }
                                            }
                                            jsonReader.endArray();
                                        } else {
                                            jsonReader.skipValue();
                                        }
                                    } else if (strNextName.equals("lel")) {
                                        eo.Bc = EO(jsonReader);
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                } else if (strNextName.equals("tl")) {
                                    eo.EO = jsonReader.nextString();
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else if (strNextName.equals("ke")) {
                                eo.IlO = jsonReader.nextInt();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if (strNextName.equals("id")) {
                            eo.MY = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("el")) {
                        eo.vCE = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (strNextName.equals("at")) {
                    eo.tV = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static void IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, List<com.bytedance.adsdk.MY.EO.EO.Cc> list, LongSparseArray<com.bytedance.adsdk.MY.EO.EO.Cc> longSparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.MY.EO.EO.Cc ccIlO = vAh.IlO(jsonReader, bc);
            ccIlO.EV();
            Cc.IlO ilO = Cc.IlO.PRE_COMP;
            list.add(ccIlO);
            longSparseArray.put(ccIlO.Cc(), ccIlO);
        }
        jsonReader.endArray();
    }

    private static void IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, Map<String, List<com.bytedance.adsdk.MY.EO.EO.Cc>> map, Map<String, com.bytedance.adsdk.MY.NV> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<NV.IlO> listTV = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayEO = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.MY.EO.EO.Cc ccIlO = vAh.IlO(jsonReader, bc);
                            longSparseArray.put(ccIlO.Cc(), ccIlO);
                            arrayList.add(ccIlO);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "el":
                        strNextString5 = jsonReader.nextString();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    case "tc":
                        jsonReader.beginArray();
                        listTV = tV(jsonReader);
                        jsonReader.endArray();
                        break;
                    case "lel":
                        jSONArrayEO = EO(jsonReader);
                        break;
                    case "rel":
                        strNextString4 = jsonReader.nextString();
                        break;
                    case "inel":
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i2 = 0; i2 < 2; i2++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i2] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.bytedance.adsdk.MY.NV nv = new com.bytedance.adsdk.MY.NV(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listTV, strNextString5, iArr, jSONArrayEO);
                map2.put(nv.lEW(), nv);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void IlO(JsonReader jsonReader, Map<String, com.bytedance.adsdk.MY.EO.EO> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (!strNextName.equals("list")) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.MY.EO.EO eoIlO = bWL.IlO(jsonReader);
                    map.put(eoIlO.MY(), eoIlO);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, SparseArray<com.bytedance.adsdk.MY.EO.tV> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.MY.EO.tV tVVarIlO = hp.IlO(jsonReader, bc);
            sparseArray.put(tVVarIlO.hashCode(), tVVarIlO);
        }
        jsonReader.endArray();
    }

    private static void IlO(JsonReader jsonReader, List<com.bytedance.adsdk.MY.EO.vCE> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.MY.EO.vCE(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
