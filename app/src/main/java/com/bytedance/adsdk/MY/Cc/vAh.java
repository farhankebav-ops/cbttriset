package com.bytedance.adsdk.MY.Cc;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.bytedance.adsdk.MY.EO.EO.Cc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vAh {

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.Cc.vAh$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[Cc.MY.values().length];
            IlO = iArr;
            try {
                iArr[Cc.MY.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[Cc.MY.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static com.bytedance.adsdk.MY.EO.EO.Cc IlO(com.bytedance.adsdk.MY.Bc bc) {
        Rect rectTV = bc.tV();
        List list = Collections.EMPTY_LIST;
        return new com.bytedance.adsdk.MY.EO.EO.Cc(list, bc, "__container", -1L, Cc.IlO.PRE_COMP, -1L, null, list, new com.bytedance.adsdk.MY.EO.IlO.rp(), 0, 0, 0, 0.0f, 0.0f, rectTV.width(), rectTV.height(), null, null, list, Cc.MY.NONE, null, false, null, null);
    }

    public static com.bytedance.adsdk.MY.EO.EO.Cc IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        Float f4;
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        Cc.MY my = Cc.MY.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Cc.MY my2 = my;
        String strNextString = null;
        com.bytedance.adsdk.MY.EO.IlO.rp rpVarIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.NV nvVCE = null;
        com.bytedance.adsdk.MY.EO.IlO.EV evIlO = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO = null;
        com.bytedance.adsdk.MY.EO.MY.IlO IlO = null;
        NV nvIlO = null;
        float fNextDouble = 0.0f;
        float fBc = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        long jNextInt = 0;
        long jNextInt2 = -1;
        int iIlO = 0;
        int iIlO2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        float fNextDouble5 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        Cc.IlO ilO = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "parent":
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case "shapes":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.MY.EO.MY.EO eoIlO = lEW.IlO(jsonReader, bc);
                        if (eoIlO != null) {
                            arrayList2.add(eoIlO);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "h":
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.MY.vCE.vCE.IlO()));
                    break;
                case "t":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.getClass();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                evIlO = MY.IlO(jsonReader, bc);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (!strNextName2.equals("d")) {
                            jsonReader.skipValue();
                        } else {
                            nvVCE = tV.vCE(jsonReader, bc);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "w":
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.MY.vCE.vCE.IlO()));
                    break;
                case "cl":
                    strNextString3 = jsonReader.nextString();
                    break;
                case "ef":
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.getClass();
                            if (strNextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (!strNextName3.equals("ty")) {
                                jsonReader.skipValue();
                            } else {
                                int iNextInt = jsonReader.nextInt();
                                if (iNextInt == 29) {
                                    IlO = Cc.IlO(jsonReader, bc);
                                } else if (iNextInt == 25) {
                                    nvIlO = new EV().IlO(jsonReader, bc);
                                }
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    bc.IlO("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ip":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ks":
                    rpVarIlO = EO.IlO(jsonReader, bc);
                    break;
                case "nm":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "op":
                    fBc = (float) jsonReader.nextDouble();
                    break;
                case "sc":
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case "sh":
                    iIlO2 = (int) (com.bytedance.adsdk.MY.vCE.vCE.IlO() * jsonReader.nextInt());
                    break;
                case "sr":
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    break;
                case "st":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case "sw":
                    iIlO = (int) (com.bytedance.adsdk.MY.vCE.vCE.IlO() * jsonReader.nextInt());
                    break;
                case "tm":
                    myIlO = tV.IlO(jsonReader, bc, false);
                    break;
                case "tt":
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 >= Cc.MY.values().length) {
                        bc.IlO("Unsupported matte type: ".concat(String.valueOf(iNextInt2)));
                        break;
                    } else {
                        my2 = Cc.MY.values()[iNextInt2];
                        int i2 = AnonymousClass1.IlO[my2.ordinal()];
                        if (i2 == 1) {
                            bc.IlO("Unsupported matte type: Luma");
                        } else if (i2 == 2) {
                            bc.IlO("Unsupported matte type: Luma Inverted");
                        }
                        bc.IlO(1);
                        break;
                    }
                    break;
                case "ty":
                    int iNextInt3 = jsonReader.nextInt();
                    ilO = Cc.IlO.UNKNOWN;
                    if (iNextInt3 >= ilO.ordinal()) {
                        break;
                    } else {
                        ilO = Cc.IlO.values()[iNextInt3];
                        break;
                    }
                    break;
                case "ind":
                    jNextInt = jsonReader.nextInt();
                    break;
                case "refId":
                    strNextString = jsonReader.nextString();
                    break;
                case "masksProperties":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(pP.IlO(jsonReader, bc));
                    }
                    bc.IlO(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble > 0.0f) {
            f4 = fValueOf;
            arrayList4.add(new com.bytedance.adsdk.MY.Bc.IlO(bc, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble)));
        } else {
            f4 = fValueOf;
        }
        if (fBc <= 0.0f) {
            fBc = bc.Bc();
        }
        arrayList4.add(new com.bytedance.adsdk.MY.Bc.IlO(bc, fValueOf2, fValueOf2, null, fNextDouble, Float.valueOf(fBc)));
        arrayList4.add(new com.bytedance.adsdk.MY.Bc.IlO(bc, f4, f4, null, fBc, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            bc.IlO("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.MY.EO.EO.Cc(arrayList2, bc, strNextString2, jNextInt, ilO, jNextInt2, strNextString, arrayList, rpVarIlO, iIlO, iIlO2, color, fNextDouble5, fNextDouble4, fNextDouble2, fNextDouble3, nvVCE, evIlO, arrayList4, my2, myIlO, zNextBoolean, IlO, nvIlO);
    }
}
