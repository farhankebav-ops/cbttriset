package com.bytedance.sdk.component.Bc.MY;

import android.text.TextUtils;
import com.bytedance.sdk.component.MY.IlO.DmF;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.ea;
import com.bytedance.sdk.component.MY.IlO.hp;
import com.bytedance.sdk.component.MY.IlO.rp;
import com.bytedance.sdk.component.MY.IlO.vCE;
import com.ironsource.G5;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends EO {
    hp IlO;

    public tV(EV ev) {
        super(ev);
        this.IlO = null;
    }

    private byte[] Cc(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes(G5.N));
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (byteArrayOutputStream == null) {
                        throw th;
                    }
                    byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException unused5) {
                        throw th;
                    }
                }
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused7) {
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused8) {
        }
        return byteArray;
    }

    public void tV(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.IlO = hp.IlO(DmF.IlO("application/json; charset=utf-8"), str);
    }

    public void IlO(JSONObject jSONObject) {
        String string;
        if (jSONObject != null) {
            string = jSONObject.toString();
        } else {
            string = "{}";
        }
        this.IlO = hp.IlO(DmF.IlO("application/json; charset=utf-8"), string);
    }

    public void IlO(String str, byte[] bArr) {
        this.IlO = hp.IlO(DmF.IlO(str), bArr);
    }

    public void IlO(final com.bytedance.sdk.component.Bc.IlO.IlO ilO) {
        try {
            rp.IlO ilO2 = new rp.IlO();
            if (TextUtils.isEmpty(this.lEW)) {
                ilO.IlO(this, new IOException("Url is Empty"));
                return;
            }
            if (!TextUtils.isEmpty(this.Cc)) {
                ilO2.IlO(this.Cc);
            }
            int i2 = this.vCE;
            if (i2 > 0) {
                ilO2.IlO(i2);
            }
            ilO2.MY(this.lEW);
            if (this.IlO == null) {
                if (ilO != null) {
                    ilO.IlO(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                IlO(ilO2);
                ilO2.IlO((Object) EO());
                this.EO.IlO(ilO2.IlO(this.IlO).MY()).IlO(new com.bytedance.sdk.component.MY.IlO.EO() { // from class: com.bytedance.sdk.component.Bc.MY.tV.1
                    @Override // com.bytedance.sdk.component.MY.IlO.EO
                    public void IlO(com.bytedance.sdk.component.MY.IlO.MY my, IOException iOException) {
                        com.bytedance.sdk.component.Bc.IlO.IlO ilO3 = ilO;
                        if (ilO3 != null) {
                            ilO3.IlO(tV.this, iOException);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.sdk.component.MY.IlO.vCE] */
                    /* JADX WARN: Type inference failed for: r13v6, types: [com.bytedance.sdk.component.Bc.IlO.IlO] */
                    /* JADX WARN: Type inference failed for: r1v0 */
                    /* JADX WARN: Type inference failed for: r1v1 */
                    /* JADX WARN: Type inference failed for: r1v8 */
                    /* JADX WARN: Type inference failed for: r2v0 */
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.sdk.component.Bc.MY] */
                    /* JADX WARN: Type inference failed for: r2v11 */
                    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
                    /* JADX WARN: Type inference failed for: r2v14 */
                    /* JADX WARN: Type inference failed for: r2v15 */
                    /* JADX WARN: Type inference failed for: r2v16 */
                    /* JADX WARN: Type inference failed for: r2v17 */
                    /* JADX WARN: Type inference failed for: r2v18 */
                    /* JADX WARN: Type inference failed for: r2v5 */
                    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.sdk.component.Bc.MY] */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.bytedance.sdk.component.MY.IlO.EO
                    public void IlO(com.bytedance.sdk.component.MY.IlO.MY my, bWL bwl) throws IOException {
                        Throwable th;
                        ?? r22;
                        ?? my2;
                        com.bytedance.sdk.component.Bc.IlO.IlO ilO3 = ilO;
                        if (ilO3 != null) {
                            if (bwl == null) {
                                ilO3.IlO(tV.this, new IOException("No response"));
                                return;
                            }
                            ?? r1 = 0;
                            IOException iOException = null;
                            try {
                                HashMap map = new HashMap();
                                ?? Bc = bwl.Bc();
                                if (Bc != 0) {
                                    my2 = 0;
                                    while (my2 < Bc.IlO()) {
                                        String strIlO = Bc.IlO(my2);
                                        String strMY = Bc.MY(my2);
                                        map.put(strIlO, strMY);
                                        if (strIlO != null && strIlO.equalsIgnoreCase("content-type")) {
                                            map.put("content-type", strMY == null ? "" : strMY.toLowerCase());
                                        }
                                        my2++;
                                    }
                                }
                                ea eaVarVCE = bwl.vCE();
                                try {
                                    if (com.bytedance.sdk.component.Bc.EO.IlO.IlO(map)) {
                                        byte[] bArrTV = eaVarVCE.tV();
                                        com.bytedance.sdk.component.Bc.MY my3 = new com.bytedance.sdk.component.Bc.MY(bwl.tV(), bwl.EO(), bwl.Cc(), map, null, bwl.MY(), bwl.IlO());
                                        my3.IlO(bArrTV);
                                        my2 = my3;
                                    } else if (tV.this.DmF) {
                                        byte[] bArrTV2 = eaVarVCE.tV();
                                        tV tVVar = tV.this;
                                        com.bytedance.sdk.component.Bc.MY my4 = new com.bytedance.sdk.component.Bc.MY(bwl.tV(), bwl.EO(), bwl.Cc(), map, new String(bArrTV2, tVVar.IlO(tVVar.IlO(eaVarVCE))), bwl.MY(), bwl.IlO());
                                        my4.IlO(bArrTV2);
                                        my2 = my4;
                                    } else if (eaVarVCE != null) {
                                        my2 = new com.bytedance.sdk.component.Bc.MY(bwl.tV(), bwl.EO(), bwl.Cc(), map, eaVarVCE.MY(), bwl.MY(), bwl.IlO());
                                    } else {
                                        throw new IOException(bwl.Cc());
                                    }
                                    tV.this.IlO((com.bytedance.sdk.component.Bc.MY) my2, bwl);
                                    r22 = my2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    r1 = my2;
                                    r22 = r1;
                                    iOException = new IOException(th);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            if (r22 != 0) {
                                ilO.IlO(tV.this, r22);
                                return;
                            }
                            com.bytedance.sdk.component.Bc.IlO.IlO ilO4 = ilO;
                            if (ilO4 instanceof com.bytedance.sdk.component.Bc.IlO.MY) {
                                com.bytedance.sdk.component.Bc.IlO.MY my5 = (com.bytedance.sdk.component.Bc.IlO.MY) ilO4;
                                tV tVVar2 = tV.this;
                                if (iOException == null) {
                                    iOException = new IOException("Unexpected exception");
                                }
                                my5.IlO(tVVar2, iOException, new com.bytedance.sdk.component.Bc.MY(bwl.tV(), bwl.EO(), bwl.Cc(), null, null, bwl.MY(), bwl.IlO()));
                                return;
                            }
                            tV tVVar3 = tV.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            ilO4.IlO(tVVar3, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ilO.IlO(this, new IOException(th.getMessage()));
        }
    }

    public com.bytedance.sdk.component.Bc.MY IlO() {
        com.bytedance.sdk.component.Bc.MY my;
        try {
            rp.IlO ilO = new rp.IlO();
            if (TextUtils.isEmpty(this.lEW)) {
                return new com.bytedance.sdk.component.Bc.MY(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            ilO.MY(this.lEW);
            if (this.IlO == null) {
                return new com.bytedance.sdk.component.Bc.MY(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            IlO(ilO);
            ilO.IlO((Object) EO());
            bWL bwlMY = this.EO.IlO(ilO.IlO(this.IlO).MY()).MY();
            if (bwlMY == null) {
                return null;
            }
            HashMap map = new HashMap();
            vCE vceBc = bwlMY.Bc();
            if (vceBc != null) {
                for (int i2 = 0; i2 < vceBc.IlO(); i2++) {
                    String strIlO = vceBc.IlO(i2);
                    String strMY = vceBc.MY(i2);
                    map.put(strIlO, strMY);
                    if (strIlO != null && strIlO.equalsIgnoreCase("content-type")) {
                        map.put("content-type", strMY == null ? "" : strMY.toLowerCase());
                    }
                }
            }
            ea eaVarVCE = bwlMY.vCE();
            if (com.bytedance.sdk.component.Bc.EO.IlO.IlO(map)) {
                byte[] bArrTV = eaVarVCE.tV();
                my = new com.bytedance.sdk.component.Bc.MY(bwlMY.tV(), bwlMY.EO(), bwlMY.Cc(), map, null, bwlMY.MY(), bwlMY.IlO());
                my.IlO(bArrTV);
            } else if (this.DmF) {
                byte[] bArrTV2 = eaVarVCE.tV();
                my = new com.bytedance.sdk.component.Bc.MY(bwlMY.tV(), bwlMY.EO(), bwlMY.Cc(), map, new String(bArrTV2, IlO(IlO(eaVarVCE))), bwlMY.MY(), bwlMY.IlO());
                my.IlO(bArrTV2);
            } else if (eaVarVCE != null) {
                my = new com.bytedance.sdk.component.Bc.MY(bwlMY.tV(), bwlMY.EO(), bwlMY.Cc(), map, eaVarVCE.MY(), bwlMY.MY(), bwlMY.IlO());
            } else {
                throw new IOException(bwlMY.Cc());
            }
            IlO(my, bwlMY);
            return my;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.Bc.MY(false, IronSourceConstants.errorCode_biddingDataException, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    public void IlO(String str, boolean z2) {
        if (z2) {
            IlO("application/json; charset=utf-8", Cc(str));
            MY("Content-Encoding", "gzip");
        } else {
            tV(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset IlO(DmF dmF) {
        try {
            return dmF != null ? dmF.IlO(com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO) : com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.MY.IlO.MY.DmF.IlO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DmF IlO(ea eaVar) {
        try {
            return eaVar.Cc();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.component.Bc.MY my, bWL bwl) {
        if (my == null || bwl == null) {
            return;
        }
        my.IlO(bwl.lEW());
    }
}
