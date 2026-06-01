package com.bytedance.adsdk.MY.Cc;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.MY.EO.MY;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF implements HSR<com.bytedance.adsdk.MY.EO.MY> {
    public static final DmF IlO = new DmF();

    private DmF() {
    }

    @Override // com.bytedance.adsdk.MY.Cc.HSR
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.MY.EO.MY MY(JsonReader jsonReader, float f4) throws IOException {
        MY.IlO ilO = MY.IlO.CENTER;
        jsonReader.beginObject();
        MY.IlO ilO2 = ilO;
        String strNextString = null;
        String strNextString2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iIlO = 0;
        int iIlO2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "f":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "j":
                    int iNextInt2 = jsonReader.nextInt();
                    ilO2 = MY.IlO.CENTER;
                    if (iNextInt2 <= ilO2.ordinal() && iNextInt2 >= 0) {
                        ilO2 = MY.IlO.values()[iNextInt2];
                        break;
                    } else {
                        break;
                    }
                    break;
                case "s":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "t":
                    strNextString = jsonReader.nextString();
                    break;
                case "fc":
                    iIlO = xF.IlO(jsonReader);
                    break;
                case "lh":
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case "ls":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ps":
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f4, ((float) jsonReader.nextDouble()) * f4);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case "sc":
                    iIlO2 = xF.IlO(jsonReader);
                    break;
                case "sw":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case "sz":
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f4, ((float) jsonReader.nextDouble()) * f4);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case "tr":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.MY.EO.MY(strNextString, strNextString2, fNextDouble, ilO2, iNextInt, fNextDouble2, fNextDouble3, iIlO, iIlO2, fNextDouble4, zNextBoolean, pointF, pointF2);
    }
}
