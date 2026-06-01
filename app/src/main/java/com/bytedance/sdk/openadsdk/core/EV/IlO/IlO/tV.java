package com.bytedance.sdk.openadsdk.core.EV.IlO.IlO;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.EV.NV;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static Set<NV> IlO(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        NV nvIlO;
        if (xmlPullParser == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Verification".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(Cc.Bc, "vendor");
                    String strMY = null;
                    String strMY2 = null;
                    String strMY3 = null;
                    while (true) {
                        if (xmlPullParser.getEventType() != 3 || !"Verification".equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == 2) {
                                String name = xmlPullParser.getName();
                                name.getClass();
                                switch (name) {
                                    case "Tracking":
                                        if (!"verificationNotExecuted".equals(xmlPullParser.getAttributeValue(Cc.Bc, NotificationCompat.CATEGORY_EVENT))) {
                                            break;
                                        } else {
                                            strMY3 = Cc.MY(xmlPullParser, "Tracking");
                                            break;
                                        }
                                        break;
                                    case "JavaScriptResource":
                                        if (!"omid".equals(xmlPullParser.getAttributeValue(Cc.Bc, "apiFramework"))) {
                                            break;
                                        } else {
                                            strMY = Cc.MY(xmlPullParser, "JavaScriptResource");
                                            break;
                                        }
                                        break;
                                    case "VerificationParameters":
                                        strMY2 = Cc.MY(xmlPullParser, "VerificationParameters");
                                        break;
                                }
                            }
                        } else if (!TextUtils.isEmpty(strMY) && (nvIlO = NV.IlO("omid", strMY, attributeValue, strMY2, strMY3)) != null) {
                            hashSet.add(nvIlO);
                        }
                    }
                } else {
                    Cc.IlO(xmlPullParser);
                }
            }
        }
        return hashSet;
    }
}
