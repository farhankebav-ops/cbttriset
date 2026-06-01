package com.bytedance.sdk.component.Cc.EO.IlO.IlO;

import a1.a;
import android.util.Log;
import com.bytedance.sdk.component.utils.NV;
import com.ironsource.C2300e4;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IlO implements Closeable {
    private final File Bc;
    private final File Cc;
    private long DmF;
    final ExecutorService MY;
    private final int NV;
    private int bWL;
    private final int lEW;
    private Writer rp;
    private final File tV;
    private final File vCE;
    static final Pattern IlO = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream EO = new OutputStream() { // from class: com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO.2
        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
        }
    };
    private long EV = 0;
    private final LinkedHashMap<String, MY> hp = new LinkedHashMap<>(0, 0.75f, true);
    private long ea = -1;
    private long zPa = 0;
    private final Callable<Void> cl = new Callable<Void>() { // from class: com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (IlO.this) {
                try {
                    if (IlO.this.rp == null) {
                        return null;
                    }
                    IlO.this.lEW();
                    if (IlO.this.vCE()) {
                        IlO.this.Cc();
                        IlO.this.bWL = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class EO implements Closeable {
        private final long[] Cc;
        private final long EO;
        private final String MY;
        private final InputStream[] tV;

        public InputStream IlO(int i2) {
            return this.tV[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.tV) {
                NV.IlO(inputStream);
            }
        }

        private EO(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.MY = str;
            this.EO = j;
            this.tV = inputStreamArr;
            this.Cc = jArr;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class C0042IlO {
        private boolean Cc;
        private final boolean[] EO;
        private final MY MY;
        private boolean tV;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO$IlO$IlO, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class C0043IlO extends FilterOutputStream {
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0042IlO.this.tV = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0042IlO.this.tV = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C0042IlO.this.tV = true;
                }
            }

            private C0043IlO(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i8) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i8);
                } catch (IOException unused) {
                    C0042IlO.this.tV = true;
                }
            }
        }

        private C0042IlO(MY my) {
            this.MY = my;
            this.EO = my.tV ? null : new boolean[IlO.this.NV];
        }

        public void MY() throws IOException {
            IlO.this.IlO(this, false);
        }

        public OutputStream IlO(int i2) throws IOException {
            FileOutputStream fileOutputStream;
            C0043IlO c0043IlO;
            if (i2 >= 0 && i2 < IlO.this.NV) {
                synchronized (IlO.this) {
                    try {
                        if (this.MY.Cc == this) {
                            if (!this.MY.tV) {
                                this.EO[i2] = true;
                            }
                            File fileMY = this.MY.MY(i2);
                            try {
                                fileOutputStream = new FileOutputStream(fileMY);
                            } catch (FileNotFoundException unused) {
                                IlO.this.tV.mkdirs();
                                try {
                                    fileOutputStream = new FileOutputStream(fileMY);
                                } catch (FileNotFoundException unused2) {
                                    return IlO.EO;
                                }
                            }
                            c0043IlO = new C0043IlO(fileOutputStream);
                        } else {
                            throw new IllegalStateException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c0043IlO;
            }
            StringBuilder sbV = a.v(i2, "Expected index ", " to be greater than 0 and less than the maximum value count of ");
            sbV.append(IlO.this.NV);
            throw new IllegalArgumentException(sbV.toString());
        }

        public void IlO() throws IOException {
            if (this.tV) {
                IlO.this.IlO(this, false);
                IlO.this.EO(this.MY.MY);
            } else {
                IlO.this.IlO(this, true);
            }
            this.Cc = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class MY {
        private C0042IlO Cc;
        private final long[] EO;
        private final String MY;
        private boolean tV;
        private long vCE;

        private MY(String str) {
            this.MY = str;
            this.EO = new long[IlO.this.NV];
        }

        private IOException MY(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File MY(int i2) {
            return new File(IlO.this.tV, this.MY + "." + i2 + ".tmp");
        }

        public String IlO() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.EO) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void IlO(String[] strArr) throws IOException {
            if (strArr.length == IlO.this.NV) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.EO[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw MY(strArr);
                    }
                }
                return;
            }
            throw MY(strArr);
        }

        public File IlO(int i2) {
            return new File(IlO.this.tV, this.MY + "." + i2);
        }
    }

    private IlO(File file, int i2, int i8, long j, ExecutorService executorService) {
        this.tV = file;
        this.lEW = i2;
        this.Cc = new File(file, "journal");
        this.vCE = new File(file, "journal.tmp");
        this.Bc = new File(file, "journal.bkp");
        this.NV = i8;
        this.DmF = j;
        this.MY = executorService;
    }

    private void Bc() {
        if (this.rp == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lEW() throws IOException {
        long j = this.DmF;
        long j3 = this.ea;
        if (j3 >= 0) {
            j = j3;
        }
        while (this.EV > j) {
            EO(this.hp.entrySet().iterator().next().getKey());
        }
        this.ea = -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.rp == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.hp.values());
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                MY my = (MY) obj;
                if (my.Cc != null) {
                    my.Cc.MY();
                }
            }
            lEW();
            this.rp.close();
            this.rp = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Cc() throws IOException {
        try {
            Writer writer = this.rp;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.vCE), tV.IlO));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.lEW));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.NV));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (MY my : this.hp.values()) {
                    if (my.Cc != null) {
                        bufferedWriter.write("DIRTY " + my.MY + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + my.MY + my.IlO() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.Cc.exists()) {
                    IlO(this.Cc, this.Bc, true);
                }
                IlO(this.vCE, this.Cc, false);
                this.Bc.delete();
                this.rp = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Cc, true), tV.IlO));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void EO() throws IOException {
        com.bytedance.sdk.component.Cc.EO.IlO.IlO.EO eo = new com.bytedance.sdk.component.Cc.EO.IlO.IlO.EO(new FileInputStream(this.Cc), tV.IlO);
        try {
            String strIlO = eo.IlO();
            String strIlO2 = eo.IlO();
            String strIlO3 = eo.IlO();
            String strIlO4 = eo.IlO();
            String strIlO5 = eo.IlO();
            if (!"libcore.io.DiskLruCache".equals(strIlO) || !"1".equals(strIlO2) || !Integer.toString(this.lEW).equals(strIlO3) || !Integer.toString(this.NV).equals(strIlO4) || !"".equals(strIlO5)) {
                throw new IOException("unexpected journal header: [" + strIlO + ", " + strIlO2 + ", " + strIlO4 + ", " + strIlO5 + C2300e4.i.e);
            }
            int i2 = 0;
            while (true) {
                try {
                    tV(eo.IlO());
                    i2++;
                } catch (EOFException unused) {
                    this.bWL = i2 - this.hp.size();
                    if (eo.MY()) {
                        Cc();
                    } else {
                        this.rp = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Cc, true), tV.IlO));
                    }
                    NV.IlO(eo);
                    return;
                }
            }
        } catch (Throwable th) {
            NV.IlO(eo);
            throw th;
        }
    }

    private void tV(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.hp.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        MY my = this.hp.get(strSubstring);
        if (my == null) {
            my = new MY(strSubstring);
            this.hp.put(strSubstring, my);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            my.tV = true;
            my.Cc = null;
            my.IlO(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            my.Cc = new C0042IlO(my);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vCE() {
        int i2 = this.bWL;
        return i2 >= 2000 && i2 >= this.hp.size();
    }

    public C0042IlO MY(String str) throws IOException {
        return IlO(str, -1L);
    }

    public void MY() throws IOException {
        close();
        tV.IlO(this.tV);
    }

    public static IlO IlO(File file, int i2, int i8, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i8 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    IlO(file2, file3, false);
                }
            }
            IlO ilO = new IlO(file, i2, i8, j, executorService);
            if (ilO.Cc.exists()) {
                try {
                    ilO.EO();
                    ilO.tV();
                    return ilO;
                } catch (IOException e) {
                    Log.w("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                    ilO.MY();
                }
            }
            file.mkdirs();
            IlO ilO2 = new IlO(file, i2, i8, j, executorService);
            ilO2.Cc();
            return ilO2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public synchronized boolean EO(String str) throws IOException {
        try {
            Bc();
            Cc(str);
            MY my = this.hp.get(str);
            if (my != null && my.Cc == null) {
                for (int i2 = 0; i2 < this.NV; i2++) {
                    File fileIlO = my.IlO(i2);
                    if (fileIlO.exists() && !fileIlO.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(fileIlO)));
                    }
                    this.EV -= my.EO[i2];
                    my.EO[i2] = 0;
                }
                this.bWL++;
                this.rp.append((CharSequence) ("REMOVE " + str + '\n'));
                this.hp.remove(str);
                if (vCE()) {
                    this.MY.submit(this.cl);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    private void tV() throws IOException {
        IlO(this.vCE);
        Iterator<MY> it = this.hp.values().iterator();
        while (it.hasNext()) {
            MY next = it.next();
            int i2 = 0;
            if (next.Cc != null) {
                next.Cc = null;
                while (i2 < this.NV) {
                    IlO(next.IlO(i2));
                    IlO(next.MY(i2));
                    i2++;
                }
                it.remove();
            } else {
                while (i2 < this.NV) {
                    this.EV += next.EO[i2];
                    i2++;
                }
            }
        }
    }

    private static void IlO(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void IlO(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            IlO(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void Cc(String str) {
        if (!IlO.matcher(str).matches()) {
            throw new IllegalArgumentException(a.m("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
        }
    }

    public synchronized EO IlO(String str) throws Throwable {
        Throwable th;
        InputStream inputStream;
        try {
            Bc();
            Cc(str);
            MY my = this.hp.get(str);
            if (my == null) {
                return null;
            }
            if (!my.tV) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.NV];
            for (int i2 = 0; i2 < this.NV; i2++) {
                try {
                    try {
                        try {
                            inputStreamArr[i2] = new FileInputStream(my.IlO(i2));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i8 = 0; i8 < this.NV && (inputStream = inputStreamArr[i8]) != null; i8++) {
                            NV.IlO(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                }
            }
            this.bWL++;
            this.rp.append((CharSequence) ("READ " + str + '\n'));
            if (vCE()) {
                this.MY.submit(this.cl);
            }
            return new EO(str, my.vCE, inputStreamArr, my.EO);
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    private synchronized C0042IlO IlO(String str, long j) throws IOException {
        Bc();
        Cc(str);
        MY my = this.hp.get(str);
        if (j != -1 && (my == null || my.vCE != j)) {
            return null;
        }
        if (my != null) {
            if (my.Cc != null) {
                return null;
            }
        } else {
            my = new MY(str);
            this.hp.put(str, my);
        }
        C0042IlO c0042IlO = new C0042IlO(my);
        my.Cc = c0042IlO;
        this.rp.write("DIRTY " + str + '\n');
        this.rp.flush();
        return c0042IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IlO(C0042IlO c0042IlO, boolean z2) throws IOException {
        MY my = c0042IlO.MY;
        if (my.Cc == c0042IlO) {
            if (z2 && !my.tV) {
                for (int i2 = 0; i2 < this.NV; i2++) {
                    if (c0042IlO.EO[i2]) {
                        if (!my.MY(i2).exists()) {
                            c0042IlO.MY();
                            return;
                        }
                    } else {
                        c0042IlO.MY();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                    }
                }
            }
            for (int i8 = 0; i8 < this.NV; i8++) {
                File fileMY = my.MY(i8);
                if (z2) {
                    if (fileMY.exists()) {
                        File fileIlO = my.IlO(i8);
                        fileMY.renameTo(fileIlO);
                        long j = my.EO[i8];
                        long length = fileIlO.length();
                        my.EO[i8] = length;
                        this.EV = (this.EV - j) + length;
                    }
                } else {
                    IlO(fileMY);
                }
            }
            this.bWL++;
            my.Cc = null;
            if (!(my.tV | z2)) {
                this.hp.remove(my.MY);
                this.rp.write("REMOVE " + my.MY + '\n');
            } else {
                my.tV = true;
                this.rp.write("CLEAN " + my.MY + my.IlO() + '\n');
                if (z2) {
                    long j3 = this.zPa;
                    this.zPa = 1 + j3;
                    my.vCE = j3;
                }
            }
            this.rp.flush();
            if (this.EV > this.DmF || vCE()) {
                this.MY.submit(this.cl);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized void IlO() throws IOException {
        Bc();
        lEW();
        this.rp.flush();
    }
}
