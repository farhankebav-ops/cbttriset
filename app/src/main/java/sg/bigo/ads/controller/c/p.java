package sg.bigo.ads.controller.c;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f16507a = new ArrayList();

    public static abstract class a {
        private a() {
        }

        public abstract int a();

        public abstract void a(ByteBuffer byteBuffer);

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    public final void a(final int i2) {
        this.f16507a.add(new a() { // from class: sg.bigo.ads.controller.c.p.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super((byte) 0);
            }

            @Override // sg.bigo.ads.controller.c.p.a
            public final int a() {
                return 4;
            }

            @Override // sg.bigo.ads.controller.c.p.a
            public final void a(ByteBuffer byteBuffer) {
                byteBuffer.putInt(i2);
            }
        });
    }

    public final void a(String str) {
        this.f16507a.add(new a(str) { // from class: sg.bigo.ads.controller.c.p.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final byte[] f16508a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f16509b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                byte[] bytes;
                super((byte) 0);
                this.f16509b = str;
                try {
                    bytes = str.getBytes(Key.STRING_CHARSET_NAME);
                } catch (Exception unused) {
                    bytes = new byte[0];
                }
                this.f16508a = bytes;
            }

            @Override // sg.bigo.ads.controller.c.p.a
            public final int a() {
                return this.f16508a.length + 4;
            }

            @Override // sg.bigo.ads.controller.c.p.a
            public final void a(ByteBuffer byteBuffer) {
                byteBuffer.putInt(this.f16508a.length);
                byteBuffer.put(this.f16508a);
            }
        });
    }
}
