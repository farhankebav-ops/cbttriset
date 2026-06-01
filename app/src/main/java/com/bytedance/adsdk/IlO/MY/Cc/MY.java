package com.bytedance.adsdk.IlO.MY.Cc;

import com.bytedance.adsdk.IlO.MY.MY.IlO.Cc;
import com.bytedance.adsdk.IlO.MY.MY.IlO.DmF;
import com.bytedance.adsdk.IlO.MY.MY.IlO.EV;
import com.bytedance.adsdk.IlO.MY.MY.IlO.bWL;
import com.bytedance.adsdk.IlO.MY.MY.IlO.cl;
import com.bytedance.adsdk.IlO.MY.MY.IlO.es;
import com.bytedance.adsdk.IlO.MY.MY.IlO.hp;
import com.bytedance.adsdk.IlO.MY.MY.IlO.lEW;
import com.bytedance.adsdk.IlO.MY.MY.IlO.rp;
import com.bytedance.adsdk.IlO.MY.MY.IlO.vCE;
import com.bytedance.adsdk.IlO.MY.MY.IlO.xF;
import com.bytedance.adsdk.IlO.MY.tV.EO;
import com.bytedance.adsdk.IlO.MY.tV.tV;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {

    /* JADX INFO: renamed from: com.bytedance.adsdk.IlO.MY.Cc.MY$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[EO.values().length];
            IlO = iArr;
            try {
                iArr[EO.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[EO.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[EO.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                IlO[EO.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                IlO[EO.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                IlO[EO.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                IlO[EO.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                IlO[EO.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                IlO[EO.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                IlO[EO.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                IlO[EO.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                IlO[EO.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                IlO[EO.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static void EO(List<com.bytedance.adsdk.IlO.MY.MY.IlO> list, String str, int i2) {
        Iterator<com.bytedance.adsdk.IlO.MY.MY.IlO> it = list.iterator();
        while (it.hasNext()) {
            if (tV.IlO(it.next().IlO())) {
                throw new IllegalArgumentException(str.substring(0, i2));
            }
        }
    }

    public static com.bytedance.adsdk.IlO.MY.MY.IlO IlO(List<com.bytedance.adsdk.IlO.MY.MY.IlO> list, String str, int i2) {
        EO(list, str, i2);
        Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> dequeIlO = IlO(MY(list, str, i2));
        if (dequeIlO.size() == 1) {
            return dequeIlO.getFirst();
        }
        throw new IllegalStateException();
    }

    private static Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> MY(List<com.bytedance.adsdk.IlO.MY.MY.IlO> list, String str, int i2) {
        LinkedList<com.bytedance.adsdk.IlO.MY.MY.IlO> linkedList = new LinkedList(list);
        int i8 = 5;
        while (i8 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.IlO.MY.MY.IlO ilO : linkedList) {
                if (!linkedList2.isEmpty() && EO.IlO(((com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList2.peekLast()).IlO()) && ((EO) ((com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList2.peekLast()).IlO()).MY() == i8) {
                    com.bytedance.adsdk.IlO.MY.MY.IlO ilO2 = (com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList2.pollLast();
                    com.bytedance.adsdk.IlO.MY.MY.IlO ilO3 = (com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList2.pollLast();
                    if (EO.IlO(ilO3.IlO()) || EO.IlO(ilO.IlO())) {
                        throw new IllegalArgumentException(str.substring(0, i2));
                    }
                    linkedList2.addLast(IlO(ilO3, ilO2, ilO));
                } else {
                    linkedList2.addLast(ilO);
                }
            }
            i8--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> IlO(Deque<com.bytedance.adsdk.IlO.MY.MY.IlO> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.IlO.MY.MY.IlO ilO : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList.peekLast()).IlO() == EO.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.IlO.MY.MY.IlO ilO2 = (com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList.pollLast();
                if (((com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList.pollLast()).IlO() == EO.QUESTION) {
                    com.bytedance.adsdk.IlO.MY.MY.IlO ilO3 = (com.bytedance.adsdk.IlO.MY.MY.IlO) linkedList.pollLast();
                    xF xFVar = new xF();
                    xFVar.IlO(ilO3);
                    xFVar.MY(ilO2);
                    xFVar.EO(ilO);
                    linkedList.addLast(xFVar);
                } else {
                    throw new IllegalStateException();
                }
            } else {
                linkedList.addLast(ilO);
            }
        }
        return linkedList;
    }

    private static com.bytedance.adsdk.IlO.MY.MY.IlO IlO(com.bytedance.adsdk.IlO.MY.MY.IlO ilO, com.bytedance.adsdk.IlO.MY.MY.IlO ilO2, com.bytedance.adsdk.IlO.MY.MY.IlO ilO3) {
        cl ev;
        switch (AnonymousClass1.IlO[((EO) ilO2.IlO()).ordinal()]) {
            case 1:
                ev = new EV();
                break;
            case 2:
                ev = new es();
                break;
            case 3:
                ev = new com.bytedance.adsdk.IlO.MY.MY.IlO.IlO();
                break;
            case 4:
                ev = new hp();
                break;
            case 5:
                ev = new rp();
                break;
            case 6:
                ev = new com.bytedance.adsdk.IlO.MY.MY.IlO.tV();
                break;
            case 7:
                ev = new bWL();
                break;
            case 8:
                ev = new vCE();
                break;
            case 9:
                ev = new DmF();
                break;
            case 10:
                ev = new Cc();
                break;
            case 11:
                ev = new lEW();
                break;
            case 12:
                ev = new com.bytedance.adsdk.IlO.MY.MY.IlO.MY();
                break;
            case 13:
                ev = new com.bytedance.adsdk.IlO.MY.MY.IlO.EO();
                break;
            default:
                throw new UnsupportedOperationException(ilO2.IlO().toString());
        }
        ev.IlO(ilO);
        ev.MY(ilO3);
        return ev;
    }

    public static boolean IlO(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
