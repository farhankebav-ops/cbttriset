package sg.bigo.ads.core.landing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public class FileChooser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Activity f17115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ValueCallback<Uri> f17116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ValueCallback<Uri[]> f17117c;

    public FileChooser(Activity activity) {
        this.f17115a = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Serializable, java.lang.Object[]] */
    public final void a(String... strArr) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                if (!q.a((CharSequence) str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.isEmpty()) {
            intent.setType("*/*");
        } else {
            intent.setType((String) arrayList.get(0));
            if (arrayList.size() > 1) {
                intent.putExtra("android.intent.extra.MIME_TYPES", (Serializable) arrayList.toArray());
            }
        }
        this.f17115a.startActivityForResult(Intent.createChooser(intent, "Select File"), 101);
    }

    @Keep
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        sg.bigo.ads.common.t.a.a(0, 3, "FileChooser", "openFileChooser");
        this.f17116b = valueCallback;
        a(str);
    }
}
