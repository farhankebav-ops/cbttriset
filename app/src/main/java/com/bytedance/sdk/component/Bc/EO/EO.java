package com.bytedance.sdk.component.Bc.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private IlO IlO;
    private MY MY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Bc.EO.EO$EO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0040EO {
        private static final EO IlO = new EO();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
    }

    public static void IlO(IlO ilO) {
        synchronized (EO.class) {
            C0040EO.IlO.IlO = ilO;
        }
    }

    private EO() {
        this.IlO = IlO.OFF;
        this.MY = new com.bytedance.sdk.component.Bc.EO.MY();
    }
}
