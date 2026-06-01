package com.bytedance.sdk.openadsdk.tV.EO;

import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2461n2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.tV.EO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0116IlO {
        public static final String Cc;
        public static final String EO;
        public static final String IlO;
        public static final String MY;
        public static final String tV;
        public static final String vCE;

        static {
            CharSequence[] charSequenceArr = {zLG.kBB(), "load_start"};
            StringBuilder sb = new StringBuilder();
            sb.append(charSequenceArr[0]);
            sb.append((CharSequence) "_");
            sb.append(charSequenceArr[1]);
            IlO = sb.toString();
            CharSequence[] charSequenceArr2 = {zLG.kBB(), "load_finish"};
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequenceArr2[0]);
            sb2.append((CharSequence) "_");
            sb2.append(charSequenceArr2[1]);
            MY = sb2.toString();
            CharSequence[] charSequenceArr3 = {zLG.kBB(), "load_url"};
            StringBuilder sb3 = new StringBuilder();
            sb3.append(charSequenceArr3[0]);
            sb3.append((CharSequence) "_");
            sb3.append(charSequenceArr3[1]);
            EO = sb3.toString();
            CharSequence[] charSequenceArr4 = {zLG.kBB(), zLG.vAh()};
            StringBuilder sb4 = new StringBuilder();
            sb4.append(charSequenceArr4[0]);
            sb4.append((CharSequence) "_");
            sb4.append(charSequenceArr4[1]);
            tV = sb4.toString();
            CharSequence[] charSequenceArr5 = {zLG.kBB(), zLG.vAh(), C2461n2.f9471v};
            StringBuilder sb5 = new StringBuilder();
            sb5.append(charSequenceArr5[0]);
            for (int i2 = 1; i2 < 3; i2++) {
                sb5.append((CharSequence) "_");
                sb5.append(charSequenceArr5[i2]);
            }
            Cc = sb5.toString();
            CharSequence[] charSequenceArr6 = {zLG.kBB(), zLG.vAh(), "progress"};
            StringBuilder sb6 = new StringBuilder();
            sb6.append(charSequenceArr6[0]);
            for (int i8 = 1; i8 < 3; i8++) {
                sb6.append((CharSequence) "_");
                sb6.append(charSequenceArr6[i8]);
            }
            vCE = sb6.toString();
        }
    }
}
