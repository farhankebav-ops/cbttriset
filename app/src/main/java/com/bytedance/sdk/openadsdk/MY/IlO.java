package com.bytedance.sdk.openadsdk.MY;

import com.bytedance.sdk.component.utils.Bc;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO {
    protected boolean IlO = false;
    private final ExecutorService MY = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class CallableC0071IlO implements Callable<Void> {
        private final File MY;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            IlO.this.MY(this.MY);
            return null;
        }

        private CallableC0071IlO(File file) {
            this.MY = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(File file) throws IOException {
        if (!this.IlO) {
            try {
                Bc.MY(file);
            } catch (Throwable unused) {
            }
            IlO(Bc.IlO(file.getParentFile()));
        } else {
            List<File> listIlO = Bc.IlO(file);
            listIlO.toString();
            IlO(listIlO);
        }
    }

    public abstract void IlO(List<File> list);

    public abstract boolean IlO(long j, int i2);

    public abstract boolean IlO(File file, long j, int i2);

    public void IlO(File file) throws IOException {
        this.MY.submit(new CallableC0071IlO(file));
    }

    public long MY(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }
}
