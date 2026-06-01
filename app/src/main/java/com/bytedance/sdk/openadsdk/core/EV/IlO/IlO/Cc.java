package com.bytedance.sdk.openadsdk.core.EV.IlO.IlO;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.openadsdk.core.EV.EO.IlO;
import com.bytedance.sdk.openadsdk.core.EV.IlO.MY;
import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends com.bytedance.sdk.openadsdk.core.EV.IlO.MY {
    public static final String Bc = null;

    public Cc(Context context, int i2, int i8) {
        super(context, i2, i8);
    }

    private void EO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(Collections.singletonList(new EO.IlO(str).IlO()), this.IlO > 0 ? com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.NO_ADS_VAST_RESPONSE : com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.UNDEFINED_ERROR, -1L, null), (EO.MY) null);
    }

    public static int MY(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> tV(String str) {
        return IlO(str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    @Override // com.bytedance.sdk.openadsdk.core.EV.IlO.MY
    public com.bytedance.sdk.openadsdk.core.EV.IlO IlO(String str, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        this.Cc = 0;
        ?? r32 = 0;
        if (this.MY == null) {
            this.Cc = -1;
            return null;
        }
        ?? IsEmpty = TextUtils.isEmpty(str);
        try {
            if (IsEmpty != 0) {
                this.Cc = -2;
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(str.getBytes(Key.STRING_CHARSET_NAME));
            } catch (Exception unused) {
                byteArrayInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (r32 != 0) {
                    try {
                        r32.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                xmlPullParserNewPullParser.setInput(byteArrayInputStream, Key.STRING_CHARSET_NAME);
                xmlPullParserNewPullParser.nextTag();
                com.bytedance.sdk.openadsdk.core.EV.IlO IlO2 = IlO(xmlPullParserNewPullParser, list);
                IlO(IlO2);
                try {
                    byteArrayInputStream.close();
                } catch (IOException unused3) {
                }
                return IlO2;
            } catch (Exception unused4) {
                this.Cc = -3;
                IlO((com.bytedance.sdk.openadsdk.core.EV.IlO) null);
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            r32 = IsEmpty;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        IlO.MY EO;
        String IlO;
        IlO.EnumC0084IlO MY;
        String tV;
        final List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> Cc = new ArrayList();
        final List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> vCE = new ArrayList();
        float Bc = Float.MIN_VALUE;

        public IlO() {
        }

        public void IlO(String str, IlO.EnumC0084IlO enumC0084IlO, IlO.MY my) {
            this.IlO = str;
            this.MY = enumC0084IlO;
            this.EO = my;
        }

        public void MY(String str) {
            this.vCE.add(new EO.IlO(str).IlO());
        }

        public void IlO(String str) {
            this.Cc.add(new EO.IlO(str).IlO());
        }

        public IlO(String str, IlO.EnumC0084IlO enumC0084IlO, IlO.MY my) {
            IlO(str, enumC0084IlO, my);
        }
    }

    public static String MY(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strTrim;
        String str2 = Bc;
        xmlPullParser.require(2, str2, str);
        if (xmlPullParser.next() == 4) {
            strTrim = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        } else {
            strTrim = "";
        }
        xmlPullParser.require(3, str2, str);
        return strTrim;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0017, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.sdk.openadsdk.core.EV.IlO MY(org.xmlpull.v1.XmlPullParser r18, java.util.List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.Cc.MY(org.xmlpull.v1.XmlPullParser, java.util.List):com.bytedance.sdk.openadsdk.core.EV.IlO");
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.EV.IlO ilO) {
        if (this.vCE == null) {
            this.vCE = new MY.IlO();
        }
        MY.IlO ilO2 = this.vCE;
        ilO2.IlO = this.Cc;
        ilO2.MY = this.IlO;
        if (ilO != null) {
            ilO2.EO = ilO.IlO().MY.size() <= 0;
        }
    }

    private com.bytedance.sdk.openadsdk.core.EV.IlO IlO(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list) throws Throwable {
        XmlPullParser xmlPullParser2;
        List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list2;
        XmlPullParser xmlPullParser3;
        List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list3;
        xmlPullParser.require(2, Bc, "VAST");
        boolean z2 = false;
        String strMY = null;
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if ("Error".equals(name)) {
                    strMY = MY(xmlPullParser, name);
                } else {
                    if ("Ad".equals(name)) {
                        if (IlO(xmlPullParser.getAttributeValue(Bc, "sequence"))) {
                            while (true) {
                                if (xmlPullParser.next() == 3 && "Ad".equals(xmlPullParser.getName())) {
                                    xmlPullParser2 = xmlPullParser;
                                    list2 = list;
                                    z2 = true;
                                    break;
                                }
                                if (xmlPullParser.getEventType() == 2) {
                                    String name2 = xmlPullParser.getName();
                                    if ("InLine".equals(name2)) {
                                        xmlPullParser3 = xmlPullParser;
                                        list3 = list;
                                        com.bytedance.sdk.openadsdk.core.EV.IlO IlO2 = MY.IlO(this.MY, xmlPullParser3, list3, this.EO, this.tV);
                                        if (IlO2 != null) {
                                            if (!TextUtils.isEmpty(IlO2.Bc())) {
                                                return IlO2;
                                            }
                                            this.Cc = -6;
                                            return null;
                                        }
                                    } else {
                                        xmlPullParser3 = xmlPullParser;
                                        list3 = list;
                                        if ("Wrapper".equals(name2)) {
                                            com.bytedance.sdk.openadsdk.core.EV.IlO ilOMY = MY(xmlPullParser3, list3);
                                            if (ilOMY != null) {
                                                return ilOMY;
                                            }
                                        } else {
                                            IlO(xmlPullParser3);
                                        }
                                    }
                                    xmlPullParser = xmlPullParser3;
                                    list = list3;
                                }
                            }
                        } else {
                            IlO(xmlPullParser);
                            z2 = true;
                        }
                    } else {
                        xmlPullParser2 = xmlPullParser;
                        list2 = list;
                        IlO(xmlPullParser2);
                    }
                    xmlPullParser = xmlPullParser2;
                    list = list2;
                }
            }
        }
        if (!z2) {
            this.Cc = -4;
            EO(strMY);
        }
        if (this.Cc == 0) {
            this.Cc = -5;
        }
        return null;
    }

    public static List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> IlO(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return tV(MY(xmlPullParser, str));
    }

    public static void IlO(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i2 = 1;
        while (i2 != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static void IlO(XmlPullParser xmlPullParser, String str, int i2) throws XmlPullParserException, IOException {
        while (xmlPullParser.getEventType() != 1) {
            if (str.equals(xmlPullParser.getName()) && xmlPullParser.getEventType() == i2) {
                return;
            } else {
                xmlPullParser.next();
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> IlO(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return Collections.singletonList(new EO.IlO(str).IlO(z2).IlO());
    }
}
