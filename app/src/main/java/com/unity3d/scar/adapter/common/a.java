package com.unity3d.scar.adapter.common;

import g7.m;
import g7.r;
import g7.u;
import h7.b0;
import h7.o;
import h7.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10959c;

    public a(int i2) {
        this.f10957a = i2;
        switch (i2) {
            case 1:
                break;
            case 2:
            default:
                this.f10958b = 0;
                break;
            case 3:
                this.f10959c = new int[10];
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(com.unity3d.scar.adapter.common.a r10, q5.b r11, x5.a r12) throws java.lang.Throwable {
        /*
            java.lang.Object r0 = r10.f10959c
            h7.b0 r0 = (h7.b0) r0
            boolean r1 = r12 instanceof h7.x
            if (r1 == 0) goto L17
            r1 = r12
            h7.x r1 = (h7.x) r1
            int r2 = r1.l
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.l = r2
            goto L1c
        L17:
            h7.x r1 = new h7.x
            r1.<init>(r10, r12)
        L1c:
            java.lang.Object r12 = r1.j
            w5.a r2 = w5.a.f17774a
            int r3 = r1.l
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 7
            r8 = 4
            r9 = 1
            if (r3 == 0) goto L60
            if (r3 != r9) goto L58
            java.lang.String r10 = r1.f11780i
            java.util.LinkedHashMap r11 = r1.h
            com.unity3d.scar.adapter.common.a r0 = r1.g
            q5.b r3 = r1.f11779f
            r2.q.z0(r12)
            g7.m r12 = (g7.m) r12
            r11.put(r10, r12)
            java.lang.Object r10 = r0.f10959c
            h7.b0 r10 = (h7.b0) r10
            byte r10 = r10.e()
            if (r10 == r8) goto L53
            if (r10 != r7) goto L49
            goto L97
        L49:
            java.lang.Object r10 = r0.f10959c
            h7.b0 r10 = (h7.b0) r10
            java.lang.String r11 = "Expected end of the object or comma"
            h7.b0.m(r10, r11, r4, r5, r6)
            throw r5
        L53:
            r12 = r10
            r10 = r0
            r0 = r11
            r11 = r3
            goto L72
        L58:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L60:
            r2.q.z0(r12)
            byte r12 = r0.f(r6)
            byte r3 = r0.q()
            if (r3 == r8) goto Laf
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
        L72:
            java.lang.Object r3 = r10.f10959c
            h7.b0 r3 = (h7.b0) r3
            boolean r4 = r3.b()
            if (r4 == 0) goto L94
            java.lang.String r12 = r3.i()
            r4 = 5
            r3.f(r4)
            r1.f11779f = r11
            r1.g = r10
            r1.h = r0
            r1.f11780i = r12
            r1.l = r9
            r11.getClass()
            r11.f13490b = r1
            return r2
        L94:
            r11 = r0
            r0 = r10
            r10 = r12
        L97:
            java.lang.Object r12 = r0.f10959c
            h7.b0 r12 = (h7.b0) r12
            if (r10 != r6) goto La1
            r12.f(r7)
            goto La3
        La1:
            if (r10 == r8) goto La9
        La3:
            g7.x r10 = new g7.x
            r10.<init>(r11)
            return r10
        La9:
            java.lang.String r10 = "object"
            h7.o.k(r12, r10)
            throw r5
        Laf:
            java.lang.String r10 = "Unexpected leading comma"
            h7.b0.m(r0, r10, r4, r5, r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.scar.adapter.common.a.a(com.unity3d.scar.adapter.common.a, q5.b, x5.a):java.lang.Object");
    }

    public void b(int i2, int i8) {
        int i9 = i8 + i2;
        char[] cArr = (char[]) this.f10959c;
        if (cArr.length <= i9) {
            int i10 = i2 * 2;
            if (i9 < i10) {
                i9 = i10;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i9);
            k.d(cArrCopyOf, "copyOf(...)");
            this.f10959c = cArrCopyOf;
        }
    }

    public synchronized void c() {
        this.f10958b++;
    }

    public boolean d(int i2) {
        return ((1 << i2) & this.f10958b) != 0;
    }

    public m e() throws Throwable {
        m xVar;
        Object obj;
        b0 b0Var = (b0) this.f10959c;
        byte bQ = b0Var.q();
        if (bQ == 1) {
            return g(true);
        }
        if (bQ == 0) {
            return g(false);
        }
        if (bQ != 6) {
            if (bQ == 8) {
                return f();
            }
            b0.m(b0Var, "Cannot read Json element because of unexpected ".concat(o.r(bQ)), 0, null, 6);
            throw null;
        }
        int i2 = this.f10958b + 1;
        this.f10958b = i2;
        if (i2 == 200) {
            w wVar = new w(this, null);
            w5.a aVar = q5.a.f13488a;
            q5.b bVar = new q5.b();
            bVar.f13489a = wVar;
            bVar.f13490b = bVar;
            w5.a aVar2 = q5.a.f13488a;
            bVar.f13491c = aVar2;
            while (true) {
                obj = bVar.f13491c;
                v5.c cVar = bVar.f13490b;
                if (cVar == null) {
                    break;
                }
                if (k.a(aVar2, obj)) {
                    try {
                        w wVar2 = bVar.f13489a;
                        d0.d(3, wVar2);
                        w wVar3 = new w(wVar2.h, cVar);
                        wVar3.g = bVar;
                        Object objInvokeSuspend = wVar3.invokeSuspend(x.f13520a);
                        if (objInvokeSuspend != w5.a.f17774a) {
                            cVar.resumeWith(objInvokeSuspend);
                        }
                    } catch (Throwable th) {
                        cVar.resumeWith(q.M(th));
                    }
                } else {
                    bVar.f13491c = aVar2;
                    cVar.resumeWith(obj);
                }
            }
            q.z0(obj);
            xVar = (m) obj;
        } else {
            byte bF = b0Var.f((byte) 6);
            if (b0Var.q() == 4) {
                b0.m(b0Var, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!b0Var.b()) {
                    break;
                }
                String strI = b0Var.i();
                b0Var.f((byte) 5);
                linkedHashMap.put(strI, e());
                bF = b0Var.e();
                if (bF != 4) {
                    if (bF != 7) {
                        b0.m(b0Var, "Expected end of the object or comma", 0, null, 6);
                        throw null;
                    }
                }
            }
            if (bF == 6) {
                b0Var.f((byte) 7);
            } else if (bF == 4) {
                o.k(b0Var, "object");
                throw null;
            }
            xVar = new g7.x(linkedHashMap);
        }
        this.f10958b--;
        return xVar;
    }

    public g7.e f() {
        b0 b0Var = (b0) this.f10959c;
        byte bE = b0Var.e();
        if (b0Var.q() == 4) {
            b0.m(b0Var, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (b0Var.b()) {
            arrayList.add(e());
            bE = b0Var.e();
            if (bE != 4) {
                boolean z2 = bE == 9;
                int i2 = b0Var.f11741a;
                if (!z2) {
                    b0.m(b0Var, "Expected end of the array or comma", i2, null, 4);
                    throw null;
                }
            }
        }
        if (bE == 8) {
            b0Var.f((byte) 9);
        } else if (bE == 4) {
            o.k(b0Var, "array");
            throw null;
        }
        return new g7.e(arrayList);
    }

    public g7.b0 g(boolean z2) {
        b0 b0Var = (b0) this.f10959c;
        String strJ = !z2 ? b0Var.j() : b0Var.i();
        return (z2 || !k.a(strJ, "null")) ? new r(strJ, z2, null) : u.INSTANCE;
    }

    public void h() {
        h7.d dVar = h7.d.f11748c;
        char[] array = (char[]) this.f10959c;
        dVar.getClass();
        k.e(array, "array");
        synchronized (dVar) {
            int i2 = dVar.f11755b;
            if (array.length + i2 < h7.c.f11745a) {
                dVar.f11755b = i2 + array.length;
                dVar.f11754a.addLast(array);
            }
        }
    }

    public void i(int i2, int i8) {
        int[] iArr = (int[]) this.f10959c;
        if (i2 >= iArr.length) {
            return;
        }
        this.f10958b = (1 << i2) | this.f10958b;
        iArr[i2] = i8;
    }

    public void j(String text) {
        k.e(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        b(this.f10958b, length);
        text.getChars(0, text.length(), (char[]) this.f10959c, this.f10958b);
        this.f10958b += length;
    }

    public String toString() {
        switch (this.f10957a) {
            case 1:
                return new String((char[]) this.f10959c, 0, this.f10958b);
            default:
                return super.toString();
        }
    }

    public a(g7.j jVar, b0 b0Var) {
        this.f10957a = 2;
        this.f10959c = b0Var;
    }
}
