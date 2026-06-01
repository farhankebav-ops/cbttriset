package com.bytedance.adsdk.MY.Cc;

import android.util.JsonReader;
import com.bytedance.adsdk.MY.EO.MY.es;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class ssS {
    public static com.bytedance.adsdk.MY.EO.MY.es IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc) throws IOException {
        int i2;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO;
        int i8;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        com.bytedance.adsdk.MY.EO.IlO.tV tVVar = null;
        String strNextString = null;
        com.bytedance.adsdk.MY.EO.IlO.MY my = null;
        com.bytedance.adsdk.MY.EO.IlO.IlO ilOBc = null;
        com.bytedance.adsdk.MY.EO.IlO.MY myIlO2 = null;
        es.IlO ilO = null;
        es.MY my2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            i2 = 1;
            switch (strNextName) {
                case "c":
                    ilOBc = tV.Bc(jsonReader, bc);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        myIlO = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.getClass();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                myIlO = tV.IlO(jsonReader, bc);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.getClass();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                i8 = 1;
                                bc.IlO(true);
                                arrayList.add(myIlO);
                                i2 = i8;
                                break;
                            case "o":
                                my = myIlO;
                                i2 = 1;
                                break;
                            default:
                                i8 = 1;
                                i2 = i8;
                                break;
                        }
                    }
                    int i9 = i2;
                    jsonReader.endArray();
                    if (arrayList.size() != i9) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                case "o":
                    tVVar = tV.MY(jsonReader, bc);
                    continue;
                    break;
                case "w":
                    myIlO2 = tV.IlO(jsonReader, bc);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    ilO = es.IlO.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    my2 = es.MY.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (tVVar == null) {
            tVVar = new com.bytedance.adsdk.MY.EO.IlO.tV(Collections.singletonList(new com.bytedance.adsdk.MY.Bc.IlO(100)));
        }
        return new com.bytedance.adsdk.MY.EO.MY.es(strNextString, my, arrayList, ilOBc, tVVar, myIlO2, ilO, my2, fNextDouble, zNextBoolean);
    }
}
