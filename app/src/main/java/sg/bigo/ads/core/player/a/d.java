package sg.bigo.ads.core.player.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.work.PeriodicWorkRequest;
import com.bumptech.glide.load.Key;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServerSocket f17282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17283c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Thread f17285f;
    private h g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f17284d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.common.n.e f17281a = new sg.bigo.ads.common.n.e("Play", 3, 0);
    private final Map<String, e> e = new ConcurrentHashMap();

    public final class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Socket f17287b;

        public a(Socket socket) {
            this.f17287b = socket;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            d dVar;
            boolean z2;
            int i2;
            boolean z7;
            long j;
            String str;
            String strA;
            String strA2;
            d dVar2 = d.this;
            Socket socket = this.f17287b;
            try {
                try {
                    try {
                        sg.bigo.ads.core.player.a.b bVarA = sg.bigo.ads.core.player.a.b.a(socket.getInputStream());
                        if (bVarA == null) {
                            d.a(socket);
                            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                            return;
                        }
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Request to cache proxy:request=".concat(String.valueOf(bVarA)));
                        String strF = q.f(bVarA.f17277a);
                        if (!"ping".equals(strF)) {
                            if (!TextUtils.isEmpty(strF)) {
                                final e eVarA = dVar2.a(strF);
                                try {
                                    if (eVarA.a()) {
                                        try {
                                            if (SystemClock.elapsedRealtime() - eVarA.e > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                                                int andSet = eVarA.f17294f.getAndSet(0);
                                                eVarA.e = SystemClock.elapsedRealtime();
                                                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "reset resetRetryCount=".concat(String.valueOf(andSet)));
                                            }
                                            eVarA.f17290a.incrementAndGet();
                                            if (eVarA.f17292c != null && eVarA.f17292c.j != 1 && !eVarA.f17292c.b() && SystemClock.elapsedRealtime() - eVarA.f17293d > 15000 && eVarA.f17294f.getAndIncrement() < 3) {
                                                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "keepDownloadTaskAlive retryCount=" + eVarA.f17294f.get());
                                                eVarA.f17293d = SystemClock.elapsedRealtime();
                                                sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.a.e.1
                                                    public AnonymousClass1() {
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        sg.bigo.ads.core.player.b.a().g.a(e.this.f17292c, true);
                                                    }
                                                });
                                            }
                                            c cVar = eVarA.f17291b;
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
                                            String strF2 = q.f(bVarA.f17277a);
                                            MimeTypeMap singleton = MimeTypeMap.getSingleton();
                                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(strF2);
                                            String mimeTypeFromExtension = TextUtils.isEmpty(fileExtensionFromUrl) ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
                                            boolean zIsEmpty = TextUtils.isEmpty(mimeTypeFromExtension);
                                            long jA = cVar.f17280a.c() ? cVar.f17280a.a() : cVar.f17280a.f17274b.f15732i;
                                            if (jA >= 0) {
                                                i2 = 0;
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                                i2 = 0;
                                            }
                                            boolean z8 = bVarA.f17279c;
                                            if (z8) {
                                                z7 = z8;
                                                j = jA - bVarA.f17278b;
                                            } else {
                                                z7 = z8;
                                                j = jA;
                                            }
                                            int i8 = (z2 && z7) ? 1 : i2;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(bVarA.f17279c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
                                            sb.append("Accept-Ranges: bytes\n");
                                            String strA3 = "";
                                            if (z2) {
                                                str = "";
                                                dVar = dVar2;
                                                try {
                                                    Object[] objArr = new Object[1];
                                                    objArr[i2] = Long.valueOf(j);
                                                    strA3 = c.a("Content-Length: %d\n", objArr);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    eVarA.b();
                                                    throw th;
                                                }
                                            } else {
                                                str = "";
                                                dVar = dVar2;
                                            }
                                            sb.append(strA3);
                                            if (i8 != 0) {
                                                Long lValueOf = Long.valueOf(bVarA.f17278b);
                                                Long lValueOf2 = Long.valueOf(jA - 1);
                                                Long lValueOf3 = Long.valueOf(jA);
                                                Object[] objArr2 = new Object[3];
                                                objArr2[i2] = lValueOf;
                                                objArr2[1] = lValueOf2;
                                                objArr2[2] = lValueOf3;
                                                strA = c.a("Content-Range: bytes %d-%d/%d\n", objArr2);
                                            } else {
                                                strA = str;
                                            }
                                            sb.append(strA);
                                            if (zIsEmpty) {
                                                strA2 = str;
                                            } else {
                                                Object[] objArr3 = new Object[1];
                                                objArr3[i2] = mimeTypeFromExtension;
                                                strA2 = c.a("Content-Type: %s\n", objArr3);
                                            }
                                            sb.append(strA2);
                                            sb.append("\n");
                                            String string = sb.toString();
                                            sg.bigo.ads.common.t.a.a(i2, 3, "ProxyCache", "newResponseHeaders =".concat(String.valueOf(string)));
                                            bufferedOutputStream.write(string.getBytes(Key.STRING_CHARSET_NAME));
                                            cVar.a(bufferedOutputStream, bVarA.f17278b);
                                            eVarA.b();
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } else {
                                        sg.bigo.ads.common.t.a.a(0, "ProxyCache", "startProcessRequest failed");
                                        eVarA.b();
                                    }
                                } catch (SocketException unused) {
                                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Closing socket… Socket is closed by client.");
                                    d.a(socket);
                                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                                    return;
                                } catch (IOException e) {
                                    e = e;
                                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                                    d.a(socket);
                                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                                } catch (j e4) {
                                    e = e4;
                                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                                    d.a(socket);
                                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                                }
                            }
                            d.a(socket);
                            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                        }
                        try {
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
                            outputStream.write("ping ok".getBytes());
                        } catch (IOException e8) {
                            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Pinger#responseToPing, error message is : " + e8.toString());
                        }
                        dVar = dVar2;
                        d.a(socket);
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar.b());
                    } catch (j e9) {
                        e = e9;
                        sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                        d.a(socket);
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                    } catch (Throwable th3) {
                        th = th3;
                        d.a(socket);
                        sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                        throw th;
                    }
                } catch (SocketException unused2) {
                } catch (IOException e10) {
                    e = e10;
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error processing request, error message is : " + e.toString());
                    d.a(socket);
                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                }
            } catch (Throwable th4) {
                th = th4;
                d.a(socket);
                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Opened connections: " + dVar2.b());
                throw th;
            }
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CountDownLatch f17289b;

        public b(CountDownLatch countDownLatch) {
            this.f17289b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f17289b.countDown();
            d dVar = d.this;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket socketAccept = dVar.f17282b.accept();
                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Accept new socket socket=".concat(String.valueOf(socketAccept)));
                    dVar.f17281a.submit(dVar.new a(socketAccept));
                } catch (Throwable th) {
                    sg.bigo.ads.core.d.b.a(3005, 10111, th.toString());
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error during waiting connection, error message is : " + th.toString());
                    return;
                }
            }
        }
    }

    public d() {
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f17282b = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f17283c = localPort;
            f.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new b(countDownLatch));
            this.f17285f = thread;
            thread.setName("BGAd-Conn");
            this.f17285f.start();
            countDownLatch.await();
            this.g = new h("127.0.0.1", this.f17283c);
            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Proxy cache server started. Is it alive? " + a());
        } catch (IOException | InterruptedException e) {
            this.f17281a.shutdown();
            sg.bigo.ads.core.d.b.a(3005, 10110, "Error starting local proxy server, error message is : " + e.toString());
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error starting local proxy server, error message is : " + e.toString());
        }
    }

    public final e a(String str) {
        e eVar;
        synchronized (this.f17284d) {
            try {
                eVar = this.e.get(str);
                if (eVar == null) {
                    eVar = new e(str);
                    this.e.put(str, eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final int b() {
        int i2;
        synchronized (this.f17284d) {
            try {
                Iterator<e> it = this.e.values().iterator();
                i2 = 0;
                while (it.hasNext()) {
                    i2 += it.next().f17290a.get();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public static void a(Socket socket) {
        String str;
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            str = "Releasing input stream… Socket is closed by client.";
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", str);
        } catch (IOException e) {
            str = "Error closing socket input stream, error message is " + e.getMessage();
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", str);
        }
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e4) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Failed to close socket on proxy side: {}. It seems client have already closed connection." + e4.getMessage());
        }
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e8) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error closing socket" + e8.getMessage());
        }
    }

    public final boolean a() {
        h hVar = this.g;
        return hVar != null && hVar.a();
    }
}
